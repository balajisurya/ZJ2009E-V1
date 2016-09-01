package in.jdsoft.educationmanagement.model;


import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@Entity
@Table(name = "tbl_receipts")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Receipts implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int receiptId;
	private String receiptNo;
	private int studentId;
	private Date createdDate;
	private String createdBy;
	
	private Set<ReceiptDetails> receiptDetails=new HashSet<ReceiptDetails>(0);

	public Receipts() {
	}

	public Receipts(int receiptId, String receiptNo, int studentId, Date createdDate, String createdBy) {
		this.receiptId = receiptId;
		this.receiptNo = receiptNo;
		this.studentId = studentId;
		this.createdDate = createdDate;
		this.createdBy = createdBy;
	}

	@Id

	@Column(name = "receipt_id", unique = true, nullable = false)
	public int getReceiptId() {
		return this.receiptId;
	}

	public void setReceiptId(int receiptId) {
		this.receiptId = receiptId;
	}

	@Column(name = "receipt_no", nullable = false, length = 50)
	public String getReceiptNo() {
		return this.receiptNo;
	}

	public void setReceiptNo(String receiptNo) {
		this.receiptNo = receiptNo;
	}

	@Column(name = "student_id", nullable = false)
	public int getStudentId() {
		return this.studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "created_date", nullable = false, length = 10)
	public Date getCreatedDate() {
		return this.createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	@Column(name = "created_by", nullable = false)
	public String getCreatedBy() {
		return this.createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	@OneToMany(fetch=FetchType.LAZY,mappedBy="receiptDetails")
	public Set<ReceiptDetails> getReceiptDetails() {
		return receiptDetails;
	}

	public void setReceiptDetails(Set<ReceiptDetails> receiptDetails) {
		this.receiptDetails = receiptDetails;
	}

}
