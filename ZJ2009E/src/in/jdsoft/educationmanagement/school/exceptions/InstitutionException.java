package in.jdsoft.educationmanagement.school.exceptions;

import in.jdsoft.educationmanagement.school.model.Message;

public class InstitutionException extends EdumaatException{
	

	private static final long serialVersionUID = 1L;

	public InstitutionException(Message message) {
		super(message);
	}
	
	public InstitutionException(Exception e,Message message) {
		super(e,message);
	}
}
