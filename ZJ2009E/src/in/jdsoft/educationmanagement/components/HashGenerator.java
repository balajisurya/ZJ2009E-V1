package in.jdsoft.educationmanagement.components;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class HashGenerator {

	public String encoder(String s){
		BCryptPasswordEncoder pencode=new BCryptPasswordEncoder();
		return pencode.encode(s);
	}
}
