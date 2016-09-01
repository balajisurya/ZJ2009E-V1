package in.jdsoft.educationmanagement.school.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import in.jdsoft.educationmanagement.school.dao.GeographicalLocationDAO;
import in.jdsoft.educationmanagement.school.model.GeographicalLocation;



@Service
public class GeographicalLocationServices {
	
	@Autowired
	GeographicalLocationDAO geographicalLocationDAO;
	
	
	@Transactional
	public GeographicalLocation getGeographicalLocationById(int geographicalLocationId){
			return  geographicalLocationDAO.getGeographicalLocationById(geographicalLocationId);
	}
	
	@Transactional
	public ArrayList<GeographicalLocation> getCountryList(){
			return (ArrayList<GeographicalLocation>) geographicalLocationDAO.getGeographicalLocationCountryList();
	}
	@Transactional
	public ArrayList<GeographicalLocation> getStateList(){
			return (ArrayList<GeographicalLocation>) geographicalLocationDAO.getGeographicalLocationStateList();
	}
	
	@Transactional
	public ArrayList<GeographicalLocation> getCityList(){
			return (ArrayList<GeographicalLocation>) geographicalLocationDAO.getGeographicalLocationCityList();
	}
	
	
	@Transactional
	public ArrayList<GeographicalLocation> getStateList(Integer CountryId){
			return (ArrayList<GeographicalLocation>) geographicalLocationDAO.getStateListByCountry(CountryId);
	}

	
	@Transactional
	public ArrayList<GeographicalLocation> getCityList(Integer StateId){
			return (ArrayList<GeographicalLocation>) geographicalLocationDAO.getCityListByState(StateId);
	}
	
	
}
