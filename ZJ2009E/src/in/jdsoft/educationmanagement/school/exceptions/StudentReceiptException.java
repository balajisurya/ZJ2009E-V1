package in.jdsoft.educationmanagement.school.exceptions;

import in.jdsoft.educationmanagement.school.model.Message;

public class StudentReceiptException extends EdumaatException {

	private static final long serialVersionUID = 1L;
	
	public StudentReceiptException(Message message) {
		super(message);
	}
	
	public StudentReceiptException(Exception e,Message message) {
		super(e,message);
	}

}
