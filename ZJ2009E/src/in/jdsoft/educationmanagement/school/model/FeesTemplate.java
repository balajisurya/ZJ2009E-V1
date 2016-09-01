package in.jdsoft.educationmanagement.school.model;


import static javax.persistence.GenerationType.IDENTITY;

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
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.apache.commons.lang.WordUtils;
import org.hibernate.annotations.ForeignKey;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@Entity
@Table(name = "tbl_fees_template",uniqueConstraints = {@UniqueConstraint(columnNames = {
		"template_name", "institution_id" })})
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class FeesTemplate implements java.io.Serializable {

	public FeesTemplate() {}
	
	public FeesTemplate(String templateName,Institution institution){
		this.templateName =WordUtils.capitalize(templateName);
		this.institution=institution;
	}
	
	private static final long serialVersionUID = 1L;
	private Integer templateId;
	private String templateName;
	private Institution institution;
	
	private Set<FeesTemplateItem> feesTemplateItems=new HashSet<FeesTemplateItem>(0);

	
	

	@Id
	@GeneratedValue(strategy = IDENTITY)
    @Column(name = "template_id",nullable = false)
	public Integer getTemplateId() {
		return this.templateId;
	}

	public void setTemplateId(Integer templateId) {
		this.templateId = templateId;
	}

	@Column(name = "template_name", nullable = false, length = 100)
	public String getTemplateName() {
		return this.templateName;
	}

	public void setTemplateName(String templateName) {
		this.templateName =WordUtils.capitalize(templateName);
	}

    
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "tbl_fees_template_mapping",joinColumns = { 
			@JoinColumn(name = "template_id", updatable = false) }, 
			inverseJoinColumns = { @JoinColumn(name = "template_item_id", 
					 updatable = false) })
	@ForeignKey(name="feesTemplatesInFessTemplateItems")
	public Set<FeesTemplateItem> getFeesTemplateItems() {
		return feesTemplateItems;
	}

	public void setFeesTemplateItems(Set<FeesTemplateItem> feesTemplateItems) {
		this.feesTemplateItems = feesTemplateItems;
	}
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "institution_id", nullable = false)
	@ForeignKey(name="feesTemplateInInstitution")
	public Institution getInstitution() {
		return institution;
	}

	public void setInstitution(Institution institution) {
		this.institution = institution;
	}

}
