package in.jdsoft.educationmanagement.school.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import in.jdsoft.educationmanagement.dao.GenericDAO;
import in.jdsoft.educationmanagement.school.model.PaymentMode;

@Repository
public class PaymentModeDAO extends GenericDAO<PaymentMode>{

	public PaymentModeDAO() {
		super(PaymentMode.class);
	}
	
	public PaymentMode getPaymentModeById(java.lang.Integer id) {
		try {
			PaymentMode instance = (PaymentMode) sessionFactory.getCurrentSession()
					.get("in.jdsoft.educationmanagement.school.model.PaymentMode", id);
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
	
	@SuppressWarnings("unchecked")
	public List<PaymentMode> getActivePaymentModes() {
		try {
			Criteria paymentcriteria=sessionFactory.getCurrentSession().createCriteria(PaymentMode.class);
			paymentcriteria.add(Restrictions.eq("visibility",1));
			List<PaymentMode> paymentModes=paymentcriteria.list();
			if (paymentModes == null) {
				//logging
			} else {
				//logging
			}
			return paymentModes;
		} catch (RuntimeException re) {
			throw re;
		}
	}
}
