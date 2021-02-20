package ssafy_0118;

import java.util.Scanner;

public class GameTest {

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		int a = (int) (Math.random() * 21 + 30);
		// 30~50 사이의 난수를 얻고 싶으면 -> (두 수의 차 +1)을 곱하고, 시작 숫자를 더해주면 됨.
		Scanner sc = new Scanner(System.in);
		// 게임 메뉴 출력
		System.out.println("가위바위보 게임을 시작합니다. 아래 보기 중 하나를 고르세요.");
		System.out.println("1. 5판 3승");
		System.out.println("2. 3판 2승");
		System.out.println("3. 1판 1승");
		System.out.print("번호를 입력하세요.");

		int menu = sc.nextInt(); // 사용자가 선택한 메뉴 변수
		int comWin = 0; // 컴퓨터가 승리한 카운트 변수
		int userWin = 0; // 사용자가 승리한 카운트 변수
		int totalCnt = 0; // 총 치뤄야 하는 게임 카운트 변수
		int winCnt = 0; // 승리조건을 충족하는 카운트 변수
		int gameCnt = 0; // 진행중인 게임 카운트 변수
		int comNo = 0; // 컴퓨터가 선택한 가위,바위,보 숫자
		int userNo = 0; // 사용자가 선택한 가위,바위,보 숫자

		switch (menu) {
		case 1:
			winCnt = 3;
			totalCnt = 5;
			break;
		case 2:
			winCnt = 2;
			totalCnt = 3;
			break;
		case 3:
			winCnt = 1;
			totalCnt = 1;
			break;
		default:
			System.out.println("메뉴 안에서 선택해주세요.");
		}

		while (gameCnt++ < totalCnt && comWin < winCnt && userWin < winCnt) {
			System.out.println("가위(1), 바위(2), 보(3) 중 하나 입력 : ");
			comNo=(int)(Math.random()*3+1);
			userNo=sc.nextInt();
			System.out.println("사용자 "+userNo + ", 컴퓨터 " + comNo);
			if(comNo==userNo) {
				System.out.println("비김");
			}
			else if(comNo<userNo) {
				if(userNo==3&&comNo==1) {
					System.out.println("이김");
					userWin++;
				}
				else {
					System.out.println("짐");
					comWin++;
				}
			}
			else{
				if(userNo==1&&comNo==3) {
					System.out.println("짐");
					comWin++;
				}
				else {
					System.out.println("이김");
					userWin++;
				}
			}
		}
		if(userWin>comWin) {
			System.out.println("***사용자 승***");
		}
		else if(userWin<comWin){
			System.out.println("***컴퓨터 승***");
		}else {
			System.out.println("***무승부***");
		}
		sc.close();
	}
}
