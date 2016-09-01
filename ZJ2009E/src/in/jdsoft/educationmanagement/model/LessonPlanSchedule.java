package in.jdsoft.educationmanagement.model;

import static javax.persistence.GenerationType.IDENTITY;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "tbl_lesson_plan_schedule")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class LessonPlanSchedule implements java.io.Serializable {

	public LessonPlanSchedule(Date lessonPlanScheduleStartdate, Date lessonPlanScheduleEnddate,
			String lessonPlanScheduleStatus, String lessonPlanScheduleRemarks, Integer lessonPlanScheduleHoursRequired, LessonPlan lessonPlan) {
		super();
		this.lessonPlanScheduleStartdate = lessonPlanScheduleStartdate;
		this.lessonPlanScheduleEnddate = lessonPlanScheduleEnddate;
		this.lessonPlanScheduleStatus = lessonPlanScheduleStatus;
		this.lessonPlanScheduleRemarks = lessonPlanScheduleRemarks;
		this.lessonPlanScheduleHoursRequired = lessonPlanScheduleHoursRequired;
	
		this.setLessonPlan(lessonPlan);
	}
private static final long serialVersionUID = 1L;
	
	//single fields
	
	private Integer lessonPlanScheduleId;
	private Date lessonPlanScheduleStartdate;
	private Date lessonPlanScheduleEnddate;
	private String lessonPlanScheduleStatus;
	private String lessonPlanScheduleRemarks;
	private Integer lessonPlanScheduleHoursRequired;
	
	
	//models
	
	
	private LessonPlan lessonPlan;
	

	//PK
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "lesson_plan_schedule_id", unique = true, nullable = false)
	public Integer getLessonPlanScheduleId() {
		return lessonPlanScheduleId;
	}
	public void setLessonPlanScheduleId(Integer lessonPlanScheduleId) {
		this.lessonPlanScheduleId = lessonPlanScheduleId;
	}
	
	//Single Fields

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "lesson_plan_schedule_start_date", nullable = false, length = 10)
	public Date getLessonPlanScheduleStartdate() {
		return lessonPlanScheduleStartdate;
	}
	public void setLessonPlanScheduleStartdate(Date lessonPlanScheduleStartdate) {
		this.lessonPlanScheduleStartdate = lessonPlanScheduleStartdate;
	}
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "lesson_plan_schedule_end_date", nullable = false, length = 10)
	public Date getLessonPlanScheduleEnddate() {
		return lessonPlanScheduleEnddate;
	}
	public void setLessonPlanScheduleEnddate(Date lessonPlanScheduleEnddate) {
		this.lessonPlanScheduleEnddate = lessonPlanScheduleEnddate;
	}
	@Column(name = "lesson_plan_schedule_status", nullable = false, length = 255)
	public String getLessonPlanScheduleStatus() {
		return lessonPlanScheduleStatus;
	}
	public void setLessonPlanScheduleStatus(String lessonPlanScheduleStatus) {
		this.lessonPlanScheduleStatus = lessonPlanScheduleStatus;
	}
	@Column(name = "lesson_plan_schedule_remarks", nullable = false, length = 255)
	public String getLessonPlanScheduleRemarks() {
		return lessonPlanScheduleRemarks;
	}
	public void setLessonPlanScheduleRemarks(String lessonPlanScheduleRemarks) {
		this.lessonPlanScheduleRemarks = lessonPlanScheduleRemarks;
	}
	@Column(name = "lesson_plan_schedule_hours_required", nullable = false, length = 255)
	public Integer getLessonPlanScheduleHoursRequired() {
		return lessonPlanScheduleHoursRequired;
	}
	public void setLessonPlanScheduleHoursRequired(Integer lessonPlanScheduleHoursRequired) {
		this.lessonPlanScheduleHoursRequired = lessonPlanScheduleHoursRequired;
	}

	
	//Mappings
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "lesson_plan_id", nullable =true)
	public LessonPlan getLessonPlan() {
		return lessonPlan;
	}
	public void setLessonPlan(LessonPlan lessonPlan) {
		this.lessonPlan = lessonPlan;
	}

}
