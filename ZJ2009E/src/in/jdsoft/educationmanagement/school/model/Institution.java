package in.jdsoft.educationmanagement.school.model;


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
import org.hibernate.annotations.ForeignKey;

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
	
	
	private Set<User> users=new HashSet<>(0);
	private Set<Student> students=new HashSet<Student>(0);
	private Set<FeesTemplate> feesTemplates=new HashSet<FeesTemplate>(0);
	private Set<FeesTemplateItem> feesTemplateItems=new HashSet<FeesTemplateItem>(0);
	private Set<Class> classes=new HashSet<Class>(0);
	private Set<Section> sections=new HashSet<Section>(0); 
	private Set<InstituteLedgerAccount> ledgerAccounts=new HashSet<InstituteLedgerAccount>(0);
	private Set<StudentInvoice> studentInvoices=new HashSet<StudentInvoice>(0);
	private Set<AcademicYear> academicYears=new HashSet<AcademicYear>(0);
	private Set<SpecialCategory> specialCategories=new HashSet<SpecialCategory>(0);
	private Set<StudentReceipt> studentReceipts=new HashSet<StudentReceipt>(0);
	private Set<FeesTerm> feesTerms=new HashSet<>(0);
	

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

	@Column(name = "institution_name", nullable = false, length = 255)
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

	
    @Column(name = "institution_contact", nullable = false, length = 10)
	public String getInstitutionContact() {
		return this.institutionContact;
	}

	public void setInstitutionContact(String institutionContact) {
		this.institutionContact = institutionContact;
	}

	@Column(name = "institution_email", nullable = false,length=100)
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



	@OneToMany(fetch = FetchType.LAZY, mappedBy ="institution")
	@ForeignKey(name="institutionInUsers")
	public Set<User> getUsers() {
		return users;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "institution")
	@ForeignKey(name="institutionInStudents")
	public Set<Student> getStudents() {
		return students;
	}

	public void setStudents(Set<Student> students) {
		this.students = students;
	}
    
	


	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "institution")
	@ForeignKey(name="institutionInFeesTemplates")
	public Set<FeesTemplate> getFeesTemplates() {
		return feesTemplates;
	}

	public void setFeesTemplates(Set<FeesTemplate> feesTemplates) {
		this.feesTemplates = feesTemplates;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "institution")
	@ForeignKey(name="institutionInFeesTemplateItems")
	public Set<FeesTemplateItem> getFeesTemplateItems() {
		return feesTemplateItems;
	}

	public void setFeesTemplateItems(Set<FeesTemplateItem> feesTemplateItems) {
		this.feesTemplateItems = feesTemplateItems;
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
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "institution")
	@ForeignKey(name="institutionInClasses")
	public Set<Class> getClasses() {
		return classes;
	}

	public void setClasses(Set<Class> classes) {
		this.classes = classes;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "institution")
	@ForeignKey(name="institutionInSections")
	public Set<Section> getSections() {
		return sections;
	}

	public void setSections(Set<Section> sections) {
		this.sections = sections;
	}
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "institution")
	@ForeignKey(name="institutionInInstituteLedgerAccounts")
	public Set<InstituteLedgerAccount> getLedgerAccounts() {
		return ledgerAccounts;
	}

	public void setLedgerAccounts(Set<InstituteLedgerAccount> ledgerAccounts) {
		this.ledgerAccounts = ledgerAccounts;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "institution")
	@ForeignKey(name="institutionInStudentInvoices")
	public Set<StudentInvoice> getStudentInvoices() {
		return studentInvoices;
	}

	public void setStudentInvoices(Set<StudentInvoice> studentInvoices) {
		this.studentInvoices = studentInvoices;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "institution")
	@ForeignKey(name="institutionInAcademicYears")
	public Set<AcademicYear> getAcademicYears() {
		return academicYears;
	}
	public void setAcademicYears(Set<AcademicYear> academicYears) {
		this.academicYears = academicYears;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "institution")
	@ForeignKey(name="institutionInSpecialCategories")
	public Set<SpecialCategory> getSpecialCategories() {
		return specialCategories;
	}

	public void setSpecialCategories(Set<SpecialCategory> specialCategories) {
		this.specialCategories = specialCategories;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "institution")
	@ForeignKey(name="institutionInStudentReceipts")
	public Set<StudentReceipt> getStudentReceipts() {
		return studentReceipts;
	}

	public void setStudentReceipts(Set<StudentReceipt> studentReceipts) {
		this.studentReceipts = studentReceipts;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "institution")
	@ForeignKey(name="institutionInFeesTerms")
	public Set<FeesTerm> getFeesTerms() {
		return feesTerms;
	}

	public void setFeesTerms(Set<FeesTerm> feesTerms) {
		this.feesTerms = feesTerms;
	}



	


}
