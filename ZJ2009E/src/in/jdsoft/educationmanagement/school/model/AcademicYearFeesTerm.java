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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.hibernate.annotations.ForeignKey;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table(name = "tbl_academic_year_fees_term",uniqueConstraints={@UniqueConstraint(columnNames={"academic_year_id","fees_term_order"})})
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class AcademicYearFeesTerm implements Serializable{

	private static final long serialVersionUID = 1L;
	
	public AcademicYearFeesTerm() {}
	
	public AcademicYearFeesTerm(AcademicYear academicYear, String feesTermTitle, Integer feesTermOrder) {
		this.academicYear = academicYear;
		this.feesTermTitle = feesTermTitle;
		this.feesTermOrder = feesTermOrder;
	}
	
	
	private Integer academicYearFeesTermId;
	private AcademicYear academicYear;
	private String feesTermTitle;
	private Integer feesTermOrder;
	
	private Set<StudentInvoice> studentInvoices=new HashSet<StudentInvoice>(0);
	
	@Id
	@GeneratedValue(strategy = IDENTITY)
    @Column(name = "academic_year_fees_term_id",nullable = false)
	public Integer getAcademicYearFeesTermId() {
		return academicYearFeesTermId;
	}
	public void setAcademicYearFeesTermId(Integer academicYearFeesTermId) {
		this.academicYearFeesTermId = academicYearFeesTermId;
	}
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "academic_year_id", nullable =true)
	@ForeignKey(name="academicYearFeesTermsInAcademicYear")
	@JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class, property="@academicYearFeesTerms")
	@JsonIdentityReference(alwaysAsId = true)
	public AcademicYear getAcademicYear() {
		return academicYear;
	}
	public void setAcademicYear(AcademicYear academicYear) {
		this.academicYear = academicYear;
	}
	
	@Column(name = "fees_term_title", nullable = false, length = 100)
	public String getFeesTermTitle() {
		return feesTermTitle;
	}
	public void setFeesTermTitle(String feesTermTitle) {
		this.feesTermTitle = feesTermTitle;
	}
	
	@Column(name = "fees_term_order", nullable = false, length = 100)
	public Integer getFeesTermOrder() {
		return feesTermOrder;
	}
	public void setFeesTermOrder(Integer feesTermOrder) {
		this.feesTermOrder = feesTermOrder;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "academicYearFeesTerm")
	@ForeignKey(name="academicYearFeesTermInStudentInvoices")
	public Set<StudentInvoice> getStudentInvoices() {
		return studentInvoices;
	}

	public void setStudentInvoices(Set<StudentInvoice> studentInvoices) {
		this.studentInvoices = studentInvoices;
	}
}
