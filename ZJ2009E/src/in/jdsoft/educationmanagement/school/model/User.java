package in.jdsoft.educationmanagement.school.model;


import static javax.persistence.GenerationType.IDENTITY;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

import org.apache.commons.lang.WordUtils;
import org.hibernate.annotations.ForeignKey;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@Entity
@Table(name = "tbl_users", uniqueConstraints = @UniqueConstraint(columnNames = "email"))
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class User implements java.io.Serializable {

	public User() {
		// TODO Auto-generated constructor stub
	}
	public User(MasterUserType userTypes,String name,String email, String password, String createdBy,
			 Integer status,String hash,String profilePicturePath,Institution intitution) {
		this.name =WordUtils.capitalize(name);
		this.email =email.toLowerCase();
		this.password = password;
		this.userTypes = userTypes;
		this.createdBy = createdBy;
		this.createdDate =new Timestamp(Calendar.getInstance().getTime().getTime());
		this.status = status;
		this.hash=hash;
		this.profilePicturePath=profilePicturePath;
		this.institution=intitution;
	}
	
	/*public Users(MasterUserType userTypes,String name,String email, String password, String createdBy,
			 Integer status) {
		this.name = name;
		this.email = email;
		this.password = password;
		this.userTypes = userTypes;
		this.createdBy = createdBy;
		this.createdDate =new Timestamp(Calendar.getInstance().getTime().getTime());
		this.status = status;
		this.modifiedDate=new Timestamp(Calendar.getInstance().getTime().getTime());
	}*/
	
	
	private static final long serialVersionUID = 1L;
	private Integer userId;
	private String name;
	private String email;
	private String password;
	private String hash;
	private MasterUserType userTypes;
	private String createdBy;
	private Date createdDate;
	private Integer status;
	private Date modifiedDate;
	private Date lastLogin;
	private String profilePicturePath;
	private Institution institution;
	
	
	
	private Set<PortalNotification> receivedPortalNotifications=new HashSet<PortalNotification>(0);
	private Set<PortalNotification> sentPortalNotifications=new HashSet<PortalNotification>(0);
	private Set<PortalTask> receivedPortalTask=new HashSet<PortalTask>(0);
	private Set<PortalTask> sentPortalTask=new HashSet<PortalTask>(0);
	private Student student=new Student();
	


	
	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "user_id",nullable = false)
	public Integer getUserId() {
		return this.userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	@Column(name = "name",length=100)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name =WordUtils.capitalize(name);
	}

	@Column(name = "email",length=100)
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email =email.toLowerCase();
	}

	@Column(name = "password", nullable = false,length=100)
	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	
	@Column(name = "created_by", length = 50)
	public String getCreatedBy() {
		return this.createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "created_date")
	public Date getCreatedDate() {
		return this.createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	@Column(name = "status")
	public Integer getStatus() {
		return this.status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "modified_date", nullable = false,columnDefinition="timestamp")
	public Date getModifiedDate() {
		return this.modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "last_login")
	public Date getLastLogin() {
		return this.lastLogin;
	}

	public void setLastLogin(Date lastLogin) {
		this.lastLogin = lastLogin;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "type_id", nullable =false)
	@ForeignKey(name="usersInUserType")
	public MasterUserType getUserTypes() {
		return userTypes;
	}

	public void setUserTypes(MasterUserType userTypes) {
		this.userTypes = userTypes;
	}
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "institution_id", nullable =false)
	@ForeignKey(name="usersInInstitution")
	public Institution getInstitution() {
		return institution;
	}
	public void setInstitution(Institution institution) {
		this.institution = institution;
	}
	
	@Column(name = "hash_key", nullable = false)
	public String getHash() {
		return hash;
	}
	public void setHash(String hash) {
		this.hash = hash;
	}
	

	@Column(name = "profile_picture", nullable = false)
	public String getProfilePicturePath() {
		return profilePicturePath;
	}
	public void setProfilePicturePath(String profilePicturePath) {
		this.profilePicturePath = profilePicturePath;
	}
	

	@OneToMany(fetch = FetchType.LAZY, mappedBy ="createdUser")
	@ForeignKey(name="createduserInPortalNotifications")
	public Set<PortalNotification> getSentPortalNotifications() {
		return sentPortalNotifications;
	}
	public void setSentPortalNotifications(Set<PortalNotification> sentPortalNotifications) {
		this.sentPortalNotifications = sentPortalNotifications;
	}
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy ="targetUser")
	@ForeignKey(name="targetuserInPortalNotifications")
	public Set<PortalNotification> getReceivedPortalNotifications() {
		return receivedPortalNotifications;
	}
	public void setReceivedPortalNotifications(Set<PortalNotification> receivedPortalNotifications) {
		this.receivedPortalNotifications = receivedPortalNotifications;
	}
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy ="targetUser")
	@ForeignKey(name="targetuserInPortalTasks")
	public Set<PortalTask> getReceivedPortalTask() {
		return receivedPortalTask;
	}
	public void setReceivedPortalTask(Set<PortalTask> receivedPortalTask) {
		this.receivedPortalTask = receivedPortalTask;
	}
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy ="createdUser")
	@ForeignKey(name="createduserInPortalTasks")
	public Set<PortalTask> getSentPortalTask() {
		return sentPortalTask;
	}
	public void setSentPortalTask(Set<PortalTask> sentPortalTask) {
		this.sentPortalTask = sentPortalTask;
	}
	
	@OneToOne(fetch = FetchType.LAZY, mappedBy = "user")
	@ForeignKey(name="userInStudent")
	public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
	}
	
}
