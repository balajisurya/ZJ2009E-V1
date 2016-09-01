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
@Table(name = "tbl_portal_notification")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class PortalNotification implements Serializable{
  
	public PortalNotification() {}

   public PortalNotification(String notificationSubject, String notificationMessage, Users targetUser,
			Integer notificationStatus, String notificationLink,Users createdUser) {
		this.notificationSubject = notificationSubject;
		this.notificationMessage = notificationMessage;
		this.targetUser = targetUser;
		this.notificationStatus = notificationStatus;
		this.notificationLink = notificationLink;
		this.createdDate = new Date(Calendar.getInstance().getTime().getTime());
		this.createdUser = createdUser;
	}
   
   private static final long serialVersionUID = 1L;

   private Integer notificationId;
   private String notificationSubject;
   private String  notificationMessage;
   private Users targetUser;
   private Integer notificationStatus;
   private String notificationLink;
   private Date createdDate;
   private Users createdUser;
   
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "portal_notification_id", nullable = false)
	public Integer getNotificationId() {
		return notificationId;
	}
	public void setNotificationId(Integer notificationId) {
		this.notificationId = notificationId;
	}
	
	@Column(name = "notification_message", nullable = false, length = 255)
	public String getNotificationMessage() {
		return notificationMessage;
	}
	public void setNotificationMessage(String notificationMessage) {
		this.notificationMessage = notificationMessage;
	}
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "target_user_id", nullable = false,referencedColumnName="user_id")
	public Users getTargetUser() {
		return targetUser;
	}
	public void setTargetUser(Users targetUser) {
		this.targetUser = targetUser;
	}
	
	@Column(name = "notification_status", nullable = false)
	public Integer getNotificationStatus() {
		return notificationStatus;
	}
	public void setNotificationStatus(Integer notificationStatus) {
		this.notificationStatus = notificationStatus;
	}
	
	@Column(name = "notification_link", nullable = false,length=255)
	public String getNotificationLink() {
		return notificationLink;
	}
	public void setNotificationLink(String notificationLink) {
		this.notificationLink = notificationLink;
	}
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "created_date", nullable = false)
	public Date getCreatedDate() {
		return createdDate;
	}
	
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "created_user_id", nullable = false,referencedColumnName="user_id")
	public Users getCreatedUser() {
		return createdUser;
	}
	public void setCreatedUser(Users createdUser) {
		this.createdUser = createdUser;
	}
	
	@Column(name = "notification_subject", nullable = false,length=100)
	public String getNotificationSubject() {
		return notificationSubject;
	}
	public void setNotificationSubject(String notificationSubject) {
		this.notificationSubject = notificationSubject;
	}
   

}
