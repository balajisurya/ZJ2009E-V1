package in.jdsoft.educationmanagement.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/timetable")
public class TimeTableController {

	@RequestMapping //list
	public ModelAndView displayUniversityTimeTablePage(){
		try {
			ModelAndView modelandview=new ModelAndView("timetablegenerator");
			return modelandview;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
	}
}
