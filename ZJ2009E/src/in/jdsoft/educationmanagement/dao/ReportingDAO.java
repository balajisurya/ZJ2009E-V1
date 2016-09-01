package in.jdsoft.educationmanagement.dao;
// Generated Mar 29, 2016 2:42:25 PM by Hibernate Tools 3.4.0.CR1

import org.springframework.stereotype.Repository;

import in.jdsoft.educationmanagement.model.Reporting;

@Repository
public class ReportingDAO extends GenericDAO<Reporting> {

		public ReportingDAO() {
			super(Reporting.class); 
		}
	

	public Reporting getReportById(java.lang.Integer id) {
		try {
			Reporting instance = (Reporting) sessionFactory.getCurrentSession()
					.get("in.jdsoft.educationmanagement.model.Reporting", id);
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
