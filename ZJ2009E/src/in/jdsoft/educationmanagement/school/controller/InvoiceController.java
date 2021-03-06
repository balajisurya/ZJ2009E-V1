package in.jdsoft.educationmanagement.school.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import in.jdsoft.educationmanagement.components.NumberToEnglishWords;
import in.jdsoft.educationmanagement.school.exceptions.AcademicYearException;
import in.jdsoft.educationmanagement.school.exceptions.StudentException;
import in.jdsoft.educationmanagement.school.exceptions.StudentInvoiceException;
import in.jdsoft.educationmanagement.school.model.AcademicYear;
import in.jdsoft.educationmanagement.school.model.Class;
import in.jdsoft.educationmanagement.school.model.FeesTermAndFeesStructure;
import in.jdsoft.educationmanagement.school.model.Message;
import in.jdsoft.educationmanagement.school.model.Section;
import in.jdsoft.educationmanagement.school.model.SpecialCategory;
import in.jdsoft.educationmanagement.school.model.Student;
import in.jdsoft.educationmanagement.school.model.StudentInvoice;
import in.jdsoft.educationmanagement.school.model.StudentInvoiceDetail;
import in.jdsoft.educationmanagement.school.services.AcademicYearServices;
import in.jdsoft.educationmanagement.school.services.ClassAndSectionServices;
import in.jdsoft.educationmanagement.school.services.FeesStructureServices;
import in.jdsoft.educationmanagement.school.services.InstitutionServices;
import in.jdsoft.educationmanagement.school.services.InvoiceServices;
import in.jdsoft.educationmanagement.school.services.SpecialCategoryServices;
import in.jdsoft.educationmanagement.school.services.StudentServices;

@Controller
@RequestMapping("/invoice")
public class InvoiceController {


	@Autowired
	ClassAndSectionServices classAndSectionServices;
	@Autowired
	StudentServices studentServices;
	@Autowired
	InvoiceServices invoiceServices;
	@Autowired
	SpecialCategoryServices specialCategoryServices;
	@Autowired
	FeesStructureServices feesStructureServices;
	
	@Autowired
	InstitutionServices institutionServices;
	@Autowired
	AcademicYearServices academicYearServices;
    
	@Autowired
	NumberToEnglishWords numberConverter;
	
	@RequestMapping 
	public ModelAndView displayGenerateInvoicePage(HttpServletRequest request,RedirectAttributes attributes) throws Exception{
		try {
			if(request.getSession().getAttribute("authenticated")!=null && request.getSession().getAttribute("authenticated").equals("true")){
				Integer instituteId=Integer.parseInt(request.getSession().getAttribute("instituteId").toString());
				ModelAndView modelandview=new ModelAndView("generateinvoice");
				modelandview.addObject("classes", classAndSectionServices.getInstitutionClassList(instituteId));
				modelandview.addObject("specialCategories",specialCategoryServices.getInstitutionSpecialCategoryList(instituteId));
				modelandview.addObject("feesTemplates",feesStructureServices.getInstitutionFeesTemplate(instituteId));
				modelandview.addObject("academicFeesTerms",institutionServices.getCurrentAcademicYearFeesTerms(instituteId));
				return modelandview;
			}
			else{
				return new ModelAndView("redirect:/");
			}
		} catch (Exception e) {
			if(e.getClass().equals(AcademicYearException.class)){
				ModelAndView modelandview=new ModelAndView("redirect:/academicYear");
				AcademicYearException ex=(AcademicYearException)e;
				attributes.addFlashAttribute("errorMessage", ex.getCustomMessage());
				return modelandview;
			}
			else{
				throw e;
			}
		}
	}
	
