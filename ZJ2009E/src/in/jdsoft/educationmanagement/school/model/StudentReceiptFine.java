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
@Table(name = "tbl_student_receipt_fine")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class StudentReceiptFine implements Serializable {

	private static final long serialVersionUID = 1L;
	
	public StudentReceiptFine() {}
	
	public StudentReceiptFine(StudentReceipt studentReceipt, StudentInvoiceFineDetail studentInvoiceFineDetail,
			String createdBy, String modifiedBy) {
		this.studentReceipt = studentReceipt;
		this.studentInvoiceFineDetail = studentInvoiceFineDetail;
		this.createdBy = createdBy;
		this.modifiedBy = modifiedBy;
		this.createdDate = new Timestamp(Calendar.getInstance().getTime().getTime());
	}
	
	private Integer studentReceiptFineId;
	private StudentReceipt studentReceipt;
	private StudentInvoiceFineDetail studentInvoiceFineDetail;
	private String createdBy;
	private String modifiedBy;
	private Date createdDate;
	private Date modifiedDate;

	
	@Id
	@GeneratedValue(strategy = IDENTITY)
    @Column(name = "student_receipt_fine_id", nullable = false)
	public Integer getStudentReceiptFineId() {
		return studentReceiptFineId;
	}

	public void setStudentReceiptFineId(Integer studentReceiptFineId) {
		this.studentReceiptFineId = studentReceiptFineId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "student_receipt_id", nullable = false)
	@ForeignKey(name="studentReceiptFinesInStudentReceipt")
	@JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class, property="@receiptFines")
	@JsonIdentityReference(alwaysAsId = true)
	public StudentReceipt getStudentReceipt() {
		return studentReceipt;
	}

	public void setStudentReceipt(StudentReceipt studentReceipt) {
		this.studentReceipt = studentReceipt;
	}

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "student_invoice_fine_detail_id", nullable =false)
	@ForeignKey(name="studentReceiptFineInStudentInvoiceFineDetail")
	public StudentInvoiceFineDetail getStudentInvoiceFineDetail() {
		return studentInvoiceFineDetail;
	}

	public void setStudentInvoiceFineDetail(StudentInvoiceFineDetail studentInvoiceFineDetail) {
		this.studentInvoiceFineDetail = studentInvoiceFineDetail;
	}

	@Column(name = "created_by", nullable = false,length=100)
	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	@Column(name = "modified_by", nullable = false,length=100)
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
}
