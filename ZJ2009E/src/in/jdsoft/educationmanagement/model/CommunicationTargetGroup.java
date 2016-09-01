package in.jdsoft.educationmanagement.model;

import static javax.persistence.GenerationType.IDENTITY;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@Entity
@Table(name = "tbl_communication_target_group")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class CommunicationTargetGroup implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	public CommunicationTargetGroup(String communicationTargetGroupName) {
		this.communicationTargetGroupName = communicationTargetGroupName;
	}

	public CommunicationTargetGroup()
	{}
	
	
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "communication_target_group_id", nullable = false)
	public Integer getCommunicationTargetGroupId() {
		return communicationTargetGroupId;
	}

	public void setCommunicationTargetGroupId(Integer communicationTargetGroupId) {
		this.communicationTargetGroupId = communicationTargetGroupId;
	}
	@Column(name = "communication_target_group_name",  nullable = false,length = 40)
	public String getCommunicationTargetGroupName() {
		return communicationTargetGroupName;
	}

	public void setCommunicationTargetGroupName(String communicationTargetGroupName) {
		this.communicationTargetGroupName = communicationTargetGroupName;
	}

	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "tbl_communication_target_group_mapping",joinColumns = { 
			@JoinColumn(name = "communication_target_group_id", nullable = false, updatable = false) }, 
			inverseJoinColumns = { @JoinColumn(name = "communication_target_group_member_id", 
					nullable = false, updatable = false) })
	public Set<CommunicationTargetGroupMember> getCommunicationTargetGroupMember() {
		return communicationTargetGroupMember;
	}

	public void setCommunicationTargetGroupMember(Set<CommunicationTargetGroupMember> communicationTargetGroupMember) {
		this.communicationTargetGroupMember = communicationTargetGroupMember;
	}



	//PK
	private Integer communicationTargetGroupId;
	
	//Single Fields
	private String communicationTargetGroupName;
	
	private Set<CommunicationTargetGroupMember> communicationTargetGroupMember=new HashSet<CommunicationTargetGroupMember>(0);

	

	
}
