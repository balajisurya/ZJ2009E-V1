package in.jdsoft.educationmanagement.dao;
// Generated Mar 29, 2016 2:42:25 PM by Hibernate Tools 3.4.0.CR1

import org.springframework.stereotype.Repository;

import in.jdsoft.educationmanagement.model.ReceiptDetails;

@Repository
public class ReceiptDetailsDAO extends GenericDAO<ReceiptDetails>{

	public ReceiptDetailsDAO() {
		super(ReceiptDetails.class);
	}

	public ReceiptDetails getReceiptDetailsById(java.lang.Integer id) {
		try {
			ReceiptDetails instance = (ReceiptDetails) sessionFactory.getCurrentSession()
					.get("in.jdsoft.educationmanagement.model.ReceiptDetails", id);
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
}
