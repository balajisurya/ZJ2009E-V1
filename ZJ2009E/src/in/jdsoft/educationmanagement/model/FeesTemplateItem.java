package in.jdsoft.educationmanagement.model;


import static javax.persistence.GenerationType.IDENTITY;

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

import org.apache.commons.lang.WordUtils;
import org.hibernate.annotations.ForeignKey;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@Entity
@Table(name = "tbl_fees_template_item")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class FeesTemplateItem implements java.io.Serializable {

	
	public FeesTemplateItem() {}
	
	public FeesTemplateItem(String templateItemName, double templateItemPrice,Institution institution) {
		this.templateItemName =WordUtils.capitalize(templateItemName);
		this.templateItemPrice = templateItemPrice;
		this.institution=institution;
	}
	
	private static final long serialVersionUID = 1L;
	private Integer templateItemId;
	private String templateItemName;
	private double templateItemPrice;
	private Institution institution;
	
	private Set<FeesTemplate> feesTemplates=new HashSet<FeesTemplate>(0);
	
	
	

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "template_item_id", nullable = false)
	public Integer getTemplateItemId() {
		return this.templateItemId;
	}

	public void setTemplateItemId(Integer templateItemId) {
		this.templateItemId = templateItemId;
	}

	@Column(name = "template_item_name", nullable = false, length = 100)
	public String getTemplateItemName() {
		return this.templateItemName;
	}

	public void setTemplateItemName(String templateItemName) {
		this.templateItemName =WordUtils.capitalize(templateItemName);
	}

	@Column(name = "template_item_price", nullable = false, precision = 22, scale = 0)
	public double getTemplateItemPrice() {
		return this.templateItemPrice;
	}

	public void setTemplateItemPrice(double templateItemPrice) {
		this.templateItemPrice = templateItemPrice;
	}

	@ManyToMany(fetch = FetchType.LAZY, mappedBy = "feesTemplateItems")
	public Set<FeesTemplate> getFeesTemplates() {
		return feesTemplates;
	}

	public void setFeesTemplates(Set<FeesTemplate> feesTemplates) {
		this.feesTemplates = feesTemplates;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "institution_id", nullable = false)
	@ForeignKey(name="feesTemplateItemInInstitution")
	public Institution getInstitution() {
		return institution;
	}

	public void setInstitution(Institution institution) {
		this.institution = institution;
	}

}
