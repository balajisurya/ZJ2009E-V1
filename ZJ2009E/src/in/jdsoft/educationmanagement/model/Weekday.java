package in.jdsoft.educationmanagement.model;

import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;
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
import javax.persistence.UniqueConstraint;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@Entity
@Table(name = "tbl_weekday",  uniqueConstraints = @UniqueConstraint(columnNames = { "time_table_template_id", "weekday_title" }))
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Weekday implements Serializable{

	public Weekday() {}
	
	public Weekday(TimeTableTemplate timetableTemplate, String weekdayTitle) {
		this.timetableTemplate = timetableTemplate;
		this.weekdayTitle = weekdayTitle;
	}
	
	private static final long serialVersionUID = 1L;
	
	private Integer weekdayId;
	private TimeTableTemplate timetableTemplate;
	private String weekdayTitle;
	
	private Set<Timeslot> timeslots=new HashSet<Timeslot>(0);
	
	@Id
	@GeneratedValue(strategy = IDENTITY)
    @Column(name = "weekday_id",nullable = false)
	public Integer getWeekdayId() {
		return weekdayId;
	}
	public void setWeekdayId(Integer weekdayId) {
		this.weekdayId = weekdayId;
	}
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "time_table_template_id", nullable = false)
	public TimeTableTemplate getTimetableTemplate() {
		return timetableTemplate;
	}
	public void setTimetableTemplate(TimeTableTemplate timetableTemplate) {
		this.timetableTemplate = timetableTemplate;
	}
	
	@Column(name = "weekday_title",nullable = false, length = 50)
	public String getWeekdayTitle() {
		return weekdayTitle;
	}
	public void setWeekdayTitle(String weekdayTitle) {
		this.weekdayTitle = weekdayTitle;
	}
    
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "weekday",cascade=CascadeType.PERSIST)
	public Set<Timeslot> getTimeslots() {
		return timeslots;
	}

	public void setTimeslots(Set<Timeslot> timeslots) {
		this.timeslots = timeslots;
	}
}
