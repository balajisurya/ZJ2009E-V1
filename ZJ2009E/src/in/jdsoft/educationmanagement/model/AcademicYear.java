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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

import org.hibernate.annotations.ForeignKey;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@Entity
@Table(name = "tbl_academic_year",uniqueConstraints = {@UniqueConstraint(columnNames ={"academic_year_title"})})
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class AcademicYear implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	
	public AcademicYear() {}
	
	public AcademicYear(String academicYearTitle, Date academicYearStartDate,
			Date academicYearEndDate,int academicYearWorkingDays,AcademicYearStatus academicYearStatus,
			String academicYearLastModifiedBy, String academicYearCreatedBy,Institution institution) {
		this.academicYearTitle = academicYearTitle;
		this.academicYearStartDate = academicYearStartDate;
		this.academicYearEndDate = academicYearEndDate;
		this.academicYearWorkingDays = academicYearWorkingDays;
		this.academicYearStatus=academicYearStatus;
		this.academicYearLastModifiedBy = academicYearLastModifiedBy;
		this.academicYearCreatedBy = academicYearCreatedBy;
		this.academicYearCreatedDate =new Date(Calendar.getInstance().getTime().getTime());
		this.institution=institution;
	}
	
	
	private Integer academicYearId;
	private String academicYearTitle;
	private Date academicYearStartDate;
	
	private Date academicYearEndDate;
	
	private int academicYearWorkingDays;
	private AcademicYearStatus academicYearStatus;
	private String academicYearLastModifiedBy;
	private Date academicYearLastModified;
	private String academicYearCreatedBy;
	private Date academicYearCreatedDate;
	private Institution institution;
	
	private Set<TimeTable> timetables=new HashSet<TimeTable>(0);
	private Set<AcademicSemesterSystem> academicSemesterSystems=new HashSet<AcademicSemesterSystem>(0);
	private Set<AcademicCourseSemesterModule> academicCourseSemesterModules=new HashSet<AcademicCourseSemesterModule>(0);
	


	
	

	@Id
	@GeneratedValue(strategy = IDENTITY)
    @Column(name = "academic_year_id", nullable = false)
	public Integer getAcademicYearId() {
		return this.academicYearId;
	}

	public void setAcademicYearId(Integer academicYearId) {
		this.academicYearId = academicYearId;
	}

	@Column(name = "academic_year_title", nullable = false, length = 30)
	public String getAcademicYearTitle() {
		return this.academicYearTitle;
	}

	public void setAcademicYearTitle(String academicYearTitle) {
		this.academicYearTitle = academicYearTitle;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "academic_year_start_date", nullable = false, length = 10)
	public Date getAcademicYearStartDate() {
		return this.academicYearStartDate;
	}

	public void setAcademicYearStartDate(Date academicYearStartDate) {
		this.academicYearStartDate = academicYearStartDate;
	}

	

	@Temporal(TemporalType.DATE)
	@Column(name = "academic_year_end_date", nullable = false, length = 10)
	public Date getAcademicYearEndDate() {
		return this.academicYearEndDate;
	}

	public void setAcademicYearEndDate(Date academicYearEndDate) {
		this.academicYearEndDate = academicYearEndDate;
	}

	

	@Column(name = "academic_year_working_days", nullable = false)
	public int getAcademicYearWorkingDays() {
		return this.academicYearWorkingDays;
	}

	public void setAcademicYearWorkingDays(int academicYearWorkingDays) {
		this.academicYearWorkingDays = academicYearWorkingDays;
	}

	@Column(name = "academic_year_last_modified_by", nullable = false, length = 100)
	public String getAcademicYearLastModifiedBy() {
		return this.academicYearLastModifiedBy;
	}

	public void setAcademicYearLastModifiedBy(String academicYearLastModifiedBy) {
		this.academicYearLastModifiedBy = academicYearLastModifiedBy;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "academic_year_last_modified", nullable = false, length = 19,columnDefinition="timestamp")
	public Date getAcademicYearLastModified() {
		return this.academicYearLastModified;
	}

	public void setAcademicYearLastModified(Date academicYearLastModified) {
		this.academicYearLastModified = academicYearLastModified;
	}

	@Column(name = "academic_year_created_by", nullable = false, length = 100)
	public String getAcademicYearCreatedBy() {
		return this.academicYearCreatedBy;
	}

	public void setAcademicYearCreatedBy(String academicYearCreatedBy) {
		this.academicYearCreatedBy = academicYearCreatedBy;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "academic_year_created_date", nullable = false, length = 19)
	public Date getAcademicYearCreatedDate() {
		return this.academicYearCreatedDate;
	}

	public void setAcademicYearCreatedDate(Date academicYearCreatedDate) {
		this.academicYearCreatedDate = academicYearCreatedDate;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "academicYear")
	public Set<TimeTable> getTimetables() {
		return timetables;
	}

	public void setTimetables(Set<TimeTable> timetables) {
		this.timetables = timetables;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "academic_year_status_id", nullable = false)
	public AcademicYearStatus getAcademicYearStatus() {
		return academicYearStatus;
	}

	public void setAcademicYearStatus(AcademicYearStatus academicYearStatus) {
		this.academicYearStatus = academicYearStatus;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "academicYear",cascade=CascadeType.PERSIST)
	public Set<AcademicSemesterSystem> getAcademicSemesterSystems() {
		return academicSemesterSystems;
	}

	public void setAcademicSemesterSystems(Set<AcademicSemesterSystem> academicSemesterSystems) {
		this.academicSemesterSystems = academicSemesterSystems;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "academicYear")
	public Set<AcademicCourseSemesterModule> getAcademicCourseSemesterModules() {
		return academicCourseSemesterModules;
	}

	public void setAcademicCourseSemesterModules(Set<AcademicCourseSemesterModule> academicCourseSemesterModules) {
		this.academicCourseSemesterModules = academicCourseSemesterModules;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "institution_id", nullable = false)
	@ForeignKey(name="academicYearInInstitution")
	public Institution getInstitution() {
		return institution;
	}

	public void setInstitution(Institution institution) {
		this.institution = institution;
	}

}
