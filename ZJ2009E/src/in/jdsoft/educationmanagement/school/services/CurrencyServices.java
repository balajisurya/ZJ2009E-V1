package in.jdsoft.educationmanagement.school.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import in.jdsoft.educationmanagement.school.dao.CurrencyDAO;
import in.jdsoft.educationmanagement.school.model.Currency;



@Service
public class CurrencyServices {
	
	@Autowired
	CurrencyDAO currencyDAO;
	
	@Transactional
	public ArrayList<Currency> getCurrecyList(){
			return (ArrayList<Currency>) currencyDAO.getList();		
	}

	@Transactional
	public void addCurrency(Currency currency){
			currencyDAO.persist(currency);
	}
}
