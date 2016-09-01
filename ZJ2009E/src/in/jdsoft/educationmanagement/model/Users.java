package in.jdsoft.educationmanagement.model;


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

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;


@Entity
@Table(name = "tbl_users", uniqueConstraints = @UniqueConstraint(columnNames = "email"))
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Users implements java.io.Serializable {

	public Users() {
		// TODO Auto-generated constructor stub
	}
	public Users(MasterUserType userTypes,String name,String email, String password, String createdBy,
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
	
	
	private Set<Admission> userAdmission=new HashSet<Admission>(0);
	private Set<StaffLeaveRequisition> staffLeaveRequistion=new HashSet<StaffLeaveRequisition>(0);
	private Set<PortalNotification> receivedPortalNotifications=new HashSet<PortalNotification>(0);
	private Set<PortalNotification> sentPortalNotifications=new HashSet<PortalNotification>(0);
	private Set<PortalTask> receivedPortalTask=new HashSet<PortalTask>(0);
	private Set<PortalTask> sentPortalTask=new HashSet<PortalTask>(0);
	private Staff staff=new Staff();
	private Student student=new Student();
	private Set<Student> students=new HashSet<Student>(0);
	private Set<Staff> staffs= new HashSet<Staff>(0);

	
	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "user_id",nullable = false)
	public Integer getUserId() {
		return this.userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	@Column(name = "name")
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name =WordUtils.capitalize(name);
	}

	@Column(name = "email")
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email =email.toLowerCase();
	}

	@Column(name = "password", nullable = false)
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
	public MasterUserType getUserTypes() {
		return userTypes;
	}

	public void setUserTypes(MasterUserType userTypes) {
		this.userTypes = userTypes;
	}
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "institution_id", nullable =false)
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
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy ="user")
	public Set<Admission> getUserAdmission() {
		return userAdmission;
	}
	public void setUserAdmission(Set<Admission> userAdmission) {
		this.userAdmission = userAdmission;
	}
	
	@Column(name = "profile_picture", nullable = false)
	public String getProfilePicturePath() {
		return profilePicturePath;
	}
	public void setProfilePicturePath(String profilePicturePath) {
		this.profilePicturePath = profilePicturePath;
	}
	
	@OneToOne(fetch = FetchType.LAZY, mappedBy = "user")
	@JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class, property="@user")
	public Staff getStaff() {
		return staff;
	}
	public void setStaff(Staff staff) {
		this.staff = staff;
	}
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy ="leaveApprover")
	public Set<StaffLeaveRequisition> getStaffLeaveRequistion() {
		return staffLeaveRequistion;
	}
	public void setStaffLeaveRequistion(Set<StaffLeaveRequisition> staffLeaveRequistion) {
		this.staffLeaveRequistion = staffLeaveRequistion;
	}
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy ="createdUser")
	public Set<PortalNotification> getSentPortalNotifications() {
		return sentPortalNotifications;
	}
	public void setSentPortalNotifications(Set<PortalNotification> sentPortalNotifications) {
		this.sentPortalNotifications = sentPortalNotifications;
	}
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy ="targetUser")
	public Set<PortalNotification> getReceivedPortalNotifications() {
		return receivedPortalNotifications;
	}
	public void setReceivedPortalNotifications(Set<PortalNotification> receivedPortalNotifications) {
		this.receivedPortalNotifications = receivedPortalNotifications;
	}
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy ="targetUser")
	public Set<PortalTask> getReceivedPortalTask() {
		return receivedPortalTask;
	}
	public void setReceivedPortalTask(Set<PortalTask> receivedPortalTask) {
		this.receivedPortalTask = receivedPortalTask;
	}
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy ="createdUser")
	public Set<PortalTask> getSentPortalTask() {
		return sentPortalTask;
	}
	public void setSentPortalTask(Set<PortalTask> sentPortalTask) {
		this.sentPortalTask = sentPortalTask;
	}
	
	@OneToOne(fetch = FetchType.LAZY, mappedBy = "user")
	@JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class, property="@user")
	public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
	}
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy ="approver")
	public Set<Student> getStudents() {
		return students;
	}
	public void setStudents(Set<Student> students) {
		this.students = students;
	}
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy ="approver")
	@JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class, property="@approver")
	public Set<Staff> getStaffs() {
		return staffs;
	}
	public void setStaffs(Set<Staff> staffs) {
		this.staffs = staffs;
	}
	
	
	
}
