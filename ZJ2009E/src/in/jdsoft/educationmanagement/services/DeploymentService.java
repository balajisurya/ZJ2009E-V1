/*package in.jdsoft.educationmanagement.services;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import in.jdsoft.educationmanagement.model.MenuLevel1;
import in.jdsoft.educationmanagement.model.MenuLevel2;

@Component
public class DeploymentService {

	@Autowired
	MenuServices menuServices;
	@Autowired
	CurrencyServices currencyService;
	
	private DeploymentService() {
		
	}
	
	
	@PostConstruct
	public void init(){
		System.out.println("executed");
		defaultMenuLevel1();
		defaultMenuLevel2();
	}
	
	public void defaultMenuLevel1(){
		 menuServices.addMenuLevelOne(new MenuLevel1("Dashboard", 1, "/home", "#teachingheadofdepartment#office#principal#librarian#nonteachingadmin", "fa fa-tachometer nav_icon"));
		 menuServices.addMenuLevelOne(new MenuLevel1("Students", 2, "#", "#admin#principal#teachingstaff#teachingheadofdepartment#nonteachingadmin", "fa fa-user nav_icon"));
		 menuServices.addMenuLevelOne(new MenuLevel1("Groups", 5, "/groups", "#admin#office", "fa fa-users nav_icon"));
		 menuServices.addMenuLevelOne(new MenuLevel1("Courses & Department", 4, "#", "#admin#office", "fa fa-graduation-cap nav_icon"));
		 menuServices.addMenuLevelOne(new MenuLevel1("Fees Structure", 9, "#", "#admin#office", "fa fa-money nav_icon"));
		 menuServices.addMenuLevelOne(new MenuLevel1("Fees Details", 5, "/feesdetails", "", "fa fa-money nav_icon"));
		 menuServices.addMenuLevelOne(new MenuLevel1("Attendance", 3, "#", "", "fa fa-pencil nav_icon"));
		 menuServices.addMenuLevelOne(new MenuLevel1("Exam & Results", 7, "/student/examandresults", "#student", "fa fa-info nav_icon"));
		 menuServices.addMenuLevelOne(new MenuLevel1("Library", 10, "#", "#student#teachingstaff", "fa fa-building-o nav_icon"));
		 menuServices.addMenuLevelOne(new MenuLevel1("User Management", 12, "/user", "#nonteachingadmin#admin", "fa fa-cogs nav_icon"));
		 menuServices.addMenuLevelOne(new MenuLevel1("Research", 11, "#", "#teachingstaff#student#librarian", "fa fa-search nav_icon"));
		 menuServices.addMenuLevelOne(new MenuLevel1("Human Resources", 3, "#", "#principal#teachingheadofdepartment#nonteachingadmin", "fa fa-users nav_icon"));
		 menuServices.addMenuLevelOne(new MenuLevel1("Facilities", 5, "/facilities", "#nonteachingadmin", "fa fa-building-o nav_icon"));
		 menuServices.addMenuLevelOne(new MenuLevel1("Approvals", 6, "/approvalsandrequisition/approvals", "#principal#teachingheadofdepartment#nonteachingadmin", "fa fa-key nav_icon"));
		 menuServices.addMenuLevelOne(new MenuLevel1("Events And Time Table", 8, "/events", "#principal#teachingheadofdepartment#nonteachingadmin", "fa fa-table nav_icon"));
		 menuServices.addMenuLevelOne(new MenuLevel1("Communication", 9, "/communication", "#principal#teachingheadofdepartment#nonteachingadmin#teachingstaff", "fa fa-comments nav_icon"));
		 menuServices.addMenuLevelOne(new MenuLevel1("Academics", 4, "/academic/academicdashboard", "#principal", "fa fa-shield nav_icon"));
		 menuServices.addMenuLevelOne(new MenuLevel1("Set up", 4, "#", "#nonteachingadmin", "fa fa-asterisk nav_icon"));
		 menuServices.addMenuLevelOne(new MenuLevel1("Apply For Admission", 2, "/admissions/candidate/applyforadmission", "#admission", "fa fa-pencil nav_icon"));
		 menuServices.addMenuLevelOne(new MenuLevel1("Facilities", 4, "/admissions/candidate/admissionfacilities", "#admission", "fa fa-building-o nav_icon"));
		 menuServices.addMenuLevelOne(new MenuLevel1("Courses", 3, "/admissions/candidate/admissioncourses", "#admission", "fa fa-book nav_icon"));
		 menuServices.addMenuLevelOne(new MenuLevel1("Lessons", 5, "/staff/lessons", "#teachingstaff", "fa fa-book nav_icon"));
		 menuServices.addMenuLevelOne(new MenuLevel1("University Profile", 1, "/home", "#admission", "fa fa-shield nav_icon"));
		 menuServices.addMenuLevelOne(new MenuLevel1("Status & Communication", 6, "/admissions/candidate/statusandcommunication", "#admission", "fa fa-comments-o nav_icon"));
		 menuServices.addMenuLevelOne(new MenuLevel1("Admissions", 11, "#", "#nonteachingadmin#principal", "fa fa-cog nav_icon"));
		 menuServices.addMenuLevelOne(new MenuLevel1("My Profile", 1, "/home", "#student#teachingstaff", "fa fa-user nav_icon"));
		 menuServices.addMenuLevelOne(new MenuLevel1("Events And Time Table", 5, "/student/eventsandtimetable", "#student", "fa fa-share-square-o nav_icon"));
		 menuServices.addMenuLevelOne(new MenuLevel1("Assignments", 4, "#", "", "fa fa-book nav_icon"));
		 menuServices.addMenuLevelOne(new MenuLevel1("My Performance", 2, "/student/myperformance", "#student", "fa fa-info nav_icon"));
		 menuServices.addMenuLevelOne(new MenuLevel1("Collection", 13, "#", "#nonteachingadmin", "fa fa-info nav_icon"));
		 menuServices.addMenuLevelOne(new MenuLevel1("Document Management", 14, "#", "#nonteachingadmin", "fa fa-book nav_icon"));
		 menuServices.addMenuLevelOne(new MenuLevel1("Communication", 8, "/student/studentcommunication", "#student", "fa fa-comments nav_icon"));
		 menuServices.addMenuLevelOne(new MenuLevel1("My Performance", 2, "/staff/myperformance", "#teachingstaff", "fa fa-info nav_icon"));
		 menuServices.addMenuLevelOne(new MenuLevel1("Requisition", 7, "/requisition", "#teachingheadofdepartment#nonteachingadmin#teachingstaff", "fa fa-location-arrow nav_icon"));
		 menuServices.addMenuLevelOne(new MenuLevel1("Lab", 6, "/staff/labs", "#teachingstaff", "fa fa-flask nav_icon"));
		//menuServices.addMenuLevelOne(new MenuLevel1("Institutions", 15, "#", "#headadmin", "fa fa-university nav_icon"));
		 //menuServices.addMenuLevelOne(new MenuLevel1("User Management", 16, "/institutionreports", "#headadmin", "fa fa-bar-chart nav_icon"));
		 //menuServices.addMenuLevelOne(new MenuLevel1("Alerts & Notifications", 9, "/notification", "", "fa fa-bell-o nav_icon"));
		 //menuServices.addMenuLevelOne(new MenuLevel1("Staff", 6, "#", "#admin", "fa fa-users nav_icon"));
		 //menuServices.addMenuLevelOne(new MenuLevel1("Modules Handled", 8, "/hr/teachingstaffmoduleshandled", "", "fa fa-code-fork nav_icon"));
		 //menuServices.addMenuLevelOne(new MenuLevel1("Books", 18, "#", "#librarian", "fa fa-book nav_icon"));
     }
	 
	 
	  public void defaultMenuLevel2(){
		  menuServices.addMenuLevelTwo(new MenuLevel2(menuServices.getMenuLevelOneById(5), "Create Fees Item", 5, "/feestemplate/item", "#admin#office#nonteachingadmin"));
		  menuServices.addMenuLevelTwo(new MenuLevel2(menuServices.getMenuLevelOneById(5), "Create Fees Structure", 6, "/feestemplate", "#admin#office#nonteachingadmin"));
		  menuServices.addMenuLevelTwo(new MenuLevel2(menuServices.getMenuLevelOneById(2), "Invoices", 2, "/student/invoices", "#admin#office#nonteachingadmin"));
		  menuServices.addMenuLevelTwo(new MenuLevel2(menuServices.getMenuLevelOneById(2), "Update Results", 6, "/student/updateResult", "#admin#office#nonteachingadmin"));
		  menuServices.addMenuLevelTwo(new MenuLevel2(menuServices.getMenuLevelOneById(16), "Manage Users", 1, "/institutionusermanagement", "#headadmin"));
		  menuServices.addMenuLevelTwo(new MenuLevel2(menuServices.getMenuLevelOneById(16), "My Profile", 2, "/home", "#headadmin"));
		  menuServices.addMenuLevelTwo(new MenuLevel2(menuServices.getMenuLevelOneById(14), "Add New Institute", 1, "/institutions", "#headadmin"));
		  menuServices.addMenuLevelTwo(new MenuLevel2(menuServices.getMenuLevelOneById(28), "Manage Institute", 2, "/institution", "#nonteachingadmin"));
		  menuServices.addMenuLevelTwo(new MenuLevel2(menuServices.getMenuLevelOneById(13), "Update E- Materials", 1, "#", "#teachingstaff#librarian"));
		  menuServices.addMenuLevelTwo(new MenuLevel2(menuServices.getMenuLevelOneById(13), "E-Materials", 2, "#", "#student#librarian#teachingstaff"));
		  menuServices.addMenuLevelTwo(new MenuLevel2(menuServices.getMenuLevelOneById(13), "Library Account", 3, "#", "#teachingstaff#student"));
		  menuServices.addMenuLevelTwo(new MenuLevel2(menuServices.getMenuLevelOneById(28), "Manage Module", 4, "/course/module", "#admin#office#nonteachingadmin"));
		  menuServices.addMenuLevelTwo(new MenuLevel2(menuServices.getMenuLevelOneById(28), "Manage Course", 1, "/course", "#admin#office#nonteachingadmin"));
		  menuServices.addMenuLevelTwo(new MenuLevel2(menuServices.getMenuLevelOneById(22), "Manage Staff", 1, "/staff/manage", "#admin#nonteachingadmin"));
		  menuServices.addMenuLevelTwo(new MenuLevel2(menuServices.getMenuLevelOneById(22), "Allocate Module", 2, "/staff/allocatemodules", "#admin#nonteachingadmin#teachingheadofdepartment"));
		  menuServices.addMenuLevelTwo(new MenuLevel2(menuServices.getMenuLevelOneById(19), "Projects", 1, "#", ""));
		  menuServices.addMenuLevelTwo(new MenuLevel2(menuServices.getMenuLevelOneById(19), "Data", 2, "#", ""));
		  menuServices.addMenuLevelTwo(new MenuLevel2(menuServices.getMenuLevelOneById(19), "Update Project", 3, "#", "#admin#librarian"));
		  menuServices.addMenuLevelTwo(new MenuLevel2(menuServices.getMenuLevelOneById(21), "Manage Books", 1, "#", "#librarian"));
		  menuServices.addMenuLevelTwo(new MenuLevel2(menuServices.getMenuLevelOneById(21), "Allocate Book", 2, "#", "#librarian"));
		  menuServices.addMenuLevelTwo(new MenuLevel2(menuServices.getMenuLevelOneById(2), "Student Profile", 1, "/student/studentProfile", "#admin#principal#nonteachingadmin#teachingheadofdepartment"));
		  menuServices.addMenuLevelTwo(new MenuLevel2(menuServices.getMenuLevelOneById(2), "Student Attendance", 3, "/student/studentattendance", "#admin##principal#nonteachingadmin#teachingheadofdepartment"));
		  menuServices.addMenuLevelTwo(new MenuLevel2(menuServices.getMenuLevelOneById(22), "Staff Attendance", 3, "/staff/attendance", "#admin#nonteachingadmin#principal#teachingheadofdepartment"));
		  menuServices.addMenuLevelTwo(new MenuLevel2(menuServices.getMenuLevelOneById(28), "Manage Department", 3, "/department", "#admin#office#nonteachingadmin"));
		  menuServices.addMenuLevelTwo(new MenuLevel2(menuServices.getMenuLevelOneById(28), "Academic Year", 7, "/academic/academicyear", "#admin#nonteachingadmin"));
		  menuServices.addMenuLevelTwo(new MenuLevel2(menuServices.getMenuLevelOneById(35), "Notifications", 3, "/admissions/notification", "#nonteachingadmin"));
		  menuServices.addMenuLevelTwo(new MenuLevel2(menuServices.getMenuLevelOneById(35), "Admissions Configuration", 2, "/admissions/admissionconfig", "#nonteachingadmin"));
		  menuServices.addMenuLevelTwo(new MenuLevel2(menuServices.getMenuLevelOneById(35), "Admissions Status", 4, "/admissions/admissionStatus", ""));
		  menuServices.addMenuLevelTwo(new MenuLevel2(menuServices.getMenuLevelOneById(35), "Generate List", 5, "/admissions/generateList", ""));
		  menuServices.addMenuLevelTwo(new MenuLevel2(menuServices.getMenuLevelOneById(35), "Finalisation", 6, "/admissions/finalization", "#nonteachingadmin"));
		  menuServices.addMenuLevelTwo(new MenuLevel2(menuServices.getMenuLevelOneById(35), "Admissions Dashboard", 1, "/admissions/admissiondashboard", "#nonteachingadmin#principal"));
		  menuServices.addMenuLevelTwo(new MenuLevel2(menuServices.getMenuLevelOneById(40), "Data Entry", 1, "/collection/dataentry", "#nonteachingadmin"));
		  menuServices.addMenuLevelTwo(new MenuLevel2(menuServices.getMenuLevelOneById(40), "Recon", 2, "/collection/reconcilation", "#nonteachingadmin"));
		  menuServices.addMenuLevelTwo(new MenuLevel2(menuServices.getMenuLevelOneById(41), "Index Entry", 1, "/documentmanagement/indexentry", "#nonteachingadmin#principal"));
		  menuServices.addMenuLevelTwo(new MenuLevel2(menuServices.getMenuLevelOneById(41), "Digitization", 2, "/documentmanagement/digitalization", "#nonteachingadmin#principal"));
		  menuServices.addMenuLevelTwo(new MenuLevel2(menuServices.getMenuLevelOneById(41), "Index Search", 3, "/documentmanagement/searchentry", "#nonteachingadmin#principal"));
		  menuServices.addMenuLevelTwo(new MenuLevel2(menuServices.getMenuLevelOneById(28), "Manage Group", 2, "/group", "#admin#office#nonteachingadmin"));
		  menuServices.addMenuLevelTwo(new MenuLevel2(menuServices.getMenuLevelOneById(35), "menuServices.addMenuLevelTwo(new MenuLevel2(menuServices.getMenuLevelOneById(New) Student Registration", 7, "/admissions/newadmission", "#admin#office#nonteachingadmin"));
		  menuServices.addMenuLevelTwo(new MenuLevel2(menuServices.getMenuLevelOneById(22), "Staff Category", 4, "/staff/category", "#admin#nonteachingadmin"));
		  menuServices.addMenuLevelTwo(new MenuLevel2(menuServices.getMenuLevelOneById(22), "Staff Profiles", 5, "/staff/staffprofile", "#admin#nonteachingadmin#principal#teachingheadofdepartment"));
		  menuServices.addMenuLevelTwo(new MenuLevel2(menuServices.getMenuLevelOneById(2), "Take Attendance", 1, "/staff/studentattendance", "#teachingstaff"));
		  menuServices.addMenuLevelTwo(new MenuLevel2(menuServices.getMenuLevelOneById(2), "Assignments", 2, "/staff/assignments", "#teachingstaff"));
		 
	  }
	  
	  menuServices.addMenuLevelTwo(new MenuLevel2(menuServices.getMenuLevelOneById(5), "Create Fees Item", 5, "/feestemplate/item", "#admin#office#nonteachingadmin"));
	  menuServices.addMenuLevelTwo(new MenuLevel2(menuServices.getMenuLevelOneById(5), "Create Fees Structure", 6, "/feestemplate", "#admin#office#nonteachingadmin"));
	  menuServices.addMenuLevelTwo(new MenuLevel2(menuServices.getMenuLevelOneById(2), "Invoices", 2, "/student/invoices", "#admin#office#nonteachingadmin"));
	  menuServices.addMenuLevelTwo(new MenuLevel2(menuServices.getMenuLevelOneById(2), "Update Results", 6, "/student/updateResult", "#admin#office#nonteachingadmin"));
	  menuServices.addMenuLevelTwo(new MenuLevel2(menuServices.getMenuLevelOneById(18), "Manage Institute", 2, "/institution", "#nonteachingadmin"));
	  menuServices.addMenuLevelTwo(new MenuLevel2(menuServices.getMenuLevelOneById(9), "Update E- Materials", 1, "#", "#teachingstaff#librarian"));
	  menuServices.addMenuLevelTwo(new MenuLevel2(menuServices.getMenuLevelOneById(9), "E-Materials", 2, "#", "#student#librarian#teachingstaff"));
	  menuServices.addMenuLevelTwo(new MenuLevel2(menuServices.getMenuLevelOneById(9), "Library Account", 3, "#", "#teachingstaff#student"));
	  menuServices.addMenuLevelTwo(new MenuLevel2(menuServices.getMenuLevelOneById(18), "Manage Module", 4, "/course/module", "#admin#office#nonteachingadmin"));
	  menuServices.addMenuLevelTwo(new MenuLevel2(menuServices.getMenuLevelOneById(18), "Manage Course", 1, "/course", "#admin#office#nonteachingadmin"));
	  menuServices.addMenuLevelTwo(new MenuLevel2(menuServices.getMenuLevelOneById(12), "Manage Staff", 1, "/staff/manage", "#admin#nonteachingadmin"));
	  menuServices.addMenuLevelTwo(new MenuLevel2(menuServices.getMenuLevelOneById(12), "Allocate Module", 2, "/staff/allocatemodules", "#admin#nonteachingadmin#teachingheadofdepartment"));
	  menuServices.addMenuLevelTwo(new MenuLevel2(menuServices.getMenuLevelOneById(11), "Projects", 1, "#", ""));
	  menuServices.addMenuLevelTwo(new MenuLevel2(menuServices.getMenuLevelOneById(11), "Data", 2, "#", ""));
	  menuServices.addMenuLevelTwo(new MenuLevel2(menuServices.getMenuLevelOneById(11), "Update Project", 3, "#", "#admin#librarian"));
	  ;
	  menuServices.addMenuLevelTwo(new MenuLevel2(menuServices.getMenuLevelOneById(2), "Student Profile", 1, "/student/studentProfile", "#admin#principal#nonteachingadmin#teachingheadofdepartment"));
	  menuServices.addMenuLevelTwo(new MenuLevel2(menuServices.getMenuLevelOneById(2), "Student Attendance", 3, "/student/studentattendance", "#admin##principal#nonteachingadmin#teachingheadofdepartment"));
	  menuServices.addMenuLevelTwo(new MenuLevel2(menuServices.getMenuLevelOneById(12), "Staff Attendance", 3, "/staff/attendance", "#admin#nonteachingadmin#principal#teachingheadofdepartment"));
	  menuServices.addMenuLevelTwo(new MenuLevel2(menuServices.getMenuLevelOneById(18), "Manage Department", 3, "/department", "#admin#office#nonteachingadmin"));
	  menuServices.addMenuLevelTwo(new MenuLevel2(menuServices.getMenuLevelOneById(18), "Academic Year", 7, "/academic/academicyear", "#admin#nonteachingadmin"));
	  menuServices.addMenuLevelTwo(new MenuLevel2(menuServices.getMenuLevelOneById(25), "Notifications", 3, "/admissions/notification", "#nonteachingadmin"));
	  menuServices.addMenuLevelTwo(new MenuLevel2(menuServices.getMenuLevelOneById(25), "Admissions Configuration", 2, "/admissions/admissionconfig", "#nonteachingadmin"));
	  menuServices.addMenuLevelTwo(new MenuLevel2(menuServices.getMenuLevelOneById(25), "Admissions Status", 4, "/admissions/admissionStatus", ""));
	  menuServices.addMenuLevelTwo(new MenuLevel2(menuServices.getMenuLevelOneById(25), "Generate List", 5, "/admissions/generateList", ""));
	  menuServices.addMenuLevelTwo(new MenuLevel2(menuServices.getMenuLevelOneById(25), "Finalisation", 6, "/admissions/finalization", "#nonteachingadmin"));
	  menuServices.addMenuLevelTwo(new MenuLevel2(menuServices.getMenuLevelOneById(25), "Admissions Dashboard", 1, "/admissions/admissiondashboard", "#nonteachingadmin#principal"));
	  menuServices.addMenuLevelTwo(new MenuLevel2(menuServices.getMenuLevelOneById(30), "Data Entry", 1, "/collection/dataentry", "#nonteachingadmin"));
	  menuServices.addMenuLevelTwo(new MenuLevel2(menuServices.getMenuLevelOneById(30), "Recon", 2, "/collection/reconcilation", "#nonteachingadmin"));
	  menuServices.addMenuLevelTwo(new MenuLevel2(menuServices.getMenuLevelOneById(31), "Index Entry", 1, "/documentmanagement/indexentry", "#nonteachingadmin#principal"));
	  menuServices.addMenuLevelTwo(new MenuLevel2(menuServices.getMenuLevelOneById(31), "Digitization", 2, "/documentmanagement/digitalization", "#nonteachingadmin#principal"));
	  menuServices.addMenuLevelTwo(new MenuLevel2(menuServices.getMenuLevelOneById(31), "Index Search", 3, "/documentmanagement/searchentry", "#nonteachingadmin#principal"));
	  menuServices.addMenuLevelTwo(new MenuLevel2(menuServices.getMenuLevelOneById(18), "Manage Group", 2, "/group", "#admin#office#nonteachingadmin"));
	  
	  public void defaultAdmissionProcessStatus(){
		  admissionService.addAdmissionProcessStatus(new AdmissionProcessStatus("Closed"));
		  admissionService.addAdmissionProcessStatus(new AdmissionProcessStatus("On Going"));
		  admissionService.addAdmissionProcessStatus(new AdmissionProcessStatus("On Hold"));
	  }
	  
	  public void defaultCurrency(){
		  currencyService.addCurrency(new Currency("KRW", "(South) Korean Won"));
		  currencyService.addCurrency(new Currency("AFA", "Afghanistan Afghani"));
		  currencyService.addCurrency(new Currency("ALL", "Albanian Lek"));
		  currencyService.addCurrency(new Currency("DZD", "Algerian Dinar"));
		  currencyService.addCurrency(new Currency("ADP", "Andorran Peseta"));
		  currencyService.addCurrency(new Currency("AOK", "Angolan Kwanza"));
		  currencyService.addCurrency(new Currency("ARS", "Argentine Peso"));
		  currencyService.addCurrency(new Currency("AMD", "Armenian Dram"));
		  currencyService.addCurrency(new Currency("AWG", "Aruban Florin"));
		  currencyService.addCurrency(new Currency("AUD", "Australian Dollar"));
		  currencyService.addCurrency(new Currency("BSD", "Bahamian Dollar"));
		  currencyService.addCurrency(new Currency("BHD", "Bahraini Dinar"));
		  currencyService.addCurrency(new Currency("BDT", "Bangladeshi Taka"));
		  currencyService.addCurrency(new Currency("BBD", "Barbados Dollar"));
		  currencyService.addCurrency(new Currency("BZD", "Belize Dollar"));
		  currencyService.addCurrency(new Currency("BMD", "Bermudian Dollar"));
		  currencyService.addCurrency(new Currency("BTN", "Bhutan Ngultrum"));
		  currencyService.addCurrency(new Currency("BOB", "Bolivian Boliviano"));
		  currencyService.addCurrency(new Currency("BWP", "Botswanian Pula"));
		  currencyService.addCurrency(new Currency("BRL", "Brazilian Real"));
		  currencyService.addCurrency(new Currency("GBP", "British Pound"));
		  currencyService.addCurrency(new Currency("BND", "Brunei Dollar"));
		  currencyService.addCurrency(new Currency("BGN", "Bulgarian Lev"));
		  currencyService.addCurrency(new Currency("BUK", "Burma Kyat"));
		  currencyService.addCurrency(new Currency("BIF", "Burundi Franc"));
		  currencyService.addCurrency(new Currency("CAD", "Canadian Dollar"));
		  currencyService.addCurrency(new Currency("CVE", "Cape Verde Escudo"));
		  currencyService.addCurrency(new Currency("KYD", "Cayman Islands Dollar"));
		  currencyService.addCurrency(new Currency("CLP", "Chilean Peso"));
		  currencyService.addCurrency(new Currency("CLF", "Chilean Unidades De Fomento"));
		  currencyService.addCurrency(new Currency("COP", "Colombian Peso"));
		  currencyService.addCurrency(new Currency("XOF", "Communauté Financière Africaine BCEAO - Francs"));
		  currencyService.addCurrency(new Currency("XAF", "Communauté Financière Africaine BEAC, Francs"));
		  currencyService.addCurrency(new Currency("KMF", "Comoros Franc"));
		  currencyService.addCurrency(new Currency("XPF", "Comptoirs Français Du Pacifique Francs"));
		  currencyService.addCurrency(new Currency("CRC", "Costa Rican Colon"));
		  currencyService.addCurrency(new Currency("CUP", "Cuban Peso"));
		  currencyService.addCurrency(new Currency("CYP", "Cyprus Pound"));
		  currencyService.addCurrency(new Currency("CZK", "Czech Republic Koruna"));
		  currencyService.addCurrency(new Currency("DKK", "Danish Krone"));
		  currencyService.addCurrency(new Currency("YDD", "Democratic Yemeni Dinar"));
		  currencyService.addCurrency(new Currency("DOP", "Dominican Peso"));
		  currencyService.addCurrency(new Currency("XCD", "East Caribbean Dollar"));
		  currencyService.addCurrency(new Currency("TPE", "East Timor Escudo"));
		  currencyService.addCurrency(new Currency("ECS", "Ecuador Sucre"));
		  currencyService.addCurrency(new Currency("EGP", "Egyptian Pound"));
		  currencyService.addCurrency(new Currency("SVC", "El Salvador Colon"));
		  currencyService.addCurrency(new Currency("EEK", "Estonian Kroon (EEK)"));
		  currencyService.addCurrency(new Currency("ETB", "Ethiopian Birr"));
		  currencyService.addCurrency(new Currency("EUR", "Euro"));
		  currencyService.addCurrency(new Currency("FKP", "Falkland Islands Pound"));
		  currencyService.addCurrency(new Currency("FJD", "Fiji Dollar"));
		  currencyService.addCurrency(new Currency("GMD", "Gambian Dalasi"));
		  currencyService.addCurrency(new Currency("GHC", "Ghanaian Cedi"));
		  currencyService.addCurrency(new Currency("GIP", "Gibraltar Pound"));
		  currencyService.addCurrency(new Currency("XAU", "Gold, Ounces"));
		  currencyService.addCurrency(new Currency("GTQ", "Guatemalan Quetzal"));
		  currencyService.addCurrency(new Currency("GNF", "Guinea Franc"));
		  currencyService.addCurrency(new Currency("GWP", "Guinea-Bissau Peso"));
		  currencyService.addCurrency(new Currency("GYD", "Guyanan Dollar"));
		  currencyService.addCurrency(new Currency("HTG", "Haitian Gourde"));
		  currencyService.addCurrency(new Currency("HNL", "Honduran Lempira"));
		  currencyService.addCurrency(new Currency("HKD", "Hong Kong Dollar"));
		  currencyService.addCurrency(new Currency("HUF", "Hungarian Forint"));
		  currencyService.addCurrency(new Currency("INR", "Indian Rupee"));
		  currencyService.addCurrency(new Currency("IDR", "Indonesian Rupiah"));
		  currencyService.addCurrency(new Currency("XDR", "International Monetary Fund (IMF) Special Drawing Rights"));
		  currencyService.addCurrency(new Currency("IRR", "Iranian Rial"));
		  currencyService.addCurrency(new Currency("IQD", "Iraqi Dinar"));
		  currencyService.addCurrency(new Currency("IEP", "Irish Punt"));
		  currencyService.addCurrency(new Currency("ILS", "Israeli Shekel"));
		  currencyService.addCurrency(new Currency("JMD", "Jamaican Dollar"));
		  currencyService.addCurrency(new Currency("JPY", "Japanese Yen"));
		  currencyService.addCurrency(new Currency("JOD", "Jordanian Dinar"));
		  currencyService.addCurrency(new Currency("KHR", "Kampuchean (Cambodian) Riel"));
		  currencyService.addCurrency(new Currency("KES", "Kenyan Schilling"));
		  currencyService.addCurrency(new Currency("KWD", "Kuwaiti Dinar"));
		  currencyService.addCurrency(new Currency("LAK", "Lao Kip"));
		  currencyService.addCurrency(new Currency("LBP", "Lebanese Pound"));
		  currencyService.addCurrency(new Currency("LSL", "Lesotho Loti"));
		  currencyService.addCurrency(new Currency("LRD", "Liberian Dollar"));
		  currencyService.addCurrency(new Currency("LYD", "Libyan Dinar"));
		  currencyService.addCurrency(new Currency("MOP", "Macau Pataca"));
		  currencyService.addCurrency(new Currency("MGF", "Malagasy Franc"));
		  currencyService.addCurrency(new Currency("MWK", "Malawi Kwacha"));
		  currencyService.addCurrency(new Currency("MYR", "Malaysian Ringgit"));
		  currencyService.addCurrency(new Currency("MVR", "Maldive Rufiyaa"));
		  currencyService.addCurrency(new Currency("MTL", "Maltese Lira"));
		  currencyService.addCurrency(new Currency("MRO", "Mauritanian Ouguiya"));
		  currencyService.addCurrency(new Currency("MUR", "Mauritius Rupee"));
		  currencyService.addCurrency(new Currency("MXP", "Mexican Peso"));
		  currencyService.addCurrency(new Currency("MNT", "Mongolian Tugrik"));
		  currencyService.addCurrency(new Currency("MAD", "Moroccan Dirham"));
		  currencyService.addCurrency(new Currency("MZM", "Mozambique Metical"));
		  currencyService.addCurrency(new Currency("NAD", "Namibian Dollar"));
		  currencyService.addCurrency(new Currency("NPR", "Nepalese Rupee"));
		  currencyService.addCurrency(new Currency("ANG", "Netherlands Antillian Guilder"));
		  currencyService.addCurrency(new Currency("YUD", "New Yugoslavia Dinar"));
		  currencyService.addCurrency(new Currency("NZD", "New Zealand Dollar"));
		  currencyService.addCurrency(new Currency("NIO", "Nicaraguan Cordoba"));
		  currencyService.addCurrency(new Currency("NGN", "Nigerian Naira"));
		  currencyService.addCurrency(new Currency("KPW", "North Korean Won"));
		  currencyService.addCurrency(new Currency("NOK", "Norwegian Kroner"));
		  currencyService.addCurrency(new Currency("OMR", "Omani Rial"));
		  currencyService.addCurrency(new Currency("PKR", "Pakistan Rupee"));
		  currencyService.addCurrency(new Currency("XPD", "Palladium Ounces"));
		  currencyService.addCurrency(new Currency("PAB", "Panamanian Balboa"));
		  currencyService.addCurrency(new Currency("PGK", "Papua New Guinea Kina"));
		  currencyService.addCurrency(new Currency("PYG", "Paraguay Guarani"));
		  currencyService.addCurrency(new Currency("PEN", "Peruvian Nuevo Sol"));
		  currencyService.addCurrency(new Currency("PHP", "Philippine Peso"));
		  currencyService.addCurrency(new Currency("XPT", "Platinum, Ounces"));
		  currencyService.addCurrency(new Currency("PLN", "Polish Zloty"));
		  currencyService.addCurrency(new Currency("QAR", "Qatari Rial"));
		  currencyService.addCurrency(new Currency("RON", "Romanian Leu"));
		  currencyService.addCurrency(new Currency("RUB", "Russian Ruble"));
		  currencyService.addCurrency(new Currency("RWF", "Rwanda Franc"));
		  currencyService.addCurrency(new Currency("WST", "Samoan Tala"));
		  currencyService.addCurrency(new Currency("STD", "Sao Tome And Principe Dobra"));
		  currencyService.addCurrency(new Currency("SAR", "Saudi Arabian Riyal"));
		  currencyService.addCurrency(new Currency("SCR", "Seychelles Rupee"));
		  currencyService.addCurrency(new Currency("SLL", "Sierra Leone Leone"));
		  currencyService.addCurrency(new Currency("XAG", "Silver, Ounces"));
		  currencyService.addCurrency(new Currency("SGD", "Singapore Dollar"));
		  currencyService.addCurrency(new Currency("SKK", "Slovak Koruna"));
		  currencyService.addCurrency(new Currency("SBD", "Solomon Islands Dollar"));
		  currencyService.addCurrency(new Currency("SOS", "Somali Schilling"));
		  currencyService.addCurrency(new Currency("ZAR", "South African Rand"));
		  currencyService.addCurrency(new Currency("LKR", "Sri Lanka Rupee"));
		  currencyService.addCurrency(new Currency("SHP", "St. Helena Pound"));
		  currencyService.addCurrency(new Currency("SDP", "Sudanese Pound"));
		  currencyService.addCurrency(new Currency("SRG", "Suriname Guilder"));
		  currencyService.addCurrency(new Currency("SZL", "Swaziland Lilangeni"));
		  currencyService.addCurrency(new Currency("SEK", "Swedish Krona"));
		  currencyService.addCurrency(new Currency("CHF", "Swiss Franc"));
		  currencyService.addCurrency(new Currency("SYP", "Syrian Potmd"));
		  currencyService.addCurrency(new Currency("TWD", "Taiwan Dollar"));
		  currencyService.addCurrency(new Currency("TZS", "Tanzanian Schilling"));
		  currencyService.addCurrency(new Currency("THB", "Thai Baht"));
		  currencyService.addCurrency(new Currency("TOP", "Tongan Paanga"));
		  currencyService.addCurrency(new Currency("TTD", "Trinidad And Tobago Dollar"));
		  currencyService.addCurrency(new Currency("TND", "Tunisian Dinar"));
		  currencyService.addCurrency(new Currency("TRY", "Turkish Lira"));
		  currencyService.addCurrency(new Currency("UGX", "Uganda Shilling"));
		  currencyService.addCurrency(new Currency("AED", "United Arab Emirates Dirham"));
		  currencyService.addCurrency(new Currency("UYU", "Uruguayan Peso"));
		  currencyService.addCurrency(new Currency("USD", "US Dollar"));
		  currencyService.addCurrency(new Currency("VUV", "Vanuatu Vatu"));
		  currencyService.addCurrency(new Currency("VEF", "Venezualan Bolivar"));
		  currencyService.addCurrency(new Currency("VND", "Vietnamese Dong"));
		  currencyService.addCurrency(new Currency("YER", "Yemeni Rial"));
		  currencyService.addCurrency(new Currency("CNY", "Yuan (Chinese) Renminbi"));
		  currencyService.addCurrency(new Currency("ZRZ", "Zaire Zaire"));
		  currencyService.addCurrency(new Currency("ZMK", "Zambian Kwacha"));
		  currencyService.addCurrency(new Currency("ZWD", "Zimbabwe Dollar"));
	  }
	  
	  public void defaultAdmissionStatus(){
		  admissionService.addAdmissionStatus(new AdmissionStatus("Pending"));
		  admissionService.addAdmissionStatus(new AdmissionStatus("Rejected"));
		  admissionService.addAdmissionStatus(new AdmissionStatus("Saved"));
		  admissionService.addAdmissionStatus(new AdmissionStatus("Selected and Paid"));
		  admissionService.addAdmissionStatus(new AdmissionStatus("Selected But Not Paid"));
		  admissionService.addAdmissionStatus(new AdmissionStatus("Submitted"));
	  }
	  
}
*/