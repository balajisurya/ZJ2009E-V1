package in.jdsoft.educationmanagement.controllers;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

import in.jdsoft.educationmanagement.model.AcademicSemesterSystem;
import in.jdsoft.educationmanagement.model.AcademicSemesterSystemSubset;
import in.jdsoft.educationmanagement.model.AcademicSemesterSystemSubsetStatus;
import in.jdsoft.educationmanagement.model.AcademicYear;
import in.jdsoft.educationmanagement.model.AcademicYearStatus;
import in.jdsoft.educationmanagement.model.Institution;
import in.jdsoft.educationmanagement.model.SemesterSystem;
import in.jdsoft.educationmanagement.model.SemesterSystemSubset;
import in.jdsoft.educationmanagement.services.AcademicYearServices;
import in.jdsoft.educationmanagement.services.InstitutionServices;
import in.jdsoft.educationmanagement.services.SemesterSystemServices;

@Controller
@RequestMapping("/academic")
public class AcademicController {

	 @Autowired
	 AcademicYearServices academicYearServices;
	 @Autowired
	 SemesterSystemServices semesterSystemServices;
	 @Autowired
	 InstitutionServices institutionServices;
	
	@RequestMapping(value="academicyear")
	public ModelAndView displayAcademicYearPage(HttpServletRequest request){
	     try {
	    	 ModelAndView modelandview=new ModelAndView("academicyear");
	 		modelandview.addObject("semesterSystemList",semesterSystemServices.getSemesterSystemList());
	 		modelandview.addObject("currentAcademicYear",academicYearServices.getCurrentAcademicYear());
	 		modelandview.addObject("academicYearList",academicYearServices.getAcademicYearsList());
	 		return modelandview;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
		
	}
	
	@RequestMapping(value="academicyear/add",method = RequestMethod.POST)
	public String addAcademicYear(HttpServletRequest request) throws Exception{//2
		  
		try {
			
			Set<AcademicYear> academicYears = academicYearServices.getAcademicYearStatusById(2).getAcademicYears();
			if(academicYears.isEmpty()){
				DateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
				String academicYearTitle=request.getParameter("academicYearName");
				String academicStartAndEndDate=request.getParameter("academicYearStartEndDate");
				String split[]= academicStartAndEndDate.split("-");
				Date academicYearStartDate=formatter.parse(split[0]);
				Date academicYearEndDate=formatter.parse(split[1]);
				Integer academicYearWorkingDays=Integer.parseInt(request.getParameter("academicYearWorkingDays"));
				AcademicYearStatus academicYearStatus=academicYearServices.getAcademicYearStatusById(2);
				String academicYearLastModifiedBy=request.getSession().getAttribute("username").toString();
				String academicYearCreatedBy=request.getSession().getAttribute("username").toString();
				String semesterSystemIds[]=request.getParameterValues("semesterSystems");
				Institution institution=institutionServices.getInstitutionById(Integer.parseInt(request.getSession().getAttribute("instituteId").toString()));
				AcademicYear academicYear=new AcademicYear(academicYearTitle, academicYearStartDate, academicYearEndDate, academicYearWorkingDays, academicYearStatus, academicYearLastModifiedBy, academicYearCreatedBy,institution);
				AcademicSemesterSystemSubsetStatus academicSemesterSystemStatusOpened=academicYearServices.getAcademicSemesterSystemSubsetStatusById(1);
				AcademicSemesterSystemSubsetStatus academicSemesterSystemStatusClosed=academicYearServices.getAcademicSemesterSystemSubsetStatusById(1);
				for(String semesterSystemId:semesterSystemIds){
					AcademicSemesterSystem academicSemesterSystem=new AcademicSemesterSystem(academicYear,semesterSystemServices.getSemesterSystemById(Integer.parseInt(semesterSystemId)));
					for(SemesterSystemSubset semesterSystemSubset:semesterSystemServices.getSemesterSystemById(Integer.parseInt(semesterSystemId)).getSemesterSystemSubsets()){
						if(semesterSystemSubset.getSemSystemSubsetId()==3||semesterSystemSubset.getSemSystemSubsetId()==5){
							AcademicSemesterSystemSubset academicSemesterSystemSubset=new AcademicSemesterSystemSubset(academicSemesterSystem, semesterSystemSubset,academicSemesterSystemStatusOpened);
							academicSemesterSystem.getAcademicSemesterSystemSubsets().add(academicSemesterSystemSubset);
						}
						else{
							AcademicSemesterSystemSubset academicSemesterSystemSubset=new AcademicSemesterSystemSubset(academicSemesterSystem, semesterSystemSubset,academicSemesterSystemStatusClosed);
							academicSemesterSystem.getAcademicSemesterSystemSubsets().add(academicSemesterSystemSubset);
						}
					}
					academicYear.getAcademicSemesterSystems().add(academicSemesterSystem);
				  }
				academicYearServices.addAcademicYear(academicYear);
			   return "redirect:/academic/academicyear";
			}else{
				throw new Exception("Already Academic Year is Active ! Close current academic year");
			}
		} catch (Exception e) {
			e.printStackTrace();
			return "redirect:/academic/academicyear";
		}
	}
	
	@RequestMapping(value="academicyear/close",method = RequestMethod.POST)
	@ResponseStatus(value=HttpStatus.OK)
	public void closeCurrentAcademicYear(HttpServletRequest request) throws Exception{
		try {
			  AcademicYear academicYear=academicYearServices.getAcademicYearById(Integer.parseInt(request.getParameter("academicYearId")));
			  AcademicYearStatus academicYearStatus=academicYearServices.getAcademicYearStatusById(1);
			  academicYear.setAcademicYearStatus(academicYearStatus);
			  academicYearServices.updateAcademicYear(academicYear);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@RequestMapping(value="semesterSystem/add",method = RequestMethod.POST)
	public String addSemesterSystem(HttpServletRequest request){
		try {
		      String semSystemTitle=request.getParameter("semesterSystemTitle");
			  Integer semestersPerYear=Integer.parseInt(request.getParameter("semesterPerYear"));
			  Integer semesterSystemStatus=Integer.parseInt(request.getParameter("semesterSystemStatus"));
			  String subset="subset";
			  SemesterSystem semesterSystem=new SemesterSystem(semSystemTitle, semestersPerYear, semesterSystemStatus);
			  for(int i=1;i<=semestersPerYear;i++){
				  String semesterSystemSubsetValue=request.getParameter(subset.concat(Integer.toString(i)));
				  SemesterSystemSubset semesterSystemSubset=new SemesterSystemSubset(semesterSystem,semesterSystemSubsetValue);
				  semesterSystem.getSemesterSystemSubsets().add(semesterSystemSubset);
			  }
		      academicYearServices.addSemesterSystem(semesterSystem);
             return "redirect:/academic/academicyear";
		} catch (Exception e) {
			e.printStackTrace();
			 return "redirect:/academic/academicyear";
		}
	}
	
	@RequestMapping(value="semesterSystem/getSubsetBySemesterSystem",method = RequestMethod.GET)
	@ResponseBody
	public Set<SemesterSystemSubset> getSemesterSystemSubSet(HttpServletRequest request){
		 try {
			 Integer semesterSystemId=Integer.parseInt(request.getParameter("semesterSystemId"));
			  return semesterSystemServices.getSemesterSystemSubsetBySemesterSystemId(semesterSystemId);
			} catch (Exception e) {
				e.printStackTrace();
				return null;
			}
		
	}
	
	@RequestMapping(value="academicdashboard",method = RequestMethod.GET)
	public ModelAndView displayInstitution(HttpServletRequest request){
		 try {
			 ModelAndView modelandview=new ModelAndView("academicdashboard");
				return modelandview;
			} catch (Exception e) {
				e.printStackTrace();
				return null;
			}
		
		
	}
}
