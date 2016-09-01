package in.jdsoft.educationmanagement.services;

import java.util.ArrayList;
import java.util.Set;

import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import in.jdsoft.educationmanagement.dao.MasterUserTypeDAO;
import in.jdsoft.educationmanagement.dao.UserStatusDAO;
import in.jdsoft.educationmanagement.dao.UsersDAO;
import in.jdsoft.educationmanagement.model.Admission;
import in.jdsoft.educationmanagement.model.MasterUserType;
import in.jdsoft.educationmanagement.model.Message;
import in.jdsoft.educationmanagement.model.UserStatus;
import in.jdsoft.educationmanagement.model.Users;

@Service
public class UserService {
	@Autowired
	UsersDAO userdao;
	@Autowired
	UserStatusDAO userstatusdao;
	@Autowired
	MasterUserTypeDAO masterusertypedao;
	
	
	@Transactional
	public boolean userLogin(String email, String password){
		boolean isValid=false;
		try{
			Users user=getUserByEmail(email);
			if(user!=null){
				if(user.getPassword().equals(password)){
					isValid=true; 
				}
				else if(!user.getPassword().equals(password)){
					isValid=false;
				}
			}
			return isValid;
		}catch(NullPointerException e){
			return isValid;
		}
	}
	
	
	@Transactional
	public void addUser(Users user){
		userdao.persist(user);
	}
	
	
	@Transactional
	public void deleteUser(int userId){
		userdao.delete(getUserById(userId));
	}
	
	@Transactional
	public ArrayList<Users> getUsersList(){
		ArrayList<Users> userList=(ArrayList<Users>) userdao.getList();
		for(Users users:userList){
			Hibernate.initialize(users.getUserTypes());
		}
		return userList;
	}

	
	@Transactional
	public void updateUser(Users user){
		userdao.update(user);
		
	}
	
	@Transactional
	public void updateLoginTime(Users user){
		userdao.update(user);
	}
	
	@Transactional
	public String getStatusTitle(int statusId){
		UserStatus userStatus= userstatusdao.getStatusById(statusId);
		return userStatus.getUserStatusTitle();
		
	}
	
	@Transactional
	public ArrayList<UserStatus> getUserStatusList(){
		return (ArrayList<UserStatus>) userstatusdao.getList();
	}
	
	@Transactional
	public ArrayList<MasterUserType> getUserTypeList(){
		return (ArrayList<MasterUserType>) masterusertypedao.getList();
	}
	
	@Transactional
	public Users getUserById(int userId){
		Users u=userdao.getUserById(userId);
		return u; 
		
	}
	
	@Transactional
	public Users getUserByEmail(String email){
		Users user=userdao.getUserByEmail(email);
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
	public Set<Admission> getUsersAdmissionApplication(String email){
		Users user=userdao.getUserByEmail(email);
		Hibernate.initialize(user.getUserAdmission());
		Set<Admission> admissions=user.getUserAdmission();
		for(Admission admission:admissions){
			Hibernate.initialize(admission.getAdmissionStatus());
		}
		return admissions;
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
	public Message emailAvailablityCheck(String usernameEmail){
    		try {
    			Users user=userdao.getUserByEmail(usernameEmail);
				if(user!=null){
					return new Message("failed","Email id is already taken !! use different e-mail id");
				}
				else{
					return new Message("success","Email Id is Available");
				}
			} catch (Exception e) {
				e.printStackTrace();
				throw e;
			}
	}
}
