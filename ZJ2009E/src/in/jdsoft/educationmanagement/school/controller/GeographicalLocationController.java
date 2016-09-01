package in.jdsoft.educationmanagement.school.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;

import in.jdsoft.educationmanagement.school.services.GeographicalLocationServices;



@Controller
@RequestMapping("/geographicallocation")
public class GeographicalLocationController {

	
	@Autowired
	GeographicalLocationServices geographicallocationService;
	
	

	@RequestMapping(value="state")
	@ResponseBody
	public String getGeographicalState(HttpServletRequest request)  
	{
		try {
			int countryId =Integer.parseInt(request.getParameter("countryId"));
	    	String json = new Gson().toJson(geographicallocationService.getStateList(countryId));
		    return json;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		
    }
	
	
	@RequestMapping(value="city")
	@ResponseBody
	public String getGeographicalcity(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		try {
			int stateId =Integer.parseInt(request.getParameter("stateId"));
			String json = new Gson().toJson(geographicallocationService.getCityList(stateId));
	        return json;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
    
    }

}
