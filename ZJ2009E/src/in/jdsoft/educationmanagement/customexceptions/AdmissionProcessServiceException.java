package in.jdsoft.educationmanagement.customexceptions;

public class AdmissionProcessServiceException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public AdmissionProcessServiceException() {
		super();
	}
	
	public AdmissionProcessServiceException(Exception e) {
		super();
	}
	
	public AdmissionProcessServiceException(String exceptionMessage){
		super(exceptionMessage);
	}
	
	public AdmissionProcessServiceException(String exceptionMessage, Throwable cause){
		super(exceptionMessage, cause);
	}
	public AdmissionProcessServiceException(String exceptionMessage, Throwable cause,boolean enableSuppression, boolean writableStackTrace){
		super(exceptionMessage,cause, enableSuppression,writableStackTrace);
	}
	

}
