package in.jdsoft.educationmanagement.model;


import static javax.persistence.GenerationType.IDENTITY;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@Entity
@Table(name = "tbl_student_status")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class StudentStatus implements java.io.Serializable {

	
	private static final long serialVersionUID = 1L;
	private Integer studentStatusId;
	private String statusTitle;

	private Set<Student> students=new HashSet<Student>(0);
	
	public StudentStatus() {
	}

	public StudentStatus(String statusTitle) {
		this.statusTitle = statusTitle;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "student_status_id", unique = true, nullable = false)
	public Integer getStudentStatusId() {
		return this.studentStatusId;
	}

	public void setStudentStatusId(Integer studentStatusId) {
		this.studentStatusId = studentStatusId;
	}

	@Column(name = "status_title", nullable = false, length = 100)
	public String getStatusTitle() {
		return this.statusTitle;
	}

	public void setStatusTitle(String statusTitle) {
		this.statusTitle = statusTitle;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "studentStatus")
	public Set<Student> getStudents() {
		return students;
	}

	public void setStudents(Set<Student> students) {
		this.students = students;
	}

}
