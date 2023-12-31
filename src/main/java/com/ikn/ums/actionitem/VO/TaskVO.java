package com.ikn.ums.actionitem.VO;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TaskVO {
	
	
    private Integer id;
	
	private String taskTitle;
	
	private String taskDescription;
	
	private String taskPriority;
	
	private String status;
	
	private Integer actionItemId;
	
	private String assignee;
	
	private LocalDateTime startDate;
	
	private LocalDateTime dueDate;
	
	private String actionTitle;


}
