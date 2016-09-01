package in.jdsoft.educationmanagement.model;

import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;
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

import org.apache.commons.lang.WordUtils;
import org.hibernate.annotations.ForeignKey;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table(name = "tbl_admission")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Admission implements Serializable{
	
	public Admission() {}
	
	public Admission(AdmissionConfig admissionConfig, CourseType courseType, Department department, Courses course,
			CourseCategory courseCategory, AdmissionStatus admissionStatus, Religion religion, Sponser sponser,
			Category category, SpecialCategory specialCategory, HearedUs hearedUs, String admissionCode,
			String candidateFirstName, String candidateLastName, String fatherFirstName, String fatherLastName,
			String fatherOccupation, String motherFirstName, String motherLastName, String motherOccupation,
			double fatherIncome, double motherIncome, String guardianFirstName, String guardianLastName,
			String passportNo, String studiedHereBefore, String previousStudentIdOfThisInstitute, String disability,
			String referenceOneFirstName, String referenceOneLastName, String referenceOneEmail,
			String referenceOneMobile, String referenceOneAddressLineOne, String referenceOneAddressLineTwo,
			int referenceOneCountry, String referenceOnePincode, String referenceTwoFirstName,
			String referenceTwoLastName, String referenceTwoEmail, String referenceTwoMobile,
			String referenceTwoAddressLineOne, String referenceTwoAddressLineTwo, int referenceTwoCountry,
			String referenceTwoPincode, String scannedSignaturePath, String candidateGender, Date dateOfBirth,
			String candidateEmail, String candidateContact, int passportIssuedCountry, String candidateAddressLineOne,
			String candidateAddressLineTwo, int candidateCountry, int candidateState, int candidateCity,
			String candidatePostcode, String candidatePhotoPath, int submitStatus, Double admissionRank, Users user,
			Set<AdmissionDocument> admissionDocuments, Set<AdmissionEducationLevelDetails> admissionAcademicsDetails,
			AdmissionFeesPaymentDetails admissionFeesPaymentDetails,Set<AdmissionEducationLevelSubjects> admissionEducationLevelSubjects) {
		
		this.admissionConfig = admissionConfig;
		this.courseType = courseType;
		this.department = department;
		this.course = course;
		this.courseCategory = courseCategory;
		this.admissionStatus = admissionStatus;
		this.religion = religion;
		this.sponser = sponser;
		this.category = category;
		this.specialCategory = specialCategory;
		this.hearedUs = hearedUs;
		this.admissionCode = admissionCode.toUpperCase();
		this.candidateFirstName =WordUtils.capitalize(candidateFirstName);
		this.candidateLastName =WordUtils.capitalize(candidateLastName);
		this.fatherFirstName =WordUtils.capitalize( fatherFirstName);
		this.fatherLastName = WordUtils.capitalize(fatherLastName);
		this.fatherOccupation =WordUtils.capitalize(fatherOccupation);
		this.motherFirstName =WordUtils.capitalize( motherFirstName);
		this.motherLastName =WordUtils.capitalize(motherLastName);
		this.motherOccupation =WordUtils.capitalize(motherOccupation);
		this.fatherIncome =fatherIncome;
		this.motherIncome = motherIncome;
		this.guardianFirstName =WordUtils.capitalize(guardianFirstName);
		this.guardianLastName =WordUtils.capitalize(guardianLastName);
		this.passportNo =passportNo;
		this.studiedHereBefore =WordUtils.capitalize(studiedHereBefore);
		this.previousStudentIdOfThisInstitute = previousStudentIdOfThisInstitute;
		this.disability =WordUtils.capitalize(disability);
		this.referenceOneFirstName =WordUtils.capitalize(referenceOneFirstName);
		this.referenceOneLastName =WordUtils.capitalize(referenceOneLastName);
		this.referenceOneEmail =referenceOneEmail.toLowerCase();
		this.referenceOneMobile = referenceOneMobile;
		this.referenceOneAddressLineOne =WordUtils.capitalize(referenceOneAddressLineOne);
		this.referenceOneAddressLineTwo =WordUtils.capitalize(referenceOneAddressLineTwo);
		this.referenceOneCountry =referenceOneCountry;
		this.referenceOnePincode = referenceOnePincode;
		this.referenceTwoFirstName =WordUtils.capitalize(referenceTwoFirstName);
		this.referenceTwoLastName =WordUtils.capitalize(referenceTwoLastName);
		this.referenceTwoEmail =referenceTwoEmail.toLowerCase();
		this.referenceTwoMobile =referenceTwoMobile;
		this.referenceTwoAddressLineOne =WordUtils.capitalize(referenceTwoAddressLineOne);
		this.referenceTwoAddressLineTwo =WordUtils.capitalize(referenceTwoAddressLineTwo);
		this.referenceTwoCountry =referenceTwoCountry;
		this.referenceTwoPincode =referenceTwoPincode;
		this.scannedSignaturePath =scannedSignaturePath;
		this.candidateGender =WordUtils.capitalize(candidateGender);
		this.dateOfBirth =dateOfBirth;
		this.candidateEmail = candidateEmail.toLowerCase();
		this.candidateContact = candidateContact;
		this.passportIssuedCountry = passportIssuedCountry;
		this.candidateAddressLineOne =WordUtils.capitalize(candidateAddressLineOne);
		this.candidateAddressLineTwo =WordUtils.capitalize(candidateAddressLineTwo);
		this.candidateCountry = candidateCountry;
		this.candidateState = candidateState;
		this.candidateCity = candidateCity;
		this.candidatePostcode = candidatePostcode;
		this.candidatePhotoPath = candidatePhotoPath;
		this.submitStatus = submitStatus;
		this.createdDate = new Date(Calendar.getInstance().getTime().getTime());
		this.admissionDocuments = admissionDocuments;
		this.admissionAcademicsDetails = admissionAcademicsDetails;
		this.admissionFeesPaymentDetails = admissionFeesPaymentDetails;
		this.admissionEducationLevelSubjects=admissionEducationLevelSubjects;
		this.user=user;
		this.admissionRank=admissionRank;
	}



	private static final long serialVersionUID = 1L;

	
	
	
	private AdmissionConfig admissionConfig;	
	private CourseType courseType;	
	private Department department;
	private Courses course;
	private CourseCategory courseCategory;
	private AdmissionStatus admissionStatus;	
	private Religion religion;	
	private Sponser sponser;	
	private Category category;	
	private SpecialCategory specialCategory;	
	private HearedUs hearedUs;	
	private Users user;
	
	
	
	private int admissionId;
	private String admissionCode;
	private String candidateFirstName;
	private String candidateLastName;
	private String fatherFirstName;
	private String fatherLastName;
	private String fatherOccupation;
	private String motherFirstName;
	private String motherLastName;
	private String motherOccupation;
	private double fatherIncome;
	private double motherIncome;
	private String guardianFirstName;
	private String guardianLastName;
	private String passportNo;
	private String studiedHereBefore;
	private String previousStudentIdOfThisInstitute;
	private String disability;
	private String referenceOneFirstName;
	private String referenceOneLastName;
	private String referenceOneEmail;
	private String referenceOneMobile;
	private String referenceOneAddressLineOne;
	private String referenceOneAddressLineTwo;
	private int referenceOneCountry;
	private String referenceOnePincode;
	private String referenceTwoFirstName;
	private String referenceTwoLastName;
	private String referenceTwoEmail;
	private String referenceTwoMobile;
	private String referenceTwoAddressLineOne;
	private String referenceTwoAddressLineTwo;
	private int referenceTwoCountry;
	private String referenceTwoPincode;
	private String scannedSignaturePath;
	private String candidateGender;
	private Date dateOfBirth;
	private String candidateEmail;
	private String candidateContact;
	private int passportIssuedCountry;
	private String candidateAddressLineOne;
	private String candidateAddressLineTwo;
	private int candidateCountry;
	private int candidateState;
	private int candidateCity;
	private String candidatePostcode;
	private String candidatePhotoPath;
	private int submitStatus;
	private Date createdDate;
	private Date modifiedDate;
	private Double admissionRank;

	
	
	private Set<AdmissionDocument> admissionDocuments=new HashSet<AdmissionDocument>(0);
	
	private Set<AdmissionEducationLevelDetails> admissionAcademicsDetails=new HashSet<AdmissionEducationLevelDetails>(0);
	
	private AdmissionFeesPaymentDetails admissionFeesPaymentDetails=new AdmissionFeesPaymentDetails();
	
	private Set<AdmissionEducationLevelSubjects> admissionEducationLevelSubjects=new HashSet<AdmissionEducationLevelSubjects>(0);
	
	private Student student=new Student();
	
	
	
	
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "admission_id",nullable = false)
	public int getAdmissionId() {
		return admissionId;
	}
	public void setAdmissionId(int admissionId) {
		this.admissionId = admissionId;
	}
	
	@Column(name = "admission_code", nullable = false, length = 50)
	public String getAdmissionCode() {
		return admissionCode;
	}
	public void setAdmissionCode(String admissionCode) {
		this.admissionCode = admissionCode.toUpperCase();
	}
	
	@Column(name = "candidate_first_name", nullable =true, length = 50)
	public String getCandidateFirstName() {
		return candidateFirstName;
	}
	public void setCandidateFirstName(String candidateFirstName) {
		this.candidateFirstName =WordUtils.capitalize(candidateFirstName);
	}
	
	@Column(name = "candidate_last_name", nullable =true, length = 50)
	public String getCandidateLastName() {
		return candidateLastName;
	}
	public void setCandidateLastName(String candidateLastName) {
		this.candidateLastName = WordUtils.capitalize(candidateLastName);
	}
	
	@Column(name = "candidate_father_first_name", nullable =true, length = 50)
	public String getFatherFirstName() {
		return fatherFirstName;
	}
	public void setFatherFirstName(String fatherFirstName) {
		this.fatherFirstName =WordUtils.capitalize(fatherFirstName);
	}
	
	@Column(name = "candidate_father_last_name", nullable =true, length = 50)
	public String getFatherLastName() {
		return fatherLastName;
	}
	public void setFatherLastName(String fatherLastName) {
		this.fatherLastName =WordUtils.capitalize(fatherLastName);
	}
	
	@Column(name = "candidate_father_occupation", nullable =true, length = 100)
	public String getFatherOccupation() {
		return fatherOccupation;
	}
	public void setFatherOccupation(String fatherOccupation) {
		this.fatherOccupation =WordUtils.capitalize(fatherOccupation);
	}
	
	@Column(name = "candidate_mother_first_name", nullable =true, length = 50)
	public String getMotherFirstName() {
		return motherFirstName;
	}
	public void setMotherFirstName(String motherFirstName) {
		this.motherFirstName =WordUtils.capitalize(motherFirstName);
	}
	
	@Column(name = "candidate_mother_last_name", nullable =true, length = 50)
	public String getMotherLastName() {
		return motherLastName;
	}
	public void setMotherLastName(String motherLastName) {
		this.motherLastName =WordUtils.capitalize(motherLastName);
	}
	
	@Column(name = "candidate_mother_occupation", nullable =true, length = 50)
	public String getMotherOccupation() {
		return motherOccupation;
	}
	public void setMotherOccupation(String motherOccupation) {
		this.motherOccupation =WordUtils.capitalize(motherOccupation);
	}
	
	@Column(name = "candidate_guardian_first_name", nullable =true, length = 50)
	public String getGuardianFirstName() {
		return guardianFirstName;
	}
	public void setGuardianFirstName(String guardianFirstName) {
		this.guardianFirstName =WordUtils.capitalize(guardianFirstName);
	}
	
	@Column(name = "candidate_guardian_last_name", nullable =true, length = 50)
	public String getGuardianLastName() {
		return guardianLastName;
	}
	public void setGuardianLastName(String guardianLastName) {
		this.guardianLastName =WordUtils.capitalize(guardianLastName);
	}
	
	@Column(name = "candidate_passport_no", nullable =true, length = 50)
	public String getPassportNo() {
		return passportNo;
	}
	public void setPassportNo(String passportNo) {
		this.passportNo = passportNo;
	}
	
	@Column(name = "studied_here_before", nullable =true, length =3)
	public String getStudiedHereBefore() {
		return studiedHereBefore;
	}
	public void setStudiedHereBefore(String studiedHereBefore) {
		this.studiedHereBefore =WordUtils.capitalize(studiedHereBefore);
	}
	
	@Column(name = "previous_student_id", nullable =true, length = 50)
	public String getPreviousStudentIdOfThisInstitute() {
		return previousStudentIdOfThisInstitute;
	}
	public void setPreviousStudentIdOfThisInstitute(String previousStudentIdOfThisInstitute) {
		this.previousStudentIdOfThisInstitute = previousStudentIdOfThisInstitute;
	}
	
	@Column(name = "disability", nullable =true, length = 3)
	public String getDisability() {
		return disability;
	}
	public void setDisability(String disability) {
		this.disability =WordUtils.capitalize(disability);
	}
	
	@Column(name = "referenceOne_first_name", nullable =true, length = 50)
	public String getReferenceOneFirstName() {
		return referenceOneFirstName;
	}
	public void setReferenceOneFirstName(String referenceOneFirstName) {
		this.referenceOneFirstName =WordUtils.capitalize(referenceOneFirstName);
	}
	
	@Column(name = "referenceOne_last_name", nullable =true, length = 50)
	public String getReferenceOneLastName() {
		return referenceOneLastName;
	}
	public void setReferenceOneLastName(String referenceOneLastName) {
		this.referenceOneLastName =WordUtils.capitalize(referenceOneLastName);
	}
	
	@Column(name = "referenceOne_email", nullable =true, length = 50)
	public String getReferenceOneEmail() {
		return referenceOneEmail;
	}
	public void setReferenceOneEmail(String referenceOneEmail) {
		this.referenceOneEmail = referenceOneEmail.toLowerCase();
	}
	
	@Column(name = "referenceOne_mobile", nullable =true, length = 20)
	public String getReferenceOneMobile() {
		return referenceOneMobile;
	}
	public void setReferenceOneMobile(String referenceOneMobile) {
		this.referenceOneMobile = referenceOneMobile;
	}
	
	@Column(name = "referenceOne_addressLine_one", nullable =true, length = 100)
	public String getReferenceOneAddressLineOne() {
		return referenceOneAddressLineOne;
	}
	public void setReferenceOneAddressLineOne(String referenceOneAddressLineOne) {
		this.referenceOneAddressLineOne =WordUtils.capitalize(referenceOneAddressLineOne);
	}
	
	@Column(name = "referenceOne_addressLine_two", nullable =true, length = 100)
	public String getReferenceOneAddressLineTwo() {
		return referenceOneAddressLineTwo;
	}
	public void setReferenceOneAddressLineTwo(String referenceOneAddressLineTwo) {
		this.referenceOneAddressLineTwo =WordUtils.capitalize(referenceOneAddressLineTwo);
	}
	
	@Column(name = "referenceOne_pincode", nullable =true, length = 10)
	public String getReferenceOnePincode() {
		return referenceOnePincode;
	}
	public void setReferenceOnePincode(String referenceOnePincode) {
		this.referenceOnePincode = referenceOnePincode;
	}
	
	@Column(name = "referenceTwo_first_name", nullable =true, length = 50)
	public String getReferenceTwoFirstName() {
		return referenceTwoFirstName;
	}
	public void setReferenceTwoFirstName(String referenceTwoFirstName) {
		this.referenceTwoFirstName =WordUtils.capitalize(referenceTwoFirstName);
	}
	
	@Column(name = "referenceTwo_last_name", nullable =true, length = 50)
	public String getReferenceTwoLastName() {
		return referenceTwoLastName;
	}
	public void setReferenceTwoLastName(String referenceTwoLastName) {
		this.referenceTwoLastName =WordUtils.capitalize(referenceTwoLastName);
	}
	
	@Column(name = "referenceTwo_email", nullable =true, length = 100)
	public String getReferenceTwoEmail() {
		return referenceTwoEmail;
	}
	public void setReferenceTwoEmail(String referenceTwoEmail) {
		this.referenceTwoEmail = referenceTwoEmail.toLowerCase();
	}
	
	@Column(name = "referenceTwo_mobile", nullable =true, length = 10)
	public String getReferenceTwoMobile() {
		return referenceTwoMobile;
	}
	public void setReferenceTwoMobile(String referenceTwoMobile) {
		this.referenceTwoMobile = referenceTwoMobile;
	}
	
	@Column(name = "referenceTwo_addressLine_one", nullable =true, length = 100)
	public String getReferenceTwoAddressLineOne() {
		return referenceTwoAddressLineOne;
	}
	
	public void setReferenceTwoAddressLineOne(String referenceTwoAddressLineOne) {
		this.referenceTwoAddressLineOne =WordUtils.capitalize(referenceTwoAddressLineOne);
	}
	
	@Column(name = "referenceTwo_addressLine_two", nullable =true, length = 100)
	public String getReferenceTwoAddressLineTwo() {
		return referenceTwoAddressLineTwo;
	}
	public void setReferenceTwoAddressLineTwo(String referenceTwoAddressLineTwo) {
		this.referenceTwoAddressLineTwo =WordUtils.capitalize(referenceTwoAddressLineTwo);
	}
	
	@Column(name = "referenceTwo_pincode", nullable =true, length = 10)
	public String getReferenceTwoPincode() {
		return referenceTwoPincode;
	}
	public void setReferenceTwoPincode(String referenceTwoPincode) {
		this.referenceTwoPincode = referenceTwoPincode;
	}
	
	@Column(name = "scanned_signature_path", nullable =true, length = 255)
	public String getScannedSignaturePath() {
		return scannedSignaturePath;
	}
	public void setScannedSignaturePath(String scannedSignaturePath) {
		this.scannedSignaturePath = scannedSignaturePath;
	}
	
	@Column(name = "candidate_gender", nullable =true, length = 7)
	public String getCandidateGender() {
		return candidateGender;
	}
	public void setCandidateGender(String candidateGender) {
		this.candidateGender = WordUtils.capitalize(candidateGender);
	}
	
	@Column(name = "candidate_email", nullable =true, length = 50)
	public String getCandidateEmail() {
		return candidateEmail;
	}
	public void setCandidateEmail(String candidateEmail) {
		this.candidateEmail =candidateEmail.toLowerCase();
	}
	
	@Column(name = "candidate_contact_no", nullable =true, length = 20)
	public String getCandidateContactNo() {
		return candidateContact;
	}
	public void setCandidateContactNo(String candidateContact) {
		this.candidateContact = candidateContact;
	}
	
	@Column(name = "candidate_addressLine_one", nullable =true, length = 100)
	public String getCandidateAddressLineOne() {
		return candidateAddressLineOne;
	}
	public void setCandidateAddressLineOne(String candidateAddressLineOne) {
		this.candidateAddressLineOne =WordUtils.capitalize(candidateAddressLineOne);
	}
	
	@Column(name = "candidate_addressLine_two", nullable =true, length = 100)
	public String getCandidateAddressLineTwo() {
		return candidateAddressLineTwo;
	}
	public void setCandidateAddressLineTwo(String candidateAddressLineTwo) {
		this.candidateAddressLineTwo =WordUtils.capitalize(candidateAddressLineTwo);
	}
	
	@Column(name = "candidate_postcode", nullable =true, length = 10)
	public String getCandidatePostcode() {
		return candidatePostcode;
	}
	public void setCandidatePostcode(String candidatePostcode) {
		this.candidatePostcode = candidatePostcode;
	}
	
	@Column(name = "candidate_photo_path", nullable =true, length =255)
	public String getCandidatePhotoPath() {
		return candidatePhotoPath;
	}
	public void setCandidatePhotoPath(String candidatePhotoPath) {
		this.candidatePhotoPath = candidatePhotoPath;
	}
	
	@Column(name = "referenceOne_country",nullable = true)
	public int getReferenceOneCountry() {
		return referenceOneCountry;
	}
	public void setReferenceOneCountry(int referenceOneCountry) {
		this.referenceOneCountry = referenceOneCountry;
	}
	
	@Column(name = "referenceTwo_country",nullable = true)
	public int getReferenceTwoCountry() {
		return referenceTwoCountry;
	}
	public void setReferenceTwoCountry(int referenceTwoCountry) {
		this.referenceTwoCountry = referenceTwoCountry;
	}
	
	@Column(name = "passport_issued_country",nullable = true)
	public int getPassportIssuedCountry() {
		return passportIssuedCountry;
	}
	public void setPassportIssuedCountry(int passportIssuedCountry) {
		this.passportIssuedCountry = passportIssuedCountry;
	}
	
	@Column(name = "candidate_country",nullable = true)
	public int getCandidateCountry() {
		return candidateCountry;
	}
	public void setCandidateCountry(int candidateCountry) {
		this.candidateCountry = candidateCountry;
	}
	
	@Column(name = "candidate_state",nullable = true)
	public int getCandidateState() {
		return candidateState;
	}
	public void setCandidateState(int candidateState) {
		this.candidateState = candidateState;
	}
	
	@Column(name = "candidate_city",nullable = true)
	public int getCandidateCity() {
		return candidateCity;
	}
	public void setCandidateCity(int candidateCity) {
		this.candidateCity = candidateCity;
	}
	
	@Column(name = "submit_status",nullable = true)
	public int getSubmitStatus() {
		return submitStatus;
	}
	public void setSubmitStatus(int submitStatus) {
		this.submitStatus = submitStatus;
	}
	
	@Column(name = "father_income",nullable = true)
	public double getFatherIncome() {
		return fatherIncome;
	}
	public void setFatherIncome(double fatherIncome) {
		this.fatherIncome = fatherIncome;
	}
	
	@Column(name = "mother_income",nullable = true)
	public double getMotherIncome() {
		return motherIncome;
	}
	public void setMotherIncome(double motherIncome) {
		this.motherIncome = motherIncome;
	}
	
	@Column(name = "admission_rank",nullable = true)
	public Double getAdmissionRank() {
		return admissionRank;
	}

	public void setAdmissionRank(Double admissionRank) {
		this.admissionRank = admissionRank;
	}
	
	
	@Temporal(TemporalType.DATE)
	@Column(name = "date_of_birth", nullable =true)
	public Date getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "created_date", nullable = false)
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "modified_date", nullable = false,columnDefinition="timestamp")
	public Date getModifiedDate() {
		return modifiedDate;
	}
	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "admission_config_id", nullable = false)
	public AdmissionConfig getAdmissionConfig() {
		return admissionConfig;
	}
	
	public void setAdmissionConfig(AdmissionConfig admissionConfig) {
		this.admissionConfig = admissionConfig;
	}

	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "admission_status_id", nullable =true)
	public AdmissionStatus getAdmissionStatus() {
		return admissionStatus;
	}
	public void setAdmissionStatus(AdmissionStatus admissionStatus) {
		this.admissionStatus = admissionStatus;
	}
	
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "department_id", nullable =true)
	@JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class, property="@admissions")
	public Department getDepartment() {
		return department;
	}
	public void setDepartment(Department department) {
		this.department = department;
	}
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "course_id", nullable =true)
	@ForeignKey(name="admissionInCourse")
	@JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class, property="@admissions")
	public Courses getCourse() {
		return course;
	}
	public void setCourse(Courses course) {
		this.course = course;
	}
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "course_type_id", nullable =true)
	public CourseType getCourseType() {
		return courseType;
	}
	public void setCourseType(CourseType courseType) {
		this.courseType = courseType;
	}
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "course_category_id", nullable =true)
	public CourseCategory getCourseCategory() {
		return courseCategory;
	}
	public void setCourseCategory(CourseCategory courseCategory) {
		this.courseCategory = courseCategory;
	}
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "religion_id", nullable =true)
	public Religion getReligion() {
		return religion;
	}
	public void setReligion(Religion religion) {
		this.religion = religion;
	}
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "sponser_id", nullable =true)
	public Sponser getSponser() {
		return sponser;
	}
	public void setSponser(Sponser sponser) {
		this.sponser = sponser;
	}
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id", nullable =false)
	public Users getUser() {
		return user;
	}

	public void setUser(Users user) {
		this.user = user;
	}
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "category_id", nullable =true)
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "special_category_id", nullable =true)
	public SpecialCategory getSpecialCategory() {
		return specialCategory;
	}
	public void setSpecialCategory(SpecialCategory specialCategory) {
		this.specialCategory = specialCategory;
	}
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "hearedus_id", nullable =true)
	public HearedUs getHearedUs() {
		return hearedUs;
	}
	public void setHearedUs(HearedUs hearedUs) {
		this.hearedUs = hearedUs;
	}
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "admission",cascade=CascadeType.ALL)
	public Set<AdmissionDocument> getAdmissionDocuments() {
		return admissionDocuments;
	}
	public void setAdmissionDocuments(Set<AdmissionDocument> admissionDocuments) {
		this.admissionDocuments = admissionDocuments;
	}
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "admission",cascade=CascadeType.ALL)
	public Set<AdmissionEducationLevelDetails> getAdmissionAcademicsDetails() {
		return admissionAcademicsDetails;
	}
	public void setAdmissionAcademicsDetails(Set<AdmissionEducationLevelDetails> admissionAcademicsDetails) {
		this.admissionAcademicsDetails = admissionAcademicsDetails;
	}
	
	@OneToOne(fetch = FetchType.LAZY, mappedBy = "admission")
	public AdmissionFeesPaymentDetails getAdmissionFeesPaymentDetails() {
		return admissionFeesPaymentDetails;
	}
	public void setAdmissionFeesPaymentDetails(AdmissionFeesPaymentDetails admissionFeesPaymentDetails) {
		this.admissionFeesPaymentDetails = admissionFeesPaymentDetails;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "admission",cascade=CascadeType.ALL)
	public Set<AdmissionEducationLevelSubjects> getAdmissionEducationLevelSubjects() {
		return admissionEducationLevelSubjects;
	}

	public void setAdmissionEducationLevelSubjects(Set<AdmissionEducationLevelSubjects> admissionEducationLevelSubjects) {
		this.admissionEducationLevelSubjects = admissionEducationLevelSubjects;
	}
    
	@OneToOne(fetch = FetchType.LAZY, mappedBy = "admission")
	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

}
