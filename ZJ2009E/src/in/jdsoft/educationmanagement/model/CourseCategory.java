package in.jdsoft.educationmanagement.model;


import static javax.persistence.GenerationType.IDENTITY;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.apache.commons.lang.WordUtils;
import org.hibernate.annotations.ForeignKey;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "tbl_course_category", uniqueConstraints = @UniqueConstraint(columnNames = "course_category_name"))
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class CourseCategory implements java.io.Serializable {

	
	private static final long serialVersionUID = 1L;
	private Integer coursecategoryId;
	private String  coursecategoryName;
	
	private Set<Admission> admissionListByCourseCategory = new HashSet<Admission>(0);
	private Set<Student> students=new HashSet<Student>(0);
	private Set<Courses> courses=new HashSet<Courses>();

	public CourseCategory() {
	}

	public CourseCategory(String coursecategoryName) {
		this.coursecategoryName =WordUtils.capitalize(coursecategoryName);
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "course_category_id", nullable = false)
	public Integer getCourseCategoryId() {
		return this.coursecategoryId;
	}

	public void setCourseCategoryId(Integer coursecategoryId) {
		this.coursecategoryId = coursecategoryId;
	}

	@Column(name = "course_category_name", unique = true, nullable = false, length = 100)
	public String getCourseCategoryName() {
		return this.coursecategoryName;
	}

	public void setCourseCategoryName(String coursecategoryName) {
		this.coursecategoryName =WordUtils.capitalize(coursecategoryName);
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "courseCategory")
	public Set<Admission> getAdmissionListByCourseCategory() {
		return admissionListByCourseCategory;
	}

	public void setAdmissionListByCourseCategory(Set<Admission> admissionListByCourseCategory) {
		this.admissionListByCourseCategory = admissionListByCourseCategory;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "courseCategory")
	public Set<Student> getStudents() {
		return students;
	}

	public void setStudents(Set<Student> students) {
		this.students = students;
	}
     
	@ManyToMany(fetch = FetchType.LAZY, mappedBy = "courseCategories")
	@ForeignKey(name="courseCategoriesInCourses")
	public Set<Courses> getCourses() {
		return courses;
	}

	public void setCourses(Set<Courses> courses) {
		this.courses = courses;
	}

}
