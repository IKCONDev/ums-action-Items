package com.ikn.ums.actionitem.service;

import java.util.List;
import java.util.Optional;

import com.ikn.ums.actionitem.VO.ActionItemsListVO;
import com.ikn.ums.actionitem.VO.TaskVO;
import com.ikn.ums.actionitem.entity.ActionItems;

public interface ActionsService {
	
	//save Action Item
	ActionItems createActionItem(ActionItems actions);
	//Fetch all Action Items
	List<ActionItems> fetchActionItemList();
	//Fetch ActionItem based on Id
	Optional<ActionItems>getSingleActionItem(Integer id);
	//Update ActionItem based on Id
	ActionItems updateActionItem(ActionItems action);
	//Delete ActionItem based on Id
	Integer deleteActionItem(Integer actionId);
	
	List<ActionItems> fetchActionItemsByEmail(String email);
	
	//get action items of an event based on eventId
	ActionItemsListVO fetchActionItemsOfEvent(Integer eventId);
	
	ActionItemsListVO fetchActionItems();
	
	List<TaskVO> sendToTasks(List<ActionItems> actionItem);
	
	boolean deleteAllActionItemsById(List<Integer> ids);
	
	boolean generateActions(List<ActionItems> actionItems);

}
