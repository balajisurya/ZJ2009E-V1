package in.jdsoft.educationmanagement.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Repository;


@Repository
public class GenericDAO<T> implements GenericDAOInterface<T>{
	
	
	
	protected SessionFactory sessionFactory;
	//static Logger logger;
	
	private  Class<T> entity;
	
	public GenericDAO(Class<T> entity){
		this.entity=entity;
	}
	
	public GenericDAO() {
		//logger = Logger.getLogger(this.getClass());
	}
	
	
	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	@Override
	public void persist(T transientInstance)throws ConstraintViolationException{
		//logger.debug("Persisting" +transientInstance.getClass()+"into database");
		try {
				sessionFactory.getCurrentSession().persist(transientInstance);
				
		} 
		catch (Exception re) {
		
			throw re;
		}
	}
	
	public T save(T transientInstance){
		try {
			sessionFactory.getCurrentSession().save(transientInstance);
			return transientInstance;
		}
		catch (Exception re) {
			re.printStackTrace();
			throw re;
		}
	}
	

	@Override
	public void delete(T persistentInstance) throws DataIntegrityViolationException{
		//logger.info("deleting" +persistentInstance.getClass()+"from database");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			//logger.info("deleting" +persistentInstance.getClass()+"was successful");
		} catch (Exception re) {
			
			throw re;
			//logger.error("deleting" +persistentInstance.getClass()+"failed due to"+re);
		
		}
		
	}
	
	

	@SuppressWarnings("unchecked")
	@Override
	public List<T> getList() {
		try {
			List<T> results = (List<T>) sessionFactory.getCurrentSession().createCriteria(entity).list();
			return (List<T>) results;
		} catch (Exception re) {
			throw re;
		}
	}

	@Override
	public void update(T transientInstance)throws DataIntegrityViolationException{
		
		try {
			sessionFactory.getCurrentSession().update(transientInstance);
			
		}
		catch (Exception  re)
		{  
			System.out.println(re.getClass());
			throw re;
		}
		
	}


	
	@Override
	public void saveOrUpdate(T instance) throws DataIntegrityViolationException{
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
		} catch (Exception re) {
			throw re;
		}
		
	}

	
	/*@SuppressWarnings("unchecked")
	public List<Courses> findByExample(Courses instance) {
		log.debug("finding Courses instance by example");
		try {
			List<Courses> results = (List<Courses>) sessionFactory.getCurrentSession()
					.createCriteria("in.jdsoft.educationmanagement.dao.CoursesDAO").add(create(instance)).list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
	
	public Courses merge(Courses detachedInstance) {
		log.debug("merging Courses instance");
		try {
			Courses result = (Courses) sessionFactory.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}
	
	public void attachDirty(Courses instance) {
		log.debug("attaching dirty Courses instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Courses instance) {
		log.debug("attaching clean Courses instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}*/
}
