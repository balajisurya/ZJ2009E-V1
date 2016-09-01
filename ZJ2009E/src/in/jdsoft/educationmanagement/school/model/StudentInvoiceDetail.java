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
@Table(name = "tbl_student_invoice_details")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class StudentInvoiceDetail implements Serializable{
	
	public StudentInvoiceDetail() {}
	
	public StudentInvoiceDetail(StudentInvoice studentInvoice,FeesTemplateItem feesTemplateItem,
			double studentInvoiceElementAmount, double studentInvoiceElementTaxAmount,Integer studentInvoiceElementPaymentStatus, String createdBy,
			String modifiedBy) {
		this.studentInvoice = studentInvoice;
		this.feesTemplateItem=feesTemplateItem;
		this.studentInvoiceElementAmount = studentInvoiceElementAmount;
		this.studentInvoiceElementTaxAmount = studentInvoiceElementTaxAmount;
		this.studentInvoiceElementTotalAmount = studentInvoiceElementAmount+studentInvoiceElementTaxAmount;
		this.studentInvoiceElementPaymentStatus = studentInvoiceElementPaymentStatus;
		this.createdBy = createdBy;
		this.modifiedBy = modifiedBy;
		this.createdDate =new Timestamp(Calendar.getInstance().getTime().getTime());
	}
	
	private static final long serialVersionUID = 1L;
	
	private Integer studentInvoiceDetailId;
	private StudentInvoice studentInvoice;
	private FeesTemplateItem feesTemplateItem;
	private double studentInvoiceElementAmount;
	private double studentInvoiceElementTaxAmount;
	private double studentInvoiceElementTotalAmount;
	private Integer studentInvoiceElementPaymentStatus;
	private String createdBy;
	private String modifiedBy;
	private Date createdDate;
	private Date modifiedDate;
	
	
	@Id
	@GeneratedValue(strategy = IDENTITY)
    @Column(name = "student_invoice_detail_id", nullable = false)
	public Integer getStudentInvoiceDetailId() {
		return studentInvoiceDetailId;
	}
	public void setStudentInvoiceDetailId(Integer studentInvoiceDetailId) {
		this.studentInvoiceDetailId = studentInvoiceDetailId;
	}
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "student_invoice_id", nullable = false)
	@ForeignKey(name="studentInvoiceDetailsInStudentInvoice")
	@JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class, property="@studentInvoiceDetails")
	@JsonIdentityReference(alwaysAsId = true)
	public StudentInvoice getStudentInvoice() {
		return studentInvoice;
	}
	public void setStudentInvoice(StudentInvoice studentInvoice) {
		this.studentInvoice = studentInvoice;
	}
	
	@Column(name = "student_invoice_element_amount", nullable = false)
	public double getStudentInvoiceElementAmount() {
		return studentInvoiceElementAmount;
	}
	public void setStudentInvoiceElementAmount(double studentInvoiceElementAmount) {
		this.studentInvoiceElementAmount = studentInvoiceElementAmount;
	}
	@Column(name = "student_invoice_element_tax_amount", nullable = false)
	public double getStudentInvoiceElementTaxAmount() {
		return studentInvoiceElementTaxAmount;
	}
	public void setStudentInvoiceElementTaxAmount(double studentInvoiceElementTaxAmount) {
		this.studentInvoiceElementTaxAmount = studentInvoiceElementTaxAmount;
	}
	@Column(name = "student_invoice_element_total_amount", nullable = false)
	public double getStudentInvoiceElementTotalAmount() {
		return studentInvoiceElementTotalAmount;
	}
	public void setStudentInvoiceElementTotalAmount(double studentInvoiceElementTotalAmount) {
		this.studentInvoiceElementTotalAmount = studentInvoiceElementTotalAmount;
	}
	@Column(name = "student_invoice_element_payment_status", nullable = false)
	public Integer getStudentInvoiceElementPaymentStatus() {
		return studentInvoiceElementPaymentStatus;
	}
	public void setStudentInvoiceElementPaymentStatus(Integer studentInvoiceElementPaymentStatus) {
		this.studentInvoiceElementPaymentStatus = studentInvoiceElementPaymentStatus;
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

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "template_item_id", nullable = false)
	@ForeignKey(name="studentInvoiceItemsInFeesTemplateItem")
	@JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class, property="@feesTemplates")
	@JsonIdentityReference(alwaysAsId = true)
	public FeesTemplateItem getFeesTemplateItem() {
		return feesTemplateItem;
	}

	public void setFeesTemplateItem(FeesTemplateItem feesTemplateItem) {
		this.feesTemplateItem = feesTemplateItem;
	}
}
