package in.jdsoft.educationmanagement.customexceptions;

import in.jdsoft.educationmanagement.model.Message;

public class CourseException extends Exception{

	private static final long serialVersionUID = 1L;
	
	private Message message;
  
	public CourseException() {
		super();
	}
	public CourseException(Exception e,Message message) {
		super(e);
		this.setCustomMessage(message);
    }
	public CourseException(String exceptionMessage,Message message) {
		super(exceptionMessage);
		this.setCustomMessage(message);
	}
	public CourseException(String exceptionMessage, Throwable cause,Message message) {
		super(exceptionMessage,cause);
		this.setCustomMessage(message);
	}
	public CourseException(String exceptionMessage, Throwable cause,boolean enableSuppression, boolean writableStackTrace,Message message) {
		super(exceptionMessage,cause,enableSuppression, writableStackTrace);
		this.setCustomMessage(message);
	}
	public Message getCustomMessage() {
		return message;
	}
	
	private void setCustomMessage(Message message) {
		this.message = message;
	}
}
