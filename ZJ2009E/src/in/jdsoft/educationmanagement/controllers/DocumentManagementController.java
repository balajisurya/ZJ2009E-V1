package in.jdsoft.educationmanagement.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/documentmanagement")
public class DocumentManagementController {

	@RequestMapping(value="indexentry",method = RequestMethod.GET) 
	public ModelAndView displayIndexEntryPage(HttpServletRequest request){
		try {
			ModelAndView modelandview=new ModelAndView("indexentry");
			return modelandview;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
	}
	
	@RequestMapping(value="digitalization",method = RequestMethod.GET) 
	public ModelAndView displayDigitalizationPage(HttpServletRequest request){
		try {
			ModelAndView modelandview=new ModelAndView("digitalization");
			return modelandview;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
	}
	
	@RequestMapping(value="searchentry",method = RequestMethod.GET)
	public ModelAndView displaySearchEntryPage(HttpServletRequest request){
		try {
			ModelAndView modelandview=new ModelAndView("searchentry");
			return modelandview;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
	}
	
}
