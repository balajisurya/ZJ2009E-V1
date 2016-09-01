package in.jdsoft.educationmanagement.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "tbl_menu_level2")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class MenuLevel2 implements java.io.Serializable {

	
	private static final long serialVersionUID = 1L;
	private Integer level2Id;
	private MenuLevel1 menuLevel1;
	private String menuName;
	private Integer orderNo;
	private String link;
	private String userType;
	
	public MenuLevel2() {
		// TODO Auto-generated constructor stub
	}

	public MenuLevel2(MenuLevel1 menuLevel1, String menuName, Integer orderNo, String link, String userType) {
		this.menuLevel1 = menuLevel1;
		this.menuName = menuName;
		this.orderNo = orderNo;
		this.link = link;
		this.userType = userType;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "level2_id", unique = true, nullable = false)
	public Integer getLevel2Id() {
		return this.level2Id;
	}

	public void setLevel2Id(Integer level2Id) {
		this.level2Id = level2Id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "level1_id")
	public MenuLevel1 getMenuLevel1() {
		return this.menuLevel1;
	}

	public void setMenuLevel1(MenuLevel1 menuLevel1) {
		this.menuLevel1 = menuLevel1;
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

}
