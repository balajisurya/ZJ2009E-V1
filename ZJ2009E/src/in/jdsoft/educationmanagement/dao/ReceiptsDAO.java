package in.jdsoft.educationmanagement.dao;
// Generated Mar 29, 2016 2:42:25 PM by Hibernate Tools 3.4.0.CR1

import org.springframework.stereotype.Repository;

import in.jdsoft.educationmanagement.model.Receipts;

@Repository
public class ReceiptsDAO extends GenericDAO<Receipts>{

	public ReceiptsDAO() {
		super(Receipts.class);
	}
	

	public Receipts getReceiptsById(int id) {
		try {
			Receipts instance = (Receipts) sessionFactory.getCurrentSession()
					.get("in.jdsoft.educationmanagement.model.Receipts", id);
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
