package com.ikn.ums.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Action_tab")
public class ActionItems {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	@Column(name="id")
	private Integer id;
	
	@Column(name="event_id")
	private String eventid;
	
	@Column(name="act_title")
	private String actionTitle;
	
	@Column(name="act_desc")
	private String description;
		
	@Column(name="act_prty")
	private String actionPriority;
	
	@Column(name="act_status")
	private String actionStatus;
	
	@Column(name="strt_date")
	private LocalDateTime startDate;
	
	@Column(name="end_date")
	private LocalDateTime endDate;

	//Getters and Setters
	
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
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
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
 
	 //toString()
	@Override
	public String toString() {
		return "ActionsEntity [id=" + id + ", eventid=" + eventid + ", actionTitle=" + actionTitle + ", Description="
				+ description + ", actionPriority=" + actionPriority + ", actionStatus=" + actionStatus + ", startDate="
				+ startDate + ", endDate=" + endDate + "]";
	}
	
   
	
}
