package in.jdsoft.educationmanagement.model;

import static javax.persistence.GenerationType.IDENTITY;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;



@Entity
@Table(name = "tbl_student_performance")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class StudentPerformance implements java.io.Serializable {

	
	public StudentPerformance(String appraisalTerm, String relationshipRating, String relationshipComments,
			String attitudeRating, String attitudeComments, String academicRating, String academicComments,
			String initiativeRating, String initiativeComments, String creativityRating, String creativityComments,
			String punctualityRating, String punctualityComments, String sportsAndSocialRating,
			String sportsAndSocialComments, String appraisalCreatedByUser, String recommendations,
			String appraisalStatus, Date createdDate, Student student) {
		this.appraisalTerm = appraisalTerm;
		this.relationshipRating = relationshipRating;
		this.relationshipComments = relationshipComments;
		this.attitudeRating = attitudeRating;
		this.attitudeComments = attitudeComments;
		this.academicRating = academicRating;
		this.academicComments = academicComments;
		this.initiativeRating = initiativeRating;
		this.initiativeComments = initiativeComments;
		this.creativityRating = creativityRating;
		this.creativityComments = creativityComments;
		this.punctualityRating = punctualityRating;
		this.punctualityComments = punctualityComments;
		this.sportsAndSocialRating = sportsAndSocialRating;
		this.sportsAndSocialComments = sportsAndSocialComments;
		this.appraisalCreatedByUser = appraisalCreatedByUser;
		this.recommendations = recommendations;
		this.appraisalStatus = appraisalStatus;
		this.createdDate = createdDate;
		this.student = student;
	}
	
	
	public StudentPerformance() {
		// TODO Auto-generated constructor stub
	}
	//PK
	
	
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "student_performance_id", unique = true, nullable = false)
	public Integer getStudentPerformanceId() {
		return studentPerformanceId;
	}

	public void setStudentPerformanceId(Integer studentPerformanceId) {
		this.studentPerformanceId = studentPerformanceId;
	}
	
	//Single Fields
	
	@Column(name = "appraisal_term", nullable = false, length = 30)
	public String getAppraisalTerm() {
		return appraisalTerm;
	}
	public void setAppraisalTerm(String appraisalTerm) {
		this.appraisalTerm = appraisalTerm;
	}
	@Column(name = "aspect_two_relationship_rating", nullable = false, length = 20)
	public String getRelationshipRating() {
		return relationshipRating;
	}
	public void setRelationshipRating(String relationshipRating) {
		this.relationshipRating = relationshipRating;
	}
	
	@Column(name = "aspect_two_relationship_comments", nullable = false, length = 150)
	public String getRelationshipComments() {
		return relationshipComments;
	}
	public void setRelationshipComments(String relationshipComments) {
		this.relationshipComments = relationshipComments;
	}
	@Column(name = "aspect_one_attitude_rating", nullable = false, length = 20)
	public String getAttitudeRating() {
		return attitudeRating;
	}

	public void setAttitudeRating(String attitudeRating) {
		this.attitudeRating = attitudeRating;
	}


	@Column(name = "aspect_one_attitude_comments", nullable = false, length = 150)
	public String getAttitudeComments() {
		return attitudeComments;
	}

	public void setAttitudeComments(String attitudeComments) {
		this.attitudeComments = attitudeComments;
	}
	
	@Column(name = "aspect_three_initiative_rating", nullable = false, length = 20)
	public String getInitiativeRating() {
		return initiativeRating;
	}

	public void setInitiativeRating(String initiativeRating) {
		this.initiativeRating = initiativeRating;
	}
	@Column(name = "aspect_three_initiative_comments", nullable = false, length = 150)
	public String getInitiativeComments() {
		return initiativeComments;
	}

	public void setInitiativeComments(String initiativeComments) {
		this.initiativeComments = initiativeComments;
	}
	
	@Column(name = "aspect_six_creativity_rating", nullable = false, length = 20)
	public String getCreativityRating() {
		return creativityRating;
	}

	public void setCreativityRating(String creativityRating) {
		this.creativityRating = creativityRating;
	}
	@Column(name = "aspect_six_creativity_comments", nullable = false, length = 150)
	public String getCreativityComments() {
		return creativityComments;
	}

	public void setCreativityComments(String creativityComments) {
		this.creativityComments = creativityComments;
	}

	@Column(name = "aspect_five_academic_rating", nullable = false, length = 20)
	public String getAcademicRating() {
		return academicRating;
	}

	public void setAcademicRating(String academicRating) {
		this.academicRating = academicRating;
	}
	@Column(name = "aspect_five_academic_comments", nullable = false, length = 150)
	public String getAcademicComments() {
		return academicComments;
	}

	public void setAcademicComments(String academicComments) {
		this.academicComments = academicComments;
	}
	@Column(name = "aspect_four_punctuality_rating", nullable = false, length = 20)
	public String getPunctualityRating() {
		return punctualityRating;
	}

	public void setPunctualityRating(String punctualityRating) {
		this.punctualityRating = punctualityRating;
	}

	@Column(name = "aspect_four_punctuality_comments", nullable = false, length = 150)
	public String getPunctualityComments() {
		return punctualityComments;
	}

	public void setPunctualityComments(String punctualityComments) {
		this.punctualityComments = punctualityComments;
	}
	

	@Column(name = "aspect_seven_sports_and_social_rating", nullable = false, length = 20)
	public String getSportsAndSocialRating() {
		return sportsAndSocialRating;
	}

	public void setSportsAndSocialRating(String sportsAndSocialRating) {
		this.sportsAndSocialRating = sportsAndSocialRating;
	}
	@Column(name = "aspect_seven_sports_and_social_comments", nullable = false, length = 150)
	public String getSportsAndSocialComments() {
		return sportsAndSocialComments;
	}

	public void setSportsAndSocialComments(String sportsAndSocialComments) {
		this.sportsAndSocialComments = sportsAndSocialComments;
	}
	@Column(name = "appraisal_created_by_user", nullable = false, length = 30)
	public String getAppraisalCreatedByUser() {
		return appraisalCreatedByUser;
	}
	public void setAppraisalCreatedByUser(String appraisalCreatedByUser) {
		this.appraisalCreatedByUser = appraisalCreatedByUser;
	}
	@Column(name = "recommendations", nullable = false, length = 150)
	public String getRecommendations() {
		return recommendations;
	}
	public void setRecommendations(String recommendations) {
		this.recommendations = recommendations;
	}
	@Column(name = "appraisal_status", nullable = false, length = 20)
	public String getAppraisalStatus() {
		return appraisalStatus;
	}
	public void setAppraisalStatus(String appraisalStatus) {
		this.appraisalStatus = appraisalStatus;
	}
		
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "appraisal_created_date", nullable = false, length = 10)
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	
	//Mappings
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "student_id", nullable = false)
	public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
	}

	
	private static final long serialVersionUID = 1L;
	
	private Integer studentPerformanceId;
	private String appraisalTerm;
	private String relationshipRating;
	private String relationshipComments;
	private String attitudeRating;
	private String attitudeComments;
	private String academicRating;
	private String academicComments;
	private String initiativeRating;
	private String initiativeComments;
	private String creativityRating;
	private String creativityComments;
	private String punctualityRating;
	private String punctualityComments;
	private String sportsAndSocialRating;
	private String sportsAndSocialComments;
	private String appraisalCreatedByUser;
	private String recommendations;
	private String appraisalStatus;
	private Date createdDate;
	
	//Model
	private Student student;



}
	

