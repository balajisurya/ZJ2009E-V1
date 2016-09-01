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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "tbl_timetable_template",  uniqueConstraints = @UniqueConstraint(columnNames = "time_table_template_name"))
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class TimeTableTemplate implements Serializable {

	public TimeTableTemplate() {}
	
	public TimeTableTemplate(String templateName) {
		this.templateName = templateName;
	}
	
	private static final long serialVersionUID = 1L;
	
	private Integer timeTableTemplateId;
	private String templateName;
	
	private Set<Weekday> weekdays=new HashSet<Weekday>(0);
	
	
	@Id
	@GeneratedValue(strategy = IDENTITY)
    @Column(name = "time_table_template_id",nullable = false)
	public Integer getTimeTableTemplateId() {
		return timeTableTemplateId;
	}
	public void setTimeTableTemplateId(Integer timeTableTemplateId) {
		this.timeTableTemplateId = timeTableTemplateId;
	}
	
	@Column(name = "time_table_template_name",nullable = false, length = 50)
	public String getTemplateName() {
		return templateName;
	}
	public void setTemplateName(String templateName) {
		this.templateName = templateName;
	}
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "timetableTemplate",cascade=CascadeType.PERSIST)
	public Set<Weekday> getWeekdays() {
		return weekdays;
	}

	public void setWeekdays(Set<Weekday> weekdays) {
		this.weekdays = weekdays;
	}
}
