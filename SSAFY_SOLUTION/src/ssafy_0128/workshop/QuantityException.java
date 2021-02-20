package ssafy_0128.workshop;

public class QuantityException extends Exception {
	private static final long serialVersionUID = 1L;
	int q;

	public QuantityException(int q) {
		super("재고가 부족합니다 : 현재 재고 " + q + "개");
		this.q=q;
	}
}
