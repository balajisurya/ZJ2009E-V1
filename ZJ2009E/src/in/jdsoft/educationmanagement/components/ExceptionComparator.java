package in.jdsoft.educationmanagement.components;

import java.util.HashSet;
import java.util.Set;

import org.springframework.stereotype.Component;

@Component
public class ExceptionComparator {

	public String containsWord(String sentence)
	 {
		 Set<String> hwords = new HashSet<String>();    
	     hwords.add("class_name");
	     hwords.add("section_name");
	     hwords.add("special_category_name");
	     hwords.add("ledger_account_name");
	     hwords.add("ledger_reference_number");
	     hwords.add("academic_year_title");
	     hwords.add("template_item_name");
	     hwords.add("template_name");
	     hwords.add("admission_no");
	     hwords.add("email");
	     hwords.add("roll_no");
	     hwords.add("class_id");
	     hwords.add("section_id");
	     hwords.add("institution_id");
	    
	     
	     
	     for (String word : hwords) {
	       if (sentence.contains(word)) {
	         return word;
	       }
	     }
		return null;
	 }

}
