package in.jdsoft.educationmanagement.school.controller;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

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
import in.jdsoft.educationmanagement.school.exceptions.ClassAndSectionException;
import in.jdsoft.educationmanagement.school.model.Class;
import in.jdsoft.educationmanagement.school.model.Institution;
import in.jdsoft.educationmanagement.school.model.Section;
import in.jdsoft.educationmanagement.school.services.ClassAndSectionServices;
import in.jdsoft.educationmanagement.school.services.InstitutionServices;

@Controller
@RequestMapping("/class")
public class ClassAndSectionController {
	
	@Autowired
	InstitutionServices institutionService;
	@Autowired
	ClassAndSectionServices classAndSectionServices;
	@Autowired
	ExceptionComparator exceptionComparator;
	
	@RequestMapping 
	public ModelAndView displayClassAndSectionPage(HttpServletRequest request){
		try {
			 Integer institutionId=Integer.parseInt(request.getSession().getAttribute("instituteId").toString());
			ModelAndView modelandview=new ModelAndView("classAndSection");
			modelandview.addObject("sectionList",classAndSectionServices.getInstitutionSectionList(institutionId));
			modelandview.addObject("classList",classAndSectionServices.getInstitutionClassList(institutionId));
			return modelandview;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		
	}
	
	@RequestMapping(value="section/add",method=RequestMethod.POST) 
	public String addNewSection(HttpServletRequest request,RedirectAttributes redirectAttributes)throws Exception{
		try {
			    String sectionName=request.getParameter("sectionName");
				Integer instituteId=Integer.parseInt(request.getSession().getAttribute("instituteId").toString());
				Institution institution= institutionService.getInstitutionById(instituteId);
				Section section=new Section(sectionName, institution);
				classAndSectionServices.createNewSection(section);
				return "redirect:/class";
		} catch (ClassAndSectionException e) 
		{
			
			if(e.getClass().equals(ClassAndSectionException.class)){
				ClassAndSectionException classAndSectionException=(ClassAndSectionException)e;
				redirectAttributes.addFlashAttribute("errorMessage", classAndSectionException.getCustomMessage());
				return "redirect:/class";
			}
			else{
				
				throw new Exception();
			}
		}
    }
	
	@RequestMapping(value="section/editReterive",method=RequestMethod.GET)
	@ResponseBody
	public Section editSectionReterive(HttpServletRequest request){
		try {
			    Integer sectionId=Integer.parseInt(request.getParameter("sectionId"));
				return classAndSectionServices.getSectionById(sectionId);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		
	}
	
	@RequestMapping(value="section/editUpdate",method=RequestMethod.POST)
	public String editSectionUpdate(HttpServletRequest request,HttpServletRequest response,RedirectAttributes redirectAttributes) throws Exception{
		try {
				Integer editSectionId=Integer.parseInt(request.getParameter("updateSectionId"));
				String editSectionName=request.getParameter("editSectionName");
				Section section= classAndSectionServices.getSectionById(editSectionId);
				section.setSectionName(editSectionName);
				classAndSectionServices.updateSection(section);
				return "redirect:/class";
		}catch (DataIntegrityViolationException e) {
			  if(e.getClass().equals(DataIntegrityViolationException.class)){
				  Throwable cause=e.getCause();
				  if(cause.getClass().equals(ConstraintViolationException.class))
				  {
					  String valid=exceptionComparator.containsWord(e.getMessage());
						if(valid!=null)
						{
							 redirectAttributes.addFlashAttribute("errorMessage",new Message("duplicate", "Already Exist Section Name"));
							 return "redirect:/class";
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
	
	@RequestMapping(value="section/delete",method=RequestMethod.POST)
	public String deleteSection(HttpServletRequest request,RedirectAttributes redirectAttributes)throws Exception{
			  try {
				  	Integer sectionId=Integer.parseInt(request.getParameter("deleteSectionId"));
					classAndSectionServices.deleteSection(sectionId);
					return "redirect:/class";
			  }catch (DataIntegrityViolationException e) {
				  if(e.getClass().equals(DataIntegrityViolationException.class)){
					  Throwable cause=e.getCause();
					  if(cause.getClass().equals(ConstraintViolationException.class)){
						 redirectAttributes.addFlashAttribute("errorMessage",new Message("constraintViolation","Section in use cannot be deleted"));
						 return "redirect:/class";
					   }
					  else{
						 throw e;
					  }
					  
				  }
				  else{
					  e.printStackTrace();
					  throw e;
				  }
			  }
	}
	
	
	
	@RequestMapping(value="add",method=RequestMethod.POST)
	public String addNewClass(HttpServletRequest request,RedirectAttributes redirectAttributes)throws Exception{
		try {
			    String className=request.getParameter("className");
			    String []sectionIds=request.getParameterValues("sections");
			    Set<Section> classSections=new HashSet<Section>(0);
			    for(String sectionId:sectionIds){
			    	classSections.add(classAndSectionServices.getSectionById(Integer.parseInt(sectionId)));
			    }
				Integer instituteId=Integer.parseInt(request.getSession().getAttribute("instituteId").toString());
				Institution institution= institutionService.getInstitutionById(instituteId);
				Class newClass=new Class(className, institution);
				classAndSectionServices.createNewClass(newClass, classSections);
				return "redirect:/class";
		} catch (ClassAndSectionException e) 
		{
	
			if(e.getClass().equals(ClassAndSectionException.class)){
				ClassAndSectionException classAndSectionException=(ClassAndSectionException)e;
				redirectAttributes.addFlashAttribute("errorMessage", classAndSectionException.getCustomMessage());
				return "redirect:/class";
			}
			else
			{
				throw new Exception();
			}
		}
    }
	
	@RequestMapping(value="delete",method=RequestMethod.POST)
	public String deleteClass(HttpServletRequest request,RedirectAttributes redirectAttributes){
		try {
				Integer classId=Integer.parseInt(request.getParameter("deleteClassId"));
				classAndSectionServices.deleteClass(classId);
				return "redirect:/class";
		} catch (DataIntegrityViolationException e) {
			  if(e.getClass().equals(DataIntegrityViolationException.class)){
				  Throwable cause=e.getCause();
				  if(cause.getClass().equals(ConstraintViolationException.class)){
					 redirectAttributes.addFlashAttribute("errorMessage",new Message("constraintViolation","Class in use cannot be deleted"));
					 return "redirect:/class";
				   }
				  else{
					 throw e;
				  }
				  
			  }
			  else{
				  e.printStackTrace();
				  throw e;
			  }
}
		
	}
	@RequestMapping(value="editRetreive",method=RequestMethod.GET)
	@ResponseBody
	public Class editClassReterive(HttpServletRequest request){
		try {
			    Integer classId=Integer.parseInt(request.getParameter("classId"));
				return classAndSectionServices.getClassLazyById(classId);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		
	}
	
	@RequestMapping(value="editUpdate",method=RequestMethod.POST)
	public String editClassUpdate(HttpServletRequest request,RedirectAttributes redirectAttributes) throws Exception{
		try {
			 	Integer classId=Integer.parseInt(request.getParameter("updateClassId"));
			    String className=request.getParameter("editClassName");
			    String []sectionIds=request.getParameterValues("editSections");
			    Set<Section> classSections=new HashSet<Section>(0);
			    for(String sectionId:sectionIds){
			    	classSections.add(classAndSectionServices.getSectionById(Integer.parseInt(sectionId)));
			    }
				Integer instituteId=Integer.parseInt(request.getSession().getAttribute("instituteId").toString());
				Institution institution= institutionService.getInstitutionById(instituteId);
				Class newClass=classAndSectionServices.getClassById(classId);
				newClass.setClassName(className);
				newClass.setInstitution(institution);
				newClass.setSections(classSections);
				classAndSectionServices.updateNewClass(newClass);
				return "redirect:/class";
		} catch (DataIntegrityViolationException e) {
			  if(e.getClass().equals(DataIntegrityViolationException.class)){
				  Throwable cause=e.getCause();
				  if(cause.getClass().equals(ConstraintViolationException.class))
				  {
					  String valid=exceptionComparator.containsWord(e.getMessage());
						if(valid!=null)
						{
							 redirectAttributes.addFlashAttribute("errorMessage",new Message("duplicate", "Already Exist Class Name"));
							 return "redirect:/class";
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
	
	@RequestMapping(value="sectionsOfClass",method=RequestMethod.GET)
	@ResponseBody
	public ArrayList<Section> getSectionOfClass(HttpServletRequest request) throws Exception{
		try {
			 Integer classId=Integer.parseInt(request.getParameter("classId")) ;
			 return classAndSectionServices.getSectionsOfClass(classId);
		} catch (Exception e) {
			throw e;
		}
	}
}
