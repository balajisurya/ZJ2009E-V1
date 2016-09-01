package in.jdsoft.educationmanagement.school.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import in.jdsoft.educationmanagement.school.model.PaymentStatus;
import in.jdsoft.educationmanagement.school.services.PaymentServices;

@Controller
@RequestMapping("/payment")
public class PaymentController {

	@Autowired
	PaymentServices paymentServices;
	
	@RequestMapping(value="paymentmode/status",method=RequestMethod.GET) 
	@ResponseBody
	public ArrayList<PaymentStatus> studentReceiptsByPaymentMode(HttpServletRequest request){
		try {
			Integer paymentModeId=Integer.parseInt(request.getParameter("paymentModeId"));
			return paymentServices.getPaymentStatusOfPaymentMode(paymentModeId);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
	}
}
