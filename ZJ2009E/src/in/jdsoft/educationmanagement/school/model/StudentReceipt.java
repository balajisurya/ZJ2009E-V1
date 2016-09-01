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

import org.hibernate.annotations.ForeignKey;
import org.springframework.beans.factory.annotation.Autowired;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import in.jdsoft.educationmanagement.components.NumberGenerator;

@Entity
@Table(name = "tbl_student_receipt")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class StudentReceipt implements Serializable {
	
	@Autowired
	NumberGenerator numberGenerator;
	
	public StudentReceipt(Institution institution,AcademicYear academicYear,PaymentMode paymentMode,
			Date paymentReceivedDate, Double amount, Student student,
			PaymentStatus paymentStatus,String createdBy, String modifiedBy) {
		this.institution = institution;
		this.transactionNo = Long.toString(System.currentTimeMillis());
		this.paymentMode = paymentMode;
		this.paymentReceivedDate = paymentReceivedDate;
		this.amount = amount;
		this.student = student;
		this.paymentStatus = paymentStatus;
		this.createdBy = createdBy;
		this.modifiedBy = modifiedBy;
		this.createdDate = new Timestamp(Calendar.getInstance().getTime().getTime());
		this.academicYear=academicYear;
	}
	
	public StudentReceipt(Institution institution,AcademicYear academicYear,PaymentMode paymentMode,
			Date chequeReceivedDate,Double amount, Student student,
			PaymentStatus paymentStatus, String chequeNumber, Date chequeDate,
			String chequeBankName, String chequeBranchName,String createdBy, String modifiedBy) {
		this.institution = institution;
		this.transactionNo = Long.toString(System.currentTimeMillis());
		this.paymentMode = paymentMode;
		this.paymentReceivedDate = chequeReceivedDate;
		this.amount = amount;
		this.student = student;
		this.paymentStatus = paymentStatus;
		this.chequeNumber = chequeNumber;
		this.chequeDate = chequeDate;
		this.chequeBankName = chequeBankName;
		this.chequeBranchName = chequeBranchName;
		this.createdBy = createdBy;
		this.modifiedBy = modifiedBy;
		this.createdDate = new Timestamp(Calendar.getInstance().getTime().getTime());
		this.academicYear=academicYear;
	}
	
	public StudentReceipt(Institution institution,AcademicYear academicYear,PaymentMode paymentMode,
			Double amount, Student student,
			PaymentStatus paymentStatus,String ddNumber, Date ddDate,
			String ddBankName, String ddBranchName,Date ddReceivedDate,
			String createdBy, String modifiedBy) {
		this.institution = institution;
		this.transactionNo = Long.toString(System.currentTimeMillis());
		this.paymentMode = paymentMode;
		this.paymentReceivedDate =ddReceivedDate;
		this.amount = amount;
		this.student = student;
		this.paymentStatus = paymentStatus;
		this.ddNumber = ddNumber;
		this.ddDate = ddDate;
		this.ddBankName = ddBankName;
		this.ddBranchName = ddBranchName;
		this.createdBy = createdBy;
		this.modifiedBy = modifiedBy;
		this.createdDate = new Timestamp(Calendar.getInstance().getTime().getTime());
		this.academicYear=academicYear;
	}
	
	public StudentReceipt(Institution institution,String transactionNo, AcademicYear academicYear,PaymentMode paymentMode,
			Date paymentReceivedDate, Double amount, Student student,
			PaymentStatus paymentStatus,String paymentGateway, String paymentGatewayMode,
			String createdBy, String modifiedBy) {
		this.institution = institution;
		this.transactionNo = transactionNo;
		this.paymentMode = paymentMode;
		this.paymentReceivedDate =paymentReceivedDate;
		this.amount = amount;
		this.student = student;
		this.paymentStatus = paymentStatus;
		this.paymentGateway = paymentGateway;
		this.paymentGatewayMode = paymentGatewayMode;
		this.createdBy = createdBy;
		this.modifiedBy = modifiedBy;
		this.createdDate = new Timestamp(Calendar.getInstance().getTime().getTime());
		this.academicYear=academicYear;
	}
	
	public StudentReceipt() {}
	
	
	
	private static final long serialVersionUID = 1L;
	
	
	private Integer receiptId;
	private Institution institution;
	private String transactionNo;
	private PaymentMode paymentMode;
	private Date paymentReceivedDate;
	private Date paymentClearedDate;
	private Double amount;
	private Student student;
	private PaymentStatus paymentStatus;
	private String chequeNumber;
	private Date chequeDate;
	private String chequeBankName;
	private String chequeBranchName;
	private String ddNumber;
	private Date ddDate;
	private String ddBankName;
	private String ddBranchName;
	private String paymentGateway;
	private String paymentGatewayMode;
	private String comments;
	private String createdBy;
	private String modifiedBy;
	private Date createdDate;
	private Date modifiedDate;
	private String receiptClearedBy;
	private AcademicYear academicYear;
	
	
	private Set<StudentReceiptDetail> receiptDetails=new HashSet<StudentReceiptDetail>(0);
	private Set<StudentReceiptFine> receiptFines=new HashSet<StudentReceiptFine>(0);
	
	@Id
	@GeneratedValue(strategy = IDENTITY)
    @Column(name = "student_receipt_id", nullable = false)
	public Integer getReceiptId() {
		return receiptId;
	}
	public void setReceiptId(Integer receiptId) {
		this.receiptId = receiptId;
	}
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "institution_id", nullable = false)
	@ForeignKey(name="studentReceiptsInInstitution")
	public Institution getInstitution() {
		return institution;
	}
	public void setInstitution(Institution institution) {
		this.institution = institution;
	}
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "payment_mode_id", nullable = false)
	@ForeignKey(name="studentReceiptsInPaymentmode")
	public PaymentMode getPaymentMode() {
		return paymentMode;
	}
	public void setPaymentMode(PaymentMode paymentMode) {
		this.paymentMode = paymentMode;
	}
	
	@Column(name = "transaction_no", nullable = false, length = 100)
	public String getTransactionNo() {
		return transactionNo;
	}
	public void setTransactionNo(String transactionNo) {
		this.transactionNo = transactionNo;
	}
	
	@Column(name = "payment_gateway", nullable =true, length = 100)
	public String getPaymentGateway() {
		return paymentGateway;
	}
	public void setPaymentGateway(String paymentGateway) {
		this.paymentGateway = paymentGateway;
	}
	@Column(name = "dd_number", nullable =true, length = 100)
	public String getDdNumber() {
		return ddNumber;
	}
	public void setDdNumber(String ddNumber) {
		this.ddNumber = ddNumber;
	}
	@Column(name = "cheque_number", nullable =true, length = 100)
	public String getChequeNumber() {
		return chequeNumber;
	}
	public void setChequeNumber(String chequeNumber) {
		this.chequeNumber = chequeNumber;
	}
	
	@Column(name = "total_receipt_amount", nullable = false)
	public Double getAmount() {
		return amount;
	}
	public void setAmount(Double amount) {
		this.amount = amount;
	}
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "student_id", nullable = false)
	@ForeignKey(name="studentReceiptsInStudent")
	public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
	}
	@Column(name = "receipt_comments", nullable =true, length = 100)
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "payment_status_id", nullable = false)
	@ForeignKey(name="studentReceiptsInPaymentStatus")
	public PaymentStatus getPaymentStatus() {
		return paymentStatus;
	}
	public void setPaymentStatus(PaymentStatus paymentStatus) {
		this.paymentStatus = paymentStatus;
	}
	
	@Temporal(TemporalType.DATE)
	@Column(name = "payment_received_date", nullable = false)
	public Date getPaymentReceivedDate() {
		return paymentReceivedDate;
	}
	public void setPaymentReceivedDate(Date paymentReceivedDate) {
		this.paymentReceivedDate = paymentReceivedDate;
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
	
	@Temporal(TemporalType.DATE)
	@Column(name = "payment_cleared_date", nullable = true)
	public Date getPaymentClearedDate() {
		return paymentClearedDate;
	}
	public void setPaymentClearedDate(Date paymentClearedDate) {
		this.paymentClearedDate = paymentClearedDate;
	}
	@Temporal(TemporalType.DATE)
	@Column(name = "cheque_date", nullable = true)
	public Date getChequeDate() {
		return chequeDate;
	}
	public void setChequeDate(Date chequeDate) {
		this.chequeDate = chequeDate;
	}
	
	@Column(name = "cheque_bank_name", nullable = true, length = 100)
	public String getChequeBankName() {
		return chequeBankName;
	}
	public void setChequeBankName(String chequeBankName) {
		this.chequeBankName = chequeBankName;
	}
	@Column(name = "cheque_branch_name", nullable = true, length = 100)
	public String getChequeBranchName() {
		return chequeBranchName;
	}
	public void setChequeBranchName(String chequeBranchName) {
		this.chequeBranchName = chequeBranchName;
	}
	@Temporal(TemporalType.DATE)
	@Column(name = "dd_date", nullable = true)
	public Date getDDDate() {
		return ddDate;
	}
	public void setDDDate(Date ddDate) {
		this.ddDate = ddDate;
	}
	
	@Column(name = "dd_bank_name", nullable = true, length = 100)
	public String getDdBankName() {
		return ddBankName;
	}
	public void setDdBankName(String ddBankName) {
		this.ddBankName = ddBankName;
	}
	@Column(name = "dd_branch_name", nullable = true, length = 100)
	public String getDdBranchName() {
		return ddBranchName;
	}
	public void setDdBranchName(String ddBranchName) {
		this.ddBranchName = ddBranchName;
	}
	@Column(name = "payment_gateway_mode", nullable = true, length = 100)
	public String getPaymentGatewayMode() {
		return paymentGatewayMode;
	}
	public void setPaymentGatewayMode(String paymentGatewayMode) {
		this.paymentGatewayMode = paymentGatewayMode;
	}
	@Column(name = "receipt_cleared_by", nullable = true, length = 100)
	public String getReceiptClearedBy() {
		return receiptClearedBy;
	}
	public void setReceiptClearedBy(String receiptClearedBy) {
		this.receiptClearedBy = receiptClearedBy;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "studentReceipt",cascade=CascadeType.ALL)
	@ForeignKey(name="studentReceiptInStudentReceiptDetails")
	public Set<StudentReceiptDetail> getReceiptDetails() {
		return receiptDetails;
	}

	public void setReceiptDetails(Set<StudentReceiptDetail> receiptDetails) {
		this.receiptDetails = receiptDetails;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "academic_year_id", nullable = false)
	@ForeignKey(name="studentReceiptsInAcademicYear")
	public AcademicYear getAcademicYear() {
		return academicYear;
	}

	public void setAcademicYear(AcademicYear academicYear) {
		this.academicYear = academicYear;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "studentReceipt",cascade=CascadeType.ALL)
	@ForeignKey(name="studentReceiptInStudentReceiptFines")
	public Set<StudentReceiptFine> getReceiptFines() {
		return receiptFines;
	}

	public void setReceiptFines(Set<StudentReceiptFine> receiptFines) {
		this.receiptFines = receiptFines;
	}
	
}
