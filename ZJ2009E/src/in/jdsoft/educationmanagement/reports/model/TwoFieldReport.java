package in.jdsoft.educationmanagement.reports.model;

public class TwoFieldReport {
private Object F1,F2;
	
	public TwoFieldReport(Object F1,Object F2) {
		this.F1=F1;
		this.F2=F2;
		
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

}
