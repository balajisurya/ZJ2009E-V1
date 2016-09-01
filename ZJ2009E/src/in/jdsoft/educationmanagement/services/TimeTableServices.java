package in.jdsoft.educationmanagement.services;

import java.util.Set;

import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import in.jdsoft.educationmanagement.dao.TimeTableTemplateDAO;
import in.jdsoft.educationmanagement.model.TimeTableTemplate;
import in.jdsoft.educationmanagement.model.Weekday;

@Service
public class TimeTableServices {

	
	@Autowired
	TimeTableTemplateDAO timeTableTemplateDAO;
	
	@Transactional
	public void addTimeTableTemplate(TimeTableTemplate timeTableTemplate){
		try {
			timeTableTemplateDAO.persist(timeTableTemplate);
		} catch (Exception e) {
			throw e;
		}
		
	}
	
	@Transactional
	public TimeTableTemplate getTimeTableTemplateById(Integer timeTableTemplateId){
		try {
			 TimeTableTemplate timeTableTemplate=timeTableTemplateDAO.getTimeTableTemplateById(timeTableTemplateId);
			 Hibernate.initialize(timeTableTemplate.getWeekdays());
			 Set<Weekday> weekdays=timeTableTemplate.getWeekdays();
			 for(Weekday weekday:weekdays){
				 Hibernate.initialize(weekday.getTimeslots());
			 }
			 return timeTableTemplate;
		} catch (Exception e) {
			 throw e;
		}
	}
}
