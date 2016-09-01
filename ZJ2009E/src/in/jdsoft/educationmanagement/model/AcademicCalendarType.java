package in.jdsoft.educationmanagement.model;

import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "tbl_academic_calendar_type",uniqueConstraints = {@UniqueConstraint(columnNames ={"academic_calendar_type"})})
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class AcademicCalendarType implements Serializable{
	
	private static final long serialVersionUID = 1L;

	public AcademicCalendarType() {}
	
	public AcademicCalendarType(String academicCalendarType) {
		this.academicCalendarType = academicCalendarType;
	}
	
	
	private Integer academicCalendarTypeId;
	private String academicCalendarType;
	

	
	
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "academic_calendar_type_id", nullable = false)
	public Integer getAcademicCalendarTypeId() {
		return academicCalendarTypeId;
	}
	public void setAcademicCalendarTypeId(Integer academicCalendarTypeId) {
		this.academicCalendarTypeId = academicCalendarTypeId;
	}
	@Column(name = "academic_calendar_type", nullable = false, length = 50)
	public String getAcademicCalendarType() {
		return academicCalendarType;
	}
	public void setAcademicCalendarType(String academicCalendarType) {
		this.academicCalendarType = academicCalendarType;
	}
}
