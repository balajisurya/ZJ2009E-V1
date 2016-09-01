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
@Table(name = "tbl_heared_us", uniqueConstraints = @UniqueConstraint(columnNames = "hearedus_title"))
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class HearedUs implements Serializable {
	
	
	public HearedUs() {}
	
	public HearedUs(String hearedUsTitle) {
		this.hearedUsTitle=WordUtils.capitalize(hearedUsTitle);
	}
	
	private static final long serialVersionUID = 1L;
	
	private int hearedUsId;
	private String hearedUsTitle;
	
	private Set<Admission> admissionListByHearedUsType=new HashSet<Admission>(0);

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "hearedus_id", unique = true, nullable = false)
	public int getHearedUsId() {
		return hearedUsId;
	}
	public void setHearedUsId(int hearedUsId) {
		this.hearedUsId = hearedUsId;
	}
	
	@Column(name = "hearedus_title", unique = true, nullable = false, length = 40)
	public String getHearedUsTitle() {
		return hearedUsTitle;
	}
	public void setHearedUsTitle(String hearedUsTitle) {
		this.hearedUsTitle =WordUtils.capitalize(hearedUsTitle);
	}
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "hearedUs")
	public Set<Admission> getAdmissionListByHearedUsType() {
		return admissionListByHearedUsType;
	}
	public void setAdmissionListByHearedUsType(Set<Admission> admissionListByHearedUsType) {
		this.admissionListByHearedUsType = admissionListByHearedUsType;
	}
	
}
