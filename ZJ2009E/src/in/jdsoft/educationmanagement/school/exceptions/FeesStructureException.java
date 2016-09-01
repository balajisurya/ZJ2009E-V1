package in.jdsoft.educationmanagement.school.exceptions;

import in.jdsoft.educationmanagement.school.model.Message;

public class FeesStructureException extends EdumaatException{

	private static final long serialVersionUID = 1L;

	public FeesStructureException(Message message) {
		super(message);
	}
	
	public FeesStructureException(Exception e,Message message) {
		super(e,message);
	}
}
