package ssafy_0128.workshop;

import java.util.ArrayList;
import java.util.Iterator;

public class ProductMgr implements IProductMgr {

	/** 1. ProductMgr은 싱글톤으로 하기 위해 private+static으로 선언해준다 */
	private static ProductMgr manager;

	private ProductMgr() {

	};

	/**
	 * 2. 등록한 상품을 저장할 ArrayList를 선언해준다. 타입 일단 설정 x
	 */
	public static ArrayList<Product> products = new ArrayList<>();

	/**
	 * 3. 등록된 상품의 개수 : pCnt = 새로 생성된 Product가 저장될 배열 인덱스를 가리키는 변수이기도 함. 새로 들어올 때마다
	 * ++되고, 등록한 상품이 N개라면 pCnt는 N+1이 되어있다.
	 */
	private static int pCnt = 0;

	public int getpCnt() {
		return pCnt;
	}

	public void setpCnt(int pCnt) {
		ProductMgr.pCnt = pCnt;
	}

	// ------------------------------------------------------------------------------------------------

	/**
	 * 4. 싱글톤이니까, 이 클래스에 접근할 수 있도록 getInstance 메서드를 선언해준다. getInstance를 통해 딱 하나만
	 * 사용가능함.
	 */
	public static ProductMgr getInstance() {
		if (manager == null) {
			manager = new ProductMgr();
		}
		return manager;
	}

	/** 배열로 전달할 때 임시배열로 쓸 객체배열 */
	public ArrayList<Product> tmp = new ArrayList<>();

	// ------------------------------------------------------------------------------------------------

	/**
	 * 상품을 새로 저장. pCnt위치에 Product를 넣고, 개수를 증가시킴 ex) pCnt=0 --> product를 배열의 0번째 인덱스에
	 * 넣고 --> pCnt++해서 1로 변경.
	 */
	@SuppressWarnings("unchecked")
	public void add(Product p) {
		products.add(p);
		for (Product p2 : products) {
			System.out.println(p2);
		}
	}

	/**
	 * 저장된 상품을 볼 수 있음. productArr를 넘기면 가변배열이 아니라 null까지 넘어감 -> 개수만큼만 값을 복사한 배열을 넘겨주기
	 */
	public ArrayList<Product> getList() {
		tmp.clear();
		if (products == null) {
			return null;
		}
		tmp.addAll(products);
		return tmp;
	}

	/** TV 목록만 보여주기 */
	public ArrayList<Product> getTV() {
		tmp.clear();
		Iterator<Product> iter = products.iterator();
		while (iter.hasNext()) {
			Product p = iter.next();
			if (p instanceof TV) {
				tmp.add(p);
			}
		}
		return tmp;
	}

	/** Refrigerator 목록만 보여주기 */
	public ArrayList<Product> getRefrigerator() {
		tmp.clear();
		Iterator<Product> iter = products.iterator();
		while (iter.hasNext()) {
			Product p = iter.next();
			if (p instanceof Refrigerator) {
				tmp.add(p);
			}
		}
		return tmp;
	}

	/** 상품 번호(pno)으로 검색하는 기능. pno과 같은 인덱스의 상품명을 출력 */
	public Product searchByNo(int pno) {
		Iterator<Product> iter = products.iterator();
		while (iter.hasNext()) {
			Product p = iter.next();
			if (p.getPno() == pno) {
				return p;
			}
		}
		return null;
	}

	/** 상품명으로 검색하기 */
	public ArrayList<Product> searchByPname(String pname) {
		tmp.clear();
		Iterator<Product> iter = products.iterator();
		while (iter.hasNext()) {
			Product p = iter.next();
			if (p.getPname().contains(pname)) {
				tmp.add(p);
			}
		}
		return tmp;
	}

	/** 특정 금액 이하의 상품만 검색하기 */
	public ArrayList<Product> searchByPrice(int price) {
		tmp.clear();
		Iterator<Product> iter = products.iterator();
		while (iter.hasNext()) {
			Product p = iter.next();
			if (p.getCost() < price) {
				tmp.add(p);
			}
		}
		return tmp;
	}

	@Override
	public ArrayList<Product> getRefrigeratorOver400() {
		tmp.clear();
		Iterator<Product> iter = products.iterator();

		while (iter.hasNext()) {
			Product p = iter.next();
			if (p instanceof Refrigerator) {
				 Refrigerator r = (Refrigerator) p;
				 if (r.getCapacity() > 400) {
				 tmp.add(r);
				 }
			}
		}
		return tmp;
	}

	@Override
	public ArrayList<Product> getTVOver50() {
		tmp.clear();
		Iterator<Product> iter = products.iterator();
		while (iter.hasNext()) {

			Product p = iter.next();
			if (p instanceof TV) {
				TV t = (TV) p;
				if (t.getInch() > 50) {
					tmp.add(t);
				}
			}
		}
		return tmp;
	}

	@Override
	public void updateCost(int pno, int cost) {
		Iterator<Product> iter = products.iterator();
		while (iter.hasNext()) {
			Product p = iter.next();
			if (p.getPno() == pno) {
				p.setCost(cost);
				return;
			}
		}
	}

	/** 상품번호로 삭제하는 기능 */
	public boolean delete(int pno) {
		tmp.clear();

		Iterator<Product> iter = products.iterator();
		while (iter.hasNext()) {
			Product p = iter.next();
			if (p.getPno() == pno) {
				iter.remove();
				return true;
			}
		}
		return false;
	}

	@Override
	public int[] getTotal() {
		tmp.clear();
		int[] sum = new int[products.size() + 1];
		int total = 0;

		for (int i = 0; i < products.size(); i++) {
			sum[i] += products.get(i).getCost() * products.get(i).getQty();
			total += sum[i];
		}
		sum[products.size()] = total;
		return sum;
	}

}
