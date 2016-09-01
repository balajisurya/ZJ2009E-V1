package in.jdsoft.educationmanagement.model;


import static javax.persistence.GenerationType.IDENTITY;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.apache.commons.lang.WordUtils;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@Entity
@Table(name = "tbl_institution")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	public class Institution implements java.io.Serializable {


	
	private static final long serialVersionUID = 1L;
	private Integer institutionId;
	private String institutionName;
	private String institutionAddressline1;
	private String institutionAddressline2;
	private String institutionCountry;
	private String institutionState;
	private String institutionCity;
	private String institutionContact;
	private String institutionEmail;
	private String institutionLogo;
	private String institutionPostcode;
	private String currencyCode;
	private Integer institutionStatus;
	
	private Set<Users> users=new HashSet<>(0);
	private Set<FeesCollectionRecord> feescollectionrecord =new HashSet<>(0);
	private Set<Staff> staffs=new HashSet<>(0);
	private Set<Student> students=new HashSet<Student>(0);
	private Set<Courses> courses=new HashSet<Courses>(0);
	private Set<Department> departments=new HashSet<Department>(0);
	private Set<Module> modules=new HashSet<Module>(0);
	private Set<FeesTemplate> feesTemplates=new HashSet<FeesTemplate>(0);
	private Set<FeesTemplateItem> feesTemplateItems=new HashSet<FeesTemplateItem>(0);
	private Set<Groups> groups=new HashSet<Groups>(0);
	private Set<AcademicYear> academicYears=new HashSet<AcademicYear>(0);

	public Institution() {}
	
	public Institution(String institutionName,String institutionAddressline1,
			String institutionAddressline2,String institutionCountry,String institutionState,String institutionCity,
			String institutionContact, String institutionEmail,String institutionLogo,
			String institutionPostcode,String currencyCode,Integer institutionStatus) {
		
		this.institutionName = WordUtils.capitalize(institutionName);
		this.institutionAddressline1 =WordUtils.capitalize(institutionAddressline1);
		this.institutionAddressline2 =WordUtils.capitalize(institutionAddressline2);
		this.institutionCountry=institutionCountry;
		this.institutionState=institutionState;
		this.institutionCity=institutionCity;
		this.institutionContact =institutionContact;
		this.institutionEmail = institutionEmail.toLowerCase();
		this.institutionLogo = institutionLogo;
		this.institutionPostcode = institutionPostcode;
		this.currencyCode=currencyCode.toUpperCase();
		this.institutionStatus=institutionStatus;
	}
	

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "institution_id", unique = true, nullable = false)
	public Integer getInstitutionId() {
		return this.institutionId;
	}

	public void setInstitutionId(Integer institutionId) {
		this.institutionId = institutionId;
	}

	@Column(name = "institution_name", nullable = false, length = 300)
	public String getInstitutionName() {
		return this.institutionName;
	}

	public void setInstitutionName(String institutionName) {
		this.institutionName = WordUtils.capitalize(institutionName);
	}

	
    @Column(name = "institution_addressline1", nullable = false)
	public String getInstitutionAddressline1() {
		return this.institutionAddressline1;
	}

	public void setInstitutionAddressline1(String institutionAddressline1) {
		this.institutionAddressline1 =WordUtils.capitalize(institutionAddressline1);
	}

	@Column(name = "institution_addressline2", nullable = false)
	public String getInstitutionAddressline2() {
		return this.institutionAddressline2;
	}

	public void setInstitutionAddressline2(String institutionAddressline2) {
		this.institutionAddressline2 =WordUtils.capitalize(institutionAddressline2);
	}

	
    @Column(name = "institution_contact", nullable = false, length = 20)
	public String getInstitutionContact() {
		return this.institutionContact;
	}

	public void setInstitutionContact(String institutionContact) {
		this.institutionContact = institutionContact;
	}

	@Column(name = "institution_email", nullable = false)
	public String getInstitutionEmail() {
		return this.institutionEmail;
	}

	public void setInstitutionEmail(String institutionEmail) {
		this.institutionEmail = institutionEmail.toLowerCase();
	}

	

	@Column(name = "institution_logo", nullable = false)
	public String getInstitutionLogo() {
		return this.institutionLogo;
	}

	public void setInstitutionLogo(String institutionLogo) {
		this.institutionLogo = institutionLogo;
	}

	@Column(name = "institution_postcode", nullable = false, length = 10)
	public String getInstitutionPostcode() {
		return this.institutionPostcode;
	}

	public void setInstitutionPostcode(String institutionPostcode) {
		this.institutionPostcode = institutionPostcode;
	}


	@Column(name = "institution_currencyCode", nullable = false,length=3)
	public String getCurrencyCode() {
		return currencyCode;
	}

	public void setCurrencyCode(String currencyCode) {
		this.currencyCode = currencyCode.toUpperCase();
	}

	@Column(name = "institution_status", nullable = false)
	public Integer getInstitutionStatus() {
		return institutionStatus;
	}

	public void setInstitutionStatus(Integer institutionStatus) {
		this.institutionStatus = institutionStatus;
	}

	

	//Mappings
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "institution")	
	public Set<FeesCollectionRecord> getFeescollectionrecord() {
		return feescollectionrecord;
	}

	public void setFeescollectionrecord(Set<FeesCollectionRecord> feescollectionrecord) {
		this.feescollectionrecord = feescollectionrecord;
	}


	@OneToMany(fetch = FetchType.LAZY, mappedBy ="institution")
	public Set<Users> getUsers() {
		return users;
	}

	public void setUsers(Set<Users> users) {
		this.users = users;
	}
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "institution")
	public Set<Staff> getStaffs() {
		return staffs;
	}

	public void setStaffs(Set<Staff> staffs) {
		this.staffs = staffs;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "institution")
	public Set<Student> getStudents() {
		return students;
	}

	public void setStudents(Set<Student> students) {
		this.students = students;
	}
    
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "institution")
	public Set<Courses> getCourses() {
		return courses;
	}

	public void setCourses(Set<Courses> courses) {
		this.courses = courses;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "institution")
	public Set<Department> getDepartments() {
		return departments;
	}

	public void setDepartments(Set<Department> departments) {
		this.departments = departments;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "institution")
	public Set<Module> getModules() {
		return modules;
	}

	public void setModules(Set<Module> modules) {
		this.modules = modules;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "institution")
	public Set<FeesTemplate> getFeesTemplates() {
		return feesTemplates;
	}

	public void setFeesTemplates(Set<FeesTemplate> feesTemplates) {
		this.feesTemplates = feesTemplates;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "institution")
	public Set<FeesTemplateItem> getFeesTemplateItems() {
		return feesTemplateItems;
	}

	public void setFeesTemplateItems(Set<FeesTemplateItem> feesTemplateItems) {
		this.feesTemplateItems = feesTemplateItems;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "institution")
	public Set<Groups> getGroups() {
		return groups;
	}

	public void setGroups(Set<Groups> groups) {
		this.groups = groups;
	}
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "institution")
	public Set<AcademicYear> getAcademicYears() {
		return academicYears;
	}

	public void setAcademicYears(Set<AcademicYear> academicYears) {
		this.academicYears = academicYears;
	}

	@Column(name = "institution_country", nullable = false,length=100)
	public String getInstitutionCountry() {
		return institutionCountry;
	}

	public void setInstitutionCountry(String institutionCountry) {
		this.institutionCountry = institutionCountry;
	}

	@Column(name = "institution_state", nullable = false,length=100)
	public String getInstitutionState() {
		return institutionState;
	}

	public void setInstitutionState(String institutionState) {
		this.institutionState = institutionState;
	}

	@Column(name = "institution_city", nullable = false,length=100)
	public String getInstitutionCity() {
		return institutionCity;
	}

	public void setInstitutionCity(String institutionCity) {
		this.institutionCity = institutionCity;
	}


	


}
