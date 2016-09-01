package in.jdsoft.educationmanagement.dao;

import org.springframework.stereotype.Repository;

import in.jdsoft.educationmanagement.model.CommunicationAndIssuesOrQueries;

@Repository
public class CommunicationAndIssuesOrQueriesDAO extends GenericDAO<CommunicationAndIssuesOrQueries>{

	public CommunicationAndIssuesOrQueriesDAO() {
		super(CommunicationAndIssuesOrQueries.class);
	}
	
	public CommunicationAndIssuesOrQueries getCommunicationAndIssuesOrQueriesById(java.lang.Integer id) {
		try {
			CommunicationAndIssuesOrQueries instance = (CommunicationAndIssuesOrQueries) sessionFactory.getCurrentSession()
					.get("in.jdsoft.educationmanagement.model.CommunicationAndIssuesOrQueries", id);
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
