package in.jdsoft.educationmanagement.school.model;

import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;
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
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

import org.hibernate.annotations.ForeignKey;
import org.springframework.beans.factory.annotation.Autowired;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import in.jdsoft.educationmanagement.components.NumberGenerator;



@Entity
@Table(name = "tbl_student_invoice",uniqueConstraints={@UniqueConstraint(columnNames={"invoice_no"})
  ,@UniqueConstraint(columnNames={"student_id","academic_year_id","academic_year_fees_term_id"})})
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class StudentInvoice implements Serializable{

	@Autowired
	NumberGenerator numberGenerator;
	
	private static final long serialVersionUID = 1L;

	public StudentInvoice() {}
	
	public StudentInvoice(Student student,AcademicYear academicYear,AcademicYearFeesTerm academicYearFeesTerm,Integer invoiceStatus, String createdBy,
			String modifiedBy,Institution institution) {
		this.student = student;
		this.invoiceNo = Long.toString(System.currentTimeMillis());
		this.invoiceStatus = invoiceStatus;
		this.createdBy = createdBy;
		this.modifiedBy = modifiedBy;
		this.createdDate = new Timestamp(Calendar.getInstance().getTime().getTime());
		this.institution = institution;
		this.academicYear=academicYear;
		this.academicYearFeesTerm=academicYearFeesTerm;
	}
	
	private Integer studentInvoiceId;
	private Student student;
	private AcademicYear academicYear;
	private AcademicYearFeesTerm academicYearFeesTerm;
	private String invoiceNo;
	private Integer invoiceStatus;
	private String createdBy;
	private String modifiedBy;
	private Date createdDate;
	private Date modifiedDate;
	private Institution institution;
	private double invoiceAmount;
	
	private Set<StudentInvoiceDetail> studentInvoiceDetails=new HashSet<StudentInvoiceDetail>(0);
	
	
	@Id
	@GeneratedValue(strategy = IDENTITY)
    @Column(name = "student_invoice_id", nullable = false)
	public Integer getStudentInvoiceId() {
		return studentInvoiceId;
	}
	public void setStudentInvoiceId(Integer studentInvoiceId) {
		this.studentInvoiceId = studentInvoiceId;
	}
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "student_id", nullable = false)
	@ForeignKey(name="studentInvoicesInStudent")
	public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
	}
	@Column(name = "invoice_no", nullable = false, length = 100)
	public String getInvoiceNo() {
		return invoiceNo;
	}
	public void setInvoiceNo(String invoiceNo) {
		this.invoiceNo = invoiceNo;
	}
	@Column(name = "invoice_status", nullable = false)
	public Integer getInvoiceStatus() {
		return invoiceStatus;
	}
	public void setInvoiceStatus(Integer invoiceStatus) {
		this.invoiceStatus = invoiceStatus;
	}
	
	
	@Column(name = "created_by", nullable = false, length = 100)
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	@Column(name = "modified_by", nullable = false, length = 100)
	public String getModifiedBy() {
		return modifiedBy;
	}
	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
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
	@JoinColumn(name = "institution_id", nullable = false)
	@ForeignKey(name="studentInvoicesInInstitution")
	public Institution getInstitution() {
		return institution;
	}
	public void setInstitution(Institution institution) {
		this.institution = institution;
	}
    
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "studentInvoice",cascade=CascadeType.ALL)
	@ForeignKey(name="studentInvoiceInStudentInvoiceDetails")
	public Set<StudentInvoiceDetail> getStudentInvoiceDetails() {
		return studentInvoiceDetails;
	}

	public void setStudentInvoiceDetails(Set<StudentInvoiceDetail> studentInvoiceDetails) {
		this.studentInvoiceDetails = studentInvoiceDetails;
	}



	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "academic_year_id", nullable = false)
	@ForeignKey(name="studentInvoicesInAcademicYear")
	public AcademicYear getAcademicYear() {
		return academicYear;
	}

	public void setAcademicYear(AcademicYear academicYear) {
		this.academicYear = academicYear;
	}
	
	@Column(name = "invoice_amount", nullable = false)
	public double getInvoiceAmount() {
		return invoiceAmount;
	}

	public void setInvoiceAmount(double invoiceAmount) {
		this.invoiceAmount = invoiceAmount;
	}
    
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "academic_year_fees_term_id", nullable = false)
	@ForeignKey(name="studentInvoicesInAcademicYearFeesTerm")
	public AcademicYearFeesTerm getAcademicYearFeesTerm() {
		return academicYearFeesTerm;
	}

	public void setAcademicYearFeesTerm(AcademicYearFeesTerm academicYearFeesTerm) {
		this.academicYearFeesTerm = academicYearFeesTerm;
	}
}
