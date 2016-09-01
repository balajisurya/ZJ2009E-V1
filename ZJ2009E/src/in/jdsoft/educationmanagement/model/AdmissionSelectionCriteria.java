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

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "tbl_admission_selection_criteria",  uniqueConstraints = @UniqueConstraint(columnNames = "admission_selection_criteria_name"))
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class AdmissionSelectionCriteria implements Serializable {

	
	private static final long serialVersionUID = 1L;

	public AdmissionSelectionCriteria() {
		// TODO Auto-generated constructor stub
	}
	public AdmissionSelectionCriteria(String admissionSelectionCriteriaName,
			Set<AdmissionSelectionCriteriaAttributes> admissionSelectionCriteriaAttributes) {
		this.admissionSelectionCriteriaName = admissionSelectionCriteriaName;
		this.admissionSelectionCriteriaAttributes = admissionSelectionCriteriaAttributes;
	}
	
	private int admissionSelectionCriteriaId;
	private String admissionSelectionCriteriaName;
	
	private Set<AdmissionSelectionCriteriaAttributes> admissionSelectionCriteriaAttributes=new HashSet<AdmissionSelectionCriteriaAttributes>(0);
	
	
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "admission_selection_criteria_id", unique = true, nullable = false)
	public int getAdmissionSelectionCriteriaId() {
		return admissionSelectionCriteriaId;
	}
	public void setAdmissionSelectionCriteriaId(int admissionSelectionCriteriaId) {
		this.admissionSelectionCriteriaId = admissionSelectionCriteriaId;
	}
	
	@Column(name = "admission_selection_criteria_name", unique = true, nullable = false)
	public String getAdmissionSelectionCriteriaName() {
		return admissionSelectionCriteriaName;
	}
	public void setAdmissionSelectionCriteriaName(String admissionSelectionCriteriaName) {
		this.admissionSelectionCriteriaName = admissionSelectionCriteriaName;
	}
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "admissionSelectionCriteria")
	public Set<AdmissionSelectionCriteriaAttributes> getAdmissionSelectionCriteriaAttributes() {
		return admissionSelectionCriteriaAttributes;
	}
	public void setAdmissionSelectionCriteriaAttributes(Set<AdmissionSelectionCriteriaAttributes> admissionSelectionCriteriaAttributes) {
		this.admissionSelectionCriteriaAttributes = admissionSelectionCriteriaAttributes;
	}
	
	
}
