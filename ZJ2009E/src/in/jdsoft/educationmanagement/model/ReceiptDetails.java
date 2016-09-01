package in.jdsoft.educationmanagement.model;


import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@Entity
@Table(name = "tbl_receipt_details")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class ReceiptDetails implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer receiptDetailId;
	private Receipts receiptDetails;
	private String feesItem;
	private String invoiceNo;
	private double amount;

	public ReceiptDetails() {
	}

	public ReceiptDetails(Receipts receiptDetails, String feesItem, String invoiceNo, double amount) {
		this.receiptDetails=receiptDetails;
		this.feesItem = feesItem;
		this.invoiceNo = invoiceNo;
		this.amount = amount;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "receipt_detail_id", unique = true, nullable = false)
	public Integer getReceiptDetailId() {
		return this.receiptDetailId;
	}

	public void setReceiptDetailId(Integer receiptDetailId) {
		this.receiptDetailId = receiptDetailId;
	}

	@Column(name = "fees_item", nullable = false)
	public String getFeesItem() {
		return this.feesItem;
	}

	public void setFeesItem(String feesItem) {
		this.feesItem = feesItem;
	}

	@Column(name = "invoice_no", nullable = false, length = 50)
	public String getInvoiceNo() {
		return this.invoiceNo;
	}

	public void setInvoiceNo(String invoiceNo) {
		this.invoiceNo = invoiceNo;
	}

	@Column(name = "amount", nullable = false, precision = 22, scale = 0)
	public double getAmount() {
		return this.amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "receipt_id", nullable = false)
	public Receipts getReceiptDetails() {
		return receiptDetails;
	}

	public void setReceiptDetails(Receipts receiptDetails) {
		this.receiptDetails = receiptDetails;
	}

}
