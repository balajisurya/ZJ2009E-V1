package in.jdsoft.educationmanagement.model;

import static javax.persistence.GenerationType.IDENTITY;

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

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "tbl_fees_collection_record")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class FeesCollectionRecord implements java.io.Serializable
{

	
	public FeesCollectionRecord(StudentInvoice invoice, Student student, Institution institution, String paymentMode,
			String outstationCheque, String ddorchequenumber, Date ddorchequeDate, Double amount, String payableAt,
			String bankName, String bankAddressLine1, String bankAddressLine2, Integer bankCityId, Integer bankStateId,
			Integer bankCountryId, String bankPostcode, String bankEFTTransactionCode, String bankIFSCode,
			Date bankEFTDate, String institutionAccountName, String institutionAccountNumber,
			String feesCollectionClerk, String bankStatementStatus, String tallyGLAccount, String remarks) {

		this.invoice = invoice;
		this.student = student;
		this.institution = institution;
		this.paymentMode = paymentMode;
		this.outstationCheque = outstationCheque;
		this.ddorchequenumber = ddorchequenumber;
		this.ddorchequeDate = ddorchequeDate;
		this.amount = amount;
		this.payableAt = payableAt;
		this.bankName = bankName;
		this.bankAddressLine1 = bankAddressLine1;
		this.bankAddressLine2 = bankAddressLine2;
		this.bankCityId = bankCityId;
		this.bankStateId = bankStateId;
		this.bankCountryId = bankCountryId;
		this.bankPostcode = bankPostcode;
		this.bankEFTTransactionCode = bankEFTTransactionCode;
		this.bankIFSCode = bankIFSCode;
		this.bankEFTDate = bankEFTDate;
		this.institutionAccountName = institutionAccountName;
		this.institutionAccountNumber = institutionAccountNumber;
		this.feesCollectionClerk = feesCollectionClerk;
		this.bankStatementStatus = bankStatementStatus;
		this.tallyGLAccount = tallyGLAccount;
		this.remarks = remarks;
		this.paymentDate=new Timestamp(Calendar.getInstance().getTime().getTime());
	}

	private static final long serialVersionUID = 1L;

	
	


	public FeesCollectionRecord() {}

	// PK	
			private Integer feesCollectionRecordId;
		
		// single fields
			
		private StudentInvoice invoice;
		private Student student;	
		private Institution institution;
		
		// Single fields
		private String paymentMode;
		private String outstationCheque;
		private String ddorchequenumber;
		private Date ddorchequeDate;
		private Double amount;
		private String payableAt;
		private String bankName;
		private String bankAddressLine1;
		private String bankAddressLine2;
		private Integer bankCityId;
		private Integer bankStateId;
		private Integer bankCountryId;
		private String bankPostcode;
		private String bankEFTTransactionCode;
		private String bankIFSCode;
		private Date bankEFTDate;
		private String institutionAccountName;
		private String institutionAccountNumber;
		private String feesCollectionClerk;
		private String bankStatementStatus;
		private String tallyGLAccount;
		private String remarks;
		private Date paymentDate;

		
	//PK 
	@Id
	@GeneratedValue(strategy = IDENTITY)
    @Column(name = "fees_collection_record_id", unique = true, nullable = false)
	public Integer getFeesCollectionRecordId() {
		return feesCollectionRecordId;
	}
	public void setFeesCollectionRecordId(Integer feesCollectionRecordId) {
		this.feesCollectionRecordId = feesCollectionRecordId;
	}

	

	// single fields
	@Column(name = "payment_mode", nullable = false, length = 80)
	public String getPaymentMode() {
		return paymentMode;
	}
	public void setPaymentMode(String paymentMode) {
		this.paymentMode = paymentMode;
	}
	
	@Temporal(TemporalType.DATE)
	@Column(name = "payment_date", nullable = false, length = 10)
	public Date getPaymentDate() {
		return paymentDate;
	}

	public void setPaymentDate(Date paymentDate) {
		this.paymentDate = paymentDate;
	}

	@Column(name = "outstation_cheque", nullable = true, length = 80)
	public String getOutstationCheque() {
		return outstationCheque;
	}
	public void setOutstationCheque(String outstationCheque) {
		this.outstationCheque = outstationCheque;
	}
	@Column(name = "dd_or_cheque_no", nullable = true, length = 80)
	public String getDdorchequenumber() {
		return ddorchequenumber;
	}
	public void setDdorchequenumber(String ddorchequenumber) {
		this.ddorchequenumber = ddorchequenumber;
	}
	@Temporal(TemporalType.DATE)
	@Column(name = "dd_or_cheque_date", nullable = true, length = 10)
	public Date getDdorchequeDate() {
		return ddorchequeDate;
	}
	public void setDdorchequeDate(Date ddorchequeDate) {
		this.ddorchequeDate = ddorchequeDate;
	}
	@Column(name = "amount", nullable = false)
	public Double getAmount() {
		return amount;
	}
	public void setAmount(Double amount) {
		this.amount = amount;
	}
	@Column(name = "payable_at", nullable = true, length = 80)
	public String getPayableAt() {
		return payableAt;
	}
	public void setPayableAt(String payableAt) {
		this.payableAt = payableAt;
	}
	@Column(name = "dd_or_cheque_bank_name", nullable = true, length = 80)
	public String getBankName() {
		return bankName;
	}
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
	@Column(name = "bank_address_line_one", nullable = true, length = 80)
	public String getBankAddressLine1() {
		return bankAddressLine1;
	}
	public void setBankAddressLine1(String bankAddressLine1) {
		this.bankAddressLine1 = bankAddressLine1;
	}
	@Column(name = "bank_address_line_two", nullable = true, length = 80)
	public String getBankAddressLine2() {
		return bankAddressLine2;
	}
	public void setBankAddressLine2(String bankAddressLine2) {
		this.bankAddressLine2 = bankAddressLine2;
	}
	@Column(name = "bank_city", nullable = true)
	public Integer getBankCityId() {
		return bankCityId;
	}
	public void setBankCityId(Integer bankCityId) {
		this.bankCityId = bankCityId;
	}
	@Column(name = "bank_state", nullable = true)
	public Integer getBankStateId() {
		return bankStateId;
	}
	public void setBankStateId(Integer bankStateId) {
		this.bankStateId = bankStateId;
	}
	@Column(name = "bank_country", nullable = true)
	public Integer getBankCountryId() {
		return bankCountryId;
	}
	public void setBankCountryId(Integer bankCountryId) {
		this.bankCountryId = bankCountryId;
	}
	@Column(name = "bank_postcode", nullable = true, length = 50)
	public String getBankPostcode() {
		return bankPostcode;
	}
	public void setBankPostcode(String bankPostcode) {
		this.bankPostcode = bankPostcode;
	}
	@Column(name = "bank_eft_transaction_code", nullable = true, length = 50)
	public String getBankEFTTransactionCode() {
		return bankEFTTransactionCode;
	}
	public void setBankEFTTransactionCode(String bankEFTTransactionCode) {
		this.bankEFTTransactionCode = bankEFTTransactionCode;
	}
	@Column(name = "bank_ifsc_code", nullable = true, length = 50)
	public String getBankIFSCode() {
		return bankIFSCode;
	}
	public void setBankIFSCode(String bankIFSCode) {
		this.bankIFSCode = bankIFSCode;
	}
	@Temporal(TemporalType.DATE)
	@Column(name = "bank_eft_transaction_date", nullable = true, length = 10)
	public Date getBankEFTDate() {
		return bankEFTDate;
	}
	public void setBankEFTDate(Date bankEFTDate) {
		this.bankEFTDate = bankEFTDate;
	}
	@Column(name = "institution_account_name", nullable = true, length = 80)
	public String getInstitutionAccountName() {
		return institutionAccountName;
	}
	public void setInstitutionAccountName(String institutionAccountName) {
		this.institutionAccountName = institutionAccountName;
	}
	@Column(name = "institution_account_no", nullable = true, length = 80)
	public String getInstitutionAccountNumber() {
		return institutionAccountNumber;
	}
	public void setInstitutionAccountNumber(String institutionAccountNumber) {
		this.institutionAccountNumber = institutionAccountNumber;
	}
	@Column(name = "bank_statement_status", nullable = true, length = 80)
	public String getBankStatementStatus() {
		return bankStatementStatus;
	}
	public void setBankStatementStatus(String bankStatementStatus) {
		this.bankStatementStatus = bankStatementStatus;
	}
	@Column(name = "tally_gl_account", nullable = true, length = 80)
	public String getTallyGLAccount() {
		return tallyGLAccount;
	}
	public void setTallyGLAccount(String tallyGLAccount) {
		this.tallyGLAccount = tallyGLAccount;
	}
	@Column(name = "remarks", nullable = true, length = 80)
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	@Column(name = "fees_collection_clerk_name", nullable = true, length = 80)
	public String getFeesCollectionClerk() {
		return feesCollectionClerk;
	}


	public void setFeesCollectionClerk(String feesCollectionClerk) {
		this.feesCollectionClerk = feesCollectionClerk;
	}

// Mappings

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "invoice_id", nullable = false)
	public StudentInvoice getInvoice() {
		return invoice;
	}
	public void setInvoice(StudentInvoice invoice) {
		this.invoice = invoice;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "student_id", nullable = false)
	public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
	}
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "institution_Id", nullable = false)
	public Institution getInstitution() {
		return institution;
	}
	public void setInstitution(Institution institution) {
		this.institution = institution;
	}
	
	
	
	
}
