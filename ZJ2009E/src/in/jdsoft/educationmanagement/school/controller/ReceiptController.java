package in.jdsoft.educationmanagement.school.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import in.jdsoft.educationmanagement.components.NumberToEnglishWords;
import in.jdsoft.educationmanagement.school.exceptions.StudentReceiptException;
import in.jdsoft.educationmanagement.school.model.AcademicYear;
import in.jdsoft.educationmanagement.school.model.Class;
import in.jdsoft.educationmanagement.school.model.Message;
import in.jdsoft.educationmanagement.school.model.PaymentMode;
import in.jdsoft.educationmanagement.school.model.Section;
import in.jdsoft.educationmanagement.school.model.SpecialCategory;
import in.jdsoft.educationmanagement.school.model.StudentReceipt;
import in.jdsoft.educationmanagement.school.services.AcademicYearServices;
import in.jdsoft.educationmanagement.school.services.ClassAndSectionServices;
import in.jdsoft.educationmanagement.school.services.GeographicalLocationServices;
import in.jdsoft.educationmanagement.school.services.InstitutionServices;
import in.jdsoft.educationmanagement.school.services.InvoiceServices;
import in.jdsoft.educationmanagement.school.services.PaymentServices;
import in.jdsoft.educationmanagement.school.services.ReceiptServices;
import in.jdsoft.educationmanagement.school.services.SpecialCategoryServices;

@Controller
@RequestMapping("/receipt")
public class ReceiptController {

	@Autowired
	ClassAndSectionServices classAndSectionServices;
	@Autowired
	GeographicalLocationServices  geographicallocationService;
	@Autowired
	PaymentServices paymentServices;
	@Autowired
	InvoiceServices invoiceServices;
	@Autowired
	ReceiptServices receiptServices;
	@Autowired
	InstitutionServices institutionServices;
	@Autowired
	NumberToEnglishWords numberConverter;
	@Autowired
	AcademicYearServices academicYearServices;
	@Autowired
	SpecialCategoryServices specialCategoryServices;
	
