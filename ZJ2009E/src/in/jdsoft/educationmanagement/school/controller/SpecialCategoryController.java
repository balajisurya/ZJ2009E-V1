package in.jdsoft.educationmanagement.school.controller;

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
import in.jdsoft.educationmanagement.model.Message;
import in.jdsoft.educationmanagement.school.exceptions.SpecialCategoryException;
import in.jdsoft.educationmanagement.school.model.Institution;
import in.jdsoft.educationmanagement.school.model.SpecialCategory;
import in.jdsoft.educationmanagement.school.services.InstitutionServices;
import in.jdsoft.educationmanagement.school.services.SpecialCategoryServices;

@Controller
@RequestMapping("/specialCategory")
public class SpecialCategoryController {
	
	@Autowired
	SpecialCategoryServices specialCategoryServices;
	@Autowired
	InstitutionServices institutionServices;
	@Autowired
	ExceptionComparator exceptionComparator;
	
	@RequestMapping 
	public ModelAndView displaySpecialCategoryPage(HttpServletRequest request){
		try {
			
			if(request.getSession().getAttribute("authenticated")!=null && request.getSession().getAttribute("authenticated").equals("true")){
				if(request.getSession().getAttribute("type").equals("Admin")){
					Integer institutionId=Integer.parseInt(request.getSession().getAttribute("instituteId").toString());
					ModelAndView modelandview=new ModelAndView("speCategory");
					modelandview.addObject("specialCategoryList",specialCategoryServices.getInstitutionSpecialCategoryList(institutionId));
					return modelandview;
				}
				else{
					ModelAndView modelandview=new ModelAndView("redirect:/home");
					return modelandview;
				}
			}
			else{
				return new ModelAndView("redirect:/");
			}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
	}
	
	@RequestMapping(value="add",method=RequestMethod.POST) 
	public String addNewSpecialCategory(HttpServletRequest request,RedirectAttributes redirectAttributes)throws Exception{
		try {
			    String specialCategoryName=request.getParameter("specialCategoryName");
			    Integer instituteId=Integer.parseInt(request.getSession().getAttribute("instituteId").toString());
			    Institution institution= institutionServices.getInstitutionById(instituteId);
			    SpecialCategory specialCategory=new SpecialCategory(specialCategoryName, institution);
				specialCategoryServices.addSpecialCategory(specialCategory);
				return "redirect:/specialCategory";
		 } catch (SpecialCategoryException e) 
		{
			
			if(e.getClass().equals(SpecialCategoryException.class)){
				SpecialCategoryException specialCategoryException=(SpecialCategoryException)e;
				redirectAttributes.addFlashAttribute("errorMessage", specialCategoryException.getCustomMessage());
				return "redirect:/specialCategory";
			}
			else{
				
				throw new Exception();
			}
		
	  }
    }
	
	@RequestMapping(value="editReterive",method=RequestMethod.GET)
	@ResponseBody
	public SpecialCategory editSpecialCategoryReterive(HttpServletRequest request){
		try {
			    Integer specialCategoryId=Integer.parseInt(request.getParameter("specialCategoryId"));
			    return specialCategoryServices.getSpecialCategoryById(specialCategoryId);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
	}
	
	@RequestMapping(value="editUpdate",method=RequestMethod.POST)
	public String editSpecialCategoryUpdate(HttpServletRequest request,HttpServletRequest response,RedirectAttributes redirectAttributes){
		try {
				Integer editSpecialCategoryId=Integer.parseInt(request.getParameter("updateSpecialCategoryId"));
				String editSpecialCategoryName=request.getParameter("editSpecialCategoryName");
				SpecialCategory specialCategory=specialCategoryServices.getSpecialCategoryById(editSpecialCategoryId);
				specialCategory.setSpecialCategoryName(editSpecialCategoryName);
				specialCategoryServices.updateSpecialCategory(specialCategory);
				return "redirect:/specialCategory";
		} catch (DataIntegrityViolationException e) {
			  if(e.getClass().equals(DataIntegrityViolationException.class)){
				  Throwable cause=e.getCause();
				  if(cause.getClass().equals(ConstraintViolationException.class))
				  {
					  String valid=exceptionComparator.containsWord(e.getMessage());
						if(valid!=null)
						{
							 redirectAttributes.addFlashAttribute("errorMessage",new Message("duplicate", "Already Exist Special Category Name"));
							 return "redirect:/specialCategory";
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
			  else
			  {
				  throw e;
			  }
}
	}
	
	@RequestMapping(value="delete",method=RequestMethod.POST)
	public String deleteSpecialCategory(HttpServletRequest request,RedirectAttributes redirectAttributes)throws Exception{
		try {
				Integer specialCategoryId=Integer.parseInt(request.getParameter("deleteSpecialCategoryId"));
				 specialCategoryServices.deleteSpecialCategory(specialCategoryId);
				 return "redirect:/specialCategory";
		}  catch (DataIntegrityViolationException e) {
			  if(e.getClass().equals(DataIntegrityViolationException.class)){
				  Throwable cause=e.getCause();
				  if(cause.getClass().equals(ConstraintViolationException.class))
				  {
							 redirectAttributes.addFlashAttribute("errorMessage",new Message("constraintViolation", "Special Category in use cannot be deleted"));
							 return "redirect:/specialCategory";
				   }
				  else
				  {
					 throw e;
				  }
				  
			  }
			  else
			  {
				  throw e;
			  }
}
		
	}
}
