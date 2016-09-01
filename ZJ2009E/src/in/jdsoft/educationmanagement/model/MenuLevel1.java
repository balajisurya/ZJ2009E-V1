package in.jdsoft.educationmanagement.model;


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

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "tbl_menu_level1")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class MenuLevel1 implements java.io.Serializable {


	private static final long serialVersionUID = 1L;
	private Integer level1Id;
	private String menuName;
	private Integer orderNo;
	private String link;
	private String userType;
	private String icon;
	
	private Set<MenuLevel2> menuLevel2 = new HashSet<MenuLevel2>(0);
	
	
	
	public MenuLevel1() {
		
	}

	public MenuLevel1(String menuName, Integer orderNo, String link, String userType, String icon){
		this.menuName = menuName;
		this.orderNo = orderNo;
		this.link = link;
		this.userType = userType;
		this.icon = icon;
	}
	
	public MenuLevel1(String menuName, Integer orderNo, String link, String userType, String icon,
			Set<MenuLevel2> menuLevel2) {
		this.menuName = menuName;
		this.orderNo = orderNo;
		this.link = link;
		this.userType = userType;
		this.icon = icon;
		this.menuLevel2 = menuLevel2;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "level1_id", unique = true, nullable = false)
	public Integer getLevel1Id() {
		return this.level1Id;
	}

	public void setLevel1Id(Integer level1Id) {
		this.level1Id = level1Id;
	}

	@Column(name = "menu_name")
	public String getMenuName() {
		return this.menuName;
	}

	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}

	@Column(name = "order_no")
	public Integer getOrderNo() {
		return this.orderNo;
	}

	public void setOrderNo(Integer orderNo) {
		this.orderNo = orderNo;
	}

	@Column(name = "link")
	public String getLink() {
		return this.link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	@Column(name = "user_type")
	public String getUserType() {
		return this.userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	@Column(name = "icon")
	public String getIcon() {
		return this.icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "menuLevel1")
	public Set<MenuLevel2> getMenuLevel2s() {
		return this.menuLevel2;
	}

	public void setMenuLevel2s(Set<MenuLevel2> menuLevel2) {
		this.menuLevel2 = menuLevel2;
	}

}
