package in.jdsoft.educationmanagement.school.exceptions;

import in.jdsoft.educationmanagement.school.model.Message;

public class UserServiceExceptions extends EdumaatException{
	

	private static final long serialVersionUID = 1L;

	public UserServiceExceptions(Message message) {
		super(message);
	}
	
	public UserServiceExceptions(Exception e,Message message) {
		super(e,message);
	}
}
