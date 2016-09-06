package in.jdsoft.educationmanagement.school.model;

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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

import org.hibernate.annotations.ForeignKey;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;


@Entity
@Table(name = "tbl_student",uniqueConstraints = {@UniqueConstraint(columnNames = {
		"class_id", "section_id","roll_no" }),@UniqueConstraint(columnNames={"admission_no"}),@UniqueConstraint(columnNames={"email"})})
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Student implements java.io.Serializable {

	
	public Student() {}

	public Student(AcademicYear joinedAcademicYear, Class studentClass,Section section,
			Category category, SpecialCategory specialCategory,
			StudentStatus studentStatus,String firstName,
			String lastName, String parentGuardianFirstName, String parentGuardianLastName,String parentGuardianEmail,String sex, Date birthDate,
			Double fathersIncome, Double mothersIncome, String addressLine1, String addressLine2, Integer cityId,
			Integer stateId, Integer countryId, String postcode, String email, String contact, String passportNumber,
			String photoPath, Date joinedDate,String scannedSignature,
			BloodGroup bloodGroup,String accessNo,String rollNo,String parentContact, Institution institution,String createdBy) {
		this.studentClass=studentClass;
		this.rollNo=rollNo;
		this.joinedClass=studentClass;
		this.section=section;
		this.category = category;
		this.specialCategory = specialCategory;
		this.studentStatus = studentStatus;
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
		this.bloodGroup = bloodGroup;
		this.accessNo=accessNo;
		this.parentGuardianEmail=parentGuardianEmail;
		this.createdBy=createdBy;
		this.institution=institution;
		this.joinedAcademicYear=joinedAcademicYear;
		this.parentContact=parentContact;
	}
	
	public Student(AcademicYear joinedAcademicYear, Class studentClass,Section section,Class joinedClass,
			Category category, SpecialCategory specialCategory,
			StudentStatus studentStatus,String firstName,
			String lastName, String parentGuardianFirstName, String parentGuardianLastName,String parentGuardianEmail,String sex, Date birthDate,
			Double fathersIncome, Double mothersIncome, String addressLine1, String addressLine2, Integer cityId,
			Integer stateId, Integer countryId, String postcode, String email, String contact, String passportNumber,
			String photoPath, Date joinedDate,String scannedSignature,
			BloodGroup bloodGroup,String accessNo,String admissionNo,String rollNo,String parentContact, Institution institution,String createdBy) {
		this.studentClass=studentClass;
		this.rollNo=rollNo;
		this.admissionNo=admissionNo;
		this.joinedClass=joinedClass;
		this.section=section;
		this.category = category;
		this.specialCategory = specialCategory;
		this.studentStatus = studentStatus;
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
		this.bloodGroup = bloodGroup;
		this.accessNo=accessNo;
		this.parentGuardianEmail=parentGuardianEmail;
		this.createdBy=createdBy;
		this.institution=institution;
		this.joinedAcademicYear=joinedAcademicYear;
		this.parentContact=parentContact;
	}
	
	
	
	
	private static final long serialVersionUID = 1L;
	
// models
	
	private Category category;
	private SpecialCategory specialCategory;
	private StudentStatus studentStatus;
	private BloodGroup bloodGroup;
	private User user;
	private Institution institution;
	private Class studentClass;
	private Section section;
// PK	
	private Integer studentId;
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
	private String parentContact;
	private String passportNumber;
	private String photoPath;
	private Date joinedDate;
	private Date createdDate;
	private Date modifiedDate;
	private String scannedSignature;
	private String accessNo;
	private String createdBy;
	private AcademicYear joinedAcademicYear;
	private Class joinedClass;
	private String admissionNo;
	private String rollNo;
	
	
	private Set<StudentInvoice> invoices=new HashSet<StudentInvoice>(0);
	private Set<StudentReceipt> studentReceipts=new HashSet<StudentReceipt>(0);
	


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

	@Column(name = "last_name", nullable = true, length = 100)
	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@Column(name = "parent_guardian_first_name", nullable = true, length = 100)
	public String getParentGuardianFirstName() {
		return this.parentGuardianFirstName;
	}

	public void setParentGuardianFirstName(String parentGuardianFirstName) {
		this.parentGuardianFirstName = parentGuardianFirstName;
	}

	@Column(name = "parent_guardian_last_name", nullable = true, length = 100)
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
	@Column(name = "birth_date", nullable =true, length = 10)
	public Date getBirthDate() {
		return this.birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	@Column(name = "address_line_1", nullable = true)
	public String getAddressLine1() {
		return this.addressLine1;
	}

	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}

	@Column(name = "address_line_2", nullable = true)
	public String getAddressLine2() {
		return this.addressLine2;
	}

	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}



	@Column(name = "postcode", nullable = true, length = 10)
	public String getPostcode() {
		return this.postcode;
	}

	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}

	@Column(name = "email", nullable =true, length = 100)
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name = "contact", nullable = true, length = 25)
	public String getContact() {
		return this.contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	@Column(name = "passport_number", nullable = true, length = 100)
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
	@Column(name = "parent_guardian_email", nullable =true, length =100)
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

	@OneToOne(fetch=FetchType.LAZY,cascade={CascadeType.REMOVE})
	@JoinColumn(name = "user_id", nullable =true)
	@ForeignKey(name="studentInUser")
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}



	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "student_status_id", nullable = false)
	@ForeignKey(name="studentInStudentStatus")
	public StudentStatus getStudentStatus() {
		return studentStatus;
	}

	public void setStudentStatus(StudentStatus studentStatus) {
		this.studentStatus = studentStatus;
	}


	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "category_id", nullable =true)
	@ForeignKey(name="studentInCategory")
	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}


	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "special_category_id", nullable = false)
	@ForeignKey(name="studentInSpecialCategory")
	@JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class, property="@students")
	@JsonIdentityReference(alwaysAsId = true)
	public SpecialCategory getSpecialCategory() {
		return specialCategory;
	}

	public void setSpecialCategory(SpecialCategory specialCategory) {
		this.specialCategory = specialCategory;
	}
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "blood_group_id", nullable =true)
	@ForeignKey(name="studentInBloodGroup")
	public BloodGroup  getBloodGroup() {
		return bloodGroup;
	}

	public void setBloodGroup(BloodGroup bloodGroup) {
		this.bloodGroup = bloodGroup;
	}

	

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "institution_id", nullable = false)
	@ForeignKey(name="studentInInstitution")
	@JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class, property="@students")
	@JsonIdentityReference(alwaysAsId = true)
	public Institution getInstitution() {
		return institution;
	}

	public void setInstitution(Institution institution) {
		this.institution = institution;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "class_id", nullable = false)
	@ForeignKey(name="studentInClass")
    public Class getStudentClass() {
		return studentClass;
	}

	public void setStudentClass(Class studentClass) {
		this.studentClass = studentClass;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "section_id", nullable = false)
	@ForeignKey(name="studentInSection")
	public Section getSection() {
		return section;
	}

	public void setSection(Section section) {
		this.section = section;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "student")
	@ForeignKey(name="studentInStudentInvoices")
	@JsonBackReference
	public Set<StudentInvoice> getInvoices() {
		return invoices;
	}

	public void setInvoices(Set<StudentInvoice> invoices) {
		this.invoices = invoices;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "academic_year_id", nullable = true)
	@ForeignKey(name="studentInAcademicYear")
	public AcademicYear getJoinedAcademicYear() {
		return joinedAcademicYear;
	}

	public void setJoinedAcademicYear(AcademicYear joinedAcademicYear) {
		this.joinedAcademicYear = joinedAcademicYear;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "joined_class_id", nullable = true,referencedColumnName="class_id")
	@ForeignKey(name="joinedStudentInClass")
	public Class getJoinedClass() {
		return joinedClass;
	}

	public void setJoinedClass(Class joinedClass) {
		this.joinedClass = joinedClass;
	}
	
	@Column(name = "admission_no",nullable =false, length =50)
	public String getAdmissionNo() {
		return admissionNo;
	}

	public void setAdmissionNo(String admissionNo) {
		this.admissionNo = admissionNo;
	}
	
	@Column(name = "roll_no", nullable =true, length =50)
	public String getRollNo() {
		return rollNo;
	}

	public void setRollNo(String rollNo) {
		this.rollNo = rollNo;
	}


	@OneToMany(fetch = FetchType.LAZY, mappedBy = "student")
	@ForeignKey(name="studentInStudentReceipts")
	@JsonBackReference
	public Set<StudentReceipt> getStudentReceipts() {
		return studentReceipts;
	}

	public void setStudentReceipts(Set<StudentReceipt> studentReceipts) {
		this.studentReceipts = studentReceipts;
	}
	@Column(name = "parent_contact", nullable =true, length =50)
	public String getParentContact() {
		return parentContact;
	}

	public void setParentContact(String parentContact) {
		this.parentContact = parentContact;
	}

}