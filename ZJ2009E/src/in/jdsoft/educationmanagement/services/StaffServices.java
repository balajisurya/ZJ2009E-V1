package in.jdsoft.educationmanagement.services;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;

import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import in.jdsoft.educationmanagement.components.HashGenerator;
import in.jdsoft.educationmanagement.dao.PortalNotificationDAO;
import in.jdsoft.educationmanagement.dao.PortalTaskDAO;
import in.jdsoft.educationmanagement.dao.StaffAttendanceDAO;
import in.jdsoft.educationmanagement.dao.StaffAttendanceTypeDAO;
import in.jdsoft.educationmanagement.dao.StaffCategoriesDAO;
import in.jdsoft.educationmanagement.dao.StaffDAO;
import in.jdsoft.educationmanagement.dao.StaffLeaveRequisitionDAO;
import in.jdsoft.educationmanagement.dao.StaffLeaveTypeDAO;
import in.jdsoft.educationmanagement.dao.StaffPerformanceDAO;
import in.jdsoft.educationmanagement.dao.StaffTypesDAO;
import in.jdsoft.educationmanagement.dao.UsersDAO;
import in.jdsoft.educationmanagement.model.PortalNotification;
import in.jdsoft.educationmanagement.model.PortalTask;
import in.jdsoft.educationmanagement.model.Staff;
import in.jdsoft.educationmanagement.model.StaffAttendance;
import in.jdsoft.educationmanagement.model.StaffAttendanceType;
import in.jdsoft.educationmanagement.model.StaffCategories;
import in.jdsoft.educationmanagement.model.StaffLeaveRequisition;
import in.jdsoft.educationmanagement.model.StaffLeaveType;
import in.jdsoft.educationmanagement.model.StaffPerformance;
import in.jdsoft.educationmanagement.model.StaffTypes;
import in.jdsoft.educationmanagement.model.Users;

@Service
public class StaffServices {
	
	@Autowired
	StaffAttendanceDAO staffAttendanceDAO;
	@Autowired
	StaffAttendanceTypeDAO staffAttendanceTypeDAO;
	@Autowired
	StaffCategoriesDAO staffCategoryDAO;
	@Autowired
	StaffDAO staffDAO;
	@Autowired
	StaffTypesDAO staffTypesDAO;
	@Autowired
	StaffLeaveTypeDAO staffLeaveTypeDAO;
	@Autowired
	UsersDAO usersDAO;
	@Autowired
	StaffPerformanceDAO staffPerformanceDAO;
	@Autowired
	StaffLeaveRequisitionDAO staffLeaveRequisitionDAO;
	@Autowired
	PortalTaskDAO portalTaskDAO;
	@Autowired
	PortalNotificationDAO portalNotificationDAO;
	
	
	@Autowired
	HashGenerator hashGenerator;
	
	
	@Transactional
	public void addStaffAppraisal(StaffPerformance staffPerformance){
		staffPerformanceDAO.persist(staffPerformance);
	}

	@Transactional
	public void deleteStaffAppraisal(int staffAppraisalId){
		staffPerformanceDAO.delete(staffPerformanceDAO.getStaffPerformanceById(staffAppraisalId));
	}

	@Transactional
	public void updateStaffAppraisal(StaffPerformance staffPerformance){
		staffPerformanceDAO.update(staffPerformance);
	}

	@Transactional
	public ArrayList<StaffPerformance> getStaffPerformanceList(){
		return (ArrayList<StaffPerformance>)staffPerformanceDAO.getList();
	}

	@Transactional
	public StaffPerformance getStaffPerformanceById(int staffAppraisalId){
		return staffPerformanceDAO.getStaffPerformanceById(staffAppraisalId);
	}

	
	
	
	@Transactional
	public ArrayList<Staff> getTeachingStaffList(){
		ArrayList<Staff> staffList= (ArrayList<Staff>) staffDAO.getList();
		Iterator<Staff> staffs=staffList.iterator();
		while(staffs.hasNext()){
			Staff staff=staffs.next();
			if(staff.getStaffType().getStaffTypeId()!=1){
				staffs.remove();
				continue;
			}
			Hibernate.initialize(staff.getDepartment());
		}
		return staffList;
	}
	
	
	@Transactional
	public ArrayList<Staff> getNonTeachingStaffList(){
		ArrayList<Staff> staffList= (ArrayList<Staff>) staffDAO.getList();
		Iterator<Staff> staffs=staffList.iterator();
		while(staffs.hasNext()){
			Staff staff=staffs.next();
			if(staff.getStaffType().getStaffTypeId()!=2){
				staffs.remove();
				continue;
			}
			Hibernate.initialize(staff.getDepartment());
		}
		return staffList;
	}
	
