package in.jdsoft.educationmanagement.dao;
// Generated Mar 29, 2016 2:42:25 PM by Hibernate Tools 3.4.0.CR1

import org.springframework.stereotype.Repository;

import in.jdsoft.educationmanagement.model.Module;

@Repository
public class ModuleDAO extends GenericDAO<Module> {

	public ModuleDAO() {
		super(Module.class);
	}

	public Module getModuleById(java.lang.Integer id) {
		try {
			Module instance = (Module) sessionFactory.getCurrentSession()
					.get("in.jdsoft.educationmanagement.model.Module", id);
			if (instance == null) {
				//logging
			} else {
				//logging
			}
			return instance;
		} catch (RuntimeException re) {
			throw re;
		}
	}
	
	
}
