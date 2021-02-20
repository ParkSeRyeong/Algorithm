package ssafy_0128.workshop;

public class TV extends Product {
	private int inch;
	private String displayType;

	public TV() {
	}

	public TV(int pno, String pname, int cost, int qty, int inch, String displayType) {
		super(pno, pname, cost, qty);
		this.inch = inch;
		this.displayType = displayType;
	}

	public int getInch() {
		return inch;
	}

	public void setInch(int inch) {
		this.inch = inch;
	}

	public String getDisplayType() {
		return displayType;
	}

	public void setDisplayType(String displayType) {
		this.displayType = displayType;
	}

	@Override
	public String toString() {
		return super.toString() + " / " + inch + "인치 / " + displayType + "타입";
	}

}
