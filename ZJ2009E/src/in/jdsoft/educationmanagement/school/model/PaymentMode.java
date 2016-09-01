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
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.ForeignKey;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "tbl_payment_mode")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class PaymentMode implements Serializable {
	
	public PaymentMode() {}
	
	public PaymentMode(String paymentModeTitle, Integer visibility) {
		this.paymentModeTitle = paymentModeTitle;
		this.visibility = visibility;
	}
	private static final long serialVersionUID = 1L;
	
	private Integer paymentModeId;
	private String paymentModeTitle;
	private Integer visibility;
	
	private Set<PaymentStatus> paymentStatusType=new HashSet<PaymentStatus>(0);
	private Set<StudentReceipt> studentReceipts=new HashSet<StudentReceipt>(0);
	
	@Id
	@GeneratedValue(strategy = IDENTITY)
    @Column(name = "payment_mode_id", nullable = false)
	public Integer getPaymentModeId() {
		return paymentModeId;
	}
	public void setPaymentModeId(Integer paymentModeId) {
		this.paymentModeId = paymentModeId;
	}
	@Column(name = "payment_mode_title", nullable = false, length = 100)
	public String getPaymentModeTitle() {
		return paymentModeTitle;
	}
	public void setPaymentModeTitle(String paymentModeTitle) {
		this.paymentModeTitle = paymentModeTitle;
	}
	
	@Column(name = "payment_mode_visibility", nullable = false)
	public Integer getVisibility() {
		return visibility;
	}
	public void setVisibility(Integer visibility) {
		this.visibility = visibility;
	}

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "tbl_payment_mode_and_payment_status_mapping",joinColumns = { 
			@JoinColumn(name = "payment_mode_id", updatable = false) }, 
			inverseJoinColumns = { @JoinColumn(name = "payment_status_id", 
					 updatable = false) })
	@ForeignKey(name="paymentModesInPaymentStatuses")
	public Set<PaymentStatus> getPaymentStatusType() {
		return paymentStatusType;
	}

	public void setPaymentStatusType(Set<PaymentStatus> paymentStatusType) {
		this.paymentStatusType = paymentStatusType;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "paymentMode")
	@ForeignKey(name="paymentModeInStudentReceipts")
	public Set<StudentReceipt> getStudentReceipts() {
		return studentReceipts;
	}

	public void setStudentReceipts(Set<StudentReceipt> studentReceipts) {
		this.studentReceipts = studentReceipts;
	}

}
