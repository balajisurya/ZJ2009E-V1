package in.jdsoft.educationmanagement.dao;

import in.jdsoft.educationmanagement.model.DocumentIndex;

public class DocumentIndexDAO extends GenericDAO<DocumentIndex>
{
	public DocumentIndexDAO() {
		super(DocumentIndex.class);
		
	}

	public DocumentIndex getDocumentIndexById(java.lang.Integer id) {
		try {
			DocumentIndex instance = (DocumentIndex) sessionFactory.getCurrentSession()
					.get("in.jdsoft.educationmanagement.model.DocumentIndex", id);
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
