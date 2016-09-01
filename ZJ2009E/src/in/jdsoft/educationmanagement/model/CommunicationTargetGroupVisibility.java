package in.jdsoft.educationmanagement.model;

import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
@Entity
@Table(name="tbl_communication_target_group_visibility")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class CommunicationTargetGroupVisibility implements Serializable 
{

	public CommunicationTargetGroupVisibility(CommunicationTargetGroup communicationTargetGroup,
			MasterUserType masterUsertype) {
		this.communicationTargetGroup = communicationTargetGroup;
		this.masterUsertype = masterUsertype;
	}
	
	public CommunicationTargetGroupVisibility() {
		
	}
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "communication_target_group_visibility_id", nullable = false)
	public Integer getCommunicationTargetGroupVisibilityId() {
		return communicationTargetGroupVisibilityId;
	}
	public void setCommunicationTargetGroupVisibilityId(Integer communicationTargetGroupVisibilityId) {
		this.communicationTargetGroupVisibilityId = communicationTargetGroupVisibilityId;
	}
	
	public CommunicationTargetGroup getCommunicationTargetGroup() {
		return communicationTargetGroup;
	}
	public void setCommunicationTargetGroup(CommunicationTargetGroup communicationTargetGroup) {
		this.communicationTargetGroup = communicationTargetGroup;
	}
	
	public MasterUserType getMasterUsertype() {
		return masterUsertype;
	}
	public void setMasterUsertype(MasterUserType masterUsertype) {
		this.masterUsertype = masterUsertype;
	}
	private static final long serialVersionUID = 1L;
	//Pk
	private Integer communicationTargetGroupVisibilityId;
	//Fields
	
	
	//Model
	private CommunicationTargetGroup communicationTargetGroup;
	private MasterUserType masterUsertype;

}
