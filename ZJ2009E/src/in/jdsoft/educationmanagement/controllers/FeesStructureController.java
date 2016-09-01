package in.jdsoft.educationmanagement.controllers;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;

import in.jdsoft.educationmanagement.model.FeesTemplate;
import in.jdsoft.educationmanagement.model.FeesTemplateItem;
import in.jdsoft.educationmanagement.model.Institution;
import in.jdsoft.educationmanagement.services.AdmissionServices;
import in.jdsoft.educationmanagement.services.FeesStructureServices;
import in.jdsoft.educationmanagement.services.InstitutionServices;

@Controller
@RequestMapping("/feestemplate")
public class FeesStructureController {

	@Autowired
	FeesStructureServices feesStructureService;
	@Autowired
	AdmissionServices admissionServices;
	@Autowired
	FeesStructureServices feesStructureServices;
	@Autowired
	InstitutionServices institutionServices;
	
	@RequestMapping 
	public ModelAndView displayFeesTemplatePage(HttpServletRequest request){
		try {
			ModelAndView modelandview=new ModelAndView("fees-structure");
			Integer instituteId=Integer.parseInt(request.getSession().getAttribute("instituteId").toString());
			modelandview.addObject("feesstructurelist",institutionServices.getInstituteFeesTemplates(instituteId));
			modelandview.addObject("feesstructureitemlist",institutionServices.getInstituteFeesTemplateItems(instituteId));
			return modelandview;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
	}
	
	@RequestMapping(value="add",method=RequestMethod.POST)
	public String addFeesTemplate(HttpServletRequest request){
		try {
			String templateName=request.getParameter("structure-name");
			String templateItemIdList[]=request.getParameterValues("templateItemList");
			Institution institution= institutionServices.getInstitutionById(Integer.parseInt(request.getSession().getAttribute("instituteId").toString()));
			FeesTemplate feesTemplate=new FeesTemplate(templateName,institution);
		    for (String templateItemId : templateItemIdList) {
		    	FeesTemplateItem feeTemplateItem=feesStructureService.getFeesItemById(Integer.parseInt(templateItemId));
		    	feesTemplate.getFeesTemplateItems().add(feeTemplateItem);
		    }
		    feesStructureService.addFeesTemplate(feesTemplate);
		    return "redirect:/feestemplate";
		} catch (Exception e) {
			e.printStackTrace();
			return "redirect:/feestemplate";
		}
		
	}
	
	
	@RequestMapping(value="update",method=RequestMethod.POST)
	@ResponseStatus(value=HttpStatus.OK)
	public void updateFeesTemplate(HttpServletRequest request){
		try {
			Integer feesStructureId=Integer.parseInt(request.getParameter("feesTemplateStuctId"));
			 String templateItemIdList[]=request.getParameterValues("editTemplateItemList");
			 String templateName=request.getParameter("editStructure-name");
			 	FeesTemplate feesTemplate=feesStructureService.getFeesTemplateLazyById(feesStructureId);
				feesTemplate.setTemplateName(templateName);
				feesTemplate.getFeesTemplateItems().clear();//.removeAll(feesTemplateMapping);
				for (String templateItemId : templateItemIdList) {
					FeesTemplateItem feeTemplateItem=feesStructureService.getFeesItemById(Integer.parseInt(templateItemId));
					feesTemplate.getFeesTemplateItems().add(feeTemplateItem);
			    }
				feesStructureService.updateTemplate(feesTemplate);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
	
	@RequestMapping(value="delete")
	public String deleteFeesTemplate(HttpServletRequest request){
		try {
			int feesStructureId=Integer.parseInt(request.getParameter("feesStructureid"));
			feesStructureService.deleteTemplate(feesStructureId);
			return "redirect:/feestemplate";
		} catch (Exception e) {
			e.printStackTrace();
			return "redirect:/feestemplate";
		}
		
	}
	@RequestMapping(value="getFeesTemplate",method = RequestMethod.GET)
	@ResponseBody
	public FeesTemplate getFeesTemplate(HttpServletRequest request){
		try {
			int feesStructureId=Integer.parseInt(request.getParameter("feesTemplateStuctId"));
			FeesTemplate feesTemplate=feesStructureService.getFeesTemplateLazyById(feesStructureId);
			return feesTemplate;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
	}
	
	@RequestMapping(value="list")
	public ModelAndView listFeesTemplate(HttpServletRequest request,HttpServletResponse response) throws IOException{
		try {
			int feesStructureId=Integer.parseInt(request.getParameter("feesStructureid"));
			FeesTemplate feesTemplate=feesStructureService.getFeesTemplateById(feesStructureId);
			String json = new Gson().toJson(feesTemplate);
	        response.setContentType("application/json");
	        response.getWriter().write(json);
			return new ModelAndView("/feestemplate");
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
	}
	
	@RequestMapping(value="item",method = RequestMethod.GET) 
	public ModelAndView displayFeesTemplateItemPage(HttpServletRequest request){
		try {
			ModelAndView modelandview=new ModelAndView("templateitem");
			Integer instituteId=Integer.parseInt(request.getSession().getAttribute("instituteId").toString());
			modelandview.addObject("feesstructureitemlist",institutionServices.getInstituteFeesTemplateItems(instituteId));
			return modelandview;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
	}
	
	@RequestMapping(value="item/add",method=RequestMethod.POST)
	public String addFeesTemplateItem(HttpServletRequest request){
		try {

			Institution institution= institutionServices.getInstitutionById(Integer.parseInt(request.getSession().getAttribute("instituteId").toString()));
			String templateItemName=request.getParameter("template-name");
			Double templateItemPrice=Double.parseDouble(request.getParameter("item-price"));
			FeesTemplateItem feesTemplateItem=new FeesTemplateItem(templateItemName,templateItemPrice,institution);
			feesStructureService.addTemplateItem(feesTemplateItem);
			return "redirect:/feestemplate/item";
		} catch (Exception e) {
			e.printStackTrace();
			return "redirect:/feestemplate/item";
		}
		
	}
	
	@RequestMapping(value="item/update",method=RequestMethod.POST)
	@ResponseStatus(value=HttpStatus.OK)
	public void updateFeesTemplateItem(HttpServletRequest request){
		try {
			int templateItemId=Integer.parseInt(request.getParameter("templateItemId"));
			String templateItemName=request.getParameter("editFeesItemName");
			Double templateItemPrice=Double.parseDouble(request.getParameter("editFeesItemPrice"));
			FeesTemplateItem feesTemplateItem=feesStructureService.getFeesItemById(templateItemId);
			feesTemplateItem.setTemplateItemName(templateItemName);
			feesTemplateItem.setTemplateItemPrice(templateItemPrice);
			feesStructureService.updateTemplateItem(feesTemplateItem);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	@RequestMapping(value="item/delete")
	public String deleteFeesTemplateItem(HttpServletRequest request){
		try {
			int templateItemId=Integer.parseInt(request.getParameter("templateItemId"));
			feesStructureService.deleteTemplateItem(templateItemId);
			return "redirect:/feestemplate/item";
		} catch (Exception e) {
			e.printStackTrace();
			return "redirect:/feestemplate/item";
		}
		
	}
	@RequestMapping(value="item/get",method=RequestMethod.GET)
	@ResponseBody
	public FeesTemplateItem getFeesTemplateItem(HttpServletRequest request){
		try {
			Integer templateItemId=Integer.parseInt(request.getParameter("templateItemId"));
			FeesTemplateItem feesTemplateItem=feesStructureService.getFeesItemLazyById(templateItemId);
			return feesTemplateItem;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
		
	}
	@RequestMapping(value="item/list")
	public ModelAndView listFeesTemplateItem(HttpServletRequest request,HttpServletResponse response) throws IOException{
		try {
			int templateId=Integer.parseInt(request.getParameter("templateitemId"));
			FeesTemplateItem feesTemplateItem =feesStructureService.getFeesItemById(templateId);
			String json = new Gson().toJson(feesTemplateItem);
	        response.setContentType("application/json");
	        response.getWriter().write(json);
			return new ModelAndView("/feestemplate/item");
		} catch (Exception e) {
			e.printStackTrace();
			return new ModelAndView("/feestemplate/item");
		}
		
	}
	
	
	
	
}