	@RequestMapping 
	public ModelAndView displayReceiptPage(HttpServletRequest request){
		try {
			if(request.getSession().getAttribute("authenticated")!=null && request.getSession().getAttribute("authenticated").equals("true")){
				ModelAndView modelandview=new ModelAndView("receipt");
				modelandview.addObject("geographicallocationList", geographicallocationService.getCountryList());
				modelandview.addObject("geographicallocationStateList", geographicallocationService.getStateList());
				modelandview.addObject("geographicallocationCityList", geographicallocationService.getCityList());
			    modelandview.addObject("paymentmodes",paymentServices.getActivePaymentModes());
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
	
	@RequestMapping(value="generate",method=RequestMethod.POST)
	public String generateReceipt(HttpServletRequest request,RedirectAttributes redirectAttributes) throws Exception{
		try {
			DateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
			String paidInvoiceIds[]=request.getParameterValues("paidInvoiceId");
			Integer paidInvoices[]=null;
			double fineAmount=0.0;
			if(!request.getParameter("fineAmount").isEmpty()){
				fineAmount=Double.parseDouble(request.getParameter("fineAmount"));
			}
			
			if(paidInvoiceIds!=null){
				paidInvoices=new Integer[paidInvoiceIds.length];
				Integer i=0;
				for (String paidInvoiceId : paidInvoiceIds) {
					paidInvoices[i++]=Integer.parseInt(paidInvoiceId);
				}
			}
			
			
			
			double totalPaidAmount=Double.parseDouble(request.getParameter("amount"));
			Integer paymentModeId=Integer.parseInt(request.getParameter("paymentMode"));
			//cash
			if(paymentModeId==1){
				PaymentMode paymentMode=paymentServices.getPaymentModeById(paymentModeId);
				Date receivedDate=formatter.parse(request.getParameter("receivedDate"));
				String createdBy=request.getSession().getAttribute("username").toString();
				String modifiedBy=request.getSession().getAttribute("username").toString();
				Integer []receiptId=receiptServices.receiptByCash(paidInvoices,fineAmount,totalPaidAmount, paymentMode, receivedDate,createdBy,modifiedBy);
				ArrayList<Integer> receiptIds=new ArrayList<Integer>();
				for (Integer receiptId1 : receiptId) {
					receiptIds.add(receiptId1);
				}
				redirectAttributes.addFlashAttribute("receiptId", receiptIds);
				return "redirect:/receipt";
			}
			else if(paymentModeId==2){
				PaymentMode paymentMode=paymentServices.getPaymentModeById(paymentModeId);
				Date chequeReceivedDate=formatter.parse(request.getParameter("receivedDate"));
				String chequeNo=request.getParameter("chequeNo");
				Date chequeDate=formatter.parse(request.getParameter("chequeDate"));
				String chequeBankName=request.getParameter("chequeBankName");
				String chequeBranchName=request.getParameter("chequeBranchName");
				String createdBy=request.getSession().getAttribute("username").toString();
				String modifiedBy=request.getSession().getAttribute("username").toString();
				Integer []receiptId=receiptServices.receiptByCheque(paidInvoices,fineAmount,totalPaidAmount, paymentMode, chequeReceivedDate, chequeNo, chequeDate, chequeBankName, chequeBranchName,createdBy,modifiedBy);
				ArrayList<Integer> receiptIds=new ArrayList<Integer>();
				for (Integer receiptId1 : receiptId) {
					receiptIds.add(receiptId1);
				}
				redirectAttributes.addFlashAttribute("receiptId", receiptIds);
				return "redirect:/receipt";
			}
			else if(paymentModeId==3){
				PaymentMode paymentMode=paymentServices.getPaymentModeById(paymentModeId);
				Date ddReceivedDate=formatter.parse(request.getParameter("receivedDate"));
				String ddNo=request.getParameter("ddNo");
				Date ddDate=formatter.parse(request.getParameter("ddDate"));
				String ddBankName=request.getParameter("ddBankName");
				String ddBranchName=request.getParameter("ddBranchName");
				String createdBy=request.getSession().getAttribute("username").toString();
				String modifiedBy=request.getSession().getAttribute("username").toString();
				Integer []receiptId=receiptServices.receiptByDD(paidInvoices,fineAmount,totalPaidAmount, paymentMode, ddReceivedDate, ddNo, ddDate, ddBankName, ddBranchName,createdBy,modifiedBy);
				ArrayList<Integer> receiptIds=new ArrayList<Integer>();
				for (Integer receiptId1 : receiptId) {
					receiptIds.add(receiptId1);
				}
				redirectAttributes.addFlashAttribute("receiptId", receiptIds);
				return "redirect:/receipt";
			}
			else{
				throw new StudentReceiptException(new Message("failed","Invalid Payment Method"));
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
	
	
	@RequestMapping(value="reconcillation",method=RequestMethod.GET) 
	public ModelAndView displayReconcillationPage(HttpServletRequest request){
		try {
			if(request.getSession().getAttribute("authenticated")!=null && request.getSession().getAttribute("authenticated").equals("true")){
				ModelAndView modelandview=new ModelAndView("reconcillation");
				modelandview.addObject("paymentModes",paymentServices.getPaymentModeList());
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
	
	@RequestMapping(value="print") 
	public ModelAndView printReceipt(HttpServletRequest request){
		try {
			 ModelAndView modelandview=new ModelAndView("printreceipt");
			 Integer receiptId=Integer.parseInt(request.getParameter("receiptId")) ;
			 modelandview.addObject("studentReceipt",  receiptServices.getStudentReceiptDetails(receiptId));
			 modelandview.addObject("numberConverter", numberConverter);
			 return modelandview;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		
	}
	
	@RequestMapping(value="byPaymentModeAndStatus",method=RequestMethod.GET) 
	@ResponseBody
	public ArrayList<StudentReceipt> studentReceiptsByPaymentMode(HttpServletRequest request){
		try {
			Integer paymentModeId=Integer.parseInt(request.getParameter("paymentModeId"));
			Integer paymentStatusId=Integer.parseInt(request.getParameter("paymentStatusId"));
			return receiptServices.getStudentReceiptsFromPaymentModeAndStatus(paymentModeId, paymentStatusId);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		
	}
	
	@RequestMapping(value="cashRecon",method=RequestMethod.POST)
	public String updateReconcillation(HttpServletRequest request,RedirectAttributes redirectAttributes) throws Exception{
		try {
			Integer cashReconReceiptId=Integer.parseInt(request.getParameter("cashReconReceiptId"));
			Integer cashReconPaymentStatusId=Integer.parseInt(request.getParameter("cashReconPaymentStatusId"));
			DateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
			Date clearanceDate=formatter.parse(request.getParameter("clearanceDate"));
			String comment=request.getParameter("cashReconComment");
			String receiptClearedBy=request.getSession().getAttribute("username").toString();
			receiptServices.updateReconcillation(cashReconReceiptId, cashReconPaymentStatusId, clearanceDate, comment,receiptClearedBy);
			return "redirect:/receipt/reconcillation";
		} catch (Exception e) {
			if(e.getClass().equals(StudentReceiptException.class)){
				StudentReceiptException studentReceiptException=(StudentReceiptException)e;
				redirectAttributes.addFlashAttribute("errorMessage",studentReceiptException.getCustomMessage());
				return "redirect:/receipt/reconcillation";
			}
			else{
				e.printStackTrace();
				throw e;
			}
		}
	}
	
	
	@RequestMapping(value="chequeRecon",method=RequestMethod.POST)
	public String updateChequeReconcillation(HttpServletRequest request,RedirectAttributes redirectAttributes) throws Exception{
		try {
			Integer chequeReconReceiptId=Integer.parseInt(request.getParameter("chequeReconReceiptId"));
			Integer chequeReconPaymentStatusId=Integer.parseInt(request.getParameter("chequeReconPaymentStatusId"));
			DateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
			Date clearanceDate=formatter.parse(request.getParameter("chequeReconClearanceDate"));
			String comment=request.getParameter("chequeReconComment");
			String receiptClearedBy=request.getSession().getAttribute("username").toString();
			receiptServices.updateChequeReconcillation(chequeReconReceiptId,chequeReconPaymentStatusId, clearanceDate, comment,receiptClearedBy);
			return "redirect:/receipt/reconcillation";
		} catch (Exception e) {
			if(e.getClass().equals(StudentReceiptException.class)){
				StudentReceiptException studentReceiptException=(StudentReceiptException)e;
				redirectAttributes.addFlashAttribute("errorMessage",studentReceiptException.getCustomMessage());
				return "redirect:/receipt/reconcillation";
			}
			else{
				e.printStackTrace();
				throw e;
			}
			
		}
	}
	
	@RequestMapping(value="invoiceAndReceipt/receipt",method=RequestMethod.GET)
	@ResponseBody
	public ArrayList<StudentReceipt> getReceiptsFromSelectedCriteria(HttpServletRequest request) throws Exception{
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
			
			
			if(option.equals("fcr")){
				if(criteria.equals("all")){
					return receiptServices.getAllStudentReceipts(academicYear, clazz, section);
				}else if(criteria.equals("specificstudent")){
					return receiptServices.getStudentReceiptsByAdmisssionNo(admissionNo);
				}else if(criteria.equals("specialcategory")){
					return receiptServices.getStudentReceiptsBySpecialCategory(academicYear, clazz, section, specialCategory);
				}
			}
			
			return null;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
	
	
	@RequestMapping(value="ddRecon",method=RequestMethod.POST)
	public String updateddReconcillation(HttpServletRequest request,RedirectAttributes redirectAttributes) throws Exception{
		try {
			Integer ddReconReceiptId=Integer.parseInt(request.getParameter("ddReconReceiptId"));
			Integer ddReconPaymentStatusId=Integer.parseInt(request.getParameter("ddReconPaymentStatusId"));
			DateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
			Date clearanceDate=formatter.parse(request.getParameter("ddReconClearanceDate"));
			String comment=request.getParameter("ddReconComment");
			String receiptClearedBy=request.getSession().getAttribute("username").toString();
			receiptServices.updateDdReconcillation(ddReconReceiptId,ddReconPaymentStatusId, clearanceDate, comment,receiptClearedBy);
			return "redirect:/receipt/reconcillation";
		} catch (Exception e) {
			if(e.getClass().equals(StudentReceiptException.class)){
				StudentReceiptException studentReceiptException=(StudentReceiptException)e;
				redirectAttributes.addFlashAttribute("errorMessage",studentReceiptException.getCustomMessage());
				return "redirect:/receipt/reconcillation";
			}
			else{
				throw e;
			}
			
		}
	}
	
	@RequestMapping(value="manageReceipt")
	public ModelAndView displayManageReceiptPage(HttpServletRequest request){
		try{
			if(request.getSession().getAttribute("authenticated")!=null && request.getSession().getAttribute("authenticated").equals("true")){
				if(request.getSession().getAttribute("type").equals("Admin")){
					ModelAndView mv=new ModelAndView("managereceipt");
					return mv;
				}
				else{
					ModelAndView modelandview=new ModelAndView("redirect:/home");
					return modelandview;
				}
			}
			else{
				return new ModelAndView("redirect:/");
			}
			
		}catch(Exception e){
			throw e;
		}
	}
	
	@RequestMapping(value="/byAdmissionNo")
	@ResponseBody
	public ArrayList<StudentReceipt> getStudentReceiptsByAdmisionNo(HttpServletRequest request){
		try {
			 String admissionNo= request.getParameter("admissionNo");
		     return	 receiptServices.getStudentReceiptsByAdmisssionNo(admissionNo);
			 
		} catch (Exception e) {
		   throw e;
		}
	}
	
	@RequestMapping(value="/delete",method=RequestMethod.POST)
	public String deleteReceipt(HttpServletRequest request){
		try {
			  Integer receiptId=Integer.parseInt(request.getParameter("deleteReceiptId"));
			  receiptServices.deleteReceipt(receiptId);
			  return "redirect:/receipt/manageReceipt";
		} catch (Exception e) {
			throw e;
		}
	}
}
