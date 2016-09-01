package in.jdsoft.educationmanagement.school.exceptions;

import in.jdsoft.educationmanagement.school.model.Message;

public class SpecialCategoryException extends EdumaatException{
	

	private static final long serialVersionUID = 1L;

	public SpecialCategoryException(Message message) {
		super(message);
	}
	
	public SpecialCategoryException(Exception e,Message message) {
		super(e,message);
	}
}
