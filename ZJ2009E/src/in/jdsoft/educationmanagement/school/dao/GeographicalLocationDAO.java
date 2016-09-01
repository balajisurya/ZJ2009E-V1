package in.jdsoft.educationmanagement.school.dao;


import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import in.jdsoft.educationmanagement.dao.GenericDAO;
import in.jdsoft.educationmanagement.school.model.GeographicalLocation;


@Repository
public class GeographicalLocationDAO extends GenericDAO<GeographicalLocation>{

	public GeographicalLocationDAO() {
		super(GeographicalLocation.class);
	}
	
	public GeographicalLocation getGeographicalLocationById(java.lang.Integer id) {
		try {
			GeographicalLocation instance = (GeographicalLocation) sessionFactory.getCurrentSession()
					.get("in.jdsoft.educationmanagement.school.model.GeographicalLocation", id);
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
	
	public GeographicalLocation getGeographicalLocationByName(String geographicalLocationName){
		try {
			Criteria criteria=sessionFactory.getCurrentSession().createCriteria(GeographicalLocation.class);
			criteria.add(Restrictions.eq("name",geographicalLocationName));
			GeographicalLocation geographicalLocation=(GeographicalLocation)criteria.uniqueResult();
			if (geographicalLocation == null) {
				//logging
			} else {
				//logging
			}
			return geographicalLocation;
		} catch (RuntimeException re) {
			System.out.println(re.getMessage());
			throw re;
		}
	}
}