	@Transactional
	public Set<StaffLeaveRequisition> getStaffLeaveRequests(String username){
		try{
			Users user= usersDAO.getUserByEmail(username);
			Hibernate.initialize(user.getStaff().getStaffLeaveRequisitions());
			Set<StaffLeaveRequisition> staffLeaveRequests=user.getStaff().getStaffLeaveRequisitions();
			Iterator<StaffLeaveRequisition> staffLeaveRequisitions=staffLeaveRequests.iterator();
			while(staffLeaveRequisitions.hasNext()){
				StaffLeaveRequisition staffLeaveRequisition= staffLeaveRequisitions.next();
				if(staffLeaveRequisition.getApprovalStatus().equals("Pending")){
					Hibernate.initialize(staffLeaveRequisition.getStaffLeaveType());
				}
				else{
					staffLeaveRequisitions.remove();
				}
				
			}
		  return staffLeaveRequests;
		}catch(Exception e){
			throw e;
		}
	}
	
	@Transactional
	public Set<StaffLeaveRequisition> getStaffLeaveApprovals(String username){
		try {
			Users user= usersDAO.getUserByEmail(username);
			Hibernate.initialize(user.getStaffLeaveRequistion());
			Set<StaffLeaveRequisition> staffLeaveRequisitions= user.getStaffLeaveRequistion();
		    Iterator<StaffLeaveRequisition> approvals=staffLeaveRequisitions.iterator();
		    while(approvals.hasNext()){
		    	StaffLeaveRequisition staffLeaveRequisition= approvals.next();
		    	if(staffLeaveRequisition.getApprovalStatus().equals("Pending")){
		    		Hibernate.initialize(staffLeaveRequisition.getStaffLeaveType());
		    		Hibernate.initialize(staffLeaveRequisition.getStaff());
		    	}
		    	else{
		    		approvals.remove();
		    	}
		    }
		    return staffLeaveRequisitions;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	
		
	}
	
	
	@Transactional
	 public ArrayList<StaffAttendance> getStaffAttendanceList(){
		 return (ArrayList<StaffAttendance>) staffAttendanceDAO.getList();
	 }
	 
	@Transactional
	 public void deleteStaffAttendance(int staffAttendanceId ){
		 staffAttendanceDAO.delete(staffAttendanceDAO.getStaffAttendanceByAttendanceId(staffAttendanceId));
	 }
	 
	@Transactional
	 public void addStaffAttendance(StaffAttendance staffAttendance){
		try {
			staffAttendanceDAO.persist(staffAttendance);
		} catch (Exception e) {
			throw e;
		}
		 
	 }
	 
	@Transactional
	 public void updateStaffAttendance(StaffAttendance staffAttendance){
		 staffAttendanceDAO.update(staffAttendance);
	 }
	 
	@Transactional
	 public StaffAttendance getStaffAttendanceById(int staffAttendanceId){
		 return staffAttendanceDAO.getStaffAttendanceByAttendanceId(staffAttendanceId);
	 }
	
	@Transactional
	public void addStaffAttendanceType(StaffAttendanceType staffAttendanceType){
		staffAttendanceTypeDAO.persist(staffAttendanceType);
	}
	
	@Transactional
	public ArrayList<StaffAttendanceType> getStaffAttendanceTypeList(){
		return (ArrayList<StaffAttendanceType>) staffAttendanceTypeDAO.getList();
	}
	
	@Transactional
	public void deleteStaffAttendanceTypes(int staffAttendanceTypeId){
		staffAttendanceTypeDAO.delete(staffAttendanceTypeDAO.getStaffAttendanceTypeById(staffAttendanceTypeId));
	}
	
	@Transactional
	public void updateStaffAttendanceTypes(StaffAttendanceType staffAttendanceType){
		staffAttendanceTypeDAO.update(staffAttendanceType);
	}
	
	@Transactional
	public StaffAttendanceType getStaffAttendanceTypeById(int attendanceTypeId){
		return staffAttendanceTypeDAO.getStaffAttendanceTypeById(attendanceTypeId);
	}
	
	@Transactional
	public void addStaffCategoy(StaffCategories category){
		staffCategoryDAO.persist(category);
	}
	
	@Transactional
	 public ArrayList<StaffCategories> getAllStaffCategories(){
		 return (ArrayList<StaffCategories>) staffCategoryDAO.getList();
	 }
	
	@Transactional
	 public ArrayList<StaffCategories> getStaffCategories(){
		 return (ArrayList<StaffCategories>) staffCategoryDAO.getList();
	 }
	
	@Transactional
	 public ArrayList<StaffCategories> getStaffCategoriesWithStaffType() throws Exception{
		try {
			ArrayList<StaffCategories> staffCategories=(ArrayList<StaffCategories>) staffCategoryDAO.getList();
			for(StaffCategories staffCategory:staffCategories){
				Hibernate.initialize(staffCategory.getStaffType());
			}
			 return staffCategories;
		} catch (Exception e) {
			throw new Exception();
		}
	 }
	 
	@Transactional
	 public  StaffCategories getStaffCategoryById(int staffCategoryId){
		StaffCategories staffCategory= staffCategoryDAO.getStaffCategoryById(staffCategoryId);
		Hibernate.initialize(staffCategory.getMasterUserType());
		Hibernate.initialize(staffCategory.getStaffType());
		
		return staffCategory;
	 }
	
	 
	@Transactional
	 public void deleteStaffCategory(int staffCategoryId){
		 staffCategoryDAO.delete(staffCategoryDAO.getStaffCategoryById(staffCategoryId));
	 }
	 
	@Transactional
	 public void updateStaffCategory(StaffCategories staffCategory){
		 staffCategoryDAO.update(staffCategory);
	 }
	
	@Transactional
	public void addStaff(Staff staff) throws Exception{
		String staffPasword="staff@edumaat";
		String hash=hashGenerator.encoder(staffPasword);
		Users user= usersDAO.save(new Users(staff.getStaffCategory().getMasterUserType(),staff.getStaffFirstName()+" "+staff.getStaffLastName(),staff.getStaffEmail(),staffPasword,staff.getStaffCreatedBy(),1, hash,staff.getProfilePicturePath(), staff.getInstitution())) ;
		if(staff.getApprover()==null){
			staff.setApprover(user);
			staff.setUser(user);
			staffDAO.persist(staff);
		}
		else{
			staff.setUser(user);
			staffDAO.persist(staff);
		}
		
	}
	
	@Transactional
	public ArrayList<Staff> getStaffList(){
		return (ArrayList<Staff>) staffDAO.getList();
	}
	
	@Transactional
	public void deleteStaff(int staffId){
	  staffDAO.delete(staffDAO.getStaffById(staffId));
	}
	
	@Transactional
	public void updateStaff(Staff staff){
		staffDAO.update(staff);
	}
	
	
	
	@Transactional
	 public Staff getStaffById(int staffId){
		Staff staff= staffDAO.getStaffById(staffId);
		return staff;
	 }
	
	@Transactional
	 public Staff getStaffLazyById(int staffId){
		try {
			Staff staff= staffDAO.getStaffById(staffId);
			if(staff!=null){
				Hibernate.initialize(staff.getCategory());
				Hibernate.initialize(staff.getStaffType());
				Hibernate.initialize(staff.getStaffCategory());
				Hibernate.initialize(staff.getDepartment());
				Hibernate.initialize(staff.getBloodGroup());
				Hibernate.initialize(staff.getApprover().getStaff());
			}
			return staff;
		} catch (Exception e) {
			throw e;
		}
		
	 }
	
	
	@Transactional
	 public ArrayList<StaffTypes> getStaffTypeList(){
		 return (ArrayList<StaffTypes>) staffTypesDAO.getList();
	 }
	
	@Transactional
	public StaffTypes getStaffTypeById(int staffTypeId){
		return staffTypesDAO.getStaffTypesById(staffTypeId);
	}
	
	@Transactional
	 public void addStaffLeaveType(StaffLeaveType staffLeaveType){
		staffLeaveTypeDAO.persist(staffLeaveType);
	 }
	 
	@Transactional
	 public ArrayList<StaffLeaveType> getStaffLeaveTypeList(){
		 return (ArrayList<StaffLeaveType>) staffLeaveTypeDAO.getList();
	 }
	 
	@Transactional
	 public void deleteStaffLeaveType(int staffLeaveTypeId ){
		staffLeaveTypeDAO.delete(staffLeaveTypeDAO.getStaffLeaveTypeById(staffLeaveTypeId));
	 }
	 
	@Transactional
	 public void updateStaffLeaveType(StaffLeaveType staffLeaveType){
		staffLeaveTypeDAO.update(staffLeaveType);
	 }
	 
	@Transactional
	 public StaffLeaveType getStaffLeaveTypeById(int staffLeaveTypeId){
		 return staffLeaveTypeDAO.getStaffLeaveTypeById(staffLeaveTypeId);
	 }

	
	@Transactional
	public Set<StaffCategories>  getStaffCategoriesFromStaffTypeId(Integer staffTypeId) throws Exception{
		try{
			StaffTypes staffType= staffTypesDAO.getStaffTypesById(staffTypeId);
			Hibernate.initialize(staffType.getStaffCategories());
			Set<StaffCategories> staffCategory= staffType.getStaffCategories();
			Iterator<StaffCategories> staffCategoryIterator=staffCategory.iterator();
			while(staffCategoryIterator.hasNext()){
				StaffCategories staffCategories=staffCategoryIterator.next();
				if(staffCategories.getStaffCategoryVisible()==0){
					staffCategoryIterator.remove();
				}
			}
		
		    return staffCategory;
		}
		catch(Exception e){
			e.printStackTrace();
			return null;
		}
		
	}
	
	
	 @Transactional
	 public Set<StaffPerformance> getStaffPerformanceRecords(int staffId){
		 try{
		  Staff staff= staffDAO.getStaffById(staffId);
		  Hibernate.initialize(staff.getStaffPerformance());
		  Set<StaffPerformance>  staffPerformance=staff.getStaffPerformance();
		  return staffPerformance;
		 }
		catch(Exception e){
				e.printStackTrace();
				return null;
			}
	 }
	
	@Transactional
	 public void addStaffLeaveRequisition(StaffLeaveRequisition staffLeaveRequisition){
		try {
			 staffLeaveRequisitionDAO.persist(staffLeaveRequisition);
			 PortalTask portalTask=new PortalTask("Leave Approvals","Leave Approvals", "staff/approvals",staffLeaveRequisition.getLeaveApprover(),staffLeaveRequisition.getApprovalStatus(),staffLeaveRequisition.getStaff().getUser());
			 portalTaskDAO.persist(portalTask);
		} catch (Exception e) {
			throw e;
		}
	}
	
	@Transactional
	public StaffLeaveRequisition getStaffLeaveRequisitionById(Integer staffLeaveRequistionId){
		try {
			  StaffLeaveRequisition staffLeaveRequisition = staffLeaveRequisitionDAO.getStaffLeaveRequisitionById(staffLeaveRequistionId);
			  Hibernate.initialize(staffLeaveRequisition.getStaff().getUser()); 
		      return staffLeaveRequisition;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
	
	@Transactional
	public void cancelStaffLeaveRequisition(StaffLeaveRequisition staffLeaveRequisition){
		try {
			staffLeaveRequisitionDAO.update(staffLeaveRequisition);
			Hibernate.initialize(staffLeaveRequisition.getStaff().getUser());
			Users createdUser=staffLeaveRequisition.getStaff().getUser();
			Users targetUser=staffLeaveRequisition.getStaff().getApprover();
			PortalNotification leaveCancelNotification= new PortalNotification("Leave Cancelled","Leave Cancelled", targetUser,0,"", createdUser);
		    portalNotificationDAO.persist(leaveCancelNotification);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
	
	@Transactional
	public void updateStaffLeaveRequisition(StaffLeaveRequisition staffLeaveRequisition){
		try {
			staffLeaveRequisitionDAO.update(staffLeaveRequisition);
			PortalNotification staffLeaveStatusNotification=new PortalNotification("Leave Approvals","Leave Approvals",staffLeaveRequisition.getStaff().getUser(),0,"${pageContext.request.contextPath}/staff/requisition",staffLeaveRequisition.getLeaveApprover());
			portalNotificationDAO.persist(staffLeaveStatusNotification);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
	
	@Transactional
	 public  Set<Staff> getStaffListOfUser(String emailId){
		 try {
			 Users user=usersDAO.getUserByEmail(emailId);
			 Hibernate.initialize(user.getStaffs());
			 Set<Staff> staffs=user.getStaffs();
			 for(Staff staff:staffs){
				 Hibernate.initialize(staff.getStaffCategory());
			 }
			 return staffs;
		} catch (Exception e) {
			throw e;
		}
	}
	
/*	@Transactional
	public void addStaffLeaveRequisition(StaffLeaveRequisition staffLeaveRequsition){
		staffRequsionDAO.persist(staffLeaveRequsition);
	}
	
	@Transactional
	public ArrayList<StaffLeaveRequisition> getStaffLeaveRequisitionList(){
		return (ArrayList<StaffLeaveRequisition>) staffRequsionDAO.getList() ;
	}
	
	@Transactional
	public void deleteStaffLeaveRequisition(int departmentId){
		staffRequsionDAO.delete(staffRequsionDAO.getStaffLeaveRequisitionById(departmentId));
	}
	
	@Transactional
	public void updateStaffLeaveRequisition(StaffLeaveRequisition staffLeaveRequisition){
		staffRequsionDAO.update(staffLeaveRequisition);
	}
	
	@Transactional
	public StaffLeaveRequisition getStaffLeaveRequisitionById(int staffLeaveRequisitionId){
		return staffRequsionDAO.getStaffLeaveRequisitionById(staffLeaveRequisitionId);
	}*/
	
}
