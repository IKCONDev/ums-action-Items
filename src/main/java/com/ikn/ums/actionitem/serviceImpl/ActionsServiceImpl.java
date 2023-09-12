package com.ikn.ums.actionitem.serviceImpl;

import java.time.LocalDateTime;
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
	
	@Override
	public List<TaskVO> sendToTasks(List<ActionItems> actionItem) {
		// TODO Auto-generated method stub
		String URL="http://localhost:8012/task/convert-task";
		HttpEntity<?> httpEntity = new HttpEntity<>(actionItem,null);
		//ResponseEntity<TaskListVO> responseEntity = restTemplate.exchange(URL, HttpMethod.POST,httpEntity,TaskListVO.class);
		ResponseEntity<List<TaskVO>> responseEntity = restTemplate.exchange(
		        URL, HttpMethod.POST, httpEntity, new ParameterizedTypeReference<List<TaskVO>>() {});
		List<TaskVO> taskList = responseEntity.getBody();
		System.out.println(responseEntity.getBody());
		//return responseEntity.getBody().getTaskList();
		//List<TaskVO> task = responseEntity.getBody().getTaskList();
		return taskList;
	}
	
	

}
