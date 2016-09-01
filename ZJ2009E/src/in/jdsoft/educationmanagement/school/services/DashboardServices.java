package in.jdsoft.educationmanagement.school.services;

import java.util.ArrayList;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import in.jdsoft.educationmanagement.reports.model.FourFieldReport;
import in.jdsoft.educationmanagement.reports.model.ThreeFieldReports;
import in.jdsoft.educationmanagement.reports.model.TwoFieldReport;
import in.jdsoft.educationmanagement.school.dao.BloodGroupDAO;
import in.jdsoft.educationmanagement.school.dao.CategoryDAO;
import in.jdsoft.educationmanagement.school.dao.ClassDAO;
import in.jdsoft.educationmanagement.school.dao.InstituteLedgerAccountDAO;
import in.jdsoft.educationmanagement.school.dao.SpecialCategoryDAO;
import in.jdsoft.educationmanagement.school.dao.StudentDAO;
import in.jdsoft.educationmanagement.school.model.BloodGroup;
import in.jdsoft.educationmanagement.school.model.Category;
import in.jdsoft.educationmanagement.school.model.Class;
import in.jdsoft.educationmanagement.school.model.FeesTemplateItem;
import in.jdsoft.educationmanagement.school.model.InstituteLedgerAccount;
import in.jdsoft.educationmanagement.school.model.SpecialCategory;
import in.jdsoft.educationmanagement.school.model.StudentInvoiceDetail;

@Service
public class DashboardServices {

	@Autowired
	StudentDAO studentDAO;
	@Autowired
	SpecialCategoryDAO specialCategoryDAO;
	@Autowired
	BloodGroupDAO bloodGroupDAO;
	@Autowired
	CategoryDAO categoryDAO;
	@Autowired
	InstituteLedgerAccountDAO institutionLedgerAccounDAO;
	@Autowired
	ClassDAO classesDAO;
	
	@Transactional
	public ThreeFieldReports getStudentRatioFromSpecialCategory(Integer SpecialCategoryId){
		SpecialCategory specialCategory=specialCategoryDAO.getSpecialCategoryById(SpecialCategoryId);
		Integer femaleCount=studentDAO.getFemaleStudentCountInSpecialCategory(specialCategory);
		Integer maleCount=studentDAO.getMaleStudentCountInSpecialCategory(specialCategory);
		Integer otherCount=studentDAO.getOtherStudentCountInSpecialCategory(specialCategory);
		return new ThreeFieldReports(maleCount, femaleCount,otherCount);
	}
	
	@Transactional
	public ThreeFieldReports getStudentRatioFromCategory(Integer categoryId){
		Category category=categoryDAO.getCategoryById(categoryId);
		Integer femaleCount=studentDAO.getFemaleStudentCountInCategory(category);
		Integer maleCount=studentDAO.getMaleStudentCountInCategory(category);
		Integer otherCount=studentDAO.getOtherStudentCountInCategory(category);
		return new ThreeFieldReports(maleCount, femaleCount,otherCount);
	}
	
	@Transactional
	public ThreeFieldReports getStudentRatioFromClass(Integer classId){
		Class studentClass=classesDAO.getClassById(classId);
		Integer femaleCount=studentDAO.getFemaleStudentCountInClass(studentClass);
		Integer maleCount=studentDAO.getMaleStudentCountInClass(studentClass);
		Integer othersCount=studentDAO.getOtherStudentCountInClass(studentClass);
		return new ThreeFieldReports(maleCount, femaleCount,othersCount);
	}
	
	@Transactional
	public ArrayList<TwoFieldReport> getBloodGroupWiseStudentCount(){
		ArrayList<BloodGroup> bloodGroups= (ArrayList<BloodGroup>) bloodGroupDAO.getList();
		ArrayList<TwoFieldReport> twoFieldReports=new ArrayList<TwoFieldReport>();
		for (BloodGroup bloodGroup : bloodGroups) {
			Integer studentsCount=bloodGroup.getStudents().size();
			TwoFieldReport report=new TwoFieldReport(bloodGroup.getBloodGroupName(),studentsCount);
			twoFieldReports.add(report);
		}
		return twoFieldReports;
	}
	
	@Transactional
	public ArrayList<FourFieldReport> getFeesItemsReportByLedger(Integer ledgerId){
		InstituteLedgerAccount ledgerAccount= institutionLedgerAccounDAO.getInstituteLedgerAccountById(ledgerId);
		ArrayList<FourFieldReport> fourFieldsReports=new ArrayList<FourFieldReport>();
		if(ledgerAccount!=null){
			Set<FeesTemplateItem> feesTemplateItems = ledgerAccount.getFeesTemplateItems();
			if(feesTemplateItems!=null){
				for (FeesTemplateItem feesTemplateItem : feesTemplateItems) {
					Double invoiceAmount=0.0;
					Double receiptAmount=0.0;
					  Set<StudentInvoiceDetail> invoicedStudentDetailItem=feesTemplateItem.getStudentInvoiceItems();
					  if(invoicedStudentDetailItem!=null){
						  for (StudentInvoiceDetail studentInvoiceDetail : invoicedStudentDetailItem) {
							  invoiceAmount=invoiceAmount+studentInvoiceDetail.getStudentInvoiceElementTotalAmount();
							  
							  if(studentInvoiceDetail.getStudentInvoiceElementPaymentStatus()==2){
								  receiptAmount=receiptAmount+studentInvoiceDetail.getStudentInvoiceElementTotalAmount();
							  }
						  }
						  
					  }
					 
					  fourFieldsReports.add(new FourFieldReport(feesTemplateItem,invoiceAmount,receiptAmount,invoiceAmount-receiptAmount));
				}
				return fourFieldsReports;
			}
			else{
				return null;
			}
		}
		else{
			return null;
		}
	 }
	
	
}
