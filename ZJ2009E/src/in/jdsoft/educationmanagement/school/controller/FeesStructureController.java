package in.jdsoft.educationmanagement.school.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.google.gson.Gson;

import in.jdsoft.educationmanagement.components.ExceptionComparator;
import in.jdsoft.educationmanagement.school.exceptions.FeesStructureException;
import in.jdsoft.educationmanagement.school.exceptions.FeesTermException;
import in.jdsoft.educationmanagement.school.model.FeesTemplate;
import in.jdsoft.educationmanagement.school.model.FeesTemplateItem;
import in.jdsoft.educationmanagement.school.model.FeesTerm;
import in.jdsoft.educationmanagement.school.model.InstituteLedgerAccount;
import in.jdsoft.educationmanagement.school.model.Institution;
import in.jdsoft.educationmanagement.school.model.Message;
import in.jdsoft.educationmanagement.school.services.FeesStructureServices;
import in.jdsoft.educationmanagement.school.services.InstitutionServices;

@Controller
@RequestMapping("/feestemplate")
public class FeesStructureController {

	@Autowired
	FeesStructureServices feesStructureService;
	@Autowired
	InstitutionServices institutionServices;
	@Autowired
	ExceptionComparator exceptionComparator;
	
	@RequestMapping 
	public ModelAndView displayFeesTemplatePage(HttpServletRequest request){
		try {
			if(request.getSession().getAttribute("authenticated")!=null && request.getSession().getAttribute("authenticated").equals("true")){
				if(request.getSession().getAttribute("type").equals("Admin")){
					ModelAndView modelandview=new ModelAndView("fees-structure");
					Integer instituteId=Integer.parseInt(request.getSession().getAttribute("instituteId").toString());
					modelandview.addObject("feesstructurelist",institutionServices.getInstituteFeesTemplates(instituteId));
					modelandview.addObject("feesstructureitemlist",institutionServices.getInstituteFeesTemplateItems(instituteId));
					return modelandview;
				}
				else{
					ModelAndView modelandview=new ModelAndView("redirect:/home");
					return modelandview;
				}
			}
			else{
				return new ModelAndView("redirect:/");
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		
	}
	
	@RequestMapping(value="add",method=RequestMethod.POST)
	public String addFeesTemplate(HttpServletRequest request,RedirectAttributes redirectAttributes)throws Exception{
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
			if(e.getClass().equals(FeesStructureException.class)){
				FeesStructureException feesStructureException=(FeesStructureException)e;
				redirectAttributes.addFlashAttribute("errorMessage", feesStructureException.getCustomMessage());
				return "redirect:/feestemplate";
			}
			else{
				
				throw new Exception();
			}
		}
		
	}
	
	
	@RequestMapping(value="update",method=RequestMethod.POST)
	public String updateFeesTemplate(HttpServletRequest request,RedirectAttributes redirectAttributes)throws Exception{
		try {
			Integer feesStructureId=Integer.parseInt(request.getParameter("updateFeesStructureId"));
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
				return "redirect:/feestemplate";
		}catch (DataIntegrityViolationException e) {
			  if(e.getClass().equals(DataIntegrityViolationException.class)){
				  Throwable cause=e.getCause();
				  if(cause.getClass().equals(ConstraintViolationException.class))
				  {
					  String valid=exceptionComparator.containsWord(e.getMessage());
						if(valid!=null)
						{
							 redirectAttributes.addFlashAttribute("errorMessage",new Message("duplicate", "Already Exist Fees Structure"));
								return "redirect:/feestemplate";
						}else
						{
							 throw e;
						}
					
					
				   }
				  else
				  {
					 throw e;
				  }
				  
			  }
			  else
			  {
				  throw e;
			  }
}
		
	}
	
	@RequestMapping(value="delete")
	public String deleteFeesTemplate(HttpServletRequest request,RedirectAttributes redirectAttributes){
		try {
			int feesStructureId=Integer.parseInt(request.getParameter("deleteFeesStructureId"));
			feesStructureService.deleteTemplate(feesStructureId);
			return "redirect:/feestemplate";
		}catch (DataIntegrityViolationException e) {
			 if(e.getClass().equals(DataIntegrityViolationException.class)){
				  Throwable cause=e.getCause();
				  if(cause.getClass().equals(ConstraintViolationException.class)){
					 redirectAttributes.addFlashAttribute("errorMessage",new Message("constraintViolation","Fees Structure in use cannot be deleted"));
					 return "redirect:/feestemplate";
				   }
				  else{
					 throw e;
				  }
				  
			  }
			  else{
				  e.printStackTrace();
				  throw e;
			  }
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
			throw e;
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
			throw e;
		}
		
	}
	
	@RequestMapping(value="item") 
	public ModelAndView displayFeesTemplateItemPage(HttpServletRequest request){
		try {
			if(request.getSession().getAttribute("authenticated")!=null && request.getSession().getAttribute("authenticated").equals("true")){
				if(request.getSession().getAttribute("type").equals("Admin")){
					ModelAndView modelandview=new ModelAndView("templateitem");
					Integer instituteId=Integer.parseInt(request.getSession().getAttribute("instituteId").toString());
					modelandview.addObject("feesstructureitemlist",institutionServices.getInstituteFeesTemplateItems(instituteId));
					modelandview.addObject("ledgerAccounts", institutionServices.getInstitutionLedgerAccountList(instituteId));
					return modelandview;
				}
				else{
					ModelAndView modelandview=new ModelAndView("redirect:/home");
					return modelandview;
				}
			}
			else{
				return new ModelAndView("redirect:/");
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		
	}
	
	@RequestMapping(value="item/add",method=RequestMethod.POST)
	public String addFeesTemplateItem(HttpServletRequest request,RedirectAttributes redirectAttributes)throws Exception{
		try {

			Institution institution= institutionServices.getInstitutionById(Integer.parseInt(request.getSession().getAttribute("instituteId").toString()));
			String templateItemName=request.getParameter("template-name");
			Double templateItemPrice=Double.parseDouble(request.getParameter("item-price"));
			Integer ledgerAccountId=Integer.parseInt(request.getParameter("ledgerAccountId"));
			InstituteLedgerAccount ledgerAccount=institutionServices.getLedgerAccountById(ledgerAccountId);
			FeesTemplateItem feesTemplateItem=new FeesTemplateItem(templateItemName,templateItemPrice,ledgerAccount,institution);
			feesStructureService.addTemplateItem(feesTemplateItem);
			return "redirect:/feestemplate/item";
		} catch (Exception e) {
			if(e.getClass().equals(FeesStructureException.class)){
				FeesStructureException feesStructureException=(FeesStructureException)e;
				redirectAttributes.addFlashAttribute("errorMessage", feesStructureException.getCustomMessage());
				return "redirect:/feestemplate/item";
			}
			else{
				
				throw e;
			}
		}
		
	}
	
	@RequestMapping(value="item/update",method=RequestMethod.POST)
	public String updateFeesTemplateItem(HttpServletRequest request){
		try {
			int templateItemId=Integer.parseInt(request.getParameter("updateTemplateItemId"));
			Double templateItemPrice=Double.parseDouble(request.getParameter("editFeesItemPrice"));
			FeesTemplateItem feesTemplateItem=feesStructureService.getFeesItemById(templateItemId);
			feesTemplateItem.setTemplateItemPrice(templateItemPrice);
			feesStructureService.updateTemplateItem(feesTemplateItem);
			return "redirect:/feestemplate/item";
		} catch (Exception e) {
			e.printStackTrace();
			return "redirect:/feestemplate/item";
		}
		
	}
	
	@RequestMapping(value="item/delete")
	public String deleteFeesTemplateItem(HttpServletRequest request,RedirectAttributes redirectAttributes){
		try {
			int templateItemId=Integer.parseInt(request.getParameter("deleteTemplateItemId"));
			feesStructureService.deleteTemplateItem(templateItemId);
			return "redirect:/feestemplate/item";
		} catch (DataIntegrityViolationException e) {
			 if(e.getClass().equals(DataIntegrityViolationException.class)){
				  Throwable cause=e.getCause();
				  if(cause.getClass().equals(ConstraintViolationException.class)){
					 redirectAttributes.addFlashAttribute("errorMessage",new Message("constraintViolation","Fees Item in use cannot be deleted"));
					 return "redirect:/feestemplate/item";
				   }
				  else{
					 throw e;
				  }
				  
			  }
			  else{
				  e.printStackTrace();
				  throw e;
			  }
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
	
	
	@RequestMapping(value="/feesterm")
	public ModelAndView  displayFeesTermPage(HttpServletRequest request){
		try {
			if(request.getSession().getAttribute("authenticated")!=null && request.getSession().getAttribute("authenticated").equals("true")){
				if(request.getSession().getAttribute("type").equals("Admin")){
					ModelAndView mv=new ModelAndView("feesterm");
					Integer institutionId=Integer.parseInt(request.getSession().getAttribute("instituteId").toString());
					mv.addObject("feesTerms", institutionServices.getInstitutionFeesTerms(institutionId));
					return mv;
				}
				else{
					ModelAndView modelandview=new ModelAndView("redirect:/home");
					return modelandview;
				}
			}
			else{
				return new ModelAndView("redirect:/");
			}
			
		} catch (Exception e) {
			throw e;
		}
	}
	
	@RequestMapping(value="/feesterm/add",method=RequestMethod.POST)
	public String addFeesTerm(HttpServletRequest request,RedirectAttributes redirectAttributes) throws Exception{
		try {
			String feesTermName=request.getParameter("feesTermName");
			Institution institution=institutionServices.getInstitutionById(Integer.parseInt(request.getSession().getAttribute("instituteId").toString()));
			Integer feesTermOrder=Integer.parseInt(request.getParameter("feesTermOrder"));
			FeesTerm feesTerm=new FeesTerm(feesTermName, institution, feesTermOrder);
			feesStructureService.addFeesTerm(feesTerm);
			return "redirect:/feestemplate/feesterm";
		} catch (Exception e) {
			if(e.getClass().equals(FeesTermException.class)){
				FeesTermException feesTermException= (FeesTermException)e;
				redirectAttributes.addFlashAttribute("errorMessage",feesTermException.getCustomMessage());
				return "redirect:/feestemplate/feesterm";
			}
			else{
				throw e;
			}
		}
	}
	
	@RequestMapping(value="feesterm/editReterive",method=RequestMethod.GET)
	@ResponseBody
	public FeesTerm editFeesTerm(HttpServletRequest request){
		try {
			 return feesStructureService.getFeesTermById(Integer.parseInt(request.getParameter("feesTermid")));
		} catch (Exception e) {
			throw e;
		}
	}
	
	@RequestMapping(value="feesterm/delete",method=RequestMethod.POST)
	public String deleteFeesTerm(HttpServletRequest request){
		try {
			feesStructureService.deleteFeesTerm(Integer.parseInt(request.getParameter("feesTermid")));
			return "redirect:/feestemplate/feesterm";
		} catch (Exception e) {
			throw e;
		}
	}
	
	@RequestMapping(value="feesterm/update",method=RequestMethod.POST)
	public String updateFeesTerm(HttpServletRequest request,RedirectAttributes redirectAttributes) throws Exception{
		try {
			Integer feesTermId=Integer.parseInt(request.getParameter("updateFeesTermId"));
			String feesTermName=request.getParameter("editFeesTermName");
			Integer feesTermOrder= Integer.parseInt(request.getParameter("editFeesTermOrder"))  ;
			FeesTerm feesTerm=feesStructureService.getFeesTermById(feesTermId);
			feesTerm.setFeesTermName(feesTermName);
			feesTerm.setTermOrder(feesTermOrder);
			feesStructureService.updateFeesTerm(feesTerm);
			return "redirect:/feestemplate/feesterm";
		} catch (Exception e) {
			if(e.getClass().equals(DataIntegrityViolationException.class)){
				  Throwable cause=e.getCause();
				  if(cause.getClass().equals(ConstraintViolationException.class)){
					 redirectAttributes.addFlashAttribute("errorMessage",new Message("constraintViolation","duplicate fees term or order no"));
					 return "redirect:/feestemplate/feesterm";
				   }
				  else{
					 throw e;
				  }
				  
			  }
			else{
				throw e;
			}
		}
	}
}
