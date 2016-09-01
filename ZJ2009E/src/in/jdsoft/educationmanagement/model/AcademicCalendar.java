package in.jdsoft.educationmanagement.model;

import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.ForeignKey;

public class AcademicCalendar implements Serializable{

	private static final long serialVersionUID = 1L;

	public AcademicCalendar() {}
	public AcademicCalendar(Date startDate, Date endDate,String description) {
		this.startDate = startDate;
		this.endDate = endDate;
		this.noOfDays = (int) TimeUnit.DAYS.convert(endDate.getTime()-startDate.getTime(), TimeUnit.MILLISECONDS);
		this.description=description;
	}
  
  private Integer academicCalendarId;
  private AcademicYear academicYear;
  private AcademicCalendarType academicCalendarType;
  private Date startDate;
  private Date endDate;
  private Integer noOfDays;
  private String description;
 
  
  		@Id
	  	@GeneratedValue(strategy =IDENTITY)
	  	@Column(name = "academic_calendar_id", nullable = false)
		public Integer getAcademicCalendarId() {
			return academicCalendarId;
		}
		public void setAcademicCalendarDayId(Integer academicCalendarId) {
			
			this.academicCalendarId = academicCalendarId;
		}
		
		@Temporal(TemporalType.DATE)
		@Column(name = "academic_calendar_start_date", nullable = false)
		public Date getStartDate() {
			return startDate;
		}
		public void setStartDate(Date startDate) {
			this.startDate = startDate;
		}
		@Temporal(TemporalType.DATE)
		@Column(name = "academic_calendar_end_date", nullable = false)
		public Date getEndDate() {
			return endDate;
		}
		public void setEndDate(Date endDate) {
			this.endDate = endDate;
		}
		
		@Column(name = "no_of_days", nullable = false)
		public Integer getNoOfDays() {
			return noOfDays;
		}
		public void setNoOfDays(Integer noOfDays) {
			this.noOfDays = noOfDays;
		}
		
		@Column(name = "calendar_description", nullable = false,length=255)
		public String getDescription() {
			return description;
		}
		public void setDescription(String description) {
			this.description = description;
		}
		
		@ManyToOne(fetch = FetchType.LAZY)
		@JoinColumn(name = "academic_calendar_type_id", nullable = false)
		@ForeignKey(name="academicCalendarInAcademicCalendarType")
		public AcademicCalendarType getAcademicCalendarType() {
			return academicCalendarType;
		}
		public void setAcademicCalendarType(AcademicCalendarType academicCalendarType) {
			this.academicCalendarType = academicCalendarType;
		}
		
		@ManyToOne(fetch = FetchType.LAZY)
		@JoinColumn(name ="academic_year_id", nullable = false)
		@ForeignKey(name="academicCalendarInAcademicYear")
		public AcademicYear getAcademicYear() {
			return academicYear;
		}
		public void setAcademicYear(AcademicYear academicYear) {
			this.academicYear = academicYear;
		}

}
