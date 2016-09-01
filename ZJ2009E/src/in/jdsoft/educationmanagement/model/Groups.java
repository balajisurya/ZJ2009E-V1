package in.jdsoft.educationmanagement.model;
 
import static javax.persistence.GenerationType.IDENTITY;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.apache.commons.lang.WordUtils;
import org.hibernate.annotations.ForeignKey;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;



@Entity
@Table(name = "tbl_groups")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Groups implements java.io.Serializable {
	
	public Groups() {
		// TODO Auto-generated constructor stub
	}
	
	private static final long serialVersionUID = 1L;
	private Integer groupId;
	private String groupCode;
	private String groupName;
	private Institution institution;
	
	private Set<GroupMapping> groupMappings = new HashSet<GroupMapping>(0);//change

	
	public Groups(String groupName,Institution institution){
		this.groupName =WordUtils.capitalize(groupName);
		this.groupCode=Long.toString(System.currentTimeMillis());
		this.institution=institution;
	}
	

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "group_id", unique = true, nullable = false)
	public Integer getGroupId() {
		return this.groupId;
	}

	public void setGroupId(Integer groupId) {
		this.groupId = groupId;
	}

	@Column(name = "group_name", nullable = false, length = 75)
	public String getGroupName() {
		return this.groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName =WordUtils.capitalize(groupName);
	}

	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "groups",cascade=CascadeType.ALL)
	public Set<GroupMapping> getGroupMapping() {
		return groupMappings;
	}

	public void setGroupMapping(Set<GroupMapping> groupMappings) {
		this.groupMappings = groupMappings;
	}

	@Column(name = "group_code", nullable = false, length = 50)
	public String getGroupCode() {
		return groupCode;
	}

	public void setGroupCode(String groupCode) {
		this.groupCode = groupCode;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "institution_id", nullable = false)
	@ForeignKey(name="groupInInstitution")
	public Institution getInstitution() {
		return institution;
	}


	public void setInstitution(Institution institution) {
		this.institution = institution;
	}

}
