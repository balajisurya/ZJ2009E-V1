package in.jdsoft.educationmanagement.model;

import static javax.persistence.GenerationType.IDENTITY;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "tbl_communications")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class CommunicationAndIssuesOrQueries implements java.io.Serializable {

	
	public CommunicationAndIssuesOrQueries(String messageMode, String communicationTargetGroup,
			String communicationSubject, String communicationMessage, String communicationCreatedByUser,
			String communicationActionStatus, String communicationActionTaken, String communicationActionTakenByUser,
			Date createdDate) {
		this.messageMode = messageMode;
		this.communicationTargetGroup = communicationTargetGroup;
		this.communicationSubject = communicationSubject;
		this.communicationMessage = communicationMessage;
		this.communicationCreatedByUser = communicationCreatedByUser;
		this.communicationActionStatus = communicationActionStatus;
		this.communicationActionTaken = communicationActionTaken;
		this.communicationActionTakenByUser = communicationActionTakenByUser;
		this.createdDate = createdDate;
	}




	public CommunicationAndIssuesOrQueries() {
	}



	
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "communication_id", unique = true, nullable = false)
	public Integer getCommunicationId() {
		return communicationId;
	}
	public void setCommunicationId(Integer communicationId) {
		this.communicationId = communicationId;
	}
	@Column(name = "communication_target_group", nullable = false, length = 80)
	public String getCommunicationTargetGroup() {
		return communicationTargetGroup;
	}
	public void setCommunicationTargetGroup(String communicationTargetGroup) {
		this.communicationTargetGroup = communicationTargetGroup;
	}
	@Column(name = "communication_subject", nullable = false, length = 80)
	public String getCommunicationSubject() {
		return communicationSubject;
	}
	public void setCommunicationSubject(String communicationSubject) {
		this.communicationSubject = communicationSubject;
	}
	@Column(name = "communication_message_mode", nullable = true, length = 80)
	public String getMessageMode() {
		return messageMode;
	}
	public void setMessageMode(String messageMode) {
		this.messageMode = messageMode;
	}
	@Column(name = "communication_message", nullable = false, length = 255)
	public String getCommunicationMessage() {
		return communicationMessage;
	}
	public void setCommunicationMessage(String communicationMessage) {
		this.communicationMessage = communicationMessage;
	}
	@Column(name = "communication_action_status", nullable = false, length = 80)
	public String getCommunicationActionStatus() {
		return communicationActionStatus;
	}
	public void setCommunicationActionStatus(String communicationActionStatus) {
		this.communicationActionStatus = communicationActionStatus;
	}
	@Column(name = "communication_created_by_user", nullable = false, length = 80)
	public String getCommunicationCreatedByUser() {
		return communicationCreatedByUser;
	}
	public void setCommunicationCreatedByUser(String communicationCreatedByUser) {
		this.communicationCreatedByUser = communicationCreatedByUser;
	}
	@Column(name = "communication_action_taken", nullable = false, length = 255)
	public String getCommunicationActionTaken() {
		return communicationActionTaken;
	}
	public void setCommunicationActionTaken(String communicationActionTaken) {
		this.communicationActionTaken = communicationActionTaken;
	}
	@Column(name = "communication_action_taken_by_user", nullable = false, length = 80)
	public String getCommunicationActionTakenByUser() {
		return communicationActionTakenByUser;
	}
	public void setCommunicationActionTakenByUser(String communicationActionTakenByUser) {
		this.communicationActionTakenByUser = communicationActionTakenByUser;
	}
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "communication_created_date", nullable = false, length = 10)
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	private static final long serialVersionUID = 1L;
	
	private Integer communicationId;
	private String messageMode;
	private String communicationTargetGroup;
	private String communicationSubject;
	private String communicationMessage;
	private String communicationCreatedByUser;
	private String communicationActionStatus;
	private String communicationActionTaken;
	private String communicationActionTakenByUser;
	private Date createdDate;
	
}
	

