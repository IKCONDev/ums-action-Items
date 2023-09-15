package com.ikn.ums.actionitem.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ActionsDto {
	
	
	private Integer id;
	
	private Integer eventid;
	
	private String actionTitle;
	
	private String Description;
		
    private String actionPriority;
	
	private String actionStatus;
	
	private LocalDateTime startDate;
	
	private LocalDateTime endDate;
	
	private String userId;

	

}
