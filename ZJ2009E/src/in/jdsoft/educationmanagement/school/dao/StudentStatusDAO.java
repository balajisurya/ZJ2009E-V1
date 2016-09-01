package in.jdsoft.educationmanagement.school.dao;
// Generated Mar 29, 2016 2:42:25 PM by Hibernate Tools 3.4.0.CR1

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import in.jdsoft.educationmanagement.dao.GenericDAO;
import in.jdsoft.educationmanagement.school.model.StudentStatus;


@Repository
public class StudentStatusDAO extends GenericDAO<StudentStatus>{

	public StudentStatusDAO() {
		super(StudentStatus.class);
	}
	
	public StudentStatus getStudentStatusById(java.lang.Integer id) {
		try {
			StudentStatus instance = (StudentStatus) sessionFactory.getCurrentSession()
					.get("in.jdsoft.educationmanagement.school.model.StudentStatus", id);
			if (instance == null) {
				//logging
			} else {
				//logging
			}
			return instance;
		} catch (RuntimeException re) {
			throw re;
		}
	}
	
	public StudentStatus getStudentStatusByName(String studentStatusTitle){
		try {
			Criteria criteria=sessionFactory.getCurrentSession().createCriteria(StudentStatus.class);
			criteria.add(Restrictions.conjunction()
					 .add(Restrictions.eq("statusTitle",studentStatusTitle)));
			StudentStatus studentStatus=(StudentStatus)criteria.uniqueResult();
			if (studentStatus == null) {
				//logging
			} else {
				//logging
			}
			return studentStatus;
		} catch (RuntimeException re) {
			throw re;
		}
	}
}
