package in.jdsoft.educationmanagement.model;

import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.apache.commons.lang.WordUtils;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "tbl_course_type",  uniqueConstraints = @UniqueConstraint(columnNames = "course_type_name"))
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class CourseType implements Serializable{
	private static final long serialVersionUID = 1L;
	
	public CourseType() {
		
	}
	
	public CourseType(String courseTypeName, String courseTypeDescription) {
		this.courseTypeName =WordUtils.capitalize(courseTypeName);
		this.courseTypeDescription =WordUtils.capitalize(courseTypeDescription);
	}
	
	
	private int courseTypeId;
	private String courseTypeName;
	private String courseTypeDescription;
	
	private Set<Admission> admissionListByCourseType = new HashSet<Admission>(0);
	private Set<Courses> coursesByCourseType=new HashSet<Courses>(0);
	private Set<Student> students=new HashSet<Student>(0);
	
	
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "course_type_id", unique = true, nullable = false)
	public int getCourseTypeId() {
		return courseTypeId;
	}
	public void setCourseTypeId(int courseTypeId) {
		this.courseTypeId = courseTypeId;
	}
	
	@Column(name = "course_type_name", unique = true, nullable = false, length = 40)
	public String getCourseTypeName() {
		return courseTypeName;
	}
	public void setCourseTypeName(String courseTypeName) {
		this.courseTypeName =WordUtils.capitalize(courseTypeName);
	}
	
	@Column(name = "course_type_description", nullable = false, length = 255)
	public String getCourseTypeDescription() {
		return courseTypeDescription;
	}
	public void setCourseTypeDescription(String courseTypeDescription) {
		this.courseTypeDescription =WordUtils.capitalize(courseTypeDescription);
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "courseType")
	public Set<Admission> getAdmissionListByCourseType() {
		return admissionListByCourseType;
	}

	public void setAdmissionListByCourseType(Set<Admission> admissionListByCourseType) {
		this.admissionListByCourseType = admissionListByCourseType;
	}
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "courseType")
	public Set<Courses> getCoursesByCourseType() {
		return coursesByCourseType;
	}

	public void setCoursesByCourseType(Set<Courses> coursesByCourseType) {
		this.coursesByCourseType = coursesByCourseType;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "courseType")
	public Set<Student> getStudents() {
		return students;
	}

	public void setStudents(Set<Student> students) {
		this.students = students;
	}

}
