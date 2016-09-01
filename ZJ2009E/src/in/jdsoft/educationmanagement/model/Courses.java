package in.jdsoft.educationmanagement.model;

import static javax.persistence.GenerationType.IDENTITY;

import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

import org.apache.commons.lang.WordUtils;
import org.hibernate.annotations.ForeignKey;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;


@Entity
@Table(name = "tbl_courses",  uniqueConstraints = @UniqueConstraint(columnNames = "course_code"))
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Courses implements java.io.Serializable {

	
	private static final long serialVersionUID = 1L;
	
	private Integer courseId;
	private String courseCode;
	private String courseName;
	private String courseDescription;
	private int durationInYears;
	private int durationInSemesters;
	private int courseStatus;
	private String createdBy;
	private Date createdDate;
	private String image;
	private Integer totalSeats;
	
	private CourseType courseType;
	private Department department;
	private SemesterSystem semesterSystem;
	private Institution institution;
	
	
    private Set<CourseSemesters> courseSemesterses = new HashSet<CourseSemesters>(0);
	private Set<Admission> admissions=new HashSet<Admission>(0);
	private Set<Student> students=new HashSet<Student>(0);
	private Set<CourseCategory> courseCategories=new HashSet<CourseCategory>();
	
	
	
	public Courses() {}

	
	public Courses(int departmentId, int semesterSystemId, String courseName,
			String courseDescription, int durationInYears, int durationInSemesters, int courseStatus, String createdBy,
			String image,CourseType courseType,Department department,SemesterSystem semesterSystem,Integer totalSeats,Institution institution) {
		this.courseCode =Long.toString(System.currentTimeMillis());
		this.department=department;
		this.semesterSystem=semesterSystem;
		this.courseName =WordUtils.capitalize(courseName);
		this.courseDescription =WordUtils.capitalize(courseDescription);
		this.durationInYears = durationInYears;
		this.durationInSemesters = durationInSemesters;
		this.courseStatus = courseStatus;
		this.createdBy = createdBy;
		this.createdDate =new Date(Calendar.getInstance().getTime().getTime());
		this.image = image;
		this.courseType=courseType;
		this.totalSeats=totalSeats;
		this.institution=institution;
	}
	
	/*public Courses(int departmentId, int semesterSystemId, String courseName,
			String courseDescription, int durationInYears, int durationInSemesters, int courseStatus, String createdBy,
			String image,CourseType courseType,Department department,SemesterSystem semesterSystem, Set<CourseSemesters> courseSemesterses) {
		this.courseCode =Long.toString(System.currentTimeMillis());
		this.department=department;
		this.semesterSystem=semesterSystem;
		this.courseName =WordUtils.capitalize(courseName);
		this.courseDescription =WordUtils.capitalize(courseDescription);
		this.durationInYears = durationInYears;
		this.durationInSemesters = durationInSemesters;
		this.courseStatus = courseStatus;
		this.createdBy = createdBy;
		this.createdDate =new Date(Calendar.getInstance().getTime().getTime());
		this.image = image;
		this.courseSemesterses = courseSemesterses;
		this.courseType=courseType;
	}
*/
	@Id
	@GeneratedValue(strategy = IDENTITY)
    @Column(name = "course_id", nullable = false)
	public Integer getCourseId() {
		return this.courseId;
	}

	public void setCourseId(Integer courseId) {
		this.courseId = courseId;
	}

	@Column(name = "course_code",nullable = false, length = 20)
	public String getCourseCode() {
		return this.courseCode;
	}

	public void setCourseCode(String courseCode) {
		this.courseCode = courseCode;
	}

	
	@Column(name = "course_name", nullable = false, length = 50)
	public String getCourseName() {
		return this.courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName =WordUtils.capitalize(courseName);
	}

	@Column(name = "course_description", nullable = false, length = 1000)
	public String getCourseDescription() {
		return this.courseDescription;
	}

	public void setCourseDescription(String courseDescription) {
		this.courseDescription =WordUtils.capitalize(courseDescription);
	}

	@Column(name = "duration_in_years", nullable = false)
	public int getDurationInYears() {
		return this.durationInYears;
	}

	public void setDurationInYears(int durationInYears) {
		this.durationInYears = durationInYears;
	}

	@Column(name = "duration_in_semesters", nullable = false)
	public int getDurationInSemesters() {
		return this.durationInSemesters;
	}

	public void setDurationInSemesters(int durationInSemesters) {
		this.durationInSemesters = durationInSemesters;
	}

	@Column(name = "course_status", nullable = false)
	public int getCourseStatus() {
		return this.courseStatus;
	}

	public void setCourseStatus(int courseStatus) {
		this.courseStatus = courseStatus;
	}

	@Column(name = "created_by", nullable = false, length = 150)
	public String getCreatedBy() {
		return this.createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "created_date", nullable = false)
	public Date getCreatedDate() {
		return this.createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	@Column(name = "image", nullable = false, length = 500)
	public String getImage() {
		return this.image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "course",cascade={CascadeType.PERSIST,CascadeType.REMOVE})
	@ForeignKey(name="courseInCourseSemesters")
	@JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class, property="@course")
	public Set<CourseSemesters> getCourseSemesterses() {
		return this.courseSemesterses;
	}

	public void setCourseSemesterses(Set<CourseSemesters> courseSemesterses) {
		this.courseSemesterses = courseSemesterses;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "course")
	@ForeignKey(name="courseInAdmissions")
	public Set<Admission> getAdmissions() {
		return admissions;
	}

	public void setAdmissions(Set<Admission> admissions) {
		this.admissions = admissions;
	}
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "course_type_id", nullable = false)
	@ForeignKey(name="courseIncourseType")
	public CourseType getCourseType() {
		return courseType;
	}


	public void setCourseType(CourseType courseType) {
		this.courseType = courseType;
	}


	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "department_id", nullable = false)
	@ForeignKey(name="courseInDepartment")
	@JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class, property="@courses")
	public Department getDepartment() {
		return department;
	}


	public void setDepartment(Department department) {
		this.department = department;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "semester_system_id", nullable = false)
	@ForeignKey(name="courseInSemesterSystem")
	public SemesterSystem getSemesterSystem() {
		return semesterSystem;
	}

	public void setSemesterSystem(SemesterSystem semesterSystem) {
		this.semesterSystem = semesterSystem;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "course")
	@ForeignKey(name="courseInStudents")
	public Set<Student> getStudents() {
		return students;
	}

	public void setStudents(Set<Student> students) {
		this.students = students;
	}
   
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "tbl_course_and_course_category_mapping",joinColumns = { 
			@JoinColumn(name = "course_id", updatable = false) }, 
			inverseJoinColumns = { @JoinColumn(name = "course_category_id", 
					 updatable = false) })
	@ForeignKey(name="coursesInCourseCategories")
	public Set<CourseCategory> getCourseCategories() {
		return courseCategories;
	}


	public void setCourseCategories(Set<CourseCategory> courseCategories) {
		this.courseCategories = courseCategories;
	}

	@Column(name = "total_seats", nullable = false)
	public Integer getTotalSeats() {
		return totalSeats;
	}


	public void setTotalSeats(Integer totalSeats) {
		this.totalSeats = totalSeats;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "institution_id", nullable = false)
	@ForeignKey(name="courseInInstitution")
	public Institution getInstitution() {
		return institution;
	}


	public void setInstitution(Institution institution) {
		this.institution = institution;
	}

}
