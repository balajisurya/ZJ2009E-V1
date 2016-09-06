package in.jdsoft.educationmanagement.school.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import in.jdsoft.educationmanagement.school.model.Student;
import in.jdsoft.educationmanagement.school.services.AcademicYearServices;
import in.jdsoft.educationmanagement.school.services.DashboardServices;
import in.jdsoft.educationmanagement.school.services.InstitutionServices;
import in.jdsoft.educationmanagement.school.services.InvoiceServices;
import in.jdsoft.educationmanagement.school.services.ReceiptServices;

@Controller
@RequestMapping("/report")
public class ReportController {
	
	@Autowired
	InvoiceServices invoiceServices;
	@Autowired
	InstitutionServices institutionServices;
	@Autowired
	DashboardServices dashboardservices;
	@Autowired
	ReceiptServices receiptServices;
	@Autowired
	AcademicYearServices academicYearServices;
	

	

	
	

	@RequestMapping(value="/finecollections")	
	public ModelAndView getPaidFees(HttpServletRequest request){
		try {
			if(request.getSession().getAttribute("authenticated")!=null && request.getSession().getAttribute("authenticated").equals("true")){
				ModelAndView mv=new ModelAndView("collectionsReport");
				Integer instituteId=Integer.parseInt(request.getSession().getAttribute("instituteId").toString());
				mv.addObject("fineReceipts", receiptServices.institutionFineReceipts(instituteId));
				return mv;
			}
			else{
				return new ModelAndView("redirect:/");
			}
			
		} catch (Exception e) {
			throw e;
		}
		
	}
	
	
	@RequestMapping(value="termFeesReport")
	public ModelAndView displayTermFeesReportPage(HttpServletRequest request){
		try {
			if(request.getSession().getAttribute("authenticated")!=null && request.getSession().getAttribute("authenticated").equals("true")){
				Integer instituteId=Integer.parseInt(request.getSession().getAttribute("instituteId").toString());
				ModelAndView mv=new ModelAndView("termfeesreport");
				mv.addObject("academicYears",academicYearServices.getInstitutionAcademicYearList(instituteId));
				return mv;
			}
			else{
				return new ModelAndView("redirect:/");
			}
		} catch (Exception e) {
			throw e;
		}
	}
	
	@RequestMapping(value="termFeesReport/students")
	@ResponseBody
	public ArrayList<Student> getPendingTermFeesStudentList(HttpServletRequest request){
		try {
			 Integer academicYearId= Integer.parseInt(request.getParameter("academicYear"));
			 Integer academicYearfeesTermId=Integer.parseInt(request.getParameter("feesTermId"));
			 return  invoiceServices.getPendingFeesTermStudentList(academicYearId, academicYearfeesTermId);
		} catch (Exception e) {
			throw e;
		}
	}
	
	
	
}
