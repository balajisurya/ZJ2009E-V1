package in.jdsoft.educationmanagement.school.exceptions;

import in.jdsoft.educationmanagement.school.model.Message;

public class StudentException extends EdumaatException{

	private static final long serialVersionUID = 1L;

	public StudentException(Message message) {
		super(message);
	}
	
	public StudentException(Exception e,Message message) {
		super(e,message);
	}
}
