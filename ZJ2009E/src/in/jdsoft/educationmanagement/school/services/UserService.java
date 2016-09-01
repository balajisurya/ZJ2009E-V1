package in.jdsoft.educationmanagement.school.services;

import java.util.ArrayList;
import java.util.Set;

import org.hibernate.Hibernate;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.mail.MailSendException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import in.jdsoft.educationmanagement.components.EmailHandler;
import in.jdsoft.educationmanagement.components.ExceptionComparator;
import in.jdsoft.educationmanagement.school.dao.InstitutionDAO;
import in.jdsoft.educationmanagement.school.dao.MasterUserTypeDAO;
import in.jdsoft.educationmanagement.school.dao.UserDAO;
import in.jdsoft.educationmanagement.school.exceptions.UserServiceExceptions;
import in.jdsoft.educationmanagement.school.model.Institution;
import in.jdsoft.educationmanagement.school.model.MasterUserType;
import in.jdsoft.educationmanagement.school.model.Message;
import in.jdsoft.educationmanagement.school.model.User;


@Service
public class UserService {
	@Autowired
	UserDAO userdao;
	@Autowired
	MasterUserTypeDAO masterusertypedao;
	@Autowired
	InstitutionDAO institutionDAO;
	@Autowired
	ExceptionComparator exceptionComparator;
	@Autowired
	EmailHandler emailHandler;
	
	@Transactional
	public boolean userLogin(String email, String password){
		boolean isValid=false;
			User user=getUserByEmail(email);
			if(user!=null){
				if(user.getPassword().equals(password)){
					isValid=true; 
				}
				else if(!user.getPassword().equals(password)){
					isValid=false;
				}
			}
			return isValid;
	}
	
	
	@Transactional(rollbackFor=UserServiceExceptions.class)
	public void addUser(User user)throws UserServiceExceptions{
		
		try
		{
		Set<User> users=getUserList(user.getInstitution().getInstitutionId());
		int size=users.size();
			if(!(size>15))
			{
					userdao.persist(user);
			}
			else
			{
				 throw new UserServiceExceptions(new Message("errorMessage", "Cannot create more than 15 users."));
				
			}
		} 
		catch (ConstraintViolationException e)
		{
		  if(e.getClass().equals(ConstraintViolationException.class))
		  {
			  String valid=exceptionComparator.containsWord(e.getMessage());
				if(valid!=null)
				{
					throw new UserServiceExceptions(new Message("duplicate", "Cannot Create Duplicate Email Id"));
					
				}else
				{
					 throw e;
				}
			  
		  }else
		  {
			  throw e;
		  }
		 
	  }
	}
	
	
	@Transactional
	public void deleteUser(int userId)throws DataIntegrityViolationException{
		userdao.delete(getUserById(userId));
	}
	
	@Transactional
	public ArrayList<User> getUserList(){
		ArrayList<User> userList=(ArrayList<User>) userdao.getList();
		for(User user:userList){
			Hibernate.initialize(user.getUserTypes());
		}
		return userList;
	}


	@Transactional
	public void updateUser(User user)throws DataIntegrityViolationException{
		userdao.update(user);	 
	}
	
	@Transactional
	public void updateLoginTime(User user){
		userdao.update(user);
	}
	
	
	@Transactional
	public ArrayList<MasterUserType> getUserTypeList(){
		return (ArrayList<MasterUserType>) masterusertypedao.getList();
	}
	
	@Transactional
	public User getUserById(int userId){
		User user=userdao.getUserById(userId);
		return user; 
		
	}
	
	@Transactional
	public User getUserByEmail(String email){
		User user=userdao.getUserByEmail(email);
		Hibernate.initialize(user.getInstitution());
		Hibernate.initialize(user.getReceivedPortalTask());
		Hibernate.initialize(user.getReceivedPortalNotifications());
		return user;
	}
	
	@Transactional
	public MasterUserType getMasterUserTypeById(int masterUserTypeId){
		return masterusertypedao.getMasterUserTypeById(masterUserTypeId);
	}
	
	
	
	@Transactional
	public void addUserType(MasterUserType userType){
		masterusertypedao.persist(userType);
	}
	
	
	@Transactional
	public void deleteUserType(int userTypeId){
		masterusertypedao.delete(getMasterUserTypeById(userTypeId));
	}
	
	@Transactional
	public Boolean validateEmail(String usernameEmail){
    			User user=userdao.getUserByEmail(usernameEmail);
				if(user!=null){
					return true;
					
				}
				else{
					return false;
				}
	}
	
	@Transactional
	public Set<User> getUserList(Integer institutionId){
			Institution institution= institutionDAO.getInstitutionById(institutionId);
			Hibernate.initialize(institution.getUsers());
			Set<User> user=institution.getUsers();
			return user;
	}
	
	@Transactional
	public void resetPasswordByEmail(String userEmail) throws UserServiceExceptions{
		try {
			if(validateEmail(userEmail)){
				User user= userdao.getUserByEmail(userEmail);
				 emailHandler.sendEmail(userEmail, "Password Reset","Username: "+user.getEmail()+"\n Password: "+user.getPassword());
			}
			else{
				throw new UserServiceExceptions(new Message("failed","No Matching Account Found With This E-mail Id"));
				
			}
			
		} catch (Exception e) {
			if(e.getClass().equals(MailSendException.class)){
              
			
			
				throw new UserServiceExceptions(new Message("failed","No Internet Connnetion Found ! Please Check The Connection"));
			}
			else{
				
				
				throw e;
			}
		}
		
		 
		
	}
}
