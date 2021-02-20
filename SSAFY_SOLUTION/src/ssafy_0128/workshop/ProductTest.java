package ssafy_0128.workshop;

import java.util.Scanner;

/* 테스트용 입력 예시 (상품 3개 등록, 시작하자마자 붙여넣기하면 등록됨.) */
/*
1
1
111
삼성 HD TV
100
37
90
HD
1
2
8302
매직도어 냉장고 600L
200
10
600
1
1
47591
삼성 QLED 스마트 TV
100
95
40
QLED
1
2
7103
4-DOOR 스마트 냉장고 370L
200
30
370
*/
public class ProductTest {
	static Scanner sc = new Scanner(System.in);
	static ProductMgr mgr = ProductMgr.getInstance();

	public static void main(String[] args) {
		int choice = 0;
		do {
			System.out.println("\n--------메뉴를 선택하세요---------");
			System.out.println("1. 상품 등록\n2. 상품 리스트 확인\n3. 상품 검색\n4. 대용량 냉장고 검색\n"
					+ "5. 대형 TV 검색\n6. 상품 수정\n7. 상품 제거\n8. 상품별 재고 금액 보기\n9. 종료");
			choice = sc.nextInt();

			// 1. 상품 등록
			if (choice == 1) {
				System.out.println("등록하려는 상품 정보를 선택하세요\n1. TV\n2. Refrigerator");
				int type = sc.nextInt();
				sc.nextLine();
				addNewProduct(type);
				System.out.println("등록 완료!");
				continue;
			}
			if (mgr.products == null) {
				System.out.println("등록된 상품이 없습니다.");
				continue;
			}

			switch (choice) {
			// 2. 상품 확인
			case 2:
				System.out.println("(1) 전체 상품 목록 보기\n(2) TV 목록 보기\n(3) Refrigerator 목록 보기");
				int choice_type = sc.nextInt();
				sc.nextLine();

				switch (choice_type) {
				case 1:
					getList();
					break;
				case 2:
					getTV();
					break;
				case 3:
					getRefrigerator();
					break;
				default:
					System.out.println("메뉴 번호를 잘못 입력하셨습니다.");
					break;
				}
				break;

			// 3. 상품 검색
			case 3:
				System.out.println("(1) 상품 번호로 검색하기\n(2) 상품명으로 검색하기\n(3) 특정 가격 이하 상품만 검색하기");
				int choice_find = sc.nextInt();
				sc.nextLine();

				switch (choice_find) {
				case 1:
					searchByNo();
					break;

				case 2:
					 searchByName();
					break;

				case 3:
					 searchByPrice();
					break;
				}
				break;
			
			// 4. 400L 이상의 냉장고만 보기
			case 4:
				//mgr.show();
				getRefrigeratorOver400();
				break;

			// 5. 50인치 이상의 Tv만 보기
			case 5:
				getTVOver50();
				break;
				
			// 6. 가격 수정
			case 6:
				updateCost();
				break;
				
			// 7. 상품번호로 제거
			case 7:
				delete();
				break;
			
			// 8. 재고별 금액 보기
			case 8:
				getTotal();
				break;

			case 9:
				System.out.println("---------종료합니다---------");
				System.exit(0);
			}
		} while (choice != 9);

	}

	/** 1. 새 상품 등록 */
	static void addNewProduct(int choice) {
		System.out.print("상품번호를 입력하세요 : ");
		int pno = sc.nextInt();
		sc.nextLine();
		System.out.print("상품명을 입력하세요 : ");
		String pname = sc.nextLine();
		System.out.print("가격을 입력하세요 : ");
		int cost = sc.nextInt();
		sc.nextLine();
		System.out.print("재고를 입력하세요 : ");
		int qty = sc.nextInt();

		Product p = null;
		/** tv냐 refrigerator냐에 따라 다르게 객체 생성 후 추가 */
		switch (choice) {
		case 1:
			System.out.print("인치(inch)를 입력하세요 : ");
			int inch = sc.nextInt();
			sc.nextLine();
			System.out.print("디스플레이 타입을 입력하세요 : ");
			String dType = sc.nextLine();
			p = new TV(pno, pname, cost, qty, inch, dType);
			break;
		case 2:
			System.out.print("용량을 입력하세요 : ");
			int capacity = sc.nextInt();
			sc.nextLine();
			p = new Refrigerator(pno, pname, cost, qty, capacity);
			break;
		}

		mgr.add(p);
	}

