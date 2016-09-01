package in.jdsoft.educationmanagement.services;

import java.util.ArrayList;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import in.jdsoft.educationmanagement.dao.ReceiptDetailsDAO;
import in.jdsoft.educationmanagement.dao.ReceiptsDAO;
import in.jdsoft.educationmanagement.model.ReceiptDetails;
import in.jdsoft.educationmanagement.model.Receipts;

public class ReceiptServices {
	
	@Autowired
	ReceiptsDAO receiptsDAO;
	@Autowired
	ReceiptDetailsDAO receiptDeatailsDAO;
	
	@Transactional
	public void addReceipt(Receipts receipt){
		receiptsDAO.persist(receipt);
	}
	
	@Transactional
	public ArrayList<Receipts> getReceiptList(){
		return (ArrayList<Receipts>) receiptsDAO.getList();
	}
	
	@Transactional
	public void deleteReceipt(int receiptId){
		receiptsDAO.delete(receiptsDAO.getReceiptsById(receiptId));
	}
	
	@Transactional
	public Receipts receiptFromId(int receiptId){
		return receiptsDAO.getReceiptsById(receiptId);
	}
	
	@Transactional
	public void addReceiptDetails(ReceiptDetails receiptdetails){
		receiptDeatailsDAO.persist(receiptdetails);
	}
	
	@Transactional
	public ArrayList<ReceiptDetails> getAllReceiptItem(int receiptId){
		ArrayList<ReceiptDetails> receiptDetailsList=new ArrayList<>();
		Set<ReceiptDetails> receiptDetails=receiptsDAO.getReceiptsById(receiptId).getReceiptDetails();
		receiptDetailsList.addAll(receiptDetails);
		return receiptDetailsList;
	}
	
	@Transactional
	public void deleteReceiptItem(int receiptItemId){
		receiptDeatailsDAO.delete(receiptDeatailsDAO.getReceiptDetailsById(receiptItemId));
	}
	

}
