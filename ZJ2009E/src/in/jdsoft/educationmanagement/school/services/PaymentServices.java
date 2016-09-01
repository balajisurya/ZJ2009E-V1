package in.jdsoft.educationmanagement.school.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import in.jdsoft.educationmanagement.school.dao.PaymentModeDAO;
import in.jdsoft.educationmanagement.school.dao.PaymentStatusDAO;
import in.jdsoft.educationmanagement.school.model.PaymentMode;
import in.jdsoft.educationmanagement.school.model.PaymentStatus;

@Service
public class PaymentServices {

	@Autowired
	PaymentModeDAO paymentModeDAO;
	@Autowired
	PaymentStatusDAO paymentStatusDAO;
	
	@Transactional
	public ArrayList<PaymentMode> getPaymentModeList(){
		return (ArrayList<PaymentMode>) paymentModeDAO.getList();
	}
	
	@Transactional
	public ArrayList<PaymentMode> getActivePaymentModes(){
		return (ArrayList<PaymentMode>) paymentModeDAO.getActivePaymentModes();
	}
	
	@Transactional
	public PaymentMode getPaymentModeById(Integer paymentModeId){
		return paymentModeDAO.getPaymentModeById(paymentModeId);
	}
	
	@Transactional
	public ArrayList<PaymentStatus> getPaymentStatusOfPaymentMode(Integer paymentModeId){
		ArrayList<PaymentStatus> paymentStatusList=new ArrayList<PaymentStatus>();
		PaymentMode paymentMode=paymentModeDAO.getPaymentModeById(paymentModeId);
		paymentStatusList.addAll(paymentMode.getPaymentStatusType());
		return paymentStatusList;
	}
}
