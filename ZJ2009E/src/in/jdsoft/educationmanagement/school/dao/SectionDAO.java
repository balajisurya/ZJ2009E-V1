package in.jdsoft.educationmanagement.school.dao;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import in.jdsoft.educationmanagement.dao.GenericDAO;
import in.jdsoft.educationmanagement.school.model.Institution;
import in.jdsoft.educationmanagement.school.model.Section;
@Repository
public class SectionDAO extends GenericDAO<Section>{

	
	public SectionDAO() {
		super(Section.class);
	}
	
	public Section getSectionById(java.lang.Integer id) {
		try {
			Section instance = (Section) sessionFactory.getCurrentSession()
					.get("in.jdsoft.educationmanagement.school.model.Section", id);
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
	
	public Section getSectionBySectionName(String sectionName,Institution institution){
		try {
			Criteria criteria=sessionFactory.getCurrentSession().createCriteria(Section.class);
			criteria.add(Restrictions.conjunction().
					add(Restrictions.eq("sectionName",sectionName))
					.add(Restrictions.eq("institution", institution)));
			Section section=(Section)criteria.uniqueResult();
			if (section == null) {
				//logging
			} else {
				//logging
			}
			return section;
		} catch (RuntimeException re) {
			throw re;
		}
	}
	
}