	@RequestMapping(value="allStudent",method=RequestMethod.GET)
	@ResponseBody
	public ArrayList<Student> getAllStudentListForInvoice(HttpServletRequest request,RedirectAttributes redirectAttributes) throws Exception{
		try {
			ArrayList<Student> students=new ArrayList<Student>();
			String classNameOrId=request.getParameter("class");
			
			String admissionNo=null;
			if(!request.getParameter("admissionNo").isEmpty()){
				admissionNo=request.getParameter("admissionNo");
				students.add(studentServices.getActiveStudentByAdmissionNo(admissionNo));
				return students;
			}
			else{
				if(classNameOrId.equals("all")){
					String criteria=request.getParameter("criteria");
					if(criteria.equals("all")){
						return studentServices.getActiveStudentsFromAllClass(Integer.parseInt(request.getSession().getAttribute("instituteId").toString()));
					}
					else if(criteria.equals("specialcategory")){
						Integer specialCategoryId=null;
						SpecialCategory specialCategory=null;
						if(request.getParameter("specialCategoryId")!=null){
							specialCategoryId=Integer.parseInt(request.getParameter("specialCategoryId"));
							specialCategory=specialCategoryServices.getSpecialCategoryById(specialCategoryId);
							return studentServices.getActiveStudentsFromAllClassBySpecialCategory(Integer.parseInt(request.getSession().getAttribute("instituteId").toString()),specialCategory);
						}
						else{
							return null;
						}
					}
					else{
						return null;
					}
				}else{
					Integer classId=Integer.parseInt(classNameOrId);
					Class clazz=classAndSectionServices.getClassById(classId);
					Integer sectionId=Integer.parseInt(request.getParameter("section"));
					Section section=classAndSectionServices.getSectionById(sectionId);
					String criteria=request.getParameter("criteria");
					if(criteria.equals("all")){
						return studentServices.getActiveStudentFromClassAndSection(clazz, section);
					}
					else if(criteria.equals("specialcategory")){
						Integer specialCategoryId=null;
						SpecialCategory specialCategory=null;
						if(request.getParameter("specialCategoryId")!=null){
							specialCategoryId=Integer.parseInt(request.getParameter("specialCategoryId"));
							specialCategory=specialCategoryServices.getSpecialCategoryById(specialCategoryId);
						}
						return studentServices.getActiveStudentFromClassAndSectionBySpecialCategory(clazz, section, specialCategory);
					}
					else{
						return students;
					}
				}
			}
		} 
		catch (Exception e) 
		{
			if(e.getClass().equals(StudentException.class))
			{
				StudentException studentException=(StudentException)e;
				redirectAttributes.addFlashAttribute("errorMessage", studentException.getCustomMessage());
				return null;
			}
			else
			{
				throw e;
			}
		}
	}
	@RequestMapping(value="students",method=RequestMethod.GET)
	@ResponseBody
	public ArrayList<Student> getStudentListForInvoice(HttpServletRequest request,RedirectAttributes redirectAttributes) throws Exception{
		try {
			ArrayList<Student> students=new ArrayList<Student>();
			String classNameOrId=request.getParameter("class");
			
			String admissionNo=null;
			if(!request.getParameter("admissionNo").isEmpty()){
				admissionNo=request.getParameter("admissionNo");
				students.add(studentServices.getActiveStudentByAdmissionNoWithoutInvoices(admissionNo));
				return students;
			}
			else{
				if(classNameOrId.equals("all")){
					String criteria=request.getParameter("criteria");
					if(criteria.equals("all")){
						return studentServices.getActiveStudentsFromAllClassWithoutInvoices(Integer.parseInt(request.getSession().getAttribute("instituteId").toString()));
					}
					else if(criteria.equals("specialcategory")){
						Integer specialCategoryId=null;
						SpecialCategory specialCategory=null;
						if(request.getParameter("specialCategoryId")!=null){
							specialCategoryId=Integer.parseInt(request.getParameter("specialCategoryId"));
							specialCategory=specialCategoryServices.getSpecialCategoryById(specialCategoryId);
							return studentServices.getActiveStudentsFromAllClassBySpecialCategoryWithoutInvoices(Integer.parseInt(request.getSession().getAttribute("instituteId").toString()),specialCategory);
						}
						else{
							return null;
						}
					}
					else{
						return null;
					}
				}else{
					Integer classId=Integer.parseInt(classNameOrId);
					Class clazz=classAndSectionServices.getClassById(classId);
					Integer sectionId=Integer.parseInt(request.getParameter("section"));
					Section section=classAndSectionServices.getSectionById(sectionId);
					String criteria=request.getParameter("criteria");
					if(criteria.equals("all")){
						return studentServices.getActiveStudentFromClassAndSectionWithoutInvoices(clazz, section);
					}
					else if(criteria.equals("specialcategory")){
						Integer specialCategoryId=null;
						SpecialCategory specialCategory=null;
						if(request.getParameter("specialCategoryId")!=null){
							specialCategoryId=Integer.parseInt(request.getParameter("specialCategoryId"));
							specialCategory=specialCategoryServices.getSpecialCategoryById(specialCategoryId);
						}
						return studentServices.getActiveStudentFromClassAndSectionBySpecialCategoryWithoutInvoices(clazz, section, specialCategory);
					}
					else{
						return students;
					}
				}
			}
		} 
		catch (Exception e) 
		{
			if(e.getClass().equals(StudentException.class))
			{
				StudentException studentException=(StudentException)e;
				redirectAttributes.addFlashAttribute("errorMessage", studentException.getCustomMessage());
				return null;
			}
			else
			{
				throw e;
			}
		}
	}
	

	
	
	
	//changes made in Student invoice constructor
	@RequestMapping(value="generate",method=RequestMethod.POST)
	@ResponseStatus(value=HttpStatus.OK)
	public void generateStudentInvoice(HttpServletRequest request) throws Exception{
		try {
			String []studentIds=request.getParameterValues("studentIds[]");
			ArrayList<FeesTermAndFeesStructure> feesTermsAndFeesStructures=new ArrayList<FeesTermAndFeesStructure>();
			
			if(studentIds!=null){
				String []academicTermAndFeesStructureIds=request.getParameterValues("academicTermIds[]");
				if(academicTermAndFeesStructureIds!=null){
					for (String academicTermAndFeesStructure : academicTermAndFeesStructureIds) {
						String splits[]=academicTermAndFeesStructure.split("-");
						FeesTermAndFeesStructure feesTermAndStructure =new FeesTermAndFeesStructure(Integer.parseInt(splits[0]),Integer.parseInt(splits[1]));
						feesTermsAndFeesStructures.add(feesTermAndStructure);
					}
				}
			}
			 String createdByAndModifiedBy=request.getSession().getAttribute("username").toString();
			 Integer instituteId=Integer.parseInt(request.getSession().getAttribute("instituteId").toString());
			 AcademicYear academicYear=academicYearServices.getInstitutionCurrentAcademicYear(instituteId);
			 Integer students[]=new Integer[studentIds.length];
			 Integer count=0;
			 for (String studentId : studentIds) {
				 students[count++]=Integer.parseInt(studentId);
			 }
			 
		     invoiceServices.generateInvoice(students,feesTermsAndFeesStructures,academicYear,createdByAndModifiedBy,institutionServices.getInstitutionById(instituteId));
		} catch (Exception e) {
			throw e;
		}
	}
	
