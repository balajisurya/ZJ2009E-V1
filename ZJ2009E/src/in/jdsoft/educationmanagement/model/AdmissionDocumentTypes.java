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
@Table(name = "tbl_admission_document_types",  uniqueConstraints = @UniqueConstraint(columnNames = "admission_document_type_title"))
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class AdmissionDocumentTypes implements Serializable{
	
	
	private static final long serialVersionUID = 1L;

	public AdmissionDocumentTypes() {
		// TODO Auto-generated constructor stub
	}
	public AdmissionDocumentTypes(String documentTypeTitle,int documentMandatory) {
		this.documentTypeTitle = WordUtils.capitalize(documentTypeTitle);
	}
	
	private int documentTypeId;
	private String documentTypeTitle;
	private int documentMandatory;
	
	private Set<AdmissionDocument> admissionDocument=new HashSet<AdmissionDocument>(0);
	

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "admission_document_type_id", unique = true, nullable = false)
	public int getDocumentTypeId() {
		return documentTypeId;
	}
	public void setDocumentTypeId(int documentTypeId) {
		this.documentTypeId = documentTypeId;
	}
	
	@Column(name = "admission_document_type_title",nullable = false,length=50,unique=true)
	public String getDocumentTypeTitle() {
		return documentTypeTitle;
	}
	public void setDocumentTypeTitle(String documentTypeTitle) {
		this.documentTypeTitle =WordUtils.capitalize(documentTypeTitle);
	}
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "admissionDocumentType")
	public Set<AdmissionDocument> getAdmissionDocument() {
		return admissionDocument;
	}
	public void setAdmissionDocument(Set<AdmissionDocument> admissionDocument) {
		this.admissionDocument = admissionDocument;
	}
	
	@Column(name = "document_mandatory",nullable = false)
	public int getDocumentMandatory() {
		return documentMandatory;
	}
	public void setDocumentMandatory(int documentMandatory) {
		this.documentMandatory = documentMandatory;
	}

}
