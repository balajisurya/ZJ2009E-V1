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
@Table(name = "tbl_religion",  uniqueConstraints = @UniqueConstraint(columnNames = "religion_name"))
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Religion implements Serializable {
	
	
	private static final long serialVersionUID = 1L;

	public Religion(){}
	
	public Religion(String religionName) {
		this.religionName =WordUtils.capitalize(religionName);
	}
	
	private int religionId;
	private String religionName;
	
	private Set<Admission> admissionListByReligion=new HashSet<Admission>(0);
	
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "religion_id", unique = true, nullable = false)
	public int getReligionId() {
		return religionId;
	}
	public void setReligionId(int religionId) {
		this.religionId = religionId;
	}
	
	@Column(name = "religion_name", unique = true, nullable = false, length = 40)
	public String getReligionName() {
		return religionName;
	}
	public void setReligionName(String religionName) {
		this.religionName =WordUtils.capitalize(religionName);
	}
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "religion")
	public Set<Admission> getAdmissionListByReligion() {
		return admissionListByReligion;
	}
	public void setAdmissionListByReligion(Set<Admission> admissionListByReligion) {
		this.admissionListByReligion = admissionListByReligion;
	}

}
