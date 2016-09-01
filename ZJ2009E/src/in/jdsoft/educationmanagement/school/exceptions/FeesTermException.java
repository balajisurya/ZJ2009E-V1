package in.jdsoft.educationmanagement.school.exceptions;

import in.jdsoft.educationmanagement.school.model.Message;

public class FeesTermException extends EdumaatException{

	private static final long serialVersionUID = 1L;

	public FeesTermException(Message message) {
		super(message);
	}
	
	public FeesTermException(Exception e,Message message) {
		super(e,message);
	}
}
