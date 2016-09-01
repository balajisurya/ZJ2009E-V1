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
@Table(name = "tbl_timeslot",  uniqueConstraints ={
		@UniqueConstraint(columnNames = { "weekday_id", "time_slot_title"}),
		@UniqueConstraint(columnNames = {"time_slot_title","time_slot_time"})})
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Timeslot implements Serializable {
	
	public Timeslot() {}
	
	public Timeslot(Weekday weekday, String timeslotTitle,
			String timeslotTime) {
		this.weekday = weekday;
		this.timeslotTitle = timeslotTitle;
		this.timeslotTime = timeslotTime;
	}
	
	private static final long serialVersionUID = 1L;
	
	private Integer timeslotId;
	private Weekday weekday;
	private String timeslotTitle;
	private String timeslotTime;
	
	
	@Id
	@GeneratedValue(strategy = IDENTITY)
    @Column(name = "timeslot_id",nullable = false)
	public Integer getTimeslotId() {
		return timeslotId;
	}
	public void setTimeslotId(Integer timeslotId) {
		this.timeslotId = timeslotId;
	}
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "weekday_id", nullable = false)
	public Weekday getWeekday() {
		return weekday;
	}
	public void setWeekday(Weekday weekday) {
		this.weekday = weekday;
	}
	
	@Column(name = "time_slot_title",nullable = false, length = 50)
	public String getTimeslotTitle() {
		return timeslotTitle;
	}
	public void setTimeslotTitle(String timeslotTitle) {
		this.timeslotTitle = timeslotTitle;
	}
	
	@Column(name = "time_slot_time",nullable = false, length = 50)
	public String getTimeslotTime() {
		return timeslotTime;
	}
	public void setTimeslotTime(String timeslotTime) {
		this.timeslotTime = timeslotTime;
	}

}
