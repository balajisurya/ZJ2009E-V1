package in.jdsoft.educationmanagement.school.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.apache.commons.lang.WordUtils;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "tbl_currency")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Currency implements Serializable{

	
	private static final long serialVersionUID = 1L;
	private String isoCode;
	private String isoName;
	
	public Currency() {}
	
	public Currency(String isoCode,String isoName) {
		this.isoCode=WordUtils.capitalize(isoCode);
		this.isoName=WordUtils.capitalize(isoName);
	}
	
	@Id
	@Column(name = "iso", unique = true, nullable = false)
	public String getIsoCode() {
		return isoCode;
	}
	public void setIsoCode(String isoCode) {
		this.isoCode =WordUtils.capitalize(isoCode);
	}
	
	@Column(name = "name", unique = true, nullable = false)
	public String getIsoName() {
		return isoName;
	}
	public void setIsoName(String isoName) {
		this.isoName =WordUtils.capitalize(isoName);
	}
}
