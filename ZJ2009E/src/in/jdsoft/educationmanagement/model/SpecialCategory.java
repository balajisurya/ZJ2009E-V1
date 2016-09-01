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
import javax.persistence.UniqueConstraint;

import org.apache.commons.lang.WordUtils;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "tbl_special_category", uniqueConstraints = @UniqueConstraint(columnNames = "special_category_name"))
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class SpecialCategory {

	public SpecialCategory() {
		
	}
	
	public SpecialCategory(String specialCategoryName) {
		this.specialCategoryName =WordUtils.capitalize(specialCategoryName);
	}
	
	
	private int specialCategoryId;
	private String specialCategoryName;
	
	private Set<Admission> admissionListBySpecialCategory=new HashSet<Admission>(0);
	private Set<Student> students=new HashSet<Student>(0);
	
	
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "special_category_id", unique = true, nullable = false)
	public int getSpecialCategoryId() {
		return specialCategoryId;
	}
	public void setSpecialCategoryId(int specialCategoryId) {
		this.specialCategoryId = specialCategoryId;
	}
	
	@Column(name = "special_category_name", unique = true, nullable = false, length = 40)
	public String getSpecialCategoryName() {
		return specialCategoryName;
	}
	public void setSpecialCategoryName(String specialCategoryName) {
		this.specialCategoryName =WordUtils.capitalize(specialCategoryName);
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "specialCategory")
	public Set<Admission> getAdmissionListBySpecialCategory() {
		return admissionListBySpecialCategory;
	}

	public void setAdmissionListBySpecialCategory(Set<Admission> admissionListBySpecialCategory) {
		this.admissionListBySpecialCategory = admissionListBySpecialCategory;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "specialCategory")
	public Set<Student> getStudents() {
		return students;
	}

	public void setStudents(Set<Student> students) {
		this.students = students;
	}
}
