package in.jdsoft.educationmanagement.school.model;


import static javax.persistence.GenerationType.IDENTITY;

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

import org.hibernate.annotations.ForeignKey;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@Entity
@Table(name = "tbl_master_user_type",uniqueConstraints=@UniqueConstraint(columnNames = {"user_type_name"}))
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class MasterUserType implements java.io.Serializable {

	
	private static final long serialVersionUID = 1L;
	private Integer typeId;
	private String userTypeName;
	private String userTheme;
	private Integer status;
	
	private Set<User> users=new HashSet<User>(0);
	

	public MasterUserType() {
		// TODO Auto-generated constructor stub
	}
	


	public MasterUserType(String userTypeName,String userTheme,int status) {
		this.userTypeName =userTypeName;
		this.userTheme=userTheme;
		this.status=status;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "type_id", unique = true, nullable = false)
	public Integer getTypeId() {
		return this.typeId;
	}

	public void setTypeId(Integer typeId) {
		this.typeId = typeId;
	}

	@Column(name = "user_type_name", length = 50)
	public String getUserTypeName() {
		return this.userTypeName;
	}

	public void setUserTypeName(String userTypeName) {
		this.userTypeName =userTypeName;
	}

	@Column(name = "user_theme", length = 50)
	public String getUserTheme() {
		return userTheme;
	}

	public void setUserTheme(String userTheme) {
		this.userTheme = userTheme;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "userTypes")
	@ForeignKey(name="userTypeInUsers")
	public Set<User> getUsers() {
		return users;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
	}

    @Column(name = "user_type_status")
	public Integer getStatus() {
		return status;
	}
    
    public void setStatus(Integer status) {
		this.status = status;
	}

    
}
