package com.ikn.ums.actionitem.serviceImpl;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.ikn.ums.actionitem.VO.ActionItemsListVO;
import com.ikn.ums.actionitem.VO.TaskVO;
import com.ikn.ums.actionitem.entity.ActionItems;
import com.ikn.ums.actionitem.exception.BusinessException;
import com.ikn.ums.actionitem.exception.ErrorCodeMessages;
import com.ikn.ums.actionitem.repo.ActionsRepository;
import com.ikn.ums.actionitem.service.ActionsService;

@Service
public class ActionsServiceImpl implements ActionsService{

	@Autowired
	private ActionsRepository repo;
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Override
	@Transactional
	public ActionItems createActionItem(ActionItems actions) {
		// TODO Auto-generated method stub
		//ActionsEntity entity =repo.saveAll(actionmodel);
		//ModelMapper mapper =new ModelMapper();
		//mapper.map(entity,ActionsDto.class);
		
		return repo.save(actions);
	}

	@Override
	public List<ActionItems> fetchActionItemList() {
		// TODO Auto-generated method stub
		List<ActionItems>actions =repo.findAll();
		return actions;
	}

	@Override
	public Optional<ActionItems> getSingleActionItem(Integer id) {
		// TODO Auto-generated method stub
		Optional<ActionItems> actionItem = repo.findById(id);
		return actionItem;
	}

	@Override
	public ActionItems updateActionItem(ActionItems action) {
		// TODO Auto-generated method stub
		ActionItems existingAction = repo.findById(action.getId()).get();
		existingAction.setEventid(action.getEventid());
		existingAction.setActionTitle(action.getActionTitle());
		existingAction.setDescription(action.getDescription());
		existingAction.setActionPriority(action.getActionPriority());
		existingAction.setActionStatus(action.getActionStatus());
		existingAction.setStartDate(action.getStartDate());
		existingAction.setEndDate(action.getEndDate());
		ActionItems updateAction= repo.save(existingAction);
		return updateAction;
	}

	@Override
	@Transactional
	public Integer deleteActionItem(Integer actionId) {
		// TODO Auto-generated method stub
	
		repo.deleteById(actionId);
		return 1;
		
	}

	//fetches action items based on event id
	@Override
	public ActionItemsListVO fetchActionItemsOfEvent(Integer eventId) {
		ActionItemsListVO acItemsVO = new ActionItemsListVO();
		List<ActionItems> actionItemsList = repo.findActionItemsByEventId(eventId);
		acItemsVO.setActionItems(actionItemsList);
		return acItemsVO;
	}

	@Override
	public ActionItemsListVO fetchActionItems() {
		ActionItemsListVO acItemsVO = new ActionItemsListVO();
		List<ActionItems> actionItemsList = repo.findAll();
		acItemsVO.setActionItems(actionItemsList);
		return acItemsVO;
	}

	@Override
	public boolean deleteAllActionItemsById(List<Integer> ids) {
		boolean isAllDeleted = false;
		try {
			repo.deleteAllById(ids);
			isAllDeleted = true;
		}catch (Exception e) {
			isAllDeleted = false;
		}
		System.out.println(isAllDeleted);
		return isAllDeleted;
	}
	
	@Transactional
	@Override
	public List<TaskVO> sendToTasks(List<ActionItems> actionItems) {
		try {
			System.out.println("ActionsServiceImpl.sendToTasks() entered "+actionItems);
			
			String URL="http://localhost:8012/task/convert-task";
			HttpEntity<?> httpEntity = new HttpEntity<>(actionItems,null);
			
			ResponseEntity<List<TaskVO>> responseEntity = restTemplate.exchange(
			        URL, HttpMethod.POST, httpEntity, new ParameterizedTypeReference<List<TaskVO>>() {});
			List<TaskVO> taskList = responseEntity.getBody();
			System.out.println(responseEntity.getBody());
			
			//change the action item status to Converted
			actionItems.stream().forEach(action ->{
				action.setActionStatus("Converted");
			});
			
			//updates only the status of action item in db
			repo.saveAll(actionItems);
			return taskList;
		}catch (Exception e) {
			throw new BusinessException("error code", "Service Exception");
		}
	}

	@Override
	public boolean generateActions(List<ActionItems> actionItems) {
		// TODO Auto-generated method stub
		List<ActionItems> action = new ArrayList<>();
		actionItems.forEach(actions->{
			ActionItems ac = new ActionItems();
		    ac.setActionTitle(actions.getActionTitle());
		    ac.setDescription(actions.getDescription());
		    ac.setStartDate(actions.getStartDate());
		    ac.setActionPriority(actions.getActionPriority());
		    ac.setActionStatus(actions.getActionStatus());
		    ac.setEndDate(actions.getEndDate());
		    ac.setEventid(actions.getEventid());
		    action.add(ac);
			
		});
		repo.saveAll(action);
		System.out.println(action);
		return true;
	}
	
	

}
