package in.jdsoft.educationmanagement.model;

import static javax.persistence.GenerationType.IDENTITY;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "tbl_document_index")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class DocumentIndex implements java.io.Serializable {

	public DocumentIndex(String documentReference, String documentCode, String documentName, String documentPathInDms,
			String documentCreatedByUser, String documentStatus) {
		
		this.documentReference = documentReference;
		this.documentCode = documentCode;
		this.documentName = documentName;
		this.documentPathInDms = documentPathInDms;
		this.documentCreatedByUser = documentCreatedByUser;
		this.documentStatus = documentStatus;
	}
	private static final long serialVersionUID = 1L;
	
	private Integer documentIndexId;
	private String documentReference;
	private String documentCode;
	private String documentName;
	private String documentPathInDms;
	private String documentCreatedByUser;
	private String documentStatus;
	private Date documentDate;
	
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "document_index_id", unique = true, nullable = false)
	public Integer getDocumentIndexId() {
		return documentIndexId;
	}
	public void setDocumentIndexId(Integer documentIndexId) {
		this.documentIndexId = documentIndexId;
	}
	@Column(name = "document_reference", nullable = false, length = 20)
	public String getDocumentReference() {
		return documentReference;
	}
	public void setDocumentReference(String documentReference) {
		this.documentReference = documentReference;
	}
	@Column(name = "document_code", nullable = false, length = 20)
	public String getDocumentCode() {
		return documentCode;
	}
	public void setDocumentCode(String documentCode) {
		this.documentCode = documentCode;
	}
	@Column(name = "document_name", nullable = false, length = 50)
	public String getDocumentName() {
		return documentName;
	}
	public void setDocumentName(String documentName) {
		this.documentName = documentName;
	}
	@Column(name = "document_path_in_dms", nullable = false, length = 120)
	public String getDocumentPathInDms() {
		return documentPathInDms;
	}
	public void setDocumentPathInDms(String documentPathInDms) {
		this.documentPathInDms = documentPathInDms;
	}
	@Column(name = "document_status", nullable = false, length = 20)
	public String getDocumentStatus() {
		return documentStatus;
	}
	public void setDocumentStatus(String documentStatus) {
		this.documentStatus = documentStatus;
	}
	@Column(name = "document_created_by_user", nullable = false, length = 20)
	public String getDocumentCreatedByUser() {
		return documentCreatedByUser;
	}
	public void setDocumentCreatedByUser(String documentCreatedByUser) {
		this.documentCreatedByUser = documentCreatedByUser;
	}
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "document_date", nullable = false, length = 10)	
	public Date getDocumentDate() {
		return documentDate;
	}
	public void setDocumentDate(Date documentDate) {
		this.documentDate = documentDate;
	}
	
}
	

