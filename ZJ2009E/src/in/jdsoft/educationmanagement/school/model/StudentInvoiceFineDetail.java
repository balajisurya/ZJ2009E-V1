package in.jdsoft.educationmanagement.school.model;

import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;
import java.sql.Timestamp;
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

import org.hibernate.annotations.ForeignKey;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table(name = "tbl_student_invoice_fine_details")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class StudentInvoiceFineDetail implements Serializable{

	public StudentInvoiceFineDetail() {}
	
	public StudentInvoiceFineDetail(StudentInvoice studentInvoice,Date previousDate, Student student, String fineName, double fineAmount,
			Integer fineStatus, String createdBy, String modifiedBy) {
		this.studentInvoice = studentInvoice;
		this.previousDate=previousDate;
		this.student = student;
		this.fineName = fineName;
		this.fineAmount = fineAmount;
		this.fineStatus = fineStatus;
		this.createdBy = createdBy;
		this.modifiedBy = modifiedBy;
		this.createdDate = new Timestamp(Calendar.getInstance().getTime().getTime());
	}
	
	private static final long serialVersionUID = 1L;
	
	private Integer studentInvoiceFineDetaiId;
	private StudentInvoice studentInvoice;
	private Student student;
	private String fineName;
	private Date previousDate;
	private double fineAmount;
	private Integer fineStatus;
	private String createdBy;
	private String modifiedBy;
	private Date createdDate;
	private Date modifiedDate;
	
	@Id
	@GeneratedValue(strategy = IDENTITY)
    @Column(name = "student_invoice_fine_detail_id", nullable = false)
	public Integer getStudentInvoiceFineDetaiId() {
		return studentInvoiceFineDetaiId;
	}
	public void setStudentInvoiceFineDetaiId(Integer studentInvoiceFineDetaiId) {
		this.studentInvoiceFineDetaiId = studentInvoiceFineDetaiId;
	}
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "student_invoice_id", nullable = false)
	@ForeignKey(name="studentInvoiceFineDetailsInStudentInvoice")
	@JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class, property="@studentInvoiceFineDetails")
	@JsonIdentityReference(alwaysAsId = true)
	public StudentInvoice getStudentInvoice() {
		return studentInvoice;
	}
	public void setStudentInvoice(StudentInvoice studentInvoice) {
		this.studentInvoice = studentInvoice;
	}
	
	@Column(name = "fine_name", nullable = false, length = 100)
	public String getFineName() {
		return fineName;
	}
	public void setFineName(String fineName) {
		this.fineName = fineName;
	}
	@Column(name = "fine_amount", nullable = false)
	public double getFineAmount() {
		return fineAmount;
	}
	public void setFineAmount(double fineAmount) {
		this.fineAmount = fineAmount;
	}
	
	@Column(name = "fine_status", nullable = false)
	public Integer getFineStatus() {
		return fineStatus;
	}
	public void setFineStatus(Integer fineStatus) {
		this.fineStatus = fineStatus;
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
	@JoinColumn(name = "student_id", nullable = false)
	@ForeignKey(name="studentInvoiceFineDetailsInStudent")
	public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "previous_due_date", nullable = false)
	public Date getPreviousDate() {
		return previousDate;
	}

	public void setPreviousDate(Date previousDate) {
		this.previousDate = previousDate;
	}
	
}
