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

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "tbl_admission_selection_criteria_attributes",  uniqueConstraints = @UniqueConstraint(columnNames = "admission_selection_criteria_attribute_key"))
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class AdmissionSelectionCriteriaAttributes implements Serializable{
	
	
	private static final long serialVersionUID = 1L;

	public AdmissionSelectionCriteriaAttributes() {
		// TODO Auto-generated constructor stub
	}
	
	private int admissionSelectionCriteriaAttributesId;
	private AdmissionSelectionCriteria admissionSelectionCriteria;
	private String admissionSelectionCriteriaAttributeKey;
	private String admissionSelectionCriteriaAttributeValue;
	
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "admission_selection_criteria_attribute_id", unique = true, nullable = false)
	public int getAdmissionSelectionCriteriaAttributesId() {
		return admissionSelectionCriteriaAttributesId;
	}
	public void setAdmissionSelectionCriteriaAttributesId(int admissionSelectionCriteriaAttributesId) {
		this.admissionSelectionCriteriaAttributesId = admissionSelectionCriteriaAttributesId;
	}
	
	@Column(name = "admission_selection_criteria_attribute_key", unique = true, nullable = false)
	public String getAdmissionSelectionCriteriaAttributeKey() {
		return admissionSelectionCriteriaAttributeKey;
	}
	public void setAdmissionSelectionCriteriaAttributeKey(String admissionSelectionCriteriaAttributeKey) {
		this.admissionSelectionCriteriaAttributeKey = admissionSelectionCriteriaAttributeKey;
	}
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "admission_selection_criteria_id", nullable = false)
	public AdmissionSelectionCriteria getAdmissionSelectionCriteria() {
		return admissionSelectionCriteria;
	}
	public void setAdmissionSelectionCriteria(AdmissionSelectionCriteria admissionSelectionCriteria) {
		this.admissionSelectionCriteria = admissionSelectionCriteria;
	}
	
	@Column(name = "admission_selection_criteria_attribute_value",  nullable = false)
	public String getAdmissionSelectionCriteriaAttributeValue() {
		return admissionSelectionCriteriaAttributeValue;
	}
	public void setAdmissionSelectionCriteriaAttributeValue(String admissionSelectionCriteriaAttributeValue) {
		this.admissionSelectionCriteriaAttributeValue = admissionSelectionCriteriaAttributeValue;
		
	}
	
	public void setAdmissionSelectionCriteriaAttributeValue(Integer admissionSelectionCriteriaAttributeValue) {
		this.admissionSelectionCriteriaAttributeValue = admissionSelectionCriteriaAttributeValue.toString();
	}
	
	public void setAdmissionSelectionCriteriaValue(Double admissionSelectionCriteriaValue) {
		this.admissionSelectionCriteriaAttributeValue = admissionSelectionCriteriaAttributeValue.toString();
	}
	
	public void setAdmissionSelectionCriteriaAttributeValue(Float admissionSelectionCriteriaAttributeValue) {
		this.admissionSelectionCriteriaAttributeValue = admissionSelectionCriteriaAttributeValue.toString();
	}
	
	

}
