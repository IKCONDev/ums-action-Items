package com.ikn.ums.serviceImpl;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ikn.ums.entity.ActionItems;

import com.ikn.ums.repo.ActionsRepository;
import com.ikn.ums.service.ActionsService;

@Service
public class ActionsServiceImpl implements ActionsService{

	@Autowired
	private ActionsRepository repo;
	
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
	

}
