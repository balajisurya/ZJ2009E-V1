package in.jdsoft.educationmanagement.school.exceptions;

import in.jdsoft.educationmanagement.school.model.Message;


public class EdumaatException extends Exception {
   	private static final long serialVersionUID = 1L;

   	private Message message;
   	
   	public EdumaatException(Message message) {
		super(message.getMessage());
		this.setCustomMessage(message);
	}
   	
   	public EdumaatException(Exception e,Message message) {
		super(e);
		this.setCustomMessage(message);
	}
   	
   	public Message getCustomMessage() {
		return message;
	}
	
	private void setCustomMessage(Message message) {
		this.message = message;
	}
}
