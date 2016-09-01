/*package in.jdsoft.educationmanagement.model;

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
 
@Entity
@Table(name = "tbl_class_of_students")
public class ClassOfStudents implements java.io.Serializable {

	
	public ClassOfStudents(String className) {
		this.className = className;
	
	}
	private static final long serialVersionUID = 1L;
	
	private Integer class_of_students_id;
	private String className;

	private Set<Student> student =new HashSet<Student>(0);
	private Set<Assignment> assignment =new HashSet<Assignment>(0);
	
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "class_of_students_id", unique = true, nullable = false)
	public Integer getClass_of_students_id() {
		return class_of_students_id;
	}
	public void setClass_of_students_id(Integer class_of_students_id) {
		this.class_of_students_id = class_of_students_id;
	}

	// single fields
	
	@Column(name = "class_name", nullable = false, length = 20)
	public String getClassName() {
		return className;
	}
	public void setClassName(String className) {
		this.className = className;
	}
	
	
	
	//mappings
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "student")
	public Set<Student> getStudent() {
		return student;
	}
	public void setStudent(Set<Student> student) {
		this.student = student;
	}
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "student")
	public Set<Assignment> getAssignment() {
		return assignment;
	}
	public void setAssignment(Set<Assignment> assignment) {
		this.assignment = assignment;
	}
	

}
*/