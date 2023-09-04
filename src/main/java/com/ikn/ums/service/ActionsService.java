package com.ikn.ums.service;


import java.util.List;
import java.util.Optional;

import com.ikn.ums.dto.ActionsDto;
import com.ikn.ums.entity.ActionItems;
import com.ikn.ums.model.ActionModel;

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

}
