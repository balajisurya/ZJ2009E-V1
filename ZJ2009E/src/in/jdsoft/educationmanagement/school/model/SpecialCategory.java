package in.jdsoft.educationmanagement.school.model;

import static javax.persistence.GenerationType.IDENTITY;

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
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.apache.commons.lang.WordUtils;
import org.hibernate.annotations.ForeignKey;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table(name = "tbl_special_category", uniqueConstraints = @UniqueConstraint(columnNames = {"institution_id","special_category_name"}))
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class SpecialCategory {

	public SpecialCategory() {
		
	}
	
	public SpecialCategory(String specialCategoryName,Institution institution) {
		this.specialCategoryName =WordUtils.capitalize(specialCategoryName);
		this.institution=institution;
	}
	
	
	private int specialCategoryId;
	private String specialCategoryName;
	private Institution institution;
	
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
	@ForeignKey(name="specialCategoryInStudents")
	public Set<Student> getStudents() {
		return students;
	}

	public void setStudents(Set<Student> students) {
		this.students = students;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "institution_id", nullable = false)
	@ForeignKey(name="specialCategoryInInstitution")
	@JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class, property="@specialCategories")
	@JsonIdentityReference(alwaysAsId = true)
	public Institution getInstitution() {
		return institution;
	}

	public void setInstitution(Institution institution) {
		this.institution = institution;
	}
}