	/** 2-1. 전체 상품 리스트 보여주기 */
	static void getList() {
		for (Product p : mgr.getList()) {
			System.out.println(p);
		}
	}

	/** 2-2. TV 리스트 보여주기 */
	static void getTV() {
		System.out.println("********* TV 목록 *********");
		for (Product p : mgr.getTV()) {
			System.out.println(p);
		}
	}

	/** 2-3. Refrigerator 리스트 보여주기 */
	static void getRefrigerator() {
		System.out.println("********* Refrigerator 목록 *********");
		for (Product p : mgr.getRefrigerator()) {
			System.out.println(p);
		}
	}

	/** 3-1. 상품 번호로 검색하기 */
	static void searchByNo() {
		System.out.print("상품 번호 입력 : ");
		int n = sc.nextInt();
		if (mgr.searchByNo(n) == null) {
			System.out.println("해당하는 상품이 없습니다.");
			return;
		}
		System.out.println(mgr.searchByNo(n));

		sc.nextLine();
	}

	/** 3-2. 상품명으로 검색하기 */
	static void searchByName() {

		System.out.print("상품명 입력 : ");
		String pname = sc.nextLine();

		if (mgr.searchByPname(pname) == null) {
			System.out.println("해당하는 상품이 없습니다.");
			return;
		}
		for (Product p : mgr.searchByPname(pname)) {
			System.out.println(p);
		}
	}

	/** 3-3. 특정 금액 이하의 상품만 검색하기 */
	static void searchByPrice() {
		System.out.print("가격 입력 : ");
		int n = sc.nextInt();
		sc.nextLine();

		if (mgr.searchByPrice(n) == null) {
			System.out.println("검색 결과 없음");
			return;
		}
		for (Product p : mgr.searchByPrice(n)) {
			System.out.println(p);
		}
	}
	
	/** 4. 400L 이상의 냉장고만 검색하기*/
	static void getRefrigeratorOver400() {
		if(mgr.getRefrigeratorOver400()==null) {
			System.out.println("검색 결과 없음");
			return;
		}
		for(Product p:mgr.getRefrigeratorOver400()) {
			System.out.println(p);
		}
	}
	
	/** 5. 50인치 이상의 TV만 검색하기*/
	static void getTVOver50() {
		if(mgr.getTVOver50()==null) {
			System.out.println("검색 결과 없음");
			return;
		}
		for(Product p:mgr.getTVOver50()) {
			System.out.println(p);
		}
	}
	
	/** 6. 상품 번호랑 가격 받아서 수정하기 */
	static void updateCost() {
		System.out.print("수정할 상품의 상품 번호 입력 : ");
		int pno = sc.nextInt();
		if(mgr.searchByNo(pno)==null) {
			System.out.println("존재하지 않는 상품 번호입니다.");
			return;
		}
		System.out.print("수정할 가격 입력 : ");
		int cost=sc.nextInt();
		sc.nextLine();

		mgr.updateCost(pno, cost);
		System.out.println("수정 완료");
	}
	

	/** 7. 상품 번호로 제거 */
	static void delete() {
		System.out.print("제거할 상품 번호 입력 : ");

		if (mgr.delete(sc.nextInt()) != true) {
			System.out.println("해당 상품이 존재하지 않습니다.");
			return;
		}
		sc.nextLine();
		System.out.println("제거 완료");
	}

	/** 8. 전체 재고 상품 금액 보기 */
	static void getTotal() {
		for (int i = 0; i < mgr.getTotal().length - 1; i++) {
			System.out.println(mgr.getList().get(i).getPname() + " : " + mgr.getTotal()[i]);
		}
		System.out.println("전체 재고 금액 합 : "+mgr.getTotal()[mgr.getTotal().length-1]);
	}
	
	/***/

}
