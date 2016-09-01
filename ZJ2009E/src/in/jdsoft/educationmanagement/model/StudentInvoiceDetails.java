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
@Table(name = "tbl_student_invoice_details")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class StudentInvoiceDetails implements java.io.Serializable {

	
	public StudentInvoiceDetails(StudentInvoice studentInvoice, String studentInvoiceElementName,
			double studentInvoiceElementAmount) {
		this.studentInvoice = studentInvoice;
		this.studentInvoiceElementName = studentInvoiceElementName;
		this.studentInvoiceElementAmount = studentInvoiceElementAmount;
	}

	private static final long serialVersionUID = 1L;
	private Integer studentInvoiceDetailsId;
	private StudentInvoice studentInvoice;
	private String studentInvoiceElementName;
	private double studentInvoiceElementAmount;
	
	

	public StudentInvoiceDetails() {}



	@Id
	@GeneratedValue(strategy = IDENTITY)
    @Column(name = "student_invoice_details_id",nullable = false)
	public Integer getStudentInvoiceDetailsId() {
		return studentInvoiceDetailsId;
	}

    public void setStudentInvoiceDetailsId(Integer studentInvoiceDetailsId) {
		this.studentInvoiceDetailsId = studentInvoiceDetailsId;
	}
    
    @ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "student_invoice_id", nullable = false)
    public StudentInvoice getStudentInvoice() {
		return studentInvoice;
	}

	public void setStudentInvoice(StudentInvoice studentInvoice) {
		this.studentInvoice = studentInvoice;
	}


	@Column(name = "student_invoice_element_name", nullable = false, length = 100)
	public String getStudentInvoiceElementName() {
		return studentInvoiceElementName;
	}



	public void setStudentInvoiceElementName(String studentInvoiceElementName) {
		this.studentInvoiceElementName = studentInvoiceElementName;
	}


	@Column(name = "student_invoice_element_amount", nullable = false)
	public double getStudentInvoiceElementAmount() {
		return studentInvoiceElementAmount;
	}

   	public void setStudentInvoiceElementAmount(double studentInvoiceElementAmount) {
		this.studentInvoiceElementAmount = studentInvoiceElementAmount;
	}

}
