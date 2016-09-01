package in.jdsoft.educationmanagement.school.model;

import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.ForeignKey;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "tbl_payment_status")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class PaymentStatus implements Serializable {
	
	public PaymentStatus() {}
	
	public PaymentStatus(String paymentStatusTitle) {
		this.paymentStatusTitle = paymentStatusTitle;
	}
	
	private static final long serialVersionUID = 1L;
	
	private Integer paymentStatusId;
	private String paymentStatusTitle;
	
	private Set<PaymentMode> paymentModes=new HashSet<PaymentMode>(0);
	private Set<StudentReceipt> studentReceipts=new HashSet<StudentReceipt>(0);
	
	@Id
	@GeneratedValue(strategy = IDENTITY)
    @Column(name = "payment_status_id", nullable = false)
	public Integer getPaymentStatusId() {
		return paymentStatusId;
	}
	public void setPaymentStatusId(Integer paymentStatusId) {
		this.paymentStatusId = paymentStatusId;
	}
	@Column(name = "payment_status_title", nullable = false, length = 100)
	public String getPaymentStatusTitle() {
		return paymentStatusTitle;
	}
	public void setPaymentStatusTitle(String paymentStatusTitle) {
		this.paymentStatusTitle = paymentStatusTitle;
	}

	@ManyToMany(fetch = FetchType.LAZY, mappedBy = "paymentStatusType")
	@ForeignKey(name="paymentStatusesInPaymentModes")
	public Set<PaymentMode> getPaymentModes() {
		return paymentModes;
	}

	public void setPaymentModes(Set<PaymentMode> paymentModes) {
		this.paymentModes = paymentModes;
	}
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "paymentStatus")
	@ForeignKey(name="paymentStatusInStudentReceipts")
	public Set<StudentReceipt> getStudentReceipts() {
		return studentReceipts;
	}

	public void setStudentReceipts(Set<StudentReceipt> studentReceipts) {
		this.studentReceipts = studentReceipts;
	}
}
