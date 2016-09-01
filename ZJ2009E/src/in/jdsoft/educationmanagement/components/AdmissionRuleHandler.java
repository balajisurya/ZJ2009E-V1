package in.jdsoft.educationmanagement.components;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;

import in.jdsoft.educationmanagement.model.Admission;
import in.jdsoft.educationmanagement.services.AdmissionServices;


public class AdmissionRuleHandler {
	
	public AdmissionRuleHandler() {}
	
	@Autowired
	private AdmissionServices admissionServices;

			private int courseId;
			private int courseCategoryId;
			private int ruleId;
			private int maxSelect;
			
			
			public ArrayList<Admission> executeRule(int courseId,int courseCategoryId,int ruleId,int maxSelect){
				this.courseId=courseId;
				this.courseCategoryId=courseCategoryId;
				this.ruleId=ruleId;
				this.maxSelect= maxSelect;
				
				ArrayList<Admission> selectedApplicants=null;
						switch(ruleId){
						case 1:	
								ArrayList<Admission> admissions= admissionServices.getApplicants(courseId, courseCategoryId);
								for(Admission admission:admissions){
									admission.setAdmissionRank(getRandomNumberInRange(1, admissions.size()+1).doubleValue());
									admissionServices.updateAdmission(admission);
								}
								selectedApplicants=sortApplicantsForSeats(admissionServices.getApplicants(courseId, courseCategoryId),maxSelect);
								break;
								
						case 2:
								ArrayList<Admission> admissions1= admissionServices.getApplicants(courseId, courseCategoryId);
								for(Admission admission1:admissions1){
									admission1.setAdmissionRank(getRandomNumberInDecimal());
									admissionServices.updateAdmission(admission1);
								}
								selectedApplicants=sortApplicantsForSeats(admissionServices.getApplicants(courseId, courseCategoryId),maxSelect);
								break;
						}
				return selectedApplicants;
            }
	
	public int getCourseId() {
		return courseId;
	}


	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}


	public int getCourseCategoryId() {
		return courseCategoryId;
	}


	public void setCourseCategoryId(int courseCategoryId) {
		this.courseCategoryId = courseCategoryId;
	}


	public int getRuleId() {
		return ruleId;
	}


	public void setRuleId(int ruleId) {
		this.ruleId = ruleId;
	}
	
	public int getMaxSelect() {
		return maxSelect;
	}

	public void setMaxSelect(int maxSelect) {
		this.maxSelect = maxSelect;
	}
	
	private static Integer getRandomNumberInRange(int min, int max) {
      
		if (min >= max) {
			throw new IllegalArgumentException("max must be greater than min");
		}

		Random r = new Random();
		return r.nextInt((max - min) + 1) + min;
	}
	
	private static double getRandomNumberInDecimal() {
		Random r = new Random();
		return   r.nextDouble();
	}
	
	private ArrayList<Admission> sortApplicantsForSeats(ArrayList<Admission> admissions,int maxSelect){
		
		ArrayList<Admission> sortedAdmission=new ArrayList<>();
		Collections.sort(admissions, new Comparator<Admission>() {

			@Override
			public int compare(Admission o1, Admission o2) {
				return o1.getAdmissionRank().compareTo(o2.getAdmissionRank());
			}
		});
		int i=0;
		for(Admission admission:admissions){
			if(i<maxSelect){
				sortedAdmission.add(admission);
				i++;
			}
		}
		return sortedAdmission;
	}

}
