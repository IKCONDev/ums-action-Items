package com.ikn.ums.dto;

import java.time.LocalDateTime;

public class ActionsDto {
	
	
	private Integer id;
	
	private String eventid;
	
	private String actionTitle;
	
	private String Description;
		
    private String actionPriority;
	
	private String actionStatus;
	
	private LocalDateTime startDate;
	
	private LocalDateTime endDate;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getEventid() {
		return eventid;
	}

	public void setEventid(String eventid) {
		this.eventid = eventid;
	}

	public String getActionTitle() {
		return actionTitle;
	}

	public void setActionTitle(String actionTitle) {
		this.actionTitle = actionTitle;
	}

	public String getDescription() {
		return Description;
	}

	public void setDescription(String description) {
		Description = description;
	}

	public String getActionPriority() {
		return actionPriority;
	}

	public void setActionPriority(String actionPriority) {
		this.actionPriority = actionPriority;
	}

	public String getActionStatus() {
		return actionStatus;
	}

	public void setActionStatus(String actionStatus) {
		this.actionStatus = actionStatus;
	}

	public LocalDateTime getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDateTime startDate) {
		this.startDate = startDate;
	}

	public LocalDateTime getEndDate() {
		return endDate;
	}

	public void setEndDate(LocalDateTime endDate) {
		this.endDate = endDate;
	}

	@Override
	public String toString() {
		return "ActionsDto [id=" + id + ", eventid=" + eventid + ", actionTitle=" + actionTitle + ", Description="
				+ Description + ", actionPriority=" + actionPriority + ", actionStatus=" + actionStatus + ", startDate="
				+ startDate + ", endDate=" + endDate + "]";
	}
	
	

}
