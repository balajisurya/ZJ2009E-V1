package in.jdsoft.educationmanagement.model;

import org.apache.commons.lang.WordUtils;

public class Message {

	
	public Message(String status,String message) {
		this.status=status;
		this.message=WordUtils.capitalize(message);
	}
	
	
	private String status;
	private String message;
	
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message =WordUtils.capitalize(message);
	}
    
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
