package in.jdsoft.educationmanagement.model;

import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@Entity
@Table(name = "tbl_timetable",  uniqueConstraints = @UniqueConstraint(columnNames = {"academic_year_id","course_sem_id","timeslot_id","acsm_id","staff_id"}))
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class TimeTable implements Serializable{

	public TimeTable() {}
	
	public TimeTable(AcademicYear academicYear, CourseSemesters courseSemester,Timeslot timeslot, AcademicCourseSemesterModule academicCourseSemesterModule,
			Staff staff) {
		this.academicYear = academicYear;
		this.courseSemester = courseSemester;
		this.timeslot = timeslot;
		this.academicCourseSemesterModule = academicCourseSemesterModule;
		this.staff = staff;
	}
	
	private static final long serialVersionUID = 1L;
	
	private Integer timetableId;
	private AcademicYear academicYear;
	private CourseSemesters courseSemester;
	private Timeslot timeslot;
	private AcademicCourseSemesterModule academicCourseSemesterModule;
	private Staff staff;
	
	
	@Id
	@GeneratedValue(strategy = IDENTITY)
    @Column(name = "timetable_id",nullable = false)
	public Integer getTimetableId() {
		return timetableId;
	}
	public void setTimetableId(Integer timetableId) {
		this.timetableId = timetableId;
	}
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "academic_year_id", nullable = false)
	public AcademicYear getAcademicYear() {
		return academicYear;
	}
	public void setAcademicYear(AcademicYear academicYear) {
		this.academicYear = academicYear;
	}
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "course_sem_id", nullable = false)
	public CourseSemesters getCourseSemester() {
		return courseSemester;
	}
	public void setCourseSemester(CourseSemesters courseSemester) {
		this.courseSemester = courseSemester;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "timeslot_id", nullable = false)
	public Timeslot getTimeslot() {
		return timeslot;
	}
	public void setTimeslot(Timeslot timeslot) {
		this.timeslot = timeslot;
	}
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "acsm_id", nullable = false)
	public AcademicCourseSemesterModule getAcademicCourseSemesterModule() {
		return academicCourseSemesterModule;
	}
	public void setAcademicCourseSemesterModule(AcademicCourseSemesterModule academicCourseSemesterModule) {
		this.academicCourseSemesterModule = academicCourseSemesterModule;
	}
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "staff_id", nullable = false)
	public Staff getStaff() {
		return staff;
	}
	public void setStaff(Staff staff) {
		this.staff = staff;
	}
}
