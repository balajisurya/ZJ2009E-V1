package in.jdsoft.educationmanagement.model;

import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.apache.commons.lang.WordUtils;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@Entity
@Table(name = "tbl_education_level_subject", uniqueConstraints = @UniqueConstraint(columnNames = {
		"education_level_id", "education_level_subject_title" }))
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class EducationLevelSubject implements Serializable {

	private static final long serialVersionUID = 1L;


	public EducationLevelSubject() {}
	
	public EducationLevelSubject(EducationLevel educationLevel, String educationLevelSubjectTitle) {
		this.educationLevel = educationLevel;
		this.educationLevelSubjectTitle =WordUtils.capitalize(educationLevelSubjectTitle);
	}
	
	private int educationLevelSubjectId;
	private EducationLevel educationLevel;
	private String educationLevelSubjectTitle;
	
	
	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "education_level_subject_id", nullable = false)
	public int getEducationLevelSubjectId() {
		return educationLevelSubjectId;
	}
	public void setEducationLevelSubjectId(int educationLevelSubjectId) {
		this.educationLevelSubjectId = educationLevelSubjectId;
	}
	
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "education_level_id", nullable = false)
	@JsonBackReference
	public EducationLevel getEducationLevel() {
		return educationLevel;
	}
	public void setEducationLevel(EducationLevel educationLevel) {
		this.educationLevel = educationLevel;
	}
	
	@Column(name = "education_level_subject_title", nullable = false, length = 100)
	public String getEducationLevelSubjectTitle() {
		return educationLevelSubjectTitle;
	}
	public void setEducationLevelSubjectTitle(String educationLevelSubjectTitle) {
		this.educationLevelSubjectTitle =WordUtils.capitalize(educationLevelSubjectTitle);
	}
	
}
