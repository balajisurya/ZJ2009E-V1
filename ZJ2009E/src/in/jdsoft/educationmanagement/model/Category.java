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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.apache.commons.lang.WordUtils;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "tbl_category", uniqueConstraints = @UniqueConstraint(columnNames = "category_name"))
@JsonIgnoreProperties(value={"hibernateLazyInitializer", "handler"})
public class Category implements Serializable{

	public Category() {}
	
	public Category(String categoryName) {
		this.categoryName =WordUtils.capitalize(categoryName);
	}
	
	private static final long serialVersionUID = 1L;
	
	private int categoryId;
	private String categoryName;
	
	private Set<Admission> admissionListByCategory=new HashSet<Admission>(0);
	private Set<Staff> staffs=new HashSet<Staff>(0);
	private Set<Student> students=new HashSet<Student>(0);
	
	
	
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "category_id", unique = true, nullable = false)
	public int getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}
	
	@Column(name = "category_name", unique = true, nullable = false, length = 40)
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName =WordUtils.capitalize(categoryName);
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "category")
	public Set<Admission> getAdmissionListByCategory() {
		return admissionListByCategory;
	}

	public void setAdmissionListByCategory(Set<Admission> admissionListByCategory) {
		this.admissionListByCategory = admissionListByCategory;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "category")
	public Set<Staff> getStaffs() {
		return staffs;
	}

	public void setStaffs(Set<Staff> staffs) {
		this.staffs = staffs;
	}
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "category")
	public Set<Student> getStudents() {
		return students;
	}

	public void setStudents(Set<Student> students) {
		this.students = students;
	}
}
