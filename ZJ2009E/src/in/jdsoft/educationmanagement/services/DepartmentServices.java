package in.jdsoft.educationmanagement.services;

import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import in.jdsoft.educationmanagement.dao.DepartmentDAO;
import in.jdsoft.educationmanagement.model.Department;

@Service
public class DepartmentServices {
	
	@Autowired
	DepartmentDAO departmentDAO;

	@Transactional
	public void addDepartment(Department department){
		departmentDAO.persist(department);
	}
	
	/*@Transactional
	public ArrayList<Department> getDepartmentList(){
		return (ArrayList<Department>)departmentDAO.getList();
	}*/
	
	@Transactional
	public void deleteDepartment(int departmentId){
		departmentDAO.delete(departmentDAO.getDepartmentById(departmentId));
	}
	
	@Transactional
	public void updateDepartment(Department department){
		departmentDAO.update(department);
	}
	
	@Transactional
	public Department getDepartmentById(int departmentId){
		try{
				Department department=departmentDAO.getDepartmentById(departmentId);
				
				
				/*Hibernate.initialize(department.getDepartmentHead());*/
				return department;
			}
		catch(Exception e){
			throw e;
			
		}
		
		
	}
	
	@Transactional
	public Department getDepartmentLazyById(int departmentId){
		try{
				Department department=departmentDAO.getDepartmentById(departmentId);
				if(department!=null){
					Hibernate.initialize(department.getDepartmentHead());
				}
				return department;
			}
		catch(Exception e){
			throw e;
		}
		
		
	}
}
