package in.jdsoft.educationmanagement.components;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Component;

@Component
public class EmailHandler {

	@Autowired
	private MailSender mailSender;
	
	private static String mailTo;
	private static String mailFrom;
	private static String message;
	private static String projectPath;
	
	public EmailHandler() {
		
	}

	public MailSender getMailSender() {
		return mailSender;
	}

	public void setMailSender(MailSender mailSender) {
		this.mailSender = mailSender;
	}

	public String getMailTo() {
		return mailTo;
	}

	public void setMailTo(String mailTo) {
		EmailHandler.mailTo = mailTo;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		EmailHandler.message = message;
	}
	
	public String getMailFrom() {
		mailFrom="EDUMAAT";
		return mailFrom;
	}

	public void setMailFrom(String mailFrom) {
		EmailHandler.mailFrom = mailFrom;
	}
	
	public void sendEmail(String mailTo,String subject,String message){
		SimpleMailMessage msg=new SimpleMailMessage();
		msg.setTo(mailTo);
		msg.setFrom(mailFrom);
		msg.setText(message);
		msg.setSubject(subject);
		this.mailSender.send(msg);
	}
	
	public void sendEmail(String mailTo[],String subject,String message){
		SimpleMailMessage msg=new SimpleMailMessage();
		msg.setTo(mailTo);
		msg.setFrom(mailFrom);
		msg.setSubject(subject);
		msg.setText(message);
		this.mailSender.send(msg);
	}

	public String getProjectPath() {
		projectPath="http://123.63.174.115:8080/Edumaat_Test";
		return projectPath;
	}

	public void setProjectPath(String projectPath) {
		EmailHandler.projectPath = projectPath;
	}
}
