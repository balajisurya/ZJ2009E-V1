package in.jdsoft.educationmanagement.model;

import static javax.persistence.GenerationType.IDENTITY;

import java.sql.Timestamp;
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
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.ForeignKey;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;


@Entity
@Table(name = "tbl_student")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Student implements java.io.Serializable {


	public Student( Courses course,
			Category category, SpecialCategory specialCategory, Admission admission, Department department,
			CourseCategory courseCategory, CourseType courseType,
			StudentStatus studentStatus, Integer joinedSemester, Integer currentSemester, String firstName,
			String lastName, String parentGuardianFirstName, String parentGuardianLastName,String parentGuardianEmail,String sex, Date birthDate,
			Double fathersIncome, Double mothersIncome, String addressLine1, String addressLine2, Integer cityId,
			Integer stateId, Integer countryId, String postcode, String email, String contact, String passportNumber,
			String photoPath, Date joinedDate,String scannedSignature,
			String bankName, String bankAccountNo, String bankIfsc, String bankAddress, String tallyAccountNo,
			BloodGroup bloodGroup, String atRiskCategory, String batch, String scholarship, String myStrengths,
			String allergy, String medicineAllergy, String achievement,Users user,String accessNo,Users approver,Institution institution,String createdBy) {
		this.course = course;
		this.category = category;
		this.specialCategory = specialCategory;
		this.admission = admission;
		this.department = department;
		this.courseCategory = courseCategory;
		this.courseType = courseType;
		this.studentStatus = studentStatus;
		this.joinedSemester = joinedSemester;
		this.currentSemester = currentSemester;
		this.firstName = firstName;
		this.lastName = lastName;
		this.parentGuardianFirstName = parentGuardianFirstName;
		this.parentGuardianLastName = parentGuardianLastName;
		this.sex = sex;
		this.birthDate = birthDate;
		this.fathersIncome = fathersIncome;
		this.mothersIncome = mothersIncome;
		this.addressLine1 = addressLine1;
		this.addressLine2 = addressLine2;
		this.cityId = cityId;
		this.stateId = stateId;
		this.countryId = countryId;
		this.postcode = postcode;
		this.email = email;
		this.contact = contact;
		this.passportNumber = passportNumber;
		this.photoPath = photoPath;
		this.joinedDate = joinedDate;
		this.createdDate =new Timestamp(Calendar.getInstance().getTime().getTime());
		this.scannedSignature = scannedSignature;
		this.bankName = bankName;
		this.bankAccountNo = bankAccountNo;
		this.bankIfsc = bankIfsc;
		this.bankAddress = bankAddress;
		this.tallyAccountNo = tallyAccountNo;
		this.bloodGroup = bloodGroup;
		this.atRiskCategory = atRiskCategory;
		this.batch = batch;
		this.scholarship = scholarship;
		this.myStrengths = myStrengths;
		this.allergy = allergy;
		this.medicineAllergy = medicineAllergy;
		this.achievement = achievement;
		this.user=user;
		this.accessNo=accessNo;
		this.approver=approver;
		this.parentGuardianEmail=parentGuardianEmail;
		this.createdBy=createdBy;
		this.institution=institution;
	}
	
	private Set<Assignment> studentassignments = new HashSet<Assignment>(0);
	private Set<StudentPerformance> studentPerformance = new HashSet<StudentPerformance>(0);
	
	private Set<StudentInvoice> studentInvoices=new HashSet<StudentInvoice>(0);
	private Set<StudentAttendance> studentAttendance=new HashSet<StudentAttendance>();
	
	private static final long serialVersionUID = 1L;
	
// models
	private Courses course;
	private Category category;
	private SpecialCategory specialCategory;
	private Admission admission;
	private Department department;
	private CourseCategory courseCategory;
	private CourseType courseType;
	private StudentStatus studentStatus;
	private BloodGroup bloodGroup;
	private Users user;
	private Users approver;
	private Institution institution;
// PK	
	private Integer studentId;
	
// fields 
	
	private Integer joinedSemester;
	private Integer currentSemester;
	private String firstName;
	private String lastName;
	private String parentGuardianFirstName;
	private String parentGuardianLastName;
	private String parentGuardianEmail;
	private String sex;
	private Date birthDate;
	private Double fathersIncome;
	private Double mothersIncome;
	private String addressLine1;
	private String addressLine2;
	private Integer cityId;
	private Integer stateId;
	private Integer countryId;
	private String postcode;
	private String email;
	private String contact;
	private String passportNumber;
	private String photoPath;
	private Date joinedDate;
	private Date createdDate;
	private Date modifiedDate;
	private String scannedSignature;
	private String bankName;
	private String bankAccountNo;
	private String bankIfsc;
	private String bankAddress;
	private String tallyAccountNo;
	private String atRiskCategory;
	private String batch;
	private String scholarship;
	private String myStrengths;
	private String allergy;
	private String medicineAllergy;
	private String achievement;
	private String accessNo;
	private String createdBy;
	
	
	
	
	public Student() {
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
    @Column(name = "student_id", nullable = false)
	public Integer getStudentId() {
		return this.studentId;
	}

	public void setStudentId(Integer studentId) {
		this.studentId = studentId;
	}
    @Column(name = "first_name", nullable = false, length = 100)
	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	@Column(name = "last_name", nullable = false, length = 100)
	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@Column(name = "parent_guardian_first_name", nullable = false, length = 100)
	public String getParentGuardianFirstName() {
		return this.parentGuardianFirstName;
	}

	public void setParentGuardianFirstName(String parentGuardianFirstName) {
		this.parentGuardianFirstName = parentGuardianFirstName;
	}

	@Column(name = "parent_guardian_last_name", nullable = false, length = 100)
	public String getParentGuardianLastName() {
		return this.parentGuardianLastName;
	}

	public void setParentGuardianLastName(String parentGuardianLastName) {
		this.parentGuardianLastName = parentGuardianLastName;
	}

	@Column(name = "sex", nullable = false, length = 7)
	public String getSex() {
		return this.sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "birth_date", nullable = false, length = 10)
	public Date getBirthDate() {
		return this.birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	@Column(name = "address_line_1", nullable = false)
	public String getAddressLine1() {
		return this.addressLine1;
	}

	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}

	@Column(name = "address_line_2", nullable = false)
	public String getAddressLine2() {
		return this.addressLine2;
	}

	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}



	@Column(name = "postcode", nullable = false, length = 10)
	public String getPostcode() {
		return this.postcode;
	}

	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}

	@Column(name = "email", nullable = false, length = 100)
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name = "contact", nullable = false, length = 25)
	public String getContact() {
		return this.contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	@Column(name = "passport_number", nullable = true, length = 50)
	public String getPassportNumber() {
		return this.passportNumber;
	}

	public void setPassportNumber(String passportNumber) {
		this.passportNumber = passportNumber;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "joined_date", nullable = true, length = 10)
	public Date getJoinedDate() {
		return this.joinedDate;
	}

	public void setJoinedDate(Date joinedDate) {
		this.joinedDate = joinedDate;
	}

	

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "created_date", nullable = false, length = 19)
	public Date getCreatedDate() {
		return this.createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "modified_date", nullable = false,columnDefinition="timestamp")
	public Date getModifiedDate() {
		return this.modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	
	
	
	
// columns single field
	
	
	@Column(name = "scanned_signature", nullable = true, length = 100)
	public String getScannedSignature() {
		return scannedSignature;
	}

	public void setScannedSignature(String scannedSignature) {
		this.scannedSignature = scannedSignature;
	}
	@Column(name = "bank_name", nullable = true, length = 55)
	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	@Column(name = "bank_account_no", nullable = true, length = 50)
	public String getBankAccountNo() {
		return bankAccountNo;
	}

	public void setBankAccountNo(String bankAccountNo) {
		this.bankAccountNo = bankAccountNo;
	}

	@Column(name = "bank_ifsc", nullable = true, length =50)
	public String getBankIfsc() {
		return bankIfsc;
	}

	public void setBankIfsc(String bankIfsc) {
		this.bankIfsc = bankIfsc;
	}
	
	@Column(name = "bank_address", nullable = true, length =100)
	public String getBankAddress() {
		return bankAddress;
	}

	public void setBankAddress(String bankAddress) {
		this.bankAddress = bankAddress;
	}

	@Column(name = "tally_account_no", nullable = true, length =50)
	public String getTallyAccountNo() {
		return tallyAccountNo;
	}

	public void setTallyAccountNo(String tallyAccountNo) {
		this.tallyAccountNo = tallyAccountNo;
	}

	@Column(name = "at_risk_category", nullable = true, length =50)

	public String getAtRiskCategory() {
		return atRiskCategory;
	}

	public void setAtRiskCategory(String atRiskCategory) {
		this.atRiskCategory = atRiskCategory;
	}

	@Column(name = "batch", nullable = true, length =50)
	public String getBatch() {
		return batch;
	}

	public void setBatch(String batch) {
		this.batch = batch;
	}

	@Column(name = "scholarship", nullable = true, length =50)
	public String getScholarship() {
		return scholarship;
	}

	public void setScholarship(String scholarship) {
		this.scholarship = scholarship;
	}

	@Column(name = "my_strengths", nullable = true, length =255)
	public String getMyStrengths() {
		return myStrengths;
	}
	public void setMyStrengths(String myStrengths) {
		this.myStrengths = myStrengths;
	}

	@Column(name = "allergy", nullable = true, length =100)
	public String getAllergy() {
		return allergy;
	}

	public void setAllergy(String allergy) {
		this.allergy = allergy;
	}

	@Column(name = "medicine_allergy", nullable = true, length =100)
	public String getMedicineAllergy() {
		return medicineAllergy;
	}

	public void setMedicineAllergy(String medicineAllergy) {
		this.medicineAllergy = medicineAllergy;
	}

	@Column(name = "achievement", nullable = true, length =250)
	public String getAchievement() {
		return achievement;
	}

	public void setAchievement(String achievement) {
		this.achievement = achievement;
	}


	@Column(name = "joined_semester", nullable = true)
	public Integer getJoinedSemester() {
		return joinedSemester;
	}



	public void setJoinedSemester(Integer joinedSemester) {
		this.joinedSemester = joinedSemester;
	}

	@Column(name = "current_semester", nullable = true)

	public Integer getCurrentSemester() {
		return currentSemester;
	}



	public void setCurrentSemester(Integer currentSemester) {
		this.currentSemester = currentSemester;
	}

	@Column(name = "fathers_income", nullable = true)

	public Double getFathersIncome() {
		return fathersIncome;
	}



	public void setFathersIncome(Double fathersIncome) {
		this.fathersIncome = fathersIncome;
	}

	@Column(name = "mothers_income", nullable = true)

	public Double getMothersIncome() {
		return mothersIncome;
	}



	public void setMothersIncome(Double mothersIncome) {
		this.mothersIncome = mothersIncome;
	}


	@Column(name = "city_id", nullable = true)
	public Integer getCityId() {
		return cityId;
	}



	public void setCityId(Integer cityId) {
		this.cityId = cityId;
	}

	@Column(name = "state_id", nullable = true)

	public Integer getStateId() {
		return stateId;
	}



	public void setStateId(Integer stateId) {
		this.stateId = stateId;
	}

	@Column(name = "country_id", nullable = true)

	public Integer getCountryId() {
		return countryId;
	}



	public void setCountryId(Integer countryId) {
		this.countryId = countryId;
	}

	@Column(name = "photo_path", nullable = true, length =100)

	public String getPhotoPath() {
		return photoPath;
	}
	public void setPhotoPath(String photoPath) {
		this.photoPath = photoPath;
	}

	@Column(name = "access_no", nullable = true, length =50)
	public String getAccessNo() {
		return accessNo;
	}

	public void setAccessNo(String accessNo) {
		this.accessNo = accessNo;
	}
	@Column(name = "parent_guardian_email", nullable =false, length =50)
	public String getParentGuardianEmail() {
		return parentGuardianEmail;
	}

	public void setParentGuardianEmail(String parentGuardianEmail) {
		this.parentGuardianEmail = parentGuardianEmail;
	}

	@Column(name = "created_by", nullable =false, length =50)
	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	// Mappings

	@ManyToMany(fetch = FetchType.LAZY,mappedBy = "studentassignments")
	public Set<Assignment> getStudentassignments() {
		return studentassignments;
	}
	public void setStudentassignments(Set<Assignment> studentassignments) {
		this.studentassignments = studentassignments;
	}


	@OneToMany(fetch = FetchType.LAZY, mappedBy = "student")
	public Set<StudentPerformance> getStudentPerformance() {
		return studentPerformance;
	}
	public void setStudentPerformance(Set<StudentPerformance> studentPerformance) {
		this.studentPerformance = studentPerformance;
	}

	@OneToOne(fetch=FetchType.LAZY,cascade=CascadeType.REMOVE)
	@JoinColumn(name = "user_id", nullable =false)
	@JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class, property="@student")
	@JsonIdentityReference(alwaysAsId = true)
	public Users getUser() {
		return user;
	}

	public void setUser(Users user) {
		this.user = user;
	}



	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "course_type_id", nullable = false)
	public CourseType getCourseType() {
		return courseType;
	}

	public void setCourseType(CourseType courseType) {
		this.courseType = courseType;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "course_category_id", nullable = false)
	public CourseCategory getCourseCategory() {
		return courseCategory;
	}

	public void setCourseCategory(CourseCategory courseCategory) {
		this.courseCategory = courseCategory;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "student_status_id", nullable = false)
	public StudentStatus getStudentStatus() {
		return studentStatus;
	}

	public void setStudentStatus(StudentStatus studentStatus) {
		this.studentStatus = studentStatus;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "department_id", nullable = false)
	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "admission_id", nullable =false)
	public Admission getAdmission() {
		return admission;
	}

	public void setAdmission(Admission admission) {
		this.admission = admission;
	}
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "category_id", nullable = false)
	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "course_id", nullable = false)
	@ForeignKey(name="courseInStudent")
	public Courses getCourse() {
		return course;
	}

	public void setCourse(Courses course) {
		this.course = course;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "special_category_id", nullable = false)
	public SpecialCategory getSpecialCategory() {
		return specialCategory;
	}

	public void setSpecialCategory(SpecialCategory specialCategory) {
		this.specialCategory = specialCategory;
	}
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "blood_group_id", nullable =true)
	public BloodGroup  getBloodGroup() {
		return bloodGroup;
	}

	public void setBloodGroup(BloodGroup bloodGroup) {
		this.bloodGroup = bloodGroup;
	}

	
  
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "approver_id", nullable =true,referencedColumnName="user_id")
	public Users getApprover() {
		return approver;
	}

	public void setApprover(Users approver) {
		this.approver = approver;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "student",cascade=CascadeType.PERSIST)
	public Set<StudentInvoice> getStudentInvoices() {
		return studentInvoices;
	}

	public void setStudentInvoices(Set<StudentInvoice> studentInvoices) {
		this.studentInvoices = studentInvoices;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "student")
	public Set<StudentAttendance> getStudentAttendance() {
		return studentAttendance;
	}

	public void setStudentAttendance(Set<StudentAttendance> studentAttendance) {
		this.studentAttendance = studentAttendance;
	}
    
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "institution_id", nullable = false)
	public Institution getInstitution() {
		return institution;
	}

	public void setInstitution(Institution institution) {
		this.institution = institution;
	}

	
	
}
