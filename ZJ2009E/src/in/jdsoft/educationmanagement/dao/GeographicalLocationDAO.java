package in.jdsoft.educationmanagement.dao;
// Generated Mar 29, 2016 2:42:25 PM by Hibernate Tools 3.4.0.CR1

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import in.jdsoft.educationmanagement.model.GeographicalLocation;

@Repository
public class GeographicalLocationDAO extends GenericDAO<GeographicalLocation>{

	public GeographicalLocationDAO() {
		super(GeographicalLocation.class);
	}
	
	public GeographicalLocation getGeographicalLocationById(java.lang.Integer id) {
		try {
			GeographicalLocation instance = (GeographicalLocation) sessionFactory.getCurrentSession()
					.get("in.jdsoft.educationmanagement.model.GeographicalLocation", id);
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
	
	@SuppressWarnings("unchecked")
	public List<GeographicalLocation> getGeographicalLocationCountryList() {
		try {
			Criteria criteria=sessionFactory.getCurrentSession().createCriteria(GeographicalLocation.class);
			criteria.add(Restrictions.eq("geographicalLocationType",0));
			criteria.add(Restrictions.eq("isVisible",0));
			ArrayList<GeographicalLocation> location =(ArrayList<GeographicalLocation>)criteria.list();
			if (location == null) {
				//logging
			} else {
				//logging
			}
			return location;
		} catch (RuntimeException re) {
			throw re;
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<GeographicalLocation> getAllGeographicalLocationCountryList() {
		try {
			Criteria criteria=sessionFactory.getCurrentSession().createCriteria(GeographicalLocation.class);
			criteria.add(Restrictions.eq("geographicalLocationType",0));
			ArrayList<GeographicalLocation> location =(ArrayList<GeographicalLocation>)criteria.list();
			if (location == null) {
				//logging
			} else {
				//logging
			}
			return location;
		} catch (RuntimeException re) {
			throw re;
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<GeographicalLocation> getGeographicalLocationStateList() {
		try {
			Criteria criteria=sessionFactory.getCurrentSession().createCriteria(GeographicalLocation.class);
			criteria.add(Restrictions.eq("geographicalLocationType",1));
			criteria.add(Restrictions.eq("isVisible",0));
			ArrayList<GeographicalLocation> location =(ArrayList<GeographicalLocation>)criteria.list();
			if (location == null) {
				//logging
			} else {
				//logging
			}
			return location;
		} catch (RuntimeException re) {
			throw re;
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<GeographicalLocation> getAllGeographicalLocationStateList() {
		try {
			Criteria criteria=sessionFactory.getCurrentSession().createCriteria(GeographicalLocation.class);
			criteria.add(Restrictions.eq("geographicalLocationType",1));
			ArrayList<GeographicalLocation> location =(ArrayList<GeographicalLocation>)criteria.list();
			if (location == null) {
				//logging
			} else {
				//logging
			}
			return location;
		} catch (RuntimeException re) {
			throw re;
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<GeographicalLocation> getGeographicalLocationCityList() {
		try {
			Criteria criteria=sessionFactory.getCurrentSession().createCriteria(GeographicalLocation.class);
			criteria.add(Restrictions.eq("geographicalLocationType",2));
			criteria.add(Restrictions.eq("isVisible",0));
			ArrayList<GeographicalLocation> location =(ArrayList<GeographicalLocation>)criteria.list();
			if (location == null) {
				//logging
			} else {
				//logging
			}
			return location;
		} catch (RuntimeException re) {
			throw re;
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<GeographicalLocation> getAllGeographicalLocationCityList() {
		try {
			Criteria criteria=sessionFactory.getCurrentSession().createCriteria(GeographicalLocation.class);
			criteria.add(Restrictions.eq("geographicalLocationType",2));
			ArrayList<GeographicalLocation> location =(ArrayList<GeographicalLocation>)criteria.list();
			if (location == null) {
				//logging
			} else {
				//logging
			}
			return location;
		} catch (RuntimeException re) {
			throw re;
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<GeographicalLocation> getStateListByCountry(Integer CountryId) {
		try {
			Criteria criteria=sessionFactory.getCurrentSession().createCriteria(GeographicalLocation.class);
			criteria.add(Restrictions.eq("parentId",CountryId));
			criteria.add(Restrictions.eq("geographicalLocationType",1));
			criteria.add(Restrictions.eq("isVisible",0));
			ArrayList<GeographicalLocation> location =(ArrayList<GeographicalLocation>) criteria.list();
			if (location == null) {
				//logging
			} else {
				//logging
			}
			return location;
		} catch (RuntimeException re) {
			throw re;
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<GeographicalLocation> getAllStateListByCountry(Integer CountryId) {
		try {
			Criteria criteria=sessionFactory.getCurrentSession().createCriteria(GeographicalLocation.class);
			criteria.add(Restrictions.eq("parentId",CountryId));
			criteria.add(Restrictions.eq("geographicalLocationType",1));
			ArrayList<GeographicalLocation> location =(ArrayList<GeographicalLocation>) criteria.list();
			if (location == null) {
				//logging
			} else {
				//logging
			}
			return location;
		} catch (RuntimeException re) {
			throw re;
		}
	}
	
	
	@SuppressWarnings("unchecked")
	public List<GeographicalLocation> getCityListByState(Integer StateId) {
		try {
			Criteria criteria=sessionFactory.getCurrentSession().createCriteria(GeographicalLocation.class);
			criteria.add(Restrictions.eq("parentId",StateId));
			criteria.add(Restrictions.eq("geographicalLocationType",2));
			criteria.add(Restrictions.eq("isVisible",0));
			ArrayList<GeographicalLocation> location =(ArrayList<GeographicalLocation>)criteria.list();
			if (location == null) {
				//logging
			} else {
				//logging
			}
			return location;
		} catch (RuntimeException re) {
			throw re;
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<GeographicalLocation> getAllCityListByState(Integer StateId) {
		try {
			Criteria criteria=sessionFactory.getCurrentSession().createCriteria(GeographicalLocation.class);
			criteria.add(Restrictions.eq("parentId",StateId));
			criteria.add(Restrictions.eq("geographicalLocationType",2));
			ArrayList<GeographicalLocation> location =(ArrayList<GeographicalLocation>)criteria.list();
			if (location == null) {
				//logging
			} else {
				//logging
			}
			return location;
		} catch (RuntimeException re) {
			throw re;
		}
	}
}


