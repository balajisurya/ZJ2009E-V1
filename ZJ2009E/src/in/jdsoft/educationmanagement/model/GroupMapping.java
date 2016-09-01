package in.jdsoft.educationmanagement.model;


import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;



@Entity
@Table(name = "tbl_group_mapping")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class GroupMapping implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private Integer groupMappingId;
	private Groups groups;
	private int courseSemId;

	public GroupMapping() {
		// TODO Auto-generated constructor stub
	}
	
	public GroupMapping(Groups groups, int courseSemId) {
		this.groups = groups;
		this.courseSemId = courseSemId;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "group_mapping_id", unique = true, nullable = false)
	public Integer getGroupMappingId() {
		return this.groupMappingId;
	}

	public void setGroupMappingId(Integer groupMappingId) {
		this.groupMappingId = groupMappingId;
	}

	@Column(name = "course_sem_id", nullable = false)
	public int getCourseSemId() {
		return this.courseSemId;
	}

	public void setCourseSemId(int courseSemId) {
		this.courseSemId = courseSemId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "group_id", nullable = false)
	@JsonBackReference
	public Groups getGroups() {
		return groups;
	}

	public void setGroups(Groups groups) {
		this.groups = groups;
	}

}
