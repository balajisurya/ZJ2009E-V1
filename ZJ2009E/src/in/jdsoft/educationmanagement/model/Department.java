package in.jdsoft.educationmanagement.model;


import static javax.persistence.GenerationType.IDENTITY;

import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

import org.apache.commons.lang.WordUtils;
import org.hibernate.annotations.ForeignKey;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;


@Entity
@Table(name = "tbl_department", uniqueConstraints = {
		@UniqueConstraint(columnNames = "department_code"), @UniqueConstraint(columnNames = "department_name") })
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Department implements java.io.Serializable{

	public Department() {}
	
	public Department(String departmentName, String createdBy,Staff departmentHead,Institution institution) {
		this.departmentCode =Long.toString(System.currentTimeMillis());
		this.departmentName =WordUtils.capitalize(departmentName);
		this.createdDate =new Date(Calendar.getInstance().getTime().getTime());
		this.createdBy = createdBy;
		this.modifiedBy=createdBy;
		this.departmentHead=departmentHead;
		this.institution=institution;
	}
	
	private static final long serialVersionUID = 1L;
	private Integer departmentId;
	private String departmentCode;
	private String departmentName;
	private Staff departmentHead;
	private Date createdDate;
	private String createdBy;
	private Date modifiedDate;
	private String modifiedBy;

	private Institution institution;
	
	private  Set<Admission> admissions=new HashSet<Admission>(0);
	private  Set<Courses> courses=new HashSet<Courses>(0);
	private  Set<Student> students=new HashSet<Student>(0);
	private  Set<Staff> staffs=new HashSet<Staff>(0);

	

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "department_id", unique = true, nullable = false)
	public Integer getDepartmentId() {
		return this.departmentId;
	}

	public void setDepartmentId(Integer departmentId) {
		this.departmentId = departmentId;
	}

	@Column(name = "department_code", unique = true, nullable = false, length = 50)
	public String getDepartmentCode() {
		return this.departmentCode;
	}

	public void setDepartmentCode(String departmentCode) {
		this.departmentCode = departmentCode;
	}

	@Column(name = "department_name", unique = true, nullable = false, length = 150)
	public String getDepartmentName() {
		return this.departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName =WordUtils.capitalize(departmentName);
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "created_date", nullable = false, length = 10)
	public Date getCreatedDate() {
		return this.createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	@Column(name = "created_by", nullable = false, length = 150)
	public String getCreatedBy() {
		return this.createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "modified_date", nullable = false, length = 19,columnDefinition="timestamp")
	public Date getModifiedDate() {
		return this.modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	@Column(name = "modified_by", nullable = false, length = 150)
	public String getModifiedBy() {
		return modifiedBy;
	}

	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "department")
	public Set<Admission> getAdmissions() {
		return admissions;
	}

	public void setAdmissions(Set<Admission> admissions) {
		this.admissions = admissions;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "department")
	public Set<Courses> getCourses() {
		return courses;
	}

	public void setCourses(Set<Courses> courses) {
		this.courses = courses;
	}
    
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "department")
	public Set<Student> getStudents() {
		return students;
	}

	public void setStudents(Set<Student> students) {
		this.students = students;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "department")
	public Set<Staff> getStaffs() {
		return staffs;
	}

	public void setStaffs(Set<Staff> staffs) {
		this.staffs = staffs;
	}


	@OneToOne
	@JoinColumn(name = "head_id",nullable =true,referencedColumnName="staff_id")
	@JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="staffId")
	public Staff getDepartmentHead() {
		return departmentHead;
	}

	public void setDepartmentHead(Staff departmentHead) {
		this.departmentHead = departmentHead;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "institution_id", nullable = false)
	@ForeignKey(name="departmentInInstitution")
	public Institution getInstitution() {
		return institution;
	}

	public void setInstitution(Institution institution) {
		this.institution = institution;
	}

}
