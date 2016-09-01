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
@Table(name = "tbl_lab_plan_schedule")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class LabPlanSchedule implements java.io.Serializable {

	public LabPlanSchedule(Date labPlanScheduleStartdate, Date labPlanScheduleEnddate, String labPlanScheduleStatus,
			String labPlanScheduleRemarks, Integer labPlanScheduleHoursRequired, LabPlan labPlan) {
		LabPlanScheduleStartdate = labPlanScheduleStartdate;
		LabPlanScheduleEnddate = labPlanScheduleEnddate;
		LabPlanScheduleStatus = labPlanScheduleStatus;
		LabPlanScheduleRemarks = labPlanScheduleRemarks;
		LabPlanScheduleHoursRequired = labPlanScheduleHoursRequired;
	
		this.setLabPlan(labPlan);
	}
private static final long serialVersionUID = 1L;
	
	//single fields
	
	private Integer LabPlanScheduleId;
	private Date LabPlanScheduleStartdate;
	private Date LabPlanScheduleEnddate;
	private String LabPlanScheduleStatus;
	private String LabPlanScheduleRemarks;
	private Integer LabPlanScheduleHoursRequired;
	
	
	//models
	
	
	private LabPlan labPlan;

	//PK
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "lab_plan_schedule_id", unique = true, nullable = false)
	public Integer getLabPlanScheduleId() {
		return LabPlanScheduleId;
	}
	public void setLabPlanScheduleId(Integer LabPlanScheduleId) {
		this.LabPlanScheduleId = LabPlanScheduleId;
	}
	
	//Single Fields

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "lab_plan_schedule_start_date", nullable = false, length = 10)
	public Date getLabPlanScheduleStartdate() {
		return LabPlanScheduleStartdate;
	}
	public void setLabPlanScheduleStartdate(Date LabPlanScheduleStartdate) {
		this.LabPlanScheduleStartdate = LabPlanScheduleStartdate;
	}
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "lab_plan_schedule_end_date", nullable = false, length = 10)
	public Date getLabPlanScheduleEnddate() {
		return LabPlanScheduleEnddate;
	}
	public void setLabPlanScheduleEnddate(Date LabPlanScheduleEnddate) {
		this.LabPlanScheduleEnddate = LabPlanScheduleEnddate;
	}
	@Column(name = "lab_plan_schedule_status", nullable = false, length = 255)
	public String getLabPlanScheduleStatus() {
		return LabPlanScheduleStatus;
	}
	public void setLabPlanScheduleStatus(String LabPlanScheduleStatus) {
		this.LabPlanScheduleStatus = LabPlanScheduleStatus;
	}
	@Column(name = "lab_plan_schedule_remarks", nullable = false, length = 255)
	public String getLabPlanScheduleRemarks() {
		return LabPlanScheduleRemarks;
	}
	public void setLabPlanScheduleRemarks(String LabPlanScheduleRemarks) {
		this.LabPlanScheduleRemarks = LabPlanScheduleRemarks;
	}
	@Column(name = "lab_plan_schedule_hours_required", nullable = false, length = 255)
	public Integer getLabPlanScheduleHoursRequired() {
		return LabPlanScheduleHoursRequired;
	}
	public void setLabPlanScheduleHoursRequired(Integer LabPlanScheduleHoursRequired) {
		this.LabPlanScheduleHoursRequired = LabPlanScheduleHoursRequired;
	}
	//Mappings
	

	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "lab_plan_id", nullable =true)
	public LabPlan getLabPlan() {
		return labPlan;
	}
	public void setLabPlan(LabPlan labPlan) {
		this.labPlan = labPlan;
	}

	
}