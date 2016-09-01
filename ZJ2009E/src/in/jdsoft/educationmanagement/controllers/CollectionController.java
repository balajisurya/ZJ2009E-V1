package in.jdsoft.educationmanagement.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import in.jdsoft.educationmanagement.services.CurrencyServices;
import in.jdsoft.educationmanagement.services.GeographicalLocationServices;
import in.jdsoft.educationmanagement.services.StudentServices;

@Controller
@RequestMapping("/collection")
public class CollectionController {
	
	
	@Autowired
	GeographicalLocationServices  geographicallocationService;
	
	@Autowired
	CurrencyServices currencyServices;
	
	@Autowired
	StudentServices studentServices;
	
	@RequestMapping(value="dataentry",method = RequestMethod.GET) 
	public ModelAndView displayDataEntryPage(HttpServletRequest request){
		try {
			ModelAndView modelandview=new ModelAndView("dataentry");
			
			modelandview.addObject("geographicallocationList", geographicallocationService.getCountryList());
			modelandview.addObject("FeesCollectionRecordList", studentServices.getFeesCollectionRecordList());
			modelandview.addObject("geographicallocationService", geographicallocationService);
			modelandview.addObject("countryList", geographicallocationService.getCountryList());
			modelandview.addObject("stateList", geographicallocationService.getStateList());
			modelandview.addObject("cityList", geographicallocationService.getCityList());
			
			return modelandview;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
	}
	
	@RequestMapping(value="reconcilation",method = RequestMethod.GET)
	public ModelAndView displayReconcilationPage(HttpServletRequest request){
		try {
			ModelAndView modelandview=new ModelAndView("recon");
			return modelandview;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
	}

}
