package in.jdsoft.educationmanagement.school.dao;

import org.springframework.stereotype.Repository;

import in.jdsoft.educationmanagement.dao.GenericDAO;
import in.jdsoft.educationmanagement.school.model.PaymentStatus;

@Repository
public class PaymentStatusDAO extends GenericDAO<PaymentStatus> {

	public PaymentStatusDAO() {
		super(PaymentStatus.class);
	}
	
	public PaymentStatus getPaymentStatusById(java.lang.Integer id) {
		try {
			PaymentStatus instance = (PaymentStatus) sessionFactory.getCurrentSession()
					.get("in.jdsoft.educationmanagement.school.model.PaymentStatus", id);
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
