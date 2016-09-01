package in.jdsoft.educationmanagement.model;

import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "tbl_portal_task")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class PortalTask implements Serializable{

	public PortalTask() {}
	
 	public PortalTask(String taskSubject, String taskMessage, String taskLink, Users targetUser, String taskStatus,
			Users createdUser) {
		this.taskSubject = taskSubject;
		this.taskMessage = taskMessage;
		this.taskLink = taskLink;
		this.targetUser = targetUser;
		this.taskStatus = taskStatus;
		this.createdUser = createdUser;
		this.createdDate = new Date(Calendar.getInstance().getTime().getTime());
	}
 	
	private static final long serialVersionUID = 1L;
 	
	private Integer taskId;
	private String taskSubject;
	private String taskMessage;
	private String taskLink;
	private Users targetUser;
	private String taskStatus;
	private Users createdUser;
	private Date createdDate;
	
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "portal_task_id", nullable = false)
	public Integer getTaskId() {
		return taskId;
	}
	public void setTaskId(Integer taskId) {
		this.taskId = taskId;
	}
	@Column(name = "task_message", nullable = false, length = 255)
	public String getTaskMessage() {
		return taskMessage;
	}
	public void setTaskMessage(String taskMessage) {
		this.taskMessage = taskMessage;
	}
	@Column(name = "task_link", nullable = false, length = 255)
	public String getTaskLink() {
		return taskLink;
	}
	public void setTaskLink(String taskLink) {
		this.taskLink = taskLink;
	}
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "target_user_id", nullable = false,referencedColumnName="user_id")
	public Users getTargetUser() {
		return targetUser;
	}
	public void setTargetUser(Users targetUser) {
		this.targetUser = targetUser;
	}
	
	@Column(name = "task_status", nullable = false, length = 100)
	public String getTaskStatus() {
		return taskStatus;
	}
	public void setTaskStatus(String taskStatus) {
		this.taskStatus = taskStatus;
	}
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "created_user_id", nullable = false,referencedColumnName="user_id")
	public Users getCreatedUser() {
		return createdUser;
	}
	public void setCreatedUser(Users createdUser) {
		this.createdUser = createdUser;
	}
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "created_date", nullable = false)
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	
	@Column(name = "task_subject", nullable = false, length = 100)
	public String getTaskSubject() {
		return taskSubject;
	}
	public void setTaskSubject(String taskSubject) {
		this.taskSubject = taskSubject;
	}

}
