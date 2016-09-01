package in.jdsoft.educationmanagement.dao;

import org.springframework.stereotype.Repository;

import in.jdsoft.educationmanagement.model.FeesCollectionRecord;

@Repository
public class FeesCollectionRecordDAO extends GenericDAO<FeesCollectionRecord>
{

	public FeesCollectionRecordDAO() {
		super(FeesCollectionRecord.class);
		// TODO Auto-generated constructor stub
	}
	
	
	public FeesCollectionRecord getFeesCollectionRecordById(java.lang.Integer id) {
		try {
			FeesCollectionRecord instance = (FeesCollectionRecord) sessionFactory.getCurrentSession()
					.get("in.jdsoft.educationmanagement.model.FeesCollectionRecord", id);
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
