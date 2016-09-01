package in.jdsoft.educationmanagement.reports.model;

public class ThreeFieldReports {

	public ThreeFieldReports(Object f1, Object f2, Object f3) {
		this.F1 = f1;
		this.F2 = f2;
		this.F3 = f3;
	}

	private Object F1,F2,F3;

	public Object getF1() {
		return F1;
	}

	public void setF1(Object f1) {
		F1 = f1;
	}

	public Object getF2() {
		return F2;
	}

	public void setF2(Object f2) {
		F2 = f2;
	}

	public Object getF3() {
		return F3;
	}

	public void setF3(Object f3) {
		F3 = f3;
	}
}
