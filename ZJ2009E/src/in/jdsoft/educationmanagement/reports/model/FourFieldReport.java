package in.jdsoft.educationmanagement.reports.model;

public class FourFieldReport {

	private Object F1,F2,F3,F4;
	
	public FourFieldReport(Object F1,Object F2,Object F3,Object F4) {
		this.F1=F1;
		this.F2=F2;
		this.F3=F3;
		this.F4=F4;
	}

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

	public Object getF4() {
		return F4;
	}

	public void setF4(Object f4) {
		F4 = f4;
	}
	
}
