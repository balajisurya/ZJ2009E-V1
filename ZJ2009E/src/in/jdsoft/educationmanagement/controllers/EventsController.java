package in.jdsoft.educationmanagement.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/events")
public class EventsController {

	@RequestMapping(method = RequestMethod.GET) //list
	public ModelAndView displayEventPage(){
		try {
			ModelAndView modelandview=new ModelAndView("events");
			return modelandview;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
	}
}
