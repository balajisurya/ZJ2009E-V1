package in.jdsoft.educationmanagement.controllers;

import java.io.IOException;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Set;

import javax.servlet.ServletException;
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

import in.jdsoft.educationmanagement.model.CommunicationAndIssuesOrQueries;
import in.jdsoft.educationmanagement.model.FeesCollectionRecord;
import in.jdsoft.educationmanagement.model.Institution;
import in.jdsoft.educationmanagement.model.Student;
import in.jdsoft.educationmanagement.model.StudentInvoice;
import in.jdsoft.educationmanagement.model.StudentPerformance;
import in.jdsoft.educationmanagement.services.AdmissionServices;
import in.jdsoft.educationmanagement.services.BloodGroupServices;
import in.jdsoft.educationmanagement.services.CategoryServices;
import in.jdsoft.educationmanagement.services.CommunicationAndIssuesOrQueriesServices;
import in.jdsoft.educationmanagement.services.CourseServices;
import in.jdsoft.educationmanagement.services.DepartmentServices;
import in.jdsoft.educationmanagement.services.FeesStructureServices;
import in.jdsoft.educationmanagement.services.InstitutionServices;
import in.jdsoft.educationmanagement.services.SpecialCategoryServices;
import in.jdsoft.educationmanagement.services.StaffServices;
import in.jdsoft.educationmanagement.services.StudentServices;
import in.jdsoft.educationmanagement.services.UserService;


@Controller
@RequestMapping("/student")
public class StudentController {
	
