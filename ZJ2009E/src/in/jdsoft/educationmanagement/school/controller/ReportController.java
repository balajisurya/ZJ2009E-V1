package in.jdsoft.educationmanagement.school.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import in.jdsoft.educationmanagement.reports.model.FourFieldReport;
import in.jdsoft.educationmanagement.school.model.StudentReceipt;
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
	
	@RequestMapping(value="byInstitution")
	public ModelAndView getInstitutionWiseReport(HttpServletRequest request){
		try {
			ModelAndView mv=new ModelAndView("institutionwise");
			mv.addObject("institutionsReports",invoiceServices.getInstitutionWiseInvoiceReport());
			return mv;
		} catch (Exception e) {
			throw e;
		}
	}
	
	@RequestMapping(value="/byFeesItem")	
	public ModelAndView getFeesItemWiseReport(HttpServletRequest request){
		try {
			ModelAndView mv=new ModelAndView("feesitemwise");
			mv.addObject("ledgerAccounts",institutionServices.getInstitutionLedgerAccountList(Integer.parseInt(request.getSession().getAttribute("instituteId").toString())));
			return mv;
		} catch (Exception e) {
			throw e;
		}
	}
	
	@RequestMapping(value="/byFeesItem/ledger")	
	@ResponseBody
	public ArrayList<FourFieldReport> getFeesItemsReportByLedger(HttpServletRequest request){
		try {
			 Integer ledgerId=Integer.parseInt(request.getParameter("ledgerId"));
			  return dashboardservices.getFeesItemsReportByLedger(ledgerId);
		} catch (Exception e) {
			throw e;
		}
	}

	@RequestMapping(value="/collections")	
	public ModelAndView getPaidFees(HttpServletRequest request){
		try {
			return new ModelAndView("collectionsReport");
		} catch (Exception e) {
			throw e;
		}
		
	}
	
	@RequestMapping(value="/collections/fees")	
	@ResponseBody
	public ArrayList<StudentReceipt> getPaidFeesRepprt(HttpServletRequest request) throws Exception{
		try {
			String dateRange=request.getParameter("startAndEndDate");
			SimpleDateFormat formatter =new SimpleDateFormat("MM/dd/yyyy");
			String dates[]=dateRange.split("-");
			Date startDate=formatter.parse(dates[0]);
			Date endDate=formatter.parse(dates[1]);
			return receiptServices.getReceiptsByDateRange(startDate, endDate,Integer.parseInt(request.getSession().getAttribute("instituteId").toString()));
		} catch (Exception e) {
			throw e;
		}
		
	}
	
	
}
