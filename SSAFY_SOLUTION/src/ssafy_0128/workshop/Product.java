package ssafy_0128.workshop;

public class Product {
	private int pno;
	private String pname;
	private int cost;
	private int qty;

	public Product() {
	}

	public Product(int pno, String pname, int cost, int qty) {
		this.pno = pno;
		this.pname = pname;
		this.cost = cost;
		this.qty = qty;
	}

	public int getPno() {
		return pno;
	}

	public void setPno(int pno) {
		this.pno = pno;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public int getCost() {
		return cost;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}

	public int getQty() {
		return qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}

	@Override
	public String toString() {
		return "상품 번호 : " + getPno() + " / " + getPname() + " / " + getCost() + "원 / " + getQty()+"개 보유";
	}

}
