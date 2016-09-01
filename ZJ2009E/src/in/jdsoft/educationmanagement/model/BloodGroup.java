package in.jdsoft.educationmanagement.model;

import static javax.persistence.GenerationType.IDENTITY;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "tbl_blood_group")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class BloodGroup implements java.io.Serializable {

	
	public BloodGroup() {
		// TODO Auto-generated constructor stub
	}
	
	public BloodGroup(String bloodGroupName) {
       this.bloodGroupName=bloodGroupName;
	}
	
	private static final long serialVersionUID = 1L;
	private int bloodGroupId;
	private String bloodGroupName;
	
	private Set<Student> students=new HashSet<Student>(0);
	private Set<Staff> staffs=new HashSet<Staff>(0);
	
	
	@Id
	@GeneratedValue(strategy = IDENTITY)
    @Column(name = "blood_group_id", unique = true, nullable = false)
	public int getBloodGroupId() {
		return bloodGroupId;
	}
	public void setBloodGroupId(int bloodGroupId) {
		this.bloodGroupId = bloodGroupId;
	}
	
	@Column(name = "blood_group_name", nullable = false, length = 100)
	public String getBloodGroupName() {
		return bloodGroupName;
	}
	public void setBloodGroupName(String bloodGroupName) {
		this.bloodGroupName = bloodGroupName;
	}
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "bloodGroup")
	public Set<Student> getStudents() {
		return students;
	}
	public void setStudents(Set<Student> students) {
		this.students = students;
	}
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "bloodGroup")
	public Set<Staff> getStaffs() {
		return staffs;
	}
	public void setStaffs(Set<Staff> staffs) {
		this.staffs = staffs;
	}
}
