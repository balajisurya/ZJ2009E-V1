package in.jdsoft.educationmanagement.services;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import in.jdsoft.educationmanagement.dao.CommunicationAndIssuesOrQueriesDAO;
import in.jdsoft.educationmanagement.dao.CommunicationTargetGroupDAO;
import in.jdsoft.educationmanagement.dao.CommunicationTargetGroupMemberDAO;
import in.jdsoft.educationmanagement.dao.CommunicationTargetGroupVisibilityDAO;
import in.jdsoft.educationmanagement.model.CommunicationAndIssuesOrQueries;
import in.jdsoft.educationmanagement.model.CommunicationTargetGroup;
import in.jdsoft.educationmanagement.model.CommunicationTargetGroupMember;
import in.jdsoft.educationmanagement.model.CommunicationTargetGroupVisibility;


// This component includes service components for both CommunicationAndIssuesOrQueries as well as CommunicationTargetGroup
@Service
public class CommunicationAndIssuesOrQueriesServices 
{
	
	@Autowired
	CommunicationAndIssuesOrQueriesDAO communicationAndIssuesOrQueriesDAO;
	@Autowired
	CommunicationTargetGroupDAO communicationTargetGroupDAO;
	@Autowired
    CommunicationTargetGroupVisibilityDAO	communicationTargetGroupVisibilityDAO;
	@Autowired
	CommunicationTargetGroupMemberDAO 	communicationTargetGroupMemberDAO;
		
	@Transactional
	public void addCommunicationAndIssuesOrQueries(CommunicationAndIssuesOrQueries communicationAndIssuesOrQueries){
		communicationAndIssuesOrQueriesDAO.persist(communicationAndIssuesOrQueries);
	}

	@Transactional
	public void deleteCommunicationAndIssuesOrQueries(int communicationAndIssuesOrQueriesId){
		communicationAndIssuesOrQueriesDAO.delete(communicationAndIssuesOrQueriesDAO.getCommunicationAndIssuesOrQueriesById(communicationAndIssuesOrQueriesId));
	}

	@Transactional
	public void updateCommunicationAndIssuesOrQueries(CommunicationAndIssuesOrQueries communicationAndIssuesOrQueries){
		communicationAndIssuesOrQueriesDAO.update(communicationAndIssuesOrQueries);
	}

	@Transactional
	public ArrayList<CommunicationAndIssuesOrQueries> getCommunicationAndIssuesOrQueriesList(){
		return (ArrayList<CommunicationAndIssuesOrQueries>)communicationAndIssuesOrQueriesDAO.getList();
	}

	@Transactional
	public CommunicationAndIssuesOrQueries getCommunicationAndIssuesOrQueriesById(int communicationAndIssuesOrQueriesId){
		return communicationAndIssuesOrQueriesDAO.getCommunicationAndIssuesOrQueriesById(communicationAndIssuesOrQueriesId);
	}

	// This is for CommunicationTargetGroup
		
		@Transactional
		public void addCommunicationTargetGroup(CommunicationTargetGroup communicationTargetGroup){
			communicationTargetGroupDAO.persist(communicationTargetGroup);
		}
	
		@Transactional
		public void deleteCommunicationTargetGroup(int communicationTargetGroupId){
			communicationTargetGroupDAO.delete(communicationTargetGroupDAO.getCommunicationTargetGroupById(communicationTargetGroupId));
		}
	
		@Transactional
		public void updateCommunicationTargetGroup(CommunicationTargetGroup communicationTargetGroup){
			communicationTargetGroupDAO.update(communicationTargetGroup);
		}
	
		@Transactional
		public ArrayList<CommunicationTargetGroup> getCommunicationTargetGroupList(){
			return (ArrayList<CommunicationTargetGroup>)communicationTargetGroupDAO.getList();
		}
	
		@Transactional
		public CommunicationTargetGroup getCommunicationTargetGroupById(int communicationTargetGroupId){
			return communicationTargetGroupDAO.getCommunicationTargetGroupById(communicationTargetGroupId);
		}
	
		
	@Transactional
	public void addCommunicationTargetGroupMember(CommunicationTargetGroupMember communicationTargetGroupMember){
		 communicationTargetGroupMemberDAO.persist(communicationTargetGroupMember);
	}
	@Transactional
	public void deleteCommunicationTargetGroupMember(int communicationTargetGroupMemberId )
	{
	     communicationTargetGroupMemberDAO.delete(communicationTargetGroupMemberDAO.getCommunicationTargetGroupMemberById(communicationTargetGroupMemberId));
	}
	@Transactional
	public void updateCommunicationTargetGroupMember(CommunicationTargetGroupMember communicationTargetGroupMember)
	{
		 communicationTargetGroupMemberDAO.update(communicationTargetGroupMember);
	}
	@Transactional
	public ArrayList<CommunicationTargetGroupMember> getCommunicationTargetGroupMemberList(){
		return (ArrayList<CommunicationTargetGroupMember>)communicationTargetGroupMemberDAO.getList();	
	}
    @Transactional
    public CommunicationTargetGroupMember getCommunicationTargetGroupMemberId(int communicationTargetGroupMemberId){
    	return communicationTargetGroupMemberDAO.getCommunicationTargetGroupMemberById(communicationTargetGroupMemberId);
    }
	@Transactional
	public ArrayList<CommunicationTargetGroupVisibility> getCommunicationTargetGroupVisibilityList(){
        return (ArrayList<CommunicationTargetGroupVisibility>)communicationTargetGroupVisibilityDAO.getList();
		
	}
}
