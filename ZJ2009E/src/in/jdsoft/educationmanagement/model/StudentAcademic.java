package in.jdsoft.educationmanagement.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@Entity
@Table(name = "tbl_student_academic")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class StudentAcademic implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private Integer stuAcaId;
	private int studentId;
	private int courseId;
	private byte semester;
	private String academicYear;
	private String academicStatus;
	private byte invoiceStatus;
	private int invoiceId;

	public StudentAcademic() {
	}

	public StudentAcademic(int studentId, int courseId, byte semester, String academicYear, byte invoiceStatus,
			int invoiceId) {
		this.studentId = studentId;
		this.courseId = courseId;
		this.semester = semester;
		this.academicYear = academicYear;
		this.invoiceStatus = invoiceStatus;
		this.invoiceId = invoiceId;
	}

	public StudentAcademic(int studentId, int courseId, byte semester, String academicYear, String academicStatus,
			byte invoiceStatus, int invoiceId) {
		this.studentId = studentId;
		this.courseId = courseId;
		this.semester = semester;
		this.academicYear = academicYear;
		this.academicStatus = academicStatus;
		this.invoiceStatus = invoiceStatus;
		this.invoiceId = invoiceId;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "stu_aca_id", unique = true, nullable = false)
	public Integer getStuAcaId() {
		return this.stuAcaId;
	}

	public void setStuAcaId(Integer stuAcaId) {
		this.stuAcaId = stuAcaId;
	}

	@Column(name = "student_id", nullable = false)
	public int getStudentId() {
		return this.studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	@Column(name = "course_id", nullable = false)
	public int getCourseId() {
		return this.courseId;
	}

	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}

	@Column(name = "semester", nullable = false)
	public byte getSemester() {
		return this.semester;
	}

	public void setSemester(byte semester) {
		this.semester = semester;
	}

	@Column(name = "academic_year", nullable = false, length = 10)
	public String getAcademicYear() {
		return this.academicYear;
	}

	public void setAcademicYear(String academicYear) {
		this.academicYear = academicYear;
	}

	@Column(name = "academic_status", length = 15)
	public String getAcademicStatus() {
		return this.academicStatus;
	}

	public void setAcademicStatus(String academicStatus) {
		this.academicStatus = academicStatus;
	}

	@Column(name = "invoice_status", nullable = false)
	public byte getInvoiceStatus() {
		return this.invoiceStatus;
	}

	public void setInvoiceStatus(byte invoiceStatus) {
		this.invoiceStatus = invoiceStatus;
	}

	@Column(name = "invoice_id", nullable = false)
	public int getInvoiceId() {
		return this.invoiceId;
	}

	public void setInvoiceId(int invoiceId) {
		this.invoiceId = invoiceId;
	}

}
