package in.jdsoft.educationmanagement.components;

import java.util.ArrayList;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.springframework.web.servlet.view.document.AbstractExcelView;

import in.jdsoft.educationmanagement.school.model.Student;

public class StudentExcelWithData extends AbstractExcelView {

	@SuppressWarnings("unchecked")
	@Override
	protected void buildExcelDocument(Map<String, Object> models, HSSFWorkbook workbook, HttpServletRequest arg2,
			HttpServletResponse arg3) throws Exception {
		
		
		ArrayList<Student> students=(ArrayList<Student>)models.get("studentList");
		// create a new Excel sheet
        HSSFSheet sheet = workbook.createSheet("students");
        sheet.setDefaultColumnWidth(30);
        
       // create style for header cells
        CellStyle style = workbook.createCellStyle();
        Font font = workbook.createFont();
        font.setFontName("Arial");
        style.setFillForegroundColor(HSSFColor.BLUE.index);
        style.setFillPattern(CellStyle.SOLID_FOREGROUND);
        font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
        font.setColor(HSSFColor.WHITE.index);
        style.setFont(font);
        
     // create header row
        HSSFRow header = sheet.createRow(0);
        
        header.createCell(0).setCellValue("Student Id");
        header.getCell(0).setCellStyle(style);
        header.createCell(1).setCellValue("Admission No");
        header.getCell(1).setCellStyle(style);
        header.createCell(2).setCellValue("First Name *");
        header.getCell(2).setCellStyle(style);
        header.createCell(3).setCellValue("Last Name");
        header.getCell(3).setCellStyle(style);
        header.createCell(4).setCellValue("Current Class *");
        header.getCell(4).setCellStyle(style);
        header.createCell(5).setCellValue("Current Section *");
        header.getCell(5).setCellStyle(style);
        header.createCell(6).setCellValue("Special Category *");
        header.getCell(6).setCellStyle(style);
        header.createCell(7).setCellValue("Status*");
        header.getCell(7).setCellStyle(style);
        header.createCell(8).setCellValue("Roll No");
        header.getCell(8).setCellStyle(style);
        header.createCell(9).setCellValue("Gender *");
        header.getCell(9).setCellStyle(style);
        header.createCell(10).setCellValue("DOB");
        header.getCell(10).setCellStyle(style);
        header.createCell(11).setCellValue("Category");
        header.getCell(11).setCellStyle(style);
        header.createCell(12).setCellValue("Blood Group");
        header.getCell(12).setCellStyle(style);
        header.createCell(13).setCellValue("Joined Academic Year");
        header.getCell(13).setCellStyle(style);
        header.createCell(14).setCellValue("Student Joined Class");
        header.getCell(14).setCellStyle(style);
        header.createCell(15).setCellValue("Parent Or Guardian First Name");
        header.getCell(15).setCellStyle(style);
        header.createCell(16).setCellValue("Parent Or Guardian Last Name");//
        header.getCell(16).setCellStyle(style);//
        header.createCell(17).setCellValue("Parent Or Guardian Email");
        header.getCell(17).setCellStyle(style);
        header.createCell(18).setCellValue("Address Line 1");
        header.getCell(18).setCellStyle(style);
        header.createCell(19).setCellValue("Address Line 2");
        header.getCell(19).setCellStyle(style);
        header.createCell(20).setCellValue("Postcode");
        header.getCell(20).setCellStyle(style);
        header.createCell(21).setCellValue("Email");
        header.getCell(21).setCellStyle(style);
        header.createCell(22).setCellValue("Contact No");
        header.getCell(22).setCellStyle(style);
        header.createCell(23).setCellValue("Parent Contact NO");
        header.getCell(23).setCellStyle(style);
        header.createCell(24).setCellValue("Joined Date");
        header.getCell(24).setCellStyle(style);
        header.createCell(25).setCellValue("Fathers Income");
        header.getCell(25).setCellStyle(style);
        header.createCell(26).setCellValue("Mothers Income");
        header.getCell(26).setCellStyle(style);
        header.createCell(27).setCellValue("Biometric Access No");
        header.getCell(27).setCellStyle(style);
        header.createCell(28).setCellValue("Passport No");
        header.getCell(28).setCellStyle(style);

        int rowCount = 1;
        
        for (Student student : students) {
            HSSFRow aRow = sheet.createRow(rowCount++);
            aRow.createCell(0).setCellValue(student.getStudentId());
            aRow.createCell(1).setCellValue(student.getAdmissionNo());
            aRow.createCell(2).setCellValue(student.getFirstName());
            aRow.createCell(3).setCellValue(student.getLastName());
            aRow.createCell(8).setCellValue(student.getRollNo());
            aRow.createCell(9).setCellValue(student.getSex());
            if(student.getBirthDate()!=null){
            	 aRow.createCell(10).setCellValue(student.getBirthDate());
            }
           
            aRow.createCell(15).setCellValue(student.getParentGuardianFirstName());
            aRow.createCell(16).setCellValue(student.getParentGuardianLastName());
            aRow.createCell(17).setCellValue(student.getParentGuardianEmail());
            aRow.createCell(18).setCellValue(student.getAddressLine1());
            aRow.createCell(19).setCellValue(student.getAddressLine2());
            aRow.createCell(20).setCellValue(student.getPostcode());
            aRow.createCell(21).setCellValue(student.getEmail());
            aRow.createCell(22).setCellValue(student.getContact());
            aRow.createCell(23).setCellValue(student.getParentContact());
            if(student.getJoinedDate()!=null){
            	aRow.createCell(24).setCellValue(student.getJoinedDate());
            }
            
            if(student.getFathersIncome()!=null){
            	aRow.createCell(25).setCellValue(student.getFathersIncome());
            }
            
            if(student.getMothersIncome()!=null){
            	aRow.createCell(26).setCellValue(student.getMothersIncome());
            }
            aRow.createCell(27).setCellValue(student.getAccessNo());
            aRow.createCell(28).setCellValue(student.getPassportNumber());
            if(student.getStudentClass()!=null){
            	aRow.createCell(4).setCellValue(student.getStudentClass().getClassName());
            }
            
            if(student.getSection()!=null){
            	aRow.createCell(5).setCellValue(student.getSection().getSectionName());
            }
            
            if(student.getBloodGroup()!=null){
            	aRow.createCell(12).setCellValue(student.getBloodGroup().getBloodGroupName());
            }
            if(student.getCategory()!=null){
            	aRow.createCell(11).setCellValue(student.getCategory().getCategoryName());
            }
            
            if(student.getSpecialCategory()!=null){
            	aRow.createCell(6).setCellValue(student.getSpecialCategory().getSpecialCategoryName());
            }
		    if(student.getStudentStatus()!=null){
		    	aRow.createCell(7).setCellValue(student.getStudentStatus().getStatusTitle());  	
		    }
		    if(student.getJoinedAcademicYear()!=null){
		    	aRow.createCell(13).setCellValue(student.getJoinedAcademicYear().getAcademicYearTitle());
		    }
		    if(student.getJoinedClass()!=null){
		    	aRow.createCell(14).setCellValue(student.getJoinedClass().getClassName());
		    }
         
    }
	}

}
