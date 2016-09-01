package in.jdsoft.educationmanagement.dao;

import org.springframework.stereotype.Repository;

import in.jdsoft.educationmanagement.model.StudentLeaveType;

@Repository
public class StudentLeaveTypeDAO extends GenericDAO<StudentLeaveType> {
	
     public StudentLeaveTypeDAO() {
    	 super(StudentLeaveType.class);
	}
     
     
     public StudentLeaveType getStudentLeaveTypeById(java.lang.Integer id) {
 		try {
 			StudentLeaveType instance = (StudentLeaveType) sessionFactory.getCurrentSession()
 					.get("in.jdsoft.educationmanagement.model.StudentLeaveType", id);
 			if (instance == null) {
 					//for logging purpose if null
 			} else {
 				//for logging purpose if not null
 			}
 			return instance;
 		} catch (RuntimeException re) {
 			throw re;
 		}
 	}
}
