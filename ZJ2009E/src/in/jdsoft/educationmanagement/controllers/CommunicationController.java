package in.jdsoft.educationmanagement.controllers;

import java.sql.Timestamp;
import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import in.jdsoft.educationmanagement.model.CommunicationAndIssuesOrQueries;
import in.jdsoft.educationmanagement.services.CommunicationAndIssuesOrQueriesServices;

@Controller
@RequestMapping("/communication")
public class CommunicationController {

	@Autowired
	CommunicationAndIssuesOrQueriesServices communicationAndIssuesOrQueriesServices;
	
	@RequestMapping(method = RequestMethod.GET) 
	public ModelAndView displayCommunicationPage(){
		try {
			ModelAndView modelandview=new ModelAndView("communication");
			modelandview.addObject("communicationAndIssuesOrQueriesList", communicationAndIssuesOrQueriesServices.getCommunicationAndIssuesOrQueriesList());
			modelandview.addObject("communicationTargetGroupList", communicationAndIssuesOrQueriesServices.getCommunicationTargetGroupList());
			return modelandview;
		} catch (Exception e) {
			e.printStackTrace();
			throw null;
		}
		
	}
	
	
	@RequestMapping(value="addCommunicationMessage",method = RequestMethod.POST)
	public String addCommunicationMessage(HttpServletRequest request) throws Exception{
		try{
			String messageMode=request.getParameter("MessageMode");
			String communicationTargetGroupId=request.getParameter("communicationTargetGroupId");
			String typeOfMessage=request.getParameter("TypeOfMessage");
			String message=request.getParameter("message");
			String communicationCreatedByUser=request.getSession().getAttribute("username").toString();
			CommunicationAndIssuesOrQueries communicationAndIssuesOrQueries=new CommunicationAndIssuesOrQueries(messageMode, communicationTargetGroupId, typeOfMessage, message, communicationCreatedByUser, "", "", "", new Timestamp(Calendar.getInstance().getTime().getTime())); 
			communicationAndIssuesOrQueriesServices.addCommunicationAndIssuesOrQueries(communicationAndIssuesOrQueries);
			return "redirect:/communication";
		}catch(Exception e){
			e.printStackTrace();
			return "redirect:/communication";
		}
	}
	@RequestMapping(value="closeCommunicationMessage",method = RequestMethod.POST)
	public String closeCommunicationMessage(HttpServletRequest request) throws Exception{
	
	  try{
			return "redirect:/communication";
		}catch(Exception e)
		{
			return "redirect:/communication";
		}
	}
}
