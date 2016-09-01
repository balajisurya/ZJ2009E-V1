package in.jdsoft.educationmanagement.school.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class ExceptionController {

	@RequestMapping("/error")
	public String errorPage(){
		return "error";
	}
	
	@ExceptionHandler(Exception.class)
	public ModelAndView exceptionHandler(HttpServletRequest request, Exception ex){
		  ModelAndView mv=new ModelAndView("error");
		  ex.printStackTrace();
		  mv.addObject("url", request.getContextPath());
		  return mv;
	}
}
