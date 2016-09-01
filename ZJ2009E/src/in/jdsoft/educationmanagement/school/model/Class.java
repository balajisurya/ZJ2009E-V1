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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.hibernate.annotations.ForeignKey;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table(name = "tbl_class",uniqueConstraints={@UniqueConstraint(columnNames={"class_name","institution_id"})})
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Class implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Integer classId;
	private String className;
	private Institution institution;
	
	private Set<Student> students=new HashSet<Student>(0);
	private Set<Section> sections=new HashSet<Section>(0);
	private Set<Student> joinedStudents=new HashSet<Student>(0);
	
	
	public Class() {}
	
	public Class(String className,Institution institution) {
		this.className=className;
		this.institution=institution;
	}
	
	
	@Id
	@GeneratedValue(strategy = IDENTITY)
    @Column(name = "class_id", nullable = false)
	public Integer getClassId() {
		return classId;
	}
	public void setClassId(Integer classId) {
		this.classId = classId;
	}
	
	@Column(name = "class_name", nullable = false, length = 50)
	public String getClassName() {
		return className;
	}
	public void setClassName(String className) {
		this.className = className;
	}
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "studentClass")
	@ForeignKey(name="classInStudents")
	public Set<Student> getStudents() {
		return students;
	}

	public void setStudents(Set<Student> students) {
		this.students = students;
	}

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "tbl_class_section_mapping",joinColumns = { 
			@JoinColumn(name = "class_id", updatable = false) }, 
			inverseJoinColumns = { @JoinColumn(name = "section_id", 
					 updatable = false) })
	@ForeignKey(name="classInSections")
	public Set<Section> getSections() {
		return sections;
	}

	public void setSections(Set<Section> sections) {
		this.sections = sections;
	}
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "institution_id", nullable = false)
	@ForeignKey(name="classInInstitution")
	@JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class, property="@classes")
	@JsonIdentityReference(alwaysAsId = true)
	public Institution getInstitution() {
		return institution;
	}

	public void setInstitution(Institution institution) {
		this.institution = institution;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "joinedClass")
	@ForeignKey(name="joinedclassInStudents")
	public Set<Student> getJoinedStudents() {
		return joinedStudents;
	}

	public void setJoinedStudents(Set<Student> joinedStudents) {
		this.joinedStudents = joinedStudents;
	}
}