	@RequestMapping(value="studentInvoices",method=RequestMethod.GET)
	@ResponseBody
	public ArrayList<StudentInvoice> studentInvoices(HttpServletRequest request){
		try {
			String admissionNo=request.getParameter("admissionNo");
			return invoiceServices.getStudentPendingInvoices(admissionNo);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
	}
	
	@RequestMapping(value="studentInvoice/itemdetails",method=RequestMethod.GET)
	@ResponseBody
	public ArrayList<StudentInvoiceDetail> getStudentPendingInvoiceFeesItems(HttpServletRequest request){
		try {
			Integer studentInvoiceId=Integer.parseInt(request.getParameter("studentInvoiceId"));
			return invoiceServices.getStudentPendingInvoiceFeesItems(studentInvoiceId);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
	
	
	
	@RequestMapping(value="studentInvoice/finalStudentInvoices",method=RequestMethod.GET)
	@ResponseBody
	public ArrayList<StudentInvoice> getStudentPendingInvoicesForPayment(HttpServletRequest request){
		try {
			String ids[]=request.getParameterValues("invoiceForPayment[]");
			Integer []invoicesId=new Integer[ids.length];
			Integer count=0;
			for (String invoiceId : ids) {
				invoicesId[count++]=Integer.parseInt(invoiceId);
			}
			return invoiceServices.getStudentInvoicesFromIds(invoicesId);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
	

	
	@RequestMapping(value="invoiceAndReceipt")
	public ModelAndView invoiceAndReceiptPage(HttpServletRequest request){
		try {
			if(request.getSession().getAttribute("authenticated")!=null && request.getSession().getAttribute("authenticated").equals("true")){
				Integer instituteId=Integer.parseInt(request.getSession().getAttribute("instituteId").toString());
				ModelAndView modelandview=new ModelAndView("invoiceandreceipt");
				modelandview.addObject("classes", classAndSectionServices.getInstitutionClassList(instituteId));
				modelandview.addObject("specialCategories",specialCategoryServices.getInstitutionSpecialCategoryList(instituteId));
				modelandview.addObject("academicYears", academicYearServices.getInstitutionAcademicYearList(instituteId));
				return modelandview;
			}
			else{
				return new ModelAndView("redirect:/");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		
		
		
	}
	@RequestMapping(value="invoiceAndReceipt/invoice",method=RequestMethod.GET)
	@ResponseBody
	public ArrayList<StudentInvoice> getInvoicesFromSelectedCriteria(HttpServletRequest request) throws Exception{
		try {
			
			Integer academicYearId=Integer.parseInt(request.getParameter("academicYearId"));
			AcademicYear academicYear=academicYearServices.getAcademicYearById(academicYearId);
			
			Integer classId=Integer.parseInt(request.getParameter("class"));
			Class clazz=classAndSectionServices.getClassById(classId);
			
			Integer sectionId=Integer.parseInt(request.getParameter("section"));
			Section section=classAndSectionServices.getSectionById(sectionId);
			
			String criteria=request.getParameter("criteria");
			
			String admissionNo=null;
			if(request.getParameter("admissionNo")!=null){
				admissionNo=request.getParameter("admissionNo");
			}
			Integer specialCategoryId=null;
			SpecialCategory specialCategory=null;
			if(request.getParameter("specialCategoryId")!=null){
				specialCategoryId=Integer.parseInt(request.getParameter("specialCategoryId"));
				specialCategory=specialCategoryServices.getSpecialCategoryById(specialCategoryId);
			}
			
			String option=request.getParameter("invoiceandfcr");
			
			
			if(option.equals("invoice")){
				if(criteria.equals("all")){
					return invoiceServices.getAllStudentInvoices(academicYear, clazz, section);
				}else if(criteria.equals("specificstudent")){
					return invoiceServices.getStudentInvoicesByAdmisssionNo(admissionNo);
				}else if(criteria.equals("specialcategory")){
					return invoiceServices.getStudentInvoicesBySpecialCategory(academicYear, clazz, section, specialCategory);
				}
			}
		
			return null;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
	@RequestMapping(value="print") 
	public ModelAndView printInvoice(HttpServletRequest request){
		try {
			ModelAndView modelandview=new ModelAndView("printinvoice");
			Integer invoiceId=Integer.parseInt(request.getParameter("invoiceId")) ;
			 modelandview.addObject("studentInvoice", invoiceServices.getStudentInvoiceDetails(invoiceId));
			 modelandview.addObject("numberConverter", numberConverter);
			return modelandview;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
	}
	
	@RequestMapping(value="dues")
	public ModelAndView duesPage(HttpServletRequest request){
		try {
			ModelAndView modelandview=new ModelAndView("dues");
			return modelandview;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
	}
	
/*	@RequestMapping(value="invoicePayable")
	@ResponseBody
	public Integer checkInvoicePayable(HttpServletRequest request) throws Exception{
		try {
			Integer studentInvoiceId=Integer.parseInt(request.getParameter("studentInvoiceId"));
			return invoiceServices.checkInvoicePayable(studentInvoiceId);
		} catch (Exception e) {
			throw e;
		}
		
	}*/
	
	@RequestMapping(value="invoiceValidation",method=RequestMethod.POST)
	@ResponseBody
    public Boolean invoiceValidation(HttpServletRequest request){
		try {
			String invoiceIds[]= request.getParameterValues("invoiceForPayment[]");
	    	Integer []invoicesId=new Integer[invoiceIds.length];
	    	Integer count=0;
	    	for (String invoiceId : invoiceIds) {
	    		invoicesId[count++]=Integer.parseInt(invoiceId);
	    	}
	    	return invoiceServices.invoiceValidation(invoicesId);
		} catch (Exception e) {
			throw e;
		}
	}
	
	
	@RequestMapping(value="manageInvoice")
	public ModelAndView manageInvoicePage(HttpServletRequest request){
		try {
			if(request.getSession().getAttribute("authenticated")!=null && request.getSession().getAttribute("authenticated").equals("true")){
				if(request.getSession().getAttribute("type").equals("Admin")){
					ModelAndView modelandview=new ModelAndView("manageinvoice");
					Integer instituteId=Integer.parseInt(request.getSession().getAttribute("instituteId").toString());
					modelandview.addObject("academicYears", academicYearServices.getInstitutionAcademicYearList(instituteId));
					modelandview.addObject("classes", classAndSectionServices.getInstitutionClassList(instituteId));
					modelandview.addObject("specialCategories",specialCategoryServices.getInstitutionSpecialCategoryList(instituteId));
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
			throw e;
		}
		
		
		
	}
	@RequestMapping(value="invoiceDelete",method=RequestMethod.POST) 
	public String deleteInvoice(HttpServletRequest request,RedirectAttributes redirectAttributes) throws Exception{
		try {
			 String studentIds=request.getParameter("selectedStudentIds");
			 Integer academicYearId=Integer.parseInt(request.getParameter("academicYearId"));
			
			 if(studentIds!=null && academicYearId!=null){
				 String []studentsIds=studentIds.split(",");
				 Integer []studentsId=new Integer[studentsIds.length];
				 Integer count=0;
				 for (String studentId : studentsIds) {
					studentsId[count++] =Integer.parseInt(studentId.trim());
				 }
				 invoiceServices.deleteStudentInvoicesByAcademicYear(studentsId, academicYearId);
				return "redirect:/invoice/manageInvoice";
			 }
			 else{
				 throw new StudentInvoiceException(new Message("invalid","No Student  Or Academic Year Selected"));
			 }
			 
		} catch (Exception e) {
			
			if(e.getClass().equals(StudentInvoiceException.class)){
				StudentInvoiceException ex=(StudentInvoiceException)e;
				redirectAttributes.addFlashAttribute("errorMessage",ex.getCustomMessage());
				return "redirect:/invoice/manageInvoice";
			}
			else{
				throw e;
			}
		}
	}
	
	
}
