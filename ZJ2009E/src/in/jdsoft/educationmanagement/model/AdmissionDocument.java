package in.jdsoft.educationmanagement.model;

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

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "tbl_admission_document", uniqueConstraints = @UniqueConstraint(columnNames = "document_path"))
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class AdmissionDocument implements Serializable{
	
	
	private static final long serialVersionUID = 1L;

	public AdmissionDocument() {
		// TODO Auto-generated constructor stub
	}
	public AdmissionDocument(Admission admission, AdmissionDocumentTypes admissionDocumentType,
			String documentName, String documentPath) {
		this.admission = admission;
		this.admissionDocumentType = admissionDocumentType;
		this.documentName =documentName;
		this.documentPath = documentPath;
	}
	
	private int admissionDocumentId;
	private Admission admission;
	private AdmissionDocumentTypes admissionDocumentType;
	private String documentName;
	private String documentPath;
	
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "admission_document_id", unique = true, nullable = false)
	public int getAdmissionDocumentId() {
		return admissionDocumentId;
	}
	public void setAdmissionDocumentId(int admissionDocumentId) {
		this.admissionDocumentId = admissionDocumentId;
	}
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "admission_id", nullable = false)
	public Admission getAdmission() {
		return admission;
	}
	public void setAdmission(Admission admission) {
		this.admission = admission;
	}
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "admission_document_type_id", nullable = false)
	public AdmissionDocumentTypes getAdmissionDocumentType() {
		return admissionDocumentType;
	}
	public void setAdmissionDocumentType(AdmissionDocumentTypes admissionDocumentType) {
		this.admissionDocumentType = admissionDocumentType;
	}
	
	@Column(name = "document_name",nullable = false,length=50)
	public String getDocumentName() {
		return documentName;
	}
	public void setDocumentName(String documentName) {
		this.documentName = documentName;
	}
	
	@Column(name = "document_path",nullable = false,length=255,unique=true)
	public String getDocumentPath() {
		return documentPath;
	}
	public void setDocumentPath(String documentPath) {
		this.documentPath = documentPath;
	}

}
