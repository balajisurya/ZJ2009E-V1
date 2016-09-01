package in.jdsoft.educationmanagement.school.model;

public class FeesTermAndFeesStructure {

	public FeesTermAndFeesStructure(Integer feesTermId, Integer feesStructureId) {
		this.feesTermId = feesTermId;
		this.feesStructureId = feesStructureId;
	}
	
	private Integer feesTermId;
	private Integer feesStructureId;
	
	public Integer getFeesTermId() {
		return feesTermId;
	}
	public void setFeesTermId(Integer feesTermId) {
		this.feesTermId = feesTermId;
	}
	public Integer getFeesStructureId() {
		return feesStructureId;
	}
	public void setFeesStructureId(Integer feesStructureId) {
		this.feesStructureId = feesStructureId;
	}
	
	
}
