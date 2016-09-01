package in.jdsoft.educationmanagement.dao;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import in.jdsoft.educationmanagement.model.AdmissionConfig;
import in.jdsoft.educationmanagement.model.AdmissionProcessStatus;

@Repository
public class AdmissionConfigDAO extends GenericDAO<AdmissionConfig>{
	
	@Autowired
	AdmissionProcessStatusDAO admissionProcessStatusDAO;
	
	public AdmissionConfigDAO() {
		super(AdmissionConfig.class);
	}
	
	public AdmissionConfig getAdmissionConfigById(java.lang.Integer id) {
		try {
			AdmissionConfig instance = (AdmissionConfig) sessionFactory.getCurrentSession()
					.get("in.jdsoft.educationmanagement.model.AdmissionConfig", id);
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
	
	public AdmissionConfig getCurrentAdmissionConfig() {
		try {
			AdmissionProcessStatus admissionConfigOnGoing=admissionProcessStatusDAO.getAdmissionProcessStatusById(3);
			AdmissionProcessStatus admissionConfigOnHold=admissionProcessStatusDAO.getAdmissionProcessStatusById(1);
			Criteria criteria=sessionFactory.getCurrentSession().createCriteria(AdmissionConfig.class);
			criteria.add(Restrictions.or(Restrictions.eq("admissionProcessStatus",admissionConfigOnGoing),Restrictions.eq("admissionProcessStatus", admissionConfigOnHold)));
			AdmissionConfig admissionConfig=(AdmissionConfig)criteria.uniqueResult();
			if (admissionConfig== null) {
				//logging
			} else {
				//logging
			}
			return admissionConfig;
		} catch (RuntimeException re) {
			throw re;
		}
	}
	
}
