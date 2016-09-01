package in.jdsoft.educationmanagement.school.model;

import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.hibernate.annotations.ForeignKey;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table(name = "tbl_institution_ledger_account",uniqueConstraints = {@UniqueConstraint(columnNames = {
		"ledger_account_name","institution_id"}),@UniqueConstraint(columnNames = {
				"ledger_reference_number","institution_id"})})
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class InstituteLedgerAccount implements Serializable {
 
	public InstituteLedgerAccount() {}
	
	public InstituteLedgerAccount(String ledgerAccountName, String ledgerReferenceNo, Institution institution) {
		this.ledgerAccountName = ledgerAccountName;
		this.ledgerReferenceNo = ledgerReferenceNo;
		this.institution = institution;
	}
	
  	private static final long serialVersionUID = 1L;
	 
	  private int ledgerAccountId;
	  private String ledgerAccountName;
	  private String ledgerReferenceNo;
	  private Institution institution;
  
	  private Set<FeesTemplateItem>  feesTemplateItems=new HashSet<FeesTemplateItem>(0);
  
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "ledger_account_id", nullable = false)
	public int getLedgerAccountId() {
		return ledgerAccountId;
	}
	public void setLedgerAccountId(int ledgerAccountId) {
		this.ledgerAccountId = ledgerAccountId;
	}
	@Column(name = "ledger_account_name", nullable = false, length = 100)
	public String getLedgerAccountName() {
		return ledgerAccountName;
	}
	public void setLedgerAccountName(String ledgerAccountName) {
		this.ledgerAccountName = ledgerAccountName;
	}
	@Column(name = "ledger_reference_number", nullable = false, length =100)
	public String getLedgerReferenceNo() {
		return ledgerReferenceNo;
	}
	public void setLedgerReferenceNo(String ledgerReferenceNo) {
		this.ledgerReferenceNo = ledgerReferenceNo;
	}
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "institution_id")
	@ForeignKey(name="instituteLedgerAccountInInstitution")
	public Institution getInstitution() {
		return institution;
	}
	public void setInstitution(Institution institution) {
		this.institution = institution;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "ledgerAccount")
	@ForeignKey(name="ledgerAccountInFeesTemplateItems")
	@JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class, property="@ledgerAccount")
	@JsonIdentityReference(alwaysAsId = true)
	public Set<FeesTemplateItem> getFeesTemplateItems() {
		return feesTemplateItems;
	}

	public void setFeesTemplateItems(Set<FeesTemplateItem> feesTemplateItems) {
		this.feesTemplateItems = feesTemplateItems;
	}

}
