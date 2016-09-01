package in.jdsoft.educationmanagement.customexceptions;

public class UserServiceExceptions extends RuntimeException{
	private static final long serialVersionUID = 1L;
	public UserServiceExceptions() {
		super();
	}
	
	public UserServiceExceptions(Exception e) {
		super();
	}
	public UserServiceExceptions(String exceptionMessage){
		super(exceptionMessage);
	}
	
	public UserServiceExceptions(String exceptionMessage, Throwable cause){
		super(exceptionMessage, cause);
	}
	public UserServiceExceptions(String exceptionMessage, Throwable cause,boolean enableSuppression, boolean writableStackTrace){
		super(exceptionMessage,cause, enableSuppression,writableStackTrace);
	}
}
