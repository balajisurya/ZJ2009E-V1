package in.jdsoft.educationmanagement.school.model;

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

import org.hibernate.annotations.ForeignKey;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "tbl_fees_term",uniqueConstraints = {@UniqueConstraint(columnNames = {"institution_id","fees_term_name"},name="duplicate_fees_term")
,@UniqueConstraint(columnNames = {"institution_id","fees_term_order"}, name="duplicate_order_no")})
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class FeesTerm implements Serializable {

	public FeesTerm(){}
	
	public FeesTerm(String feesTermName, Institution institution, Integer termOrder) {
		this.feesTermName = feesTermName;
		this.institution = institution;
		this.termOrder = termOrder;
	}
	
	
	private static final long serialVersionUID = 1L;
	
	private Integer feesTermId;
	private String feesTermName;
	private Institution institution;
	private Integer termOrder;
	
	
	@Id
	@GeneratedValue(strategy = IDENTITY)
    @Column(name = "fees_term_id",nullable = false)
	public Integer getFeesTermId() {
		return feesTermId;
	}
	public void setFeesTermId(Integer feesTermId) {
		this.feesTermId = feesTermId;
	}
	
	@Column(name = "fees_term_name", nullable = false, length = 100)
	public String getFeesTermName() {
		return feesTermName;
	}
	public void setFeesTermName(String feesTermName) {
		this.feesTermName = feesTermName;
	}
	@Column(name = "fees_term_order", nullable = false)
	public Integer getTermOrder() {
		return termOrder;
	}
	public void setTermOrder(Integer termOrder) {
		this.termOrder = termOrder;
	}
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "institution_id", nullable = false)
	@ForeignKey(name="feesTermsInInstitution")
	public Institution getInstitution() {
		return institution;
	}
	public void setInstitution(Institution institution) {
		this.institution = institution;
	}
}
