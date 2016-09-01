package in.jdsoft.educationmanagement.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;



@Entity
@Table(name = "tbl_reporting")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Reporting implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer rowId;
	private double f1;
	private double f2;
	private int f3;
	private int f4;
	private int f5;

	public Reporting() {
	}

	public Reporting(double f1, double f2, int f3, int f4, int f5) {
		this.f1 = f1;
		this.f2 = f2;
		this.f3 = f3;
		this.f4 = f4;
		this.f5 = f5;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "row_id", unique = true, nullable = false)
	public Integer getRowId() {
		return this.rowId;
	}

	public void setRowId(Integer rowId) {
		this.rowId = rowId;
	}

	@Column(name = "F1", nullable = false, precision = 22, scale = 0)
	public double getF1() {
		return this.f1;
	}

	public void setF1(double f1) {
		this.f1 = f1;
	}

	@Column(name = "F2", nullable = false, precision = 22, scale = 0)
	public double getF2() {
		return this.f2;
	}

	public void setF2(double f2) {
		this.f2 = f2;
	}

	@Column(name = "F3", nullable = false)
	public int getF3() {
		return this.f3;
	}

	public void setF3(int f3) {
		this.f3 = f3;
	}

	@Column(name = "F4", nullable = false)
	public int getF4() {
		return this.f4;
	}

	public void setF4(int f4) {
		this.f4 = f4;
	}

	@Column(name = "F5", nullable = false)
	public int getF5() {
		return this.f5;
	}

	public void setF5(int f5) {
		this.f5 = f5;
	}

}
