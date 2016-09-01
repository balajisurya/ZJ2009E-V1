package in.jdsoft.educationmanagement.components;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import in.jdsoft.educationmanagement.school.dao.StudentDAO;


@Component
public class NumberGenerator {

	@Autowired
	StudentDAO studentDAO;
	
	
	
	private static Long admissionNumber=(long) 4999;
	
	
	public Long generateAdmissionNumber(){
		return admissionNumber++;
	}
		
}
