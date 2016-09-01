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
@Table(name = "tbl_sponser", uniqueConstraints = @UniqueConstraint(columnNames = "sponser_title"))
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Sponser implements Serializable{

	public Sponser() {
		
	}
	
	public Sponser(String sponserTitle) {
		this.sponserTitle =WordUtils.capitalize(sponserTitle);
	}
	
	private static final long serialVersionUID = 1L;
	
	private int sponserId;
	private String sponserTitle;
	private Set<Admission> admissionListBySponserType=new HashSet<Admission>(0);
	
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "sponser_id", unique = true, nullable = false)
	public int getSponserId() {
		return sponserId;
	}
	public void setSponserId(int sponserId) {
		this.sponserId = sponserId;
	}
	
	@Column(name = "sponser_title", unique = true, nullable = false, length = 40)
	public String getSponserTitle() {
		return sponserTitle;
	}
	public void setSponserTitle(String sponserTitle) {
		this.sponserTitle =WordUtils.capitalize(sponserTitle);
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "sponser")
	public Set<Admission> getAdmissionListBySponserType() {
		return admissionListBySponserType;
	}

	public void setAdmissionListBySponserType(Set<Admission> admissionListBySponserType) {
		this.admissionListBySponserType = admissionListBySponserType;
	}

}
