package in.jdsoft.educationmanagement.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import in.jdsoft.educationmanagement.model.Admission;
import in.jdsoft.educationmanagement.model.CourseCategory;
import in.jdsoft.educationmanagement.model.Courses;

@Repository
public class AdmissionDAO extends GenericDAO<Admission>{

	public AdmissionDAO() {
		super(Admission.class);
	}
	
	public Admission getAdmissionById(java.lang.Integer id) {
		try {
			Admission instance = (Admission) sessionFactory.getCurrentSession()
					.get("in.jdsoft.educationmanagement.model.Admission", id);
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
	
	@SuppressWarnings("unchecked")
	public List<Admission> getApplicants(Courses course,CourseCategory courseCategory) {
		try {
			Criteria applicantCriteria=sessionFactory.getCurrentSession().createCriteria(Admission.class);
			applicantCriteria.add(Restrictions.conjunction().add(Restrictions.eq("course", course)).add(Restrictions.eq("courseCategory",courseCategory)));
			List<Admission> admissionList=(List<Admission>)applicantCriteria.list();
			if (admissionList == null) {
				//logging
			} else {
				//logging
			}
			return admissionList;
		} catch (RuntimeException re) {
			throw re;
		}
	}
}
