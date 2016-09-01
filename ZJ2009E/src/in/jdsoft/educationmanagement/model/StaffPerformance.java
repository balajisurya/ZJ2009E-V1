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
@Table(name = "tbl_staff_performance")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class StaffPerformance implements java.io.Serializable {

	public StaffPerformance(String appraisalTerm, String relationshipRating, String relationshipComments,
			String teachingRating, String teachingComments, String researchAndHigherQualificationRating,
			String researchAndHigherQualificationComments, String initiativeAndOrganizationRating,
			String initiativeAndOrganizationComments, String innovationRating, String innovationComments,
			String punctualityRating, String punctualityComments, String goalAlignmentRating,
			String goalAlignmentComments, String appraisalCreatedByUser, String recommendations, Date createdDate,String appraisalStatus,
			Staff staff) {
		this.appraisalTerm = appraisalTerm;
		this.relationshipRating = relationshipRating;
		this.relationshipComments = relationshipComments;
		this.setTeachingRating(teachingRating);
		this.setTeachingComments(teachingComments);
		this.researchAndHigherQualificationRating = researchAndHigherQualificationRating;
		this.researchAndHigherQualificationComments = researchAndHigherQualificationComments;
		this.initiativeAndOrganizationRating = initiativeAndOrganizationRating;
		this.initiativeAndOrganizationComments = initiativeAndOrganizationComments;
		this.innovationRating = innovationRating;
		this.innovationComments = innovationComments;
		this.setPunctualityRating(punctualityRating);
		this.setPunctualityComments(punctualityComments);
		this.setGoalAlignmentRating(goalAlignmentRating);
		this.goalAlignmentComments = goalAlignmentComments;
		this.appraisalCreatedByUser = appraisalCreatedByUser;
		this.recommendations = recommendations;
		this.createdDate = createdDate;
		this.appraisalStatus=appraisalStatus;
		this.staff = staff;
	}
	
	public StaffPerformance() {
		// TODO Auto-generated constructor stub
	}
	
	//PK
	
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "staff_performance_id", unique = true, nullable = false)
	public Integer getStaffPerformanceId() {
		return staffPerformanceId;
	}
	public void setStaffPerformanceId(Integer staffPerformanceId) {
		this.staffPerformanceId = staffPerformanceId;
	}
	
	//Single Fields
	
	@Column(name = "appraisal_term", nullable = false, length = 50)
	public String getAppraisalTerm() {
		return appraisalTerm;
	}
	public void setAppraisalTerm(String appraisalTerm) {
		this.appraisalTerm = appraisalTerm;
	}
	@Column(name = "aspect_one_relationship_rating", nullable = false, length = 20)
	public String getRelationshipRating() {
		return relationshipRating;
	}
	public void setRelationshipRating(String relationshipRating) {
		this.relationshipRating = relationshipRating;
	}
	
	@Column(name = "aspect_one_relationship_comments", nullable = false, length = 100)
	public String getRelationshipComments() {
		return relationshipComments;
	}
	public void setRelationshipComments(String relationshipComments) {
		this.relationshipComments = relationshipComments;
	}
	@Column(name = "aspect_two_teaching_rating", nullable = false, length = 20)
	public String getTeachingRating() {
		return teachingRating;
	}
	public void setTeachingRating(String teachingRating) {
		this.teachingRating = teachingRating;
	}

	@Column(name = "aspect_two_teaching_comments", nullable = false, length = 100)
	public String getTeachingComments() {
		return teachingComments;
	}
	public void setTeachingComments(String teachingComments) {
		this.teachingComments = teachingComments;
	}
	@Column(name = "aspect_three_research_and_higher_qualification_rating", nullable = false, length = 20)
	public String getResearchAndHigherQualificationRating() {
		return researchAndHigherQualificationRating;
	}
	public void setResearchAndHigherQualificationRating(String researchAndHigherQualificationRating) {
		this.researchAndHigherQualificationRating = researchAndHigherQualificationRating;
	}
	@Column(name = "aspect_three_research_and_higher_qualification_comments", nullable = false, length = 100)
	public String getResearchAndHigherQualificationComments() {
		return researchAndHigherQualificationComments;
	}
	public void setResearchAndHigherQualificationComments(String researchAndHigherQualificationComments) {
		this.researchAndHigherQualificationComments = researchAndHigherQualificationComments;
	}
	
	@Column(name = "aspect_four_initiative_and_organization_rating", nullable = false, length = 20)
	public String getInitiativeAndOrganizationRating() {
		return initiativeAndOrganizationRating;
	}
	public void setInitiativeAndOrganizationRating(String initiativeAndOrganizationRating) {
		this.initiativeAndOrganizationRating = initiativeAndOrganizationRating;
	}
	@Column(name = "aspect_four_initiative_and_organization_comments", nullable = false, length = 100)
	public String getInitiativeAndOrganizationComments() {
		return initiativeAndOrganizationComments;
	}
	public void setInitiativeAndOrganizationComments(String initiativeAndOrganizationComments) {
		this.initiativeAndOrganizationComments = initiativeAndOrganizationComments;
	}
	@Column(name = "aspect_five_innovation_rating", nullable = false, length = 20)
	public String getInnovationRating() {
		return innovationRating;
	}
	public void setInnovationRating(String innovationRating) {
		this.innovationRating = innovationRating;
	}
	@Column(name = "aspect_five_innovation_comments", nullable = false, length = 100)
	public String getInnovationComments() {
		return innovationComments;
	}
	public void setInnovationComments(String innovationComments) {
		this.innovationComments = innovationComments;
	}
	@Column(name = "aspect_six_punctuality_rating", nullable = false, length = 20)
	public String getPunctualityRating() {
		return punctualityRating;
	}

	public void setPunctualityRating(String punctualityRating) {
		this.punctualityRating = punctualityRating;
	}

	@Column(name = "aspect_six_punctuality_comments", nullable = false, length = 100)
	public String getPunctualityComments() {
		return punctualityComments;
	}

	public void setPunctualityComments(String punctualityComments) {
		this.punctualityComments = punctualityComments;
	}
	

	@Column(name = "aspect_seven_goal_alignment_rating", nullable = false, length = 20)
	public String getGoalAlignmentRating() {
		return goalAlignmentRating;
	}

	public void setGoalAlignmentRating(String goalAlignmentRating) {
		this.goalAlignmentRating = goalAlignmentRating;
	}
	@Column(name = "aspect_seven_goal_alignment_comments", nullable = false, length = 100)
	public String getGoalAlignmentComments() {
		return goalAlignmentComments;
	}
	public void setGoalAlignmentComments(String goalAlignmentComments) {
		this.goalAlignmentComments = goalAlignmentComments;
	}
	@Column(name = "appraisal_created_by_user", nullable = false, length = 30)
	public String getAppraisalCreatedByUser() {
		return appraisalCreatedByUser;
	}
	public void setAppraisalCreatedByUser(String appraisalCreatedByUser) {
		this.appraisalCreatedByUser = appraisalCreatedByUser;
	}
	@Column(name = "recommendations", nullable = false, length = 100)
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
	@JoinColumn(name = "staff_id", nullable = false)
	public Staff getStaff() {
		return staff;
	}
	public void setStaff(Staff staff) {
		this.staff = staff;
	}

	
	private static final long serialVersionUID = 1L;
	
	private Integer staffPerformanceId;
	private String appraisalTerm;
	private String relationshipRating;
	private String relationshipComments;
	private String teachingRating;
	private String teachingComments;
	private String researchAndHigherQualificationRating;
	private String researchAndHigherQualificationComments;
	private String initiativeAndOrganizationRating;
	private String initiativeAndOrganizationComments;
	private String innovationRating;
	private String innovationComments;
	private String punctualityRating;
	private String punctualityComments;
	private String goalAlignmentRating;
	private String goalAlignmentComments;
	private String appraisalCreatedByUser;
	private String recommendations;
	private String appraisalStatus;
	private Date createdDate;
	
	//Model
	private Staff staff;


}
	

