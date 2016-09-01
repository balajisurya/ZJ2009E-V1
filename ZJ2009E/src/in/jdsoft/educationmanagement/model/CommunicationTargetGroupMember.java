package in.jdsoft.educationmanagement.model;

import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="tbl_communication_target_group_member")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class CommunicationTargetGroupMember implements Serializable{

	
	public CommunicationTargetGroupMember(CommunicationTargetGroup communicationTargetGroup, Users users) {
		this.communicationTargetGroups.add(communicationTargetGroup);
		this.users = users;
	}
	
	public CommunicationTargetGroupMember() {
		
	}
	
	private static final long serialVersionUID = 1L;
	
	

	private Integer commuincationTargetGroupMemberId;
	
	private Users users;
	private Set<CommunicationTargetGroup> communicationTargetGroups=new HashSet<CommunicationTargetGroup>(0);

	
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "communication_target_group_member_id", nullable = false)
	public Integer getCommuincationTargetGroupMemberId() {
		return commuincationTargetGroupMemberId;
	}
	public void setCommuincationTargetGroupMemberId(Integer commuincationTargetGroupMemberId) {
		this.commuincationTargetGroupMemberId = commuincationTargetGroupMemberId;
	}
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id", nullable = false)
	public Users getUsers() {
		return users;
	}
	public void setUsers(Users users) {
		this.users = users;
	}
	
	@ManyToMany(fetch = FetchType.LAZY, mappedBy = "communicationTargetGroupMember")
	public Set<CommunicationTargetGroup> getCommunicationTargetGroups() {
		return communicationTargetGroups;
	}
	public void setCommunicationTargetGroups(Set<CommunicationTargetGroup> communicationTargetGroups) {
		this.communicationTargetGroups = communicationTargetGroups;
	}

	
	
}
