package in.jdsoft.educationmanagement.school.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import in.jdsoft.educationmanagement.components.ExceptionComparator;
import in.jdsoft.educationmanagement.school.exceptions.AcademicYearException;
import in.jdsoft.educationmanagement.school.model.AcademicYear;
import in.jdsoft.educationmanagement.school.model.AcademicYearFeesTerm;
import in.jdsoft.educationmanagement.school.model.Institution;
import in.jdsoft.educationmanagement.school.model.Message;
import in.jdsoft.educationmanagement.school.services.AcademicYearServices;
import in.jdsoft.educationmanagement.school.services.InstitutionServices;

@Controller
@RequestMapping("/academicYear")
public class AcademicYearController {
	
	@Autowired
	AcademicYearServices academicYearServices;
	
	@Autowired
	ExceptionComparator exceptionComparator;
	@Autowired
	InstitutionServices institutionServices;
	@RequestMapping 
	public ModelAndView displayAcademicYearPage(HttpServletRequest request){
		try {
			Integer institutionId=Integer.parseInt(request.getSession().getAttribute("instituteId").toString());
			ModelAndView modelandview=new ModelAndView("schoolAcademicYear");
			modelandview.addObject("academicYearList",academicYearServices.getInstitutionAcademicYearList(institutionId));
			modelandview.addObject("feesTermList",institutionServices.getInstitutionFeesTerms(institutionId));
			return modelandview;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		
	}
	
	@RequestMapping(value="add",method=RequestMethod.POST) 
	public String addAcademicYear(HttpServletRequest request,RedirectAttributes redirectAttributes) throws Exception{
		try {
			    String academicYearTitle=request.getParameter("academicYearTitle");
			    Integer academicYearStatus=Integer.parseInt(request.getParameter("academicYearStatus"));
			    String feesTermIds[]=request.getParameterValues("feesTermsList");
			    Integer instituteId=Integer.parseInt(request.getSession().getAttribute("instituteId").toString());
			    Institution institution= institutionServices.getInstitutionById(instituteId);
			    AcademicYear academicYear=new AcademicYear(academicYearTitle, academicYearStatus, institution);
			    Integer []feesTermIds1=new Integer[feesTermIds.length];
			    int count=0;
			    for (String feesTermId : feesTermIds) {
			    	feesTermIds1[count++]=Integer.parseInt(feesTermId);
				}
				academicYearServices.addAcademicYear(academicYear,feesTermIds1);
				return "redirect:/academicYear";
		  } 
		catch (Exception e) 
		{
			
			if(e.getClass().equals(AcademicYearException.class)){
				AcademicYearException academicYearException=(AcademicYearException)e;
				redirectAttributes.addFlashAttribute("errorMessage", academicYearException.getCustomMessage());
				return "redirect:/academicYear";
			}
			else{
				throw e;
			}
		
	  }
    }
	
	@RequestMapping(value="editReterive",method=RequestMethod.GET)
	@ResponseBody
	public AcademicYear editAcademicYearReterive(HttpServletRequest request){
		try {
			    Integer academicYearId=Integer.parseInt(request.getParameter("academicYearId"));
			    return academicYearServices.getAcademicYearById(academicYearId);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		
	}
	
	@RequestMapping(value="editUpdate",method=RequestMethod.POST)
	public String editAcademicYearUpdate(HttpServletRequest request,HttpServletRequest response,RedirectAttributes redirectAttributes) throws Exception{
		try {
				Integer academicYearId=Integer.parseInt(request.getParameter("updateAcademicYearId"));
				String editAcademicYearTitle=request.getParameter("editAcademicYearTitle");
				Integer editAcademicYearStatus=Integer.parseInt(request.getParameter("editAcademicYearStatus"));
				AcademicYear academicYear= academicYearServices.getAcademicYearById(academicYearId);
				academicYear.setAcademicYearTitle(editAcademicYearTitle);
				academicYear.setAcademicYearStatus(editAcademicYearStatus);
			    academicYearServices.updateAcademicYear(academicYear);
				return "redirect:/academicYear";
		} 	catch (Exception e) {
			  if(e.getClass().equals(DataIntegrityViolationException.class))
			  {
				  Throwable cause=e.getCause();
				  if(cause.getClass().equals(ConstraintViolationException.class))
				  {
					  String valid=exceptionComparator.containsWord(e.getMessage());
						if(valid!=null)
						{
							 redirectAttributes.addFlashAttribute("errorMessage",new Message("duplicate", "Already Exist Academic Year Title"));
								return "redirect:/academicYear";
						}else
						{
							 throw e;
						}
					  }
				  else
				  {
					 throw e;
				  }
				  
			  }
			  else if(e.getClass().equals(AcademicYearException.class)){
					AcademicYearException academicYearException=(AcademicYearException)e;
					redirectAttributes.addFlashAttribute("errorMessage", academicYearException.getCustomMessage());
					return "redirect:/academicYear";
				}
			  else
			  {
				  throw e;
			  }
	}
		
	}
	
	@RequestMapping(value="academicFeesTermsByacademicYear",method=RequestMethod.GET)
	@ResponseBody
	public ArrayList<AcademicYearFeesTerm> getAcademicYearFeesTerms(HttpServletRequest request){
		try {
			 Integer academicYearId=Integer.parseInt(request.getParameter("academicYearId"));
			 return academicYearServices.getAcademicYearFeesTermsByAcademicYear(academicYearId);
		} catch (Exception e) {
			throw e;
		}
	}

	@RequestMapping(value="delete",method=RequestMethod.POST)
	public String deleteAcademicYear(HttpServletRequest request,RedirectAttributes redirectAttributes) throws Exception{
				Integer academicYearId=Integer.parseInt(request.getParameter("deleteAcademicYearId"));
				try {
					academicYearServices.deleteAcademicYear(academicYearId);
					return "redirect:/academicYear";
				} 
				catch (Exception e) 
				{
					if(e.getClass().equals(AcademicYearException.class))
					{
						AcademicYearException customException=(AcademicYearException)e;
						redirectAttributes.addFlashAttribute("errorMessage",customException.getCustomMessage());
						return "redirect:/academicYear";
					}
					else if(e.getClass().equals(DataIntegrityViolationException.class))
					  {
						  Throwable cause=e.getCause();
						  if(cause.getClass().equals(ConstraintViolationException.class))
						  {
									 redirectAttributes.addFlashAttribute("errorMessage",new Message("constraintViolation","Academic Year in use cannot be deleted"));
										return "redirect:/academicYear";
						 }
						  else
						  {
							 throw e;
						  }
						  
					  }
					else{
						e.printStackTrace();
						throw e;
					}
					
				}
	}
	
}
