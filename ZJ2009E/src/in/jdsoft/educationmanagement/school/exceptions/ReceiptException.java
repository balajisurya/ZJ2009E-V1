package in.jdsoft.educationmanagement.school.exceptions;

import in.jdsoft.educationmanagement.school.model.Message;

public class ReceiptException extends EdumaatException{

	private static final long serialVersionUID = 1L;
	
	public ReceiptException(Message message) {
		super(message);
	}
	
	public ReceiptException(Exception e,Message message) {
		super(e,message);
	}
}
