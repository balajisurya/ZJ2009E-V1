package in.jdsoft.educationmanagement.school.dao;

import org.springframework.stereotype.Repository;

import in.jdsoft.educationmanagement.dao.GenericDAO;
import in.jdsoft.educationmanagement.school.model.InstituteLedgerAccount;

@Repository
public class InstituteLedgerAccountDAO extends GenericDAO<InstituteLedgerAccount>{

	public InstituteLedgerAccountDAO() {
		super(InstituteLedgerAccount.class);
	}
	
	public InstituteLedgerAccount getInstituteLedgerAccountById(java.lang.Integer id) {
		try {
			InstituteLedgerAccount instance = (InstituteLedgerAccount) sessionFactory.getCurrentSession()
					.get("in.jdsoft.educationmanagement.school.model.InstituteLedgerAccount", id);
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
