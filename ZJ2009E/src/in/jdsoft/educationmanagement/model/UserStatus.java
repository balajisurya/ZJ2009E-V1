package in.jdsoft.educationmanagement.model;


import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.apache.commons.lang.WordUtils;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@Entity
@Table(name = "tbl_user_status")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class UserStatus implements java.io.Serializable {

	
	private static final long serialVersionUID = 1L;
	private Integer userStatusId;
	private String userStatusTitle;

	public UserStatus(String userStatusTitle) {
		this.userStatusTitle =WordUtils.capitalize(userStatusTitle);
	}
	
	public UserStatus() {
		// TODO Auto-generated constructor stub
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "user_status_id", unique = true, nullable = false)
	public Integer getUserStatusId() {
		return this.userStatusId;
	}

	public void setUserStatusId(Integer userStatusId) {
		this.userStatusId = userStatusId;
	}

	@Column(name = "user_status_title", nullable = false, length = 10)
	public String getUserStatusTitle() {
		return this.userStatusTitle;
	}

	public void setUserStatusTitle(String userStatusTitle) {
		this.userStatusTitle =WordUtils.capitalize(userStatusTitle);
	}

}
