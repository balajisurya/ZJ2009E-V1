package in.jdsoft.educationmanagement.school.model;

import static javax.persistence.GenerationType.IDENTITY;

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
import javax.persistence.UniqueConstraint;

import org.hibernate.annotations.ForeignKey;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "tbl_academic_year",uniqueConstraints={@UniqueConstraint(columnNames={"academic_year_title","institution_id"})})
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class AcademicYear {

	public AcademicYear() {}
	
	public AcademicYear(String academicYearTitle, Integer academicYearStatus,Institution institution) {
		this.academicYearTitle = academicYearTitle;
		this.academicYearStatus = academicYearStatus;
		this.institution=institution;
	}
	
	private Integer academicYearId;
	private String academicYearTitle;
	private Integer academicYearStatus;
	private Institution institution;
	
	private Set<Student> joinedStudents=new HashSet<Student>(0);
	private Set<StudentInvoice> studentInvoices=new HashSet<StudentInvoice>(0);
	private Set<StudentReceipt> studentReceipts=new HashSet<StudentReceipt>(0);
	private Set<AcademicYearFeesTerm> academicYearFeesTerms=new HashSet<AcademicYearFeesTerm>(0);
	
	@Id
	@GeneratedValue(strategy = IDENTITY)
    @Column(name = "academic_year_id",nullable = false)
	public Integer getAcademicYearId() {
		return academicYearId;
	}
	public void setAcademicYearId(Integer academicYearId) {
		this.academicYearId = academicYearId;
	}
	@Column(name = "academic_year_title", nullable = false, length = 100)
	public String getAcademicYearTitle() {
		return academicYearTitle;
	}
	public void setAcademicYearTitle(String academicYearTitle) {
		this.academicYearTitle = academicYearTitle;
	}
	@Column(name = "academic_year_status", nullable = false)
	public Integer getAcademicYearStatus() {
		return academicYearStatus;
	}
	public void setAcademicYearStatus(Integer academicYearStatus) {
		this.academicYearStatus = academicYearStatus;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "institution_id", nullable =true)
	@ForeignKey(name="academicYearInInstitution")
	public Institution getInstitution() {
		return institution;
	}

	public void setInstitution(Institution institution) {
		this.institution = institution;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "joinedAcademicYear")
	@ForeignKey(name="academicYearInStudents")
	public Set<Student> getJoinedStudents() {
		return joinedStudents;
	}

	public void setJoinedStudents(Set<Student> joinedStudents) {
		this.joinedStudents = joinedStudents;
	}
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "academicYear")
	@ForeignKey(name="academicYearInStudentInvoices")
	public Set<StudentInvoice> getStudentInvoices() {
		return studentInvoices;
	}

	public void setStudentInvoices(Set<StudentInvoice> studentInvoices) {
		this.studentInvoices = studentInvoices;
	}
	

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "academicYear")
	@ForeignKey(name="academicYearInStudentReceipts")
	public Set<StudentReceipt> getStudentReceipts() {
		return studentReceipts;
	}

	public void setStudentReceipts(Set<StudentReceipt> studentReceipts) {
		this.studentReceipts = studentReceipts;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "academicYear",cascade={CascadeType.PERSIST,CascadeType.REMOVE})
	@ForeignKey(name="academicYearInAcademicYearFeesTerms")
	public Set<AcademicYearFeesTerm> getAcademicYearFeesTerms() {
		return academicYearFeesTerms;
	}

	public void setAcademicYearFeesTerms(Set<AcademicYearFeesTerm> academicYearFeesTerms) {
		this.academicYearFeesTerms = academicYearFeesTerms;
	}
}
