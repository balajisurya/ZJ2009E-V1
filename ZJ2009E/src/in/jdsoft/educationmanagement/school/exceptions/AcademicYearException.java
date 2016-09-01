package in.jdsoft.educationmanagement.school.exceptions;

import in.jdsoft.educationmanagement.school.model.Message;

public class AcademicYearException extends EdumaatException{

	private static final long serialVersionUID = 1L;

	public AcademicYearException(Message message) {
		super(message);
	}
	
	public AcademicYearException(Exception e,Message message) {
		super(e,message);
	}
}
