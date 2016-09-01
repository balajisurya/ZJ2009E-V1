package in.jdsoft.educationmanagement.school.model;


import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.apache.commons.lang.WordUtils;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@Entity
@Table(name = "tbl_geographical_location")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class GeographicalLocation implements java.io.Serializable {

	
	private static final long serialVersionUID = 1L;
	private Integer geographicalLocationId;
	private String name;
	private int geographicalLocationType;
	private int parentId;
	private int isVisible;

	
	public GeographicalLocation() {
		// TODO Auto-generated constructor stub
	}
	
	public GeographicalLocation(String name, int geographicalLocationType, int parentId, int isVisible) {
		this.name =WordUtils.capitalize(name);
		this.geographicalLocationType = geographicalLocationType;
		this.parentId = parentId;
		this.isVisible = isVisible;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "location_id", unique = true, nullable = false)
	public Integer getGeographicalLocationId() {
		return this.geographicalLocationId;
	}

	public void setGeographicalLocationId(Integer geographicalLocationId) {
		this.geographicalLocationId =geographicalLocationId;
	}

	@Column(name = "name", nullable = false, length = 30)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name =WordUtils.capitalize(name);
	}

	//0-country 1-state 2-city
	@Column(name = "location_type", nullable = false)
	public int getGeographicalLocationType() {
		return this.geographicalLocationType;
	}

	public void setGeographicalLocationType(int geographicalLocationType) {
		this.geographicalLocationType = geographicalLocationType;
	}

	@Column(name = "parent_id", nullable = false)
	public int getParentId() {
		return this.parentId;
	}

	public void setParentId(int parentId) {
		this.parentId = parentId;
	}

	@Column(name = "is_visible", nullable = false)
	public int getIsVisible() {
		return this.isVisible;
	}

	public void setIsVisible(int isVisible) {
		this.isVisible = isVisible;
	}

}