	@Autowired
	CommunicationAndIssuesOrQueriesServices communicationAndIssuesOrQueriesServices;
	@Autowired
	StudentServices studentServices;
	@Autowired
	UserService userServices;
	@Autowired
	InstitutionServices institutionServices;	
	@Autowired
	private AdmissionServices admissionServices;
	@Autowired
	private CategoryServices categoryServices;
	@Autowired
	private SpecialCategoryServices specialCategoryServices;
	@Autowired
	private CourseServices courseServices;
	@Autowired
	private DepartmentServices departmentServices;
	@Autowired
	private FeesStructureServices feesStructureServices;
	@Autowired
	private BloodGroupServices bloodGroupServices;
	@Autowired 
	private StaffServices staffServices;
	
	
	@RequestMapping(value="myperformance", method = RequestMethod.GET) 
	public ModelAndView displayStudentDashboardPage(){
		try {
			ModelAndView modelandview=new ModelAndView("studentperformance");
			return modelandview;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	@RequestMapping
	public ModelAndView displayManageStudent(){
		try {
			ModelAndView modelandview=new ModelAndView("managestudent");
			return modelandview;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	@RequestMapping(value="studentProfile", method = RequestMethod.GET) 
	public ModelAndView displayStudentProfilePage(){
		try {
			ModelAndView modelandview=new ModelAndView("studentprofile");
			return modelandview;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
	}
	
	@RequestMapping(value="invoices")
	public ModelAndView displayInvoicePage(){
		try {
			ModelAndView modelandview=new ModelAndView("invoices");
			return modelandview;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
	}
	
	@RequestMapping(value="studentattendance")
	public ModelAndView displayStudentAttendancePage(HttpServletRequest request){
		try {
			ModelAndView modelandview=new ModelAndView("studentattendance");
			modelandview.addObject("studentAttendanceTypeList",studentServices.getStudentAttendanceTypeList());
			modelandview.addObject("studentList",studentServices.getStudentListOfUser(request.getSession().getAttribute("username").toString()));
			return modelandview;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
		
	}
	
	@RequestMapping(value="updateResult", method = RequestMethod.GET)
	public ModelAndView displayUpdateResultPage(){
		try {
			ModelAndView modelandview=new ModelAndView("updateResult");
			return modelandview;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
	}
	@RequestMapping(value="eventsandtimetable", method = RequestMethod.GET) 
	public ModelAndView displayEventsAndTimeTable(){
		try {
			ModelAndView modelandview=new ModelAndView("eventsandtimetable");
			return modelandview;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
	}
	@RequestMapping(value="examandresults", method = RequestMethod.GET)
	public ModelAndView displayexamandresults(){
		try {
			ModelAndView modelandview=new ModelAndView("examandresults");
			return modelandview;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
	}
	@RequestMapping(value="studentcommunication", method = RequestMethod.GET) 
	public ModelAndView displayCommunication(){
		try {
			ModelAndView modelandview=new ModelAndView("studentcommunication");
			modelandview.addObject("communicationAndIssuesOrQueriesList", communicationAndIssuesOrQueriesServices.getCommunicationAndIssuesOrQueriesList());
			modelandview.addObject("communicationTargetGroupList", communicationAndIssuesOrQueriesServices.getCommunicationTargetGroupList());
			return modelandview;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
	}
	

	@RequestMapping(value="addCommunicationMessage",method = RequestMethod.POST)
	public String addCommunicationMessage(HttpServletRequest request) throws Exception{
	
		
		try{
			String messageMode=request.getParameter("MessageMode");
			String communicationTargetGroupId=request.getParameter("communicationTargetGroupId");
			String typeOfMessage=request.getParameter("TypeOfMessage");
			String message=request.getParameter("message");
			String communicationCreatedByUser=request.getSession().getAttribute("username").toString();
			CommunicationAndIssuesOrQueries communicationAndIssuesOrQueries=new CommunicationAndIssuesOrQueries(messageMode, communicationTargetGroupId, typeOfMessage, message, communicationCreatedByUser, "", "", "", new Timestamp(Calendar.getInstance().getTime().getTime())); 
			communicationAndIssuesOrQueriesServices.addCommunicationAndIssuesOrQueries(communicationAndIssuesOrQueries);
			 return "redirect:/student/studentcommunication";
		}catch(Exception e){
			e.printStackTrace();
			return "redirect:/student/studentcommunication";
		}
	}
	@RequestMapping(value="studentappraisal", method = RequestMethod.GET) 	
	public ModelAndView displayStudentApprasial(){
		try {
			ModelAndView modelandview=new ModelAndView("studentappraisal");	
			return modelandview;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
	}

	
	@RequestMapping(value="addStudentAppraisal",method = RequestMethod.POST)
	public String addStudentAppraisal(HttpServletRequest request) throws Exception{
		try{
			Integer studentId=Integer.parseInt(request.getParameter("studentId"));
			String appraisalTerm=request.getParameter("appraisalTerm");
			String relationshipRating=request.getParameter("relationshipRating");
			String relationshipComments=request.getParameter("relationshipComments");
			String attitudeRating=request.getParameter("attitudeRating");
			String attitudeComments=request.getParameter("attitudeComments");
			String academicRating=request.getParameter("academicRating");
			String academicComments=request.getParameter("academicComments");
			String initiativeRating=request.getParameter("initiativeRating");
			String initiativeComments=request.getParameter("initiativeComments");
			String creativityRating=request.getParameter("creativityRating");
			String creativityComments=request.getParameter("creativityComments");
			String punctualityRating=request.getParameter("punctualityRating");
			String punctualityComments=request.getParameter("punctualityComments");
			String sportsAndSocialRating=request.getParameter("sportsAndSocialRating");
			String sportsAndSocialComments=request.getParameter("sportsAndSocialComments");
			String recommentation=request.getParameter("recommentation");
			String appraisalStatus=request.getParameter("appraisalStatus");
			String appraisalCreatedByUser=request.getSession().getAttribute("username").toString();
			Student student=studentServices.getStudentById(studentId);
			StudentPerformance studentPerformance=new StudentPerformance(appraisalTerm, relationshipRating, relationshipComments, attitudeRating, attitudeComments, academicRating, academicComments, initiativeRating, initiativeComments, creativityRating, creativityComments, punctualityRating, punctualityComments, sportsAndSocialRating, sportsAndSocialComments, appraisalCreatedByUser, recommentation, appraisalStatus, new Timestamp(Calendar.getInstance().getTime().getTime()), student);
			studentServices.addStudentAppraisal(studentPerformance);
			return "redirect:/student/studentappraisal";
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}

	@RequestMapping(value="getStudentPerformanceList")
	@ResponseBody
	public Set<StudentPerformance> getStudentPerformanceList(HttpServletRequest request) throws ServletException, IOException 
	{
		try {
			Integer studentId=Integer.parseInt(request.getParameter("getStudentId"));
			Set<StudentPerformance> studentPerformance=studentServices.getStudentPerformanceRecords(studentId);		
		    return studentPerformance;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
    }
	@RequestMapping(value="editStudentPerformance")
	@ResponseBody
	public StudentPerformance editStudentPerformance(HttpServletRequest request) 
	{
		try {
			Integer studentPerformanceId=Integer.parseInt(request.getParameter("studentPerformanceId"));
			StudentPerformance studentPerformance=studentServices.getStudentPerformanceById(studentPerformanceId);	
		    return studentPerformance;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
    }
	
	@RequestMapping(value="deleteStudentPerformance",method=RequestMethod.GET)
	public String deleteStudentPerformance(HttpServletRequest request) throws Exception{
		try {
			Integer deleteStudentPerformanceId=Integer.parseInt(request.getParameter("studentPerformanceId"));
			studentServices.deleteStudentAppraisal(deleteStudentPerformanceId);
			return "redirect:/student/studentappraisal";
		} catch (Exception e) {
			e.printStackTrace();
			return "redirect:/student/studentappraisal";
		}
		
	}
	
	@RequestMapping(value="updateStudentPerformance",method=RequestMethod.POST)
	@ResponseStatus(value=HttpStatus.OK)
	public void updateStudentPerformance(HttpServletRequest request) throws Exception
	{
		
		try {
			Integer studentId=Integer.parseInt(request.getParameter("editStudentId"));
			String appraisalTerm=request.getParameter("editAppraisalTerm");
			String relationshipRating=request.getParameter("editRelationshipRating");
			String relationshipComments=request.getParameter("editRelationshipComments");
			String attitudeRating=request.getParameter("editAttitudeRating");
			String attitudeComments=request.getParameter("editAttitudeComments");
			String academicRating=request.getParameter("editAcademicRating");
			String academicComments=request.getParameter("editAcademicComments");
			String initiativeRating=request.getParameter("editInitiativeRating");
			String initiativeComments=request.getParameter("editInitiativeComments");
			String creativityRating=request.getParameter("editCreativityRating");
			String creativityComments=request.getParameter("editCreativityComments");
			String punctualityRating=request.getParameter("editPunctualityRating");
			String punctualityComments=request.getParameter("editPunctualityComments");
			String sportsAndSocialRating=request.getParameter("editSportsAndSocialRating");
			String sportsAndSocialComments=request.getParameter("editSportsAndSocialComments");
			String recommentation=request.getParameter("editRecommentation");
			String appraisalStatus=request.getParameter("editAppraisalStatus");
			String appraisalCreatedByUser=request.getSession().getAttribute("username").toString();
			Integer studentPerformanceId=Integer.parseInt(request.getParameter("studentPerformanceId"));
			
			StudentPerformance studentPerformance=studentServices.getStudentPerformanceById(studentPerformanceId);
			Student student=studentServices.getStudentById(studentId);
			studentPerformance.setStudent(student);
			studentPerformance.setAppraisalTerm(appraisalTerm);
			studentPerformance.setRelationshipRating(relationshipRating);
			studentPerformance.setRelationshipComments(relationshipComments);
			studentPerformance.setAttitudeRating(attitudeRating);
			studentPerformance.setAttitudeComments(attitudeComments);
			studentPerformance.setAcademicRating(academicRating);
			studentPerformance.setAcademicComments(academicComments);
			studentPerformance.setInitiativeRating(initiativeRating);
			studentPerformance.setInitiativeComments(initiativeComments);
			studentPerformance.setCreativityRating(creativityRating);
			studentPerformance.setCreativityComments(creativityComments);
			studentPerformance.setPunctualityRating(punctualityRating);
			studentPerformance.setPunctualityComments(punctualityComments);
			studentPerformance.setSportsAndSocialRating(sportsAndSocialRating);
			studentPerformance.setSportsAndSocialComments(sportsAndSocialComments);
			studentPerformance.setRecommendations(recommentation);
			studentPerformance.setAppraisalStatus(appraisalStatus);
			studentPerformance.setAppraisalCreatedByUser(appraisalCreatedByUser);
			studentPerformance.setCreatedDate(new Timestamp(Calendar.getInstance().getTime().getTime()));
			studentServices.updateStudentAppraisal(studentPerformance);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
    }
	
	@RequestMapping(value="getFeesDetails",method=RequestMethod.GET)
	@ResponseBody
	public StudentInvoice getFeesDetails(HttpServletRequest request,RedirectAttributes redirectAttributes) throws Exception
	{
		try {
		
			StudentInvoice studentInvoice=studentServices.getStudentInvoiceLazyById(Integer.parseInt(request.getParameter("invoiceId")));
			return studentInvoice;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
	}
	
	//changes need as per new concept
	/*@RequestMapping(value="addStudentFeesDetails",method = RequestMethod.POST)
	public String addStudentFeesDetails(HttpServletRequest request) throws Exception{
	
		try{
			DateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
			
			Integer invoiceId=Integer.parseInt(request.getParameter("invoiceId"));
			Integer studentId=Integer.parseInt(request.getParameter("studentId"));
			Integer instituteId=Integer.parseInt(request.getParameter("instituteId"));
			
			Double amount= Double.parseDouble(request.getParameter("amount"));

			String paymentMode=request.getParameter("paymentMode");
			String payableAt=request.getParameter("payableAt");
			String feesCollectionClerk=request.getSession().getAttribute("username").toString();
			String tallyGLAccount=request.getParameter("tallyGLAccount");
			String remarks=request.getParameter("remarks");
		
			
			
			
			
			
		
				if(paymentMode.equals("BankEFT"))
			{
				String bankName=request.getParameter("bankName");
				String bankAddressLine1=request.getParameter("bankAddressLine1");
				String bankAddressLine2=request.getParameter("bankAddressLine2");
				Integer bankCountryId=Integer.parseInt(request.getParameter("bankCountryId"));
				Integer bankStateId=Integer.parseInt(request.getParameter("bankStateId"));
				Integer bankCityId=Integer.parseInt(request.getParameter("bankCityId"));
				String bankTransactionCode=request.getParameter("bankTransactionCode");
				String bankPostCode=request.getParameter("bankPostCode");
				String bankIFSCCode=request.getParameter("bankIFSCCode");
				Date dateOFEFTOrCash=null;
				
				if(!request.getParameter("dateOFEFTOrCash").isEmpty())
				{
					
					dateOFEFTOrCash=formatter.parse(request.getParameter("dateOFEFTOrCash"));

					
					
				}
				Student student=studentServices.getStudentById(studentId);
				Institution institution=institutionServices.getInstitutionById(instituteId);		
				StudentInvoice studentInvoice=studentServices.getStudentInvoiceById(invoiceId);
				
				FeesCollectionRecord feesCollectionRecord=new FeesCollectionRecord(studentInvoice, student, institution, paymentMode, null,null, null, amount, payableAt, bankName, bankAddressLine1, bankAddressLine2, bankCityId, bankStateId, bankCountryId, bankPostCode, bankTransactionCode, bankIFSCCode, dateOFEFTOrCash,"" institution.getInstitutionAccountNumber(), feesCollectionClerk, null, tallyGLAccount, remarks);			
				studentServices.addFeesCollectionRecord(feesCollectionRecord);
				
			}
			else if(paymentMode.equals("Cash"))
			{
				Date dateOFEFTOrCash=null;
				
				if(!request.getParameter("dateOFEFTOrCash").isEmpty())
				{
					
					dateOFEFTOrCash=formatter.parse(request.getParameter("dateOFEFTOrCash"));

					
					
				}
				Student student=studentServices.getStudentById(studentId);
				Institution institution=institutionServices.getInstitutionById(instituteId);		
				StudentInvoice studentInvoice=studentServices.getStudentInvoiceById(invoiceId);
				
				FeesCollectionRecord feesCollectionRecord=new FeesCollectionRecord(studentInvoice, student, institution, paymentMode, null, null, null, amount, payableAt, null, null, null, null, null, null, null, null, null, dateOFEFTOrCash, institution.getInstitutionAccountName(), institution.getInstitutionAccountNumber(), feesCollectionClerk, null, tallyGLAccount, remarks);			
				studentServices.addFeesCollectionRecord(feesCollectionRecord);
				
			}
			else if((paymentMode.equals("Cheque")) || (paymentMode.equals("DD")))
			{
				
				int bankCountryId=0;
				if(request.getParameter("bankCountryId")!=null){
				     bankCountryId=Integer.parseInt(request.getParameter("bankCountryId"));
				}
			    int bankStateId=0;
			    if(request.getParameter("bankStateId")!=null){
			    	
			        bankStateId=Integer.parseInt(request.getParameter("bankStateId"));
					
			    }
				
			    int bankCityId=0;
			    if(request.getParameter("bankCityId")!=null){
			    	bankCityId=Integer.parseInt(request.getParameter("bankCityId"));
			    }
				
				
				String ddOrChequeNo=request.getParameter("ddOrChequeNo");	
				Date ddOrChequeDate=null;
				if(!request.getParameter("ddOrChequeDate").isEmpty())
				{
					ddOrChequeDate=formatter.parse( request.getParameter("ddOrChequeDate"));
				}
				String outStationCheque=request.getParameter("outStationCheque");
				
				
				String bankName=request.getParameter("bankName");
				String bankAddressLine1=request.getParameter("bankAddressLine1");
				String bankAddressLine2=request.getParameter("bankAddressLine2");
				
				
				String bankPostCode=request.getParameter("bankPostCode");
				String bankStatementStatus=request.getParameter("bankStatementStatus");
				
				Student student=studentServices.getStudentById(studentId);
				Institution institution=institutionServices.getInstitutionById(instituteId);		
				StudentInvoice studentInvoice=studentServices.getStudentInvoiceById(invoiceId);
				
				FeesCollectionRecord feesCollectionRecord=new FeesCollectionRecord(studentInvoice, student, institution, paymentMode, outStationCheque, ddOrChequeNo, ddOrChequeDate, amount, payableAt, bankName, bankAddressLine1, bankAddressLine2, bankCityId, bankStateId, bankCountryId, bankPostCode, null, null, null, institution.getInstitutionAccountName(), institution.getInstitutionAccountNumber(), feesCollectionClerk, bankStatementStatus, tallyGLAccount, remarks);			
				studentServices.addFeesCollectionRecord(feesCollectionRecord);
			}
			
			
			
			return "redirect:/collection/dataentry";
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}*/

	@RequestMapping(value="editFeesDetails",method=RequestMethod.GET)
	@ResponseBody
	public FeesCollectionRecord editFeesDetails(HttpServletRequest request,RedirectAttributes redirectAttributes) throws Exception
	{
		try {
			FeesCollectionRecord feesCollectionRecord=studentServices.getFeesCollectionRecordLazyById(Integer.parseInt(request.getParameter("feesCollectionRecordId")));
			return feesCollectionRecord;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
	}
	
	@RequestMapping(value="deleteStudentFeesDetails",method=RequestMethod.POST)
	@ResponseStatus(value=HttpStatus.OK)
	public void deleteStudentFeesDetails(HttpServletRequest request,RedirectAttributes redirectAttributes) throws Exception
	{
		try {
			studentServices.deleteFeesCollectionRecord(Integer.parseInt(request.getParameter("feesCollectionRecordId")));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	@RequestMapping(value="updateStudentFeesDetails",method = RequestMethod.POST)
	@ResponseStatus(value=HttpStatus.OK)
	public void updateStudentFeesDetails(HttpServletRequest request) throws Exception{
		try{
			
			DateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
			
			Integer feesCollectionRecordId=Integer.parseInt(request.getParameter("feesCollectionRecordId"));
			
			Integer invoiceId=Integer.parseInt(request.getParameter("editInvoiceId"));
			Integer studentId=Integer.parseInt(request.getParameter("editStudentId"));
			Integer instituteId=Integer.parseInt(request.getParameter("editInstituteId"));
			
			
			Double amount= Double.parseDouble(request.getParameter("editAmount"));	
			String paymentMode=request.getParameter("editPaymentMode");
			String payableAt=request.getParameter("editPayableAt");
			
			String feesCollectionClerk=request.getSession().getAttribute("username").toString();
			String tallyGLAccount=request.getParameter("editTallyGLAccount");
			String remarks=request.getParameter("editRemarks");
			
			if(paymentMode.equals("BankEFT"))
			{
				String bankName=request.getParameter("editBankName");
				String bankAddressLine1=request.getParameter("editBankAddressLine1");
				String bankAddressLine2=request.getParameter("editBankAddressLine2");
				Integer bankCountryId=Integer.parseInt(request.getParameter("editBankCountryId"));
				Integer bankStateId=Integer.parseInt(request.getParameter("editBankStateId"));
				Integer bankCityId=Integer.parseInt(request.getParameter("editBankCityId"));
				String bankTransactionCode=request.getParameter("editBankTransactionCode");
				String bankIFSCCode=request.getParameter("editBankIFSCCode");
				String bankPostCode=request.getParameter("editBankPostCode");
				
				Date dateOFEFTOrCash=formatter.parse(request.getParameter("editDateOFEFTOrCash"));
				
				Student student=studentServices.getStudentById(studentId);
				Institution institution=institutionServices.getInstitutionById(instituteId);		
				StudentInvoice studentInvoice=studentServices.getStudentInvoiceById(invoiceId);
				
				FeesCollectionRecord feesCollectionRecord=studentServices.getFeesCollectionRecordLazyById(feesCollectionRecordId);
				
				feesCollectionRecord.setStudent(student);
				feesCollectionRecord.setInstitution(institution);
				feesCollectionRecord.setInvoice(studentInvoice);
				
				feesCollectionRecord.setBankEFTDate(dateOFEFTOrCash);
				
				feesCollectionRecord.setAmount(amount);
				feesCollectionRecord.setPaymentMode(paymentMode);
				feesCollectionRecord.setPayableAt(payableAt);
				
				feesCollectionRecord.setBankName(bankName);
				feesCollectionRecord.setBankAddressLine1(bankAddressLine1);
				feesCollectionRecord.setBankAddressLine2(bankAddressLine2);
				feesCollectionRecord.setBankCityId(bankCityId);
				feesCollectionRecord.setBankStateId(bankStateId);
				feesCollectionRecord.setBankCountryId(bankCountryId);
				feesCollectionRecord.setBankEFTTransactionCode(bankTransactionCode);
				feesCollectionRecord.setBankIFSCode(bankIFSCCode);
				feesCollectionRecord.setBankPostcode(bankPostCode);
				
				feesCollectionRecord.setFeesCollectionClerk(feesCollectionClerk);
				feesCollectionRecord.setTallyGLAccount(tallyGLAccount);
				feesCollectionRecord.setRemarks(remarks);
				
				studentServices.updateFeesCollectionRecord(feesCollectionRecord);
				
			}
			else if(paymentMode.equals("Cash"))
			{
				Date dateOFEFTOrCash=formatter.parse(request.getParameter("editDateOFEFTOrCash"));
				
				Student student=studentServices.getStudentById(studentId);
				Institution institution=institutionServices.getInstitutionById(instituteId);		
				StudentInvoice studentInvoice=studentServices.getStudentInvoiceById(invoiceId);
				
				FeesCollectionRecord feesCollectionRecord=studentServices.getFeesCollectionRecordLazyById(feesCollectionRecordId);
				
				feesCollectionRecord.setStudent(student);
				feesCollectionRecord.setInstitution(institution);
				feesCollectionRecord.setInvoice(studentInvoice);
				feesCollectionRecord.setBankEFTDate(dateOFEFTOrCash);
				
				feesCollectionRecord.setAmount(amount);
				feesCollectionRecord.setPaymentMode(paymentMode);
				feesCollectionRecord.setPayableAt(payableAt);
				feesCollectionRecord.setFeesCollectionClerk(feesCollectionClerk);
				feesCollectionRecord.setTallyGLAccount(tallyGLAccount);
				feesCollectionRecord.setRemarks(remarks);
				
				studentServices.updateFeesCollectionRecord(feesCollectionRecord);
			}
			else if((paymentMode.equals("Cheque")) || (paymentMode.equals("DD")))
			{
				String ddOrChequeNo=request.getParameter("editDdOrChequeNo");		
				String outStationCheque=request.getParameter("editOutStationCheque");
				Date ddOrChequeDate=formatter.parse( request.getParameter("editDdOrChequeDate"));
				
				String bankName=request.getParameter("editBankName");
				String bankAddressLine1=request.getParameter("editBankAddressLine1");
				String bankAddressLine2=request.getParameter("editBankAddressLine2");
				Integer bankCountryId=Integer.parseInt(request.getParameter("editBankCountryId"));
				Integer bankStateId=Integer.parseInt(request.getParameter("editBankStateId"));
				Integer bankCityId=Integer.parseInt(request.getParameter("editBankCityId"));
			
				String bankPostCode=request.getParameter("editBankPostCode");
				String bankStatementStatus=request.getParameter("editBankStatementStatus");
				
				Student student=studentServices.getStudentById(studentId);
				Institution institution=institutionServices.getInstitutionById(instituteId);		
				StudentInvoice studentInvoice=studentServices.getStudentInvoiceById(invoiceId);
				
				FeesCollectionRecord feesCollectionRecord=studentServices.getFeesCollectionRecordLazyById(feesCollectionRecordId);
				
				feesCollectionRecord.setStudent(student);
				feesCollectionRecord.setInstitution(institution);
				feesCollectionRecord.setInvoice(studentInvoice);
				feesCollectionRecord.setAmount(amount);
				feesCollectionRecord.setDdorchequeDate(ddOrChequeDate);
				feesCollectionRecord.setPaymentMode(paymentMode);
				feesCollectionRecord.setDdorchequenumber(ddOrChequeNo);
				feesCollectionRecord.setPayableAt(payableAt);
				feesCollectionRecord.setOutstationCheque(outStationCheque);
				feesCollectionRecord.setBankName(bankName);
				feesCollectionRecord.setBankAddressLine1(bankAddressLine1);
				feesCollectionRecord.setBankAddressLine2(bankAddressLine2);
				feesCollectionRecord.setBankCityId(bankCityId);
				feesCollectionRecord.setBankStateId(bankStateId);
				feesCollectionRecord.setBankCountryId(bankCountryId);
				feesCollectionRecord.setFeesCollectionClerk(feesCollectionClerk);
				feesCollectionRecord.setBankPostcode(bankPostCode);
				feesCollectionRecord.setBankStatementStatus(bankStatementStatus);
				feesCollectionRecord.setTallyGLAccount(tallyGLAccount);
				feesCollectionRecord.setRemarks(remarks);
				
				studentServices.updateFeesCollectionRecord(feesCollectionRecord);
			}
			
			
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
	
	@RequestMapping(value="viewProfile",method=RequestMethod.GET)
	@ResponseBody
	public Student editStudentProfile(HttpServletRequest request,RedirectAttributes redirectAttributes) throws Exception
	{
		try {
			
			Student student=studentServices.getStudentLazyById(Integer.parseInt(request.getParameter("studentId")));
			return student;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
	}
	
	@RequestMapping(value="editInvoice",method=RequestMethod.GET)
	@ResponseBody
	public StudentInvoice editInvoice(HttpServletRequest request,RedirectAttributes redirectAttributes) throws Exception
	{
		try {
			
				StudentInvoice student=studentServices.getStudentInvoiceByStudentId(Integer.parseInt(request.getParameter("studentId")));
			
			return student;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
	}
	
/*	@RequestMapping(value="deleteAdmission",method=RequestMethod.POST)
	@ResponseStatus(value=HttpStatus.OK)
	public void deleteAdmission(HttpServletRequest request,RedirectAttributes redirectAttributes) throws Exception
	{
		try {
			studentServices.deleteStudent(Integer.parseInt(request.getParameter("studentId")));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	*/
	/*
	@RequestMapping(value="saveStudentDetails",method = RequestMethod.POST) 
	public String saveStudentDetails(HttpServletRequest request) throws Exception
	{
		try
		{
			DateFormat formatter = new SimpleDateFormat("MM/dd/yy");
			
			String firstName=request.getParameter("firstName");
			String lastName=request.getParameter("lastName");
			String parentOrGuardianFirstName=request.getParameter("parentOrGuardianFirstName");
			String parentOrGuardianLastName=request.getParameter("parentOrGuardianLastName");
			String parentOrGuardianEmail=request.getParameter("parentOrGuardianEmail");
			String eMail=request.getParameter("eMail");
			String contact=request.getParameter("contact");	
			Double fatherIncome=Double.parseDouble(request.getParameter("fatherIncome"));
			Double motherIncome=Double.parseDouble(request.getParameter("motherIncome"));
			Date dateOfBirth= formatter.parse(request.getParameter("dateOfBirth"));
			Date joinedDate=null;
			if(!request.getParameter("joinedDate").isEmpty()){
			     joinedDate= formatter.parse(request.getParameter("joinedDate"));
			}
			
			String addressLine1=request.getParameter("addressLine1");
			String addressLine2=request.getParameter("addressLine2");
			String postCode=request.getParameter("postCode");
			String bankName=request.getParameter("bankName");
			String bankAccountNo=request.getParameter("bankAccountNo");
			String bankIFSCCode=request.getParameter("bankIFSCCode");
			String bankAddress=request.getParameter("bankAddress");
			String tallyAccountNo=request.getParameter("tallyAccountNo");
			String passportNo=request.getParameter("passportNo");
			String batch=request.getParameter("batch");		
			String achievement=request.getParameter("achievement");
			String allergy=request.getParameter("allergy");
			String medicineAllergy=request.getParameter("medicineAllergy");
			String myStrength=request.getParameter("myStrength");
			String studentGender=request.getParameter("studentGender");
			String scholarShip=request.getParameter("scholarShip");
			String atRiskCategory=request.getParameter("atRiskCategory");
			String studentPhoto="";
			String studentSignature="";
			Integer currentSemester=Integer.parseInt(request.getParameter("currentSemester"));
			Integer joinedSemester=Integer.parseInt(request.getParameter("joinedSemester"));	
			Integer countryId=Integer.parseInt(request.getParameter("countryId"));
			Integer stateId=Integer.parseInt(request.getParameter("stateId"));
			Integer cityId=Integer.parseInt(request.getParameter("cityId"));
			
			
			Integer admissionId=Integer.parseInt(request.getParameter("admissionId"));
			Integer categoryId=Integer.parseInt(request.getParameter("categoryId"));
			Integer specialCategoryId=Integer.parseInt(request.getParameter("specialCategoryId"));	
			Integer courseTypeId=Integer.parseInt(request.getParameter("courseTypeId"));
			Integer courseCategoryId=Integer.parseInt(request.getParameter("courseCategoryId"));
			Integer departmentId=Integer.parseInt(request.getParameter("departmentId"));
			Integer courseId=Integer.parseInt(request.getParameter("courseId"));
			Integer feesTemplateListId=Integer.parseInt(request.getParameter("feesTemplateListId"));
			
			int bloodGroupListId=0;
			if(request.getParameter("bloodGroupListId")!=null){
				bloodGroupListId=Integer.parseInt(request.getParameter("bloodGroupListId"));
			}
			
			
			Integer studentStatusId=Integer.parseInt(request.getParameter("studentStatus"));
			String accessNO=request.getParameter("studentAccessNo");
			
			
			Admission admission=admissionServices.getAdmissionDetailsById(admissionId);
			Category category=categoryServices.getCategoryById(categoryId);
			SpecialCategory specialCategory=specialCategoryServices.getSpecialCategoryById(specialCategoryId);
			CourseType courseType=courseServices.getCourseTypeById(courseTypeId);
			CourseCategory courseCategory=courseServices.getCourseCategoryById(courseCategoryId);
			Department department=departmentServices.getDepartmentById(departmentId);
			Courses courses=courseServices.getCourseById(courseId);
			FeesTemplate feesTemplate=feesStructureServices.getFeesTemplateWithTemplateItems(feesTemplateListId);
			BloodGroup bloodGroup=bloodGroupServices.getBloodGroupById(bloodGroupListId);
			StudentStatus studentStatus=studentServices.getStudentStatusById(studentStatusId);
			Institution institution=institutionServices.getInstitutionById(Integer.parseInt(request.getSession().getAttribute("instituteId").toString()));
			Users approver=null;
			if(request.getParameter("approverId")!=null){
				
				approver=staffServices.getStaffById(Integer.parseInt(request.getParameter("approverId"))).getUser();   
				
			}
			
			
			Student student=new Student(courses, category, specialCategory, admission, department, courseCategory, courseType,studentStatus, joinedSemester, currentSemester, firstName, lastName, parentOrGuardianFirstName, parentOrGuardianLastName,parentOrGuardianEmail,studentGender, dateOfBirth, fatherIncome, motherIncome, addressLine1, addressLine2, cityId, stateId, countryId, postCode, eMail, contact, passportNo, studentPhoto, joinedDate,studentSignature, bankName, bankAccountNo, bankIFSCCode, bankAddress, tallyAccountNo, bloodGroup, atRiskCategory, batch, scholarShip, myStrength, allergy, medicineAllergy, achievement,admission.getUser(),accessNO,approver,institution,request.getSession().getAttribute("username").toString());
			StudentInvoice studentInvoice=new StudentInvoice(student,student.getCurrentSemester(),request.getSession().getAttribute("username").toString());
			Set<FeesTemplateItem> feesTemplateItems =feesTemplate.getFeesTemplateItems();
			for(FeesTemplateItem feesTemplateItem:feesTemplateItems){
				StudentInvoiceDetails studentInvoiceDetail=new StudentInvoiceDetails(studentInvoice,feesTemplateItem.getTemplateItemName(),feesTemplateItem.getTemplateItemPrice());
				studentInvoice.getStudentInvoiceDetails().add(studentInvoiceDetail);
			}
			student.getStudentInvoices().add(studentInvoice);
			studentServices.addStudent(student);
			return "redirect:/admissions/newadmission";
				
		}catch(Exception e)
		{
			e.printStackTrace();
			return null;
		}
}*/
}
