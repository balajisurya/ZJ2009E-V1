package in.jdsoft.educationmanagement.model;

import static javax.persistence.GenerationType.IDENTITY;

import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
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

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table(name = "tbl_staff")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Staff implements java.io.Serializable {


	public Staff(Department department,String staffFirstName, String staffLastName, String staffSex, Date staffBirthDate,
			String staffContact, String staffEmail, String accessId, String parentOrGuardianFirstName,
			String parentOrGuardianLastName, String spouseName, Category category, String staffAddressLineOne,
			String staffAddressLineTwo, Integer countryId, Integer stateId, Integer cityId, String postCode,
			String bankName, String bankAccountNo, String bankIFSC, String bankAddress, String tallyAccountNo,
			String passportNo,Users approver, String panNO, String pfNo, String profilePicturePath, String scannedSignaturePath,
			StaffTypes staffType, StaffCategories staffCategory, Date joiningDate, Double previousExperience,
			String resumePath, String healthInsuranceNo, String offerLetterPath, String form16path, Integer status,
			 String staffCreatedBy,String staffLastModifiedBy,BloodGroup bloodGroup,Institution institution) {
	    this.staffCode =Long.toString(System.currentTimeMillis());
		this.staffFirstName = staffFirstName;
		this.staffLastName = staffLastName;
		this.staffSex = staffSex;
		this.staffBirthDate = staffBirthDate;
		this.staffContact = staffContact;
		this.staffEmail = staffEmail;
		this.accessId = accessId;
		this.parentOrGuardianFirstName = parentOrGuardianFirstName;
		this.parentOrGuardianLastName = parentOrGuardianLastName;
		this.spouseName = spouseName;
		this.category = category;
		this.staffAddressLineOne = staffAddressLineOne;
		this.staffAddressLineTwo = staffAddressLineTwo;
		this.countryId = countryId;
		this.stateId = stateId;
		this.cityId = cityId;
		this.postCode = postCode;
		this.bankName = bankName;
		this.bankAccountNo = bankAccountNo;
		this.bankIFSC = bankIFSC;
		this.bankAddress = bankAddress;
		this.tallyAccountNo = tallyAccountNo;
		this.passportNo = passportNo;
		this.panNO = panNO;
		this.pfNo = pfNo;
		this.profilePicturePath = profilePicturePath;
		this.scannedSignaturePath = scannedSignaturePath;
		this.staffType = staffType;
		this.staffCategory = staffCategory;
		this.joiningDate = joiningDate;
		this.previousExperience = previousExperience;
		this.resumePath = resumePath;
		this.healthInsuranceNo = healthInsuranceNo;
		this.offerLetterPath = offerLetterPath;
		this.form16path = form16path;
		this.status = status;
		this.staffCreatedDate =new Date(Calendar.getInstance().getTime().getTime());
		this.staffCreatedBy = staffCreatedBy;
		this.staffLastModifiedBy = staffLastModifiedBy;
		this.department=department;
		this.bloodGroup=bloodGroup;
		this.institution=institution;
		this.approver=approver;
	}

	private static final long serialVersionUID = 1L;
	private Integer staffId;
	private String staffCode;
	private String staffFirstName;
	private String staffLastName;
	private String staffSex;
	private Date staffBirthDate;
	private String staffContact;
	private String staffEmail;
	private String accessId; 
	private String parentOrGuardianFirstName;
	private String parentOrGuardianLastName;
	private String spouseName;
	private String staffAddressLineOne;
	private String staffAddressLineTwo;
	private Integer countryId;
	private Integer stateId;
	private Integer cityId;
	private String postCode;
	private String bankName;
	private String bankAccountNo;
	private String bankIFSC;
	private String bankAddress;
	private String tallyAccountNo;
	private String passportNo;
	private String panNO;
	private String pfNo;
	private String profilePicturePath;
	private String scannedSignaturePath;
	private Date joiningDate;
	private Double previousExperience;
	private String resumePath;
	private String healthInsuranceNo;
	private String offerLetterPath;
	private String form16path;
	private Integer status;
    private Date staffCreatedDate;
	private String staffCreatedBy;
	private Date staffLastModifiedDate;
	private String staffLastModifiedBy;
	private Department department;
	private BloodGroup bloodGroup;
	private Users user;
	private Users approver;
	private Institution institution;
	private StaffTypes staffType;
	private StaffCategories staffCategory;
	private Category category;

	
	
	private Set<StaffAttendance> staffAttendances = new HashSet<StaffAttendance>(0);
	private Set<StaffLeaveRequisition> staffLeaveRequisitions = new HashSet<StaffLeaveRequisition>(0);
	private Set<StaffPerformance> staffPerformance = new HashSet<StaffPerformance>(0);
	private Set<TimeTable> timetables=new HashSet<TimeTable>(0);
	private Set<AcademicCourseSemesterModule> academicCourseSemesterModules=new HashSet<AcademicCourseSemesterModule>(0);
	

  
	public Staff() {}
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "staff_id", nullable = false)
	public Integer getStaffId() {
		return this.staffId;
	}

	public void setStaffId(Integer staffId) {
		this.staffId = staffId;
	}

	@Column(name = "staff_code", nullable = false, length = 20)
	public String getStaffCode() {
		return this.staffCode;
	}

	public void setStaffCode(String staffCode) {
		this.staffCode = staffCode;
	}

	@Column(name = "staff_first_name", nullable = false, length = 40)
	public String getStaffFirstName() {
		return this.staffFirstName;
	}

	public void setStaffFirstName(String staffFirstName) {
		this.staffFirstName = staffFirstName;
	}

	@Column(name = "staff_last_name", nullable = true, length = 30)
	public String getStaffLastName() {
		return this.staffLastName;
	}

	public void setStaffLastName(String staffLastName) {
		this.staffLastName = staffLastName;
	}

	@Column(name = "staff_sex", nullable = false, length = 15)
	public String getStaffSex() {
		return this.staffSex;
	}

	public void setStaffSex(String staffSex) {
		this.staffSex = staffSex;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "staff_birth_date", nullable = false, length = 10)
	public Date getStaffBirthDate() {
		return this.staffBirthDate;
	}

	public void setStaffBirthDate(Date staffBirthDate) {
		this.staffBirthDate = staffBirthDate;
	}

	@Column(name = "staff_contact", nullable = false, length = 15)
	public String getStaffContact() {
		return this.staffContact;
	}

	public void setStaffContact(String staffContact) {
		this.staffContact = staffContact;
	}

	@Column(name = "staff_email", nullable = false, length = 100)
	public String getStaffEmail() {
		return this.staffEmail;
	}

	public void setStaffEmail(String staffEmail) {
		this.staffEmail = staffEmail;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "staff_created_date", nullable = false)
	public Date getStaffCreatedDate() {
		return this.staffCreatedDate;
	}

	public void setStaffCreatedDate(Date staffCreatedDate) {
		this.staffCreatedDate = staffCreatedDate;
	}

	@Column(name = "staff_created_by", nullable = false, length = 100)
	public String getStaffCreatedBy() {
		return this.staffCreatedBy;
	}

	public void setStaffCreatedBy(String staffCreatedBy) {
		this.staffCreatedBy = staffCreatedBy;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "staff_last_modified_date", nullable = false,columnDefinition="timestamp")
	public Date getStaffLastModifiedDate() {
		return this.staffLastModifiedDate;
	}

	public void setStaffLastModifiedDate(Date staffLastModifiedDate) {
		this.staffLastModifiedDate = staffLastModifiedDate;
	}

	@Column(name = "staff_last_modified_by", nullable = false, length = 100)
	public String getStaffLastModifiedBy() {
		return this.staffLastModifiedBy;
	}

	public void setStaffLastModifiedBy(String staffLastModifiedBy) {
		this.staffLastModifiedBy = staffLastModifiedBy;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "staff")
	public Set<StaffAttendance> getStaffAttendances() {
		return this.staffAttendances;
	}

	public void setStaffAttendances(Set<StaffAttendance> staffAttendances) {
		this.staffAttendances = staffAttendances;
	}

	

	@Column(name = "biometric_access_id", nullable = false, length = 50)
	public String getAccessId() {
		return accessId;
	}



	public void setAccessId(String accessId) {
		this.accessId = accessId;
	}


	@Column(name = "parent_guardian_first_name", nullable = false, length = 100)
	public String getParentOrGuardianFirstName() {
		return parentOrGuardianFirstName;
	}



	public void setParentOrGuardianFirstName(String parentOrGuardianFirstName) {
		this.parentOrGuardianFirstName = parentOrGuardianFirstName;
	}


	@Column(name = "parent_guardian_last_name", nullable = false, length = 100)
	public String getParentOrGuardianLastName() {
		return parentOrGuardianLastName;
	}



	public void setParentOrGuardianLastName(String parentOrGuardianLastName) {
		this.parentOrGuardianLastName = parentOrGuardianLastName;
	}


	@Column(name = "spouse_name", nullable = false, length = 100)
	public String getSpouseName() {
		return spouseName;
	}



	public void setSpouseName(String spouseName) {
		this.spouseName = spouseName;
	}


	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "category_id", nullable = false)
	public Category getCategory() {
		return category;
	}


  
	public void setCategory(Category category) {
		this.category = category;
	}


	@Column(name = "staff_address_line_one", nullable = false, length = 100)
	public String getStaffAddressLineOne() {
		return staffAddressLineOne;
	}



	public void setStaffAddressLineOne(String staffAddressLineOne) {
		this.staffAddressLineOne = staffAddressLineOne;
	}


	@Column(name = "staff_address_line_two", nullable = false, length = 100)
	public String getStaffAddressLineTwo() {
		return staffAddressLineTwo;
	}



	public void setStaffAddressLineTwo(String staffAddressLineTwo) {
		this.staffAddressLineTwo = staffAddressLineTwo;
	}


	@Column(name = "country_id", nullable = false)
	public Integer getCountryId() {
		return countryId;
	}



	public void setCountryId(Integer countryId) {
		this.countryId = countryId;
	}


	@Column(name = "state_id", nullable = false)
	public Integer getStateId() {
		return stateId;
	}



	public void setStateId(Integer stateId) {
		this.stateId = stateId;
	}


	@Column(name = "city_id", nullable = false)
	public Integer getCityId() {
		return cityId;
	}



	public void setCityId(Integer cityId) {
		this.cityId = cityId;
	}


	@Column(name = "post_code", nullable = false,length=10)
	public String getPostCode() {
		return postCode;
	}



	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}


	@Column(name = "bank_name", nullable = false,length=50)
	public String getBankName() {
		return bankName;
	}



	public void setBankName(String bankName) {
		this.bankName = bankName;
	}


	@Column(name = "bank_account_number", nullable = false,length=50)
	public String getBankAccountNo() {
		return bankAccountNo;
	}



	public void setBankAccountNo(String bankAccountNo) {
		this.bankAccountNo = bankAccountNo;
	}


	@Column(name = "ifsc_code", nullable = false,length=20)
	public String getBankIFSC() {
		return bankIFSC;
	}



	public void setBankIFSC(String bankIFSC) {
		this.bankIFSC = bankIFSC;
	}




	@Column(name = "bank_address", nullable = false,length=100)
	public String getBankAddress() {
		return bankAddress;
	}



	public void setBankAddress(String bankAddress) {
		this.bankAddress = bankAddress;
	}


	@Column(name = "tally_account_no", nullable = false,length=25)
	public String getTallyAccountNo() {
		return tallyAccountNo;
	}



	public void setTallyAccountNo(String tallyAccountNo) {
		this.tallyAccountNo = tallyAccountNo;
	}


	@Column(name = "passport_number", nullable = false,length=20)
	public String getPassportNo() {
		return passportNo;
	}



	public void setPassportNo(String passportNo) {
		this.passportNo = passportNo;
	}


	@Column(name = "pan_no", nullable = false,length=20)
	public String getPanNO() {
		return panNO;
	}



	public void setPanNO(String panNO) {
		this.panNO = panNO;
	}


	@Column(name = "pf_no", nullable = false,length=20)
	public String getPfNo() {
		return pfNo;
	}



	public void setPfNo(String pfNo) {
		this.pfNo = pfNo;
	}


	@Column(name = "profile_picture_path", nullable = false,length=255)
	public String getProfilePicturePath() {
		return profilePicturePath;
	}



	public void setProfilePicturePath(String profilePicturePath) {
		this.profilePicturePath = profilePicturePath;
	}


	@Column(name = "signature_path", nullable = false,length=255)
	public String getScannedSignaturePath() {
		return scannedSignaturePath;
	}



	public void setScannedSignaturePath(String scannedSignaturePath) {
		this.scannedSignaturePath = scannedSignaturePath;
	}



	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "staff_type_id", nullable = false)
	public StaffTypes getStaffType() {
		return staffType;
	}



	public void setStaffType(StaffTypes staffType) {
		this.staffType = staffType;
	}


	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "staff_category_id", nullable = false)
	public StaffCategories getStaffCategory() {
		return staffCategory;
	}

	public void setStaffCategory(StaffCategories staffCategory) {
		this.staffCategory = staffCategory;
	}

  
	@Temporal(TemporalType.DATE)
	@Column(name = "date_of_joining", nullable =true)
	public Date getJoiningDate() {
		return joiningDate;
	}



	public void setJoiningDate(Date joiningDate) {
		this.joiningDate = joiningDate;
	}


	@Column(name = "previous_experience", nullable = false)
	public Double getPreviousExperience() {
		return previousExperience;
	}



	public void setPreviousExperience(Double previousExperience) {
		this.previousExperience = previousExperience;
	}


	@Column(name = "resume_path", nullable = false,length=255)
	public String getResumePath() {
		return resumePath;
	}



	public void setResumePath(String resumePath) {
		this.resumePath = resumePath;
	}


	@Column(name = "insurance_no", nullable = false,length=50)
	public String getHealthInsuranceNo() {
		return healthInsuranceNo;
	}



	public void setHealthInsuranceNo(String healthInsuranceNo) {
		this.healthInsuranceNo = healthInsuranceNo;
	}


	@Column(name = "offer_letter_path", nullable = false,length=255)
	public String getOfferLetterPath() {
		return offerLetterPath;
	}



	public void setOfferLetterPath(String offerLetterPath) {
		this.offerLetterPath = offerLetterPath;
	}


	@Column(name = "form16_path", nullable = false,length=255)
	public String getForm16path() {
		return form16path;
	}



	public void setForm16path(String form16path) {
		this.form16path = form16path;
	}


	@Column(name = "status", nullable = false)
	public Integer getStatus() {
		return status;
	}



	public void setStatus(Integer status) {
		this.status = status;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "department_id", nullable = false)
	@JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class, property="@staffs")
	public Department getDepartment() {
		return department;
	}

    public void setDepartment(Department department) {
		this.department = department;
	}


    @OneToMany(fetch = FetchType.LAZY, mappedBy = "staff")
    public Set<StaffLeaveRequisition> getStaffLeaveRequisitions() {
		return staffLeaveRequisitions;
	}
    public void setStaffLeaveRequisitions(Set<StaffLeaveRequisition> staffLeaveRequisitions) {
		this.staffLeaveRequisitions = staffLeaveRequisitions;
	}


    @ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "blood_group_id", nullable = true)
	public BloodGroup getBloodGroup() {
		return bloodGroup;
	}



	public void setBloodGroup(BloodGroup bloodGroup) {
		this.bloodGroup = bloodGroup;
	}

	@OneToOne(fetch=FetchType.LAZY,cascade=CascadeType.REMOVE)
	@JoinColumn(name = "user_id", nullable =false)
	@JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class, property="@staff")
	public Users getUser() {
		return user;
	}

    public void setUser(Users user) {
		this.user = user;
	}


    @OneToMany(fetch = FetchType.LAZY, mappedBy = "staff")
    public Set<StaffPerformance> getStaffPerformance() {
		return staffPerformance;
	}
	public void setStaffPerformance(Set<StaffPerformance> staffPerformance) {
		this.staffPerformance = staffPerformance;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "approver_id", nullable = false,referencedColumnName="user_id")
	@JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class, property="@staffs")
	public Users getApprover() {
		return approver;
	}

    public void setApprover(Users approver) {
		this.approver = approver;
	}

    @ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "institution_id", nullable = false)
    public Institution getInstitution() {
		return institution;
	}

    public void setInstitution(Institution institution) {
		this.institution = institution;
	}

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "staff")
    public Set<TimeTable> getTimetables() {
		return timetables;
	}



	public void setTimetables(Set<TimeTable> timetables) {
		this.timetables = timetables;
	}

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "staff")
	public Set<AcademicCourseSemesterModule> getAcademicCourseSemesterModules() {
		return academicCourseSemesterModules;
	}



	public void setAcademicCourseSemesterModules(Set<AcademicCourseSemesterModule> academicCourseSemesterModules) {
		this.academicCourseSemesterModules = academicCourseSemesterModules;
	}
	
}
