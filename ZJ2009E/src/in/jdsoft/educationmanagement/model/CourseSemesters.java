package in.jdsoft.educationmanagement.model;


import static javax.persistence.GenerationType.IDENTITY;

import java.util.HashSet;
import java.util.Set;

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
import javax.persistence.UniqueConstraint;

import org.hibernate.annotations.ForeignKey;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "tbl_course_semesters", uniqueConstraints = @UniqueConstraint(columnNames = {
		"course_id", "semester" }))
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class CourseSemesters implements java.io.Serializable {

	public CourseSemesters() {
		// TODO Auto-generated constructor stub
	}
	private static final long serialVersionUID = 1L;
	private Integer courseSemId;
	private Courses course;
	private byte semester;
	private SemesterSystemSubset semesterSystemSubset;
	private int groupLock;
	
	
	private Set<TimeTable> timeTables=new HashSet<TimeTable>(0);
	private Set<Module> modules=new HashSet<Module>(0);
	private Set<AcademicCourseSemesterModule> academicCourseSemesterModules=new HashSet<AcademicCourseSemesterModule>(0);
 
	public CourseSemesters(Courses course, byte semester, SemesterSystemSubset semesterSystemSubset, int groupLock) {
		this.course = course;
		this.semester = semester;
		this.setSemesterSystemSubset(semesterSystemSubset);
		this.groupLock = groupLock;
	}
	
	
	@Id
	@GeneratedValue(strategy = IDENTITY)
    @Column(name = "course_sem_id", nullable = false)
	public Integer getCourseSemId() {
		return this.courseSemId;
	}

	public void setCourseSemId(Integer courseSemId) {
		this.courseSemId = courseSemId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "course_id", nullable = false)
	@ForeignKey(name="courseSemesterInCourse")
	public Courses getCourse() {
		return this.course;
	}

	public void setCourse(Courses course) {
		this.course = course;
	}

	@Column(name = "semester", nullable = false)
	public byte getSemester() {
		return this.semester;
	}

	public void setSemester(byte semester) {
		this.semester = semester;
	}

	

	@Column(name = "group_lock", nullable = false)
	public int getGroupLock() {
		return this.groupLock;
	}

	public void setGroupLock(int groupLock) {
		this.groupLock = groupLock;
	}


	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "semester_system_subset_id", nullable = false)
	@ForeignKey(name="courseSemesterInSemesterSystemSubset")
	public SemesterSystemSubset getSemesterSystemSubset() {
		return semesterSystemSubset;
	}


	public void setSemesterSystemSubset(SemesterSystemSubset semesterSystemSubset) {
		this.semesterSystemSubset = semesterSystemSubset;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "courseSemester")
	@ForeignKey(name="courseSemesterInTimeTables")
	public Set<TimeTable> getTimeTables() {
		return timeTables;
	}

	public void setTimeTables(Set<TimeTable> timeTables) {
		this.timeTables = timeTables;
	}
    
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "tbl_course_semester_module_mapping",joinColumns = { 
			@JoinColumn(name = "course_sem_id", updatable = false) }, 
			inverseJoinColumns = { @JoinColumn(name = "module_id", 
					 updatable = false) })
	@ForeignKey(name="courseSemestersInModules")
	public Set<Module> getModules() {
		return modules;
	}


	public void setModules(Set<Module> modules) {
		this.modules = modules;
	}


	@OneToMany(fetch = FetchType.LAZY, mappedBy = "courseSemester")
	@ForeignKey(name="courseSemesterInAcademicCourseSemesterModules")
	public Set<AcademicCourseSemesterModule> getAcademicCourseSemesterModules() {
		return academicCourseSemesterModules;
	}


	public void setAcademicCourseSemesterModules(Set<AcademicCourseSemesterModule> academicCourseSemesterModules) {
		this.academicCourseSemesterModules = academicCourseSemesterModules;
	}

}
