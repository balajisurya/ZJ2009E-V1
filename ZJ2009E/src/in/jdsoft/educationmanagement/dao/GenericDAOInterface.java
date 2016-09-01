package in.jdsoft.educationmanagement.dao;

import java.util.List;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Repository;

@Repository
public interface GenericDAOInterface<T> {
	public void persist(T transientInstance)throws ConstraintViolationException;
	public void  delete(T persistentInstance)throws DataIntegrityViolationException;
	public List<T> getList();
	public void update(T persistentInstance)throws DataIntegrityViolationException;
	public void saveOrUpdate(T instance)throws DataIntegrityViolationException;
}
