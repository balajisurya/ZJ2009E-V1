package in.jdsoft.educationmanagement.school.model;

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
import javax.persistence.UniqueConstraint;

import org.hibernate.annotations.ForeignKey;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table(name = "tbl_section",uniqueConstraints=@UniqueConstraint(columnNames = {"section_name","institution_id"}))
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Section implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Integer sectionId;
	private String sectionName;
	private Institution institution;
	
	private Set<Class> classes=new HashSet<Class>(0); 
	
	
	public Section() {}
	
	public Section(String sectionName,Institution institution) {
		this.sectionName=sectionName;
		this.institution=institution;
	}
	
	@Id
	@GeneratedValue(strategy = IDENTITY)
    @Column(name = "section_id", nullable = false)
	public Integer getSectionId() {
		return sectionId;
	}
	public void setSectionId(Integer sectionId) {
		this.sectionId = sectionId;
	}
	
	@Column(name = "section_name", nullable = false, length = 50)
	public String getSectionName() {
		return sectionName;
	}
	public void setSectionName(String sectionName) {
		this.sectionName = sectionName;
	}

	@ManyToMany(fetch = FetchType.LAZY, mappedBy = "sections")
	@ForeignKey(name="sectionsInClasses")
	public Set<Class> getClasses() {
		return classes;
	}

	
	public void setClasses(Set<Class> classes) {
		this.classes = classes;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "institution_id", nullable = false)
	@ForeignKey(name="sectionsInInstitution")
	@JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class, property="@sections")
	@JsonIdentityReference(alwaysAsId = true)
	public Institution getInstitution() {
		return institution;
	}

	public void setInstitution(Institution institution) {
		this.institution = institution;
	}
	
}
