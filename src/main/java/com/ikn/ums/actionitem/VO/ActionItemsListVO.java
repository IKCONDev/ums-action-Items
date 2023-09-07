package com.ikn.ums.actionitem.VO;

import java.util.List;

import com.ikn.ums.actionitem.entity.ActionItems;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ActionItemsListVO {
	
	private List<ActionItems> actionItems;

}
