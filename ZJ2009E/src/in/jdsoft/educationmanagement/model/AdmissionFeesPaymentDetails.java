package in.jdsoft.educationmanagement.model;

import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "tbl_admission_fees_payment_details", uniqueConstraints = @UniqueConstraint(columnNames = {"admission_id","transaction_code"}))
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class AdmissionFeesPaymentDetails implements Serializable{

	
	private static final long serialVersionUID = 1L;

	public AdmissionFeesPaymentDetails() {}
	public AdmissionFeesPaymentDetails(Admission admission, double amountPaid,
			String transactionCode, String transactionStatus, String bankName, String paymentMode, String iFSCCode) {
		this.admission = admission;
		this.amountPaid = amountPaid;
		this.transactionCode = transactionCode;
		this.transactionStatus = transactionStatus;
		this.bankName = bankName;
		this.paymentMode = paymentMode;
		this.IFSCCode = iFSCCode;
	}
	
	private int feesPaymentId;
	private Admission admission;
	private double amountPaid;
	private String transactionCode;
	private String transactionStatus;
	private String bankName;
	private String paymentMode;
	private String IFSCCode;
	
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "fees_payment_id", nullable = false)
	public int getFeesPaymentId() {
		return feesPaymentId;
	}
	
	public void setFeesPaymentId(int feesPaymentId) {
		this.feesPaymentId = feesPaymentId;
	}
	
	@OneToOne
	@JoinColumn(name = "admission_id", nullable =false)
	public Admission getAdmission() {
		return admission;
	}
	public void setAdmission(Admission admission) {
		this.admission = admission;
	}
	@Column(name = "fees_paid",nullable = false)
	public double getAmountPaid() {
		return amountPaid;
	}
	public void setAmountPaid(double amountPaid) {
		this.amountPaid = amountPaid;
	}
	
	@Column(name = "transaction_code",nullable = false,length=30)
	public String getTransactionCode() {
		return transactionCode;
	}
	public void setTransactionCode(String transactionCode) {
		this.transactionCode = transactionCode;
	}
	@Column(name = "transaction_status",nullable = false,length=10)
	public String getTransactionStatus() {
		return transactionStatus;
	}
	public void setTransactionStatus(String transactionStatus) {
		this.transactionStatus = transactionStatus;
	}
	
	@Column(name = "bank_name",nullable = false,length=30)
	public String getBankName() {
		return bankName;
	}
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
	
	@Column(name = "payment_mode",nullable = false,length=20)
	public String getPaymentMode() {
		return paymentMode;
	}
	public void setPaymentMode(String paymentMode) {
		this.paymentMode = paymentMode;
	}
	
	@Column(name = "ifsc_code",nullable = false,length=20)
	public String getIFSCCode() {
		return IFSCCode;
	}
	public void setIFSCCode(String iFSCCode) {
		IFSCCode = iFSCCode;
	}
	
	
}
