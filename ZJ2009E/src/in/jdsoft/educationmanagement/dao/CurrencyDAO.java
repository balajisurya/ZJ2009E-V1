package in.jdsoft.educationmanagement.dao;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import in.jdsoft.educationmanagement.model.Currency;

@Repository
public class CurrencyDAO extends GenericDAO<Currency> {

	
	public CurrencyDAO() {
		super(Currency.class);
	}
	
	public Currency geCurrencyByIsoCode(String currencyCode) {
		try {
			Criteria currencycriteria=sessionFactory.getCurrentSession().createCriteria(Currency.class);
			currencycriteria.add(Restrictions.eq("isoCode",currencyCode));
			Currency currency=(Currency)currencycriteria.uniqueResult();
			if (currency == null) {
				//logging
			} else {
				//logging
			}
			return currency;
		} catch (RuntimeException re) {
			throw re;
		}
	}
}
