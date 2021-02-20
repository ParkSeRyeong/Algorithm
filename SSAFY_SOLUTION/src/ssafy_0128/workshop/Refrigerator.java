package ssafy_0128.workshop;

public class Refrigerator extends Product {
	private int capacity;

	public Refrigerator() {
	}

	public Refrigerator(int pno, String pname, int cost, int qty, int capacity) {
		super(pno, pname, cost, qty);
		this.capacity = capacity;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	@Override
	public String toString() {
		return super.toString() + " / 용량 " + capacity;
	}

}
