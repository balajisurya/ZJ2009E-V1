package in.jdsoft.educationmanagement.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

import in.jdsoft.educationmanagement.model.Department;
import in.jdsoft.educationmanagement.model.Institution;
import in.jdsoft.educationmanagement.model.Staff;
import in.jdsoft.educationmanagement.services.DepartmentServices;
import in.jdsoft.educationmanagement.services.InstitutionServices;
import in.jdsoft.educationmanagement.services.StaffServices;

@Controller
@RequestMapping("/department")
public class DepartmentController {

	@Autowired
	DepartmentServices departmentServices;
	@Autowired
	StaffServices staffServices;
	@Autowired
	InstitutionServices institutionServices;
	
	@RequestMapping
	public ModelAndView displayDepartmentPage(HttpServletRequest request){
		try {
			ModelAndView modelandview=new ModelAndView("department");
			Integer instituteId=Integer.parseInt(request.getSession().getAttribute("instituteId").toString());
			modelandview.addObject("departmentlist",institutionServices.getInstituteDepartments(instituteId));
			modelandview.addObject("staffList",staffServices.getStaffList());
			return modelandview;
		} catch (Exception e) {
			e.printStackTrace();
			throw null;
		}
	
	}
	
	@RequestMapping(value="add",method = RequestMethod.POST)
	public ModelAndView addDepartment(HttpServletRequest request){
		try {
			String departmentName=request.getParameter("department-name");
			Staff departmentHead=null;
			String createdBy=request.getSession().getAttribute("username").toString();
			try {
				Integer staffId=Integer.parseInt(request.getParameter("head-staff-id"));
				departmentHead=staffServices.getStaffById(staffId);
			} catch (NumberFormatException e) {
				departmentHead=staffServices.getStaffById(0);
			}
			Institution institution=institutionServices.getInstitutionById(Integer.parseInt(request.getSession().getAttribute("instituteId").toString()));
			Department department=new Department(departmentName,createdBy,departmentHead,institution);
			departmentServices.addDepartment(department);
			return new ModelAndView("/department");
		} catch (Exception e) {
			e.printStackTrace();
			return new ModelAndView("/department");
		}
		
	}
	
	@RequestMapping(value="delete")
	public String deleteDepartment(HttpServletRequest request){
		try {
			int departmentId=Integer.parseInt(request.getParameter("departmentId"));
			departmentServices.deleteDepartment(departmentId);
			return "redirect:/department";
		} catch (Exception e) {
			e.printStackTrace();
			return "redirect:/department";
		}
		
	}
	
	@RequestMapping(value="update",method = RequestMethod.POST)
	@ResponseStatus(value=HttpStatus.OK)
	public void updateDepartment(HttpServletRequest request){
		try {
			int departmentId=Integer.parseInt(request.getParameter("departmentId"));
			
			String departmentName=request.getParameter("editDepartmentName");
			
			Staff departmentHead=null;		
			try {
				Integer staffId=Integer.parseInt(request.getParameter("editHeadStaffId"));
				departmentHead=staffServices.getStaffById(staffId);
			} catch (NumberFormatException e) {
				departmentHead=staffServices.getStaffById(0);
			}
			Department department=departmentServices.getDepartmentById(departmentId);
			department.setDepartmentName(departmentName);
			department.setDepartmentHead(departmentHead);
			department.setModifiedBy(request.getSession().getAttribute("username").toString());
		    departmentServices.updateDepartment(department);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@RequestMapping(value="getDepartment",method = RequestMethod.GET)
	@ResponseBody
	public Department getDepartment(HttpServletRequest request,HttpServletRequest response)
	{
		try {
			
			Integer departmentId= Integer.parseInt(request.getParameter("departmentId"));
			Department department=departmentServices.getDepartmentLazyById(departmentId);
			return department;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
			
		
	}
	
	/*@RequestMapping(value="list")
	public ModelAndView listDepartment(HttpServletRequest request, HttpServletResponse response) throws IOException{
		int departmentId=Integer.parseInt(request.getParameter("departmentId"));
		Department department=departmentServices.getDepartmentById(departmentId);
		String json = new Gson().toJson(department);
        response.setContentType("application/json");
        response.getWriter().write(json);
		return new ModelAndView("/department");
	}*/
}
