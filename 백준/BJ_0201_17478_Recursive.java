package recursive;

import java.util.Scanner;

public class BJ_0201_17478_Recursive {
//	static String[] sArr = { "\"재귀함수가 뭔가요?\"", "\"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.",
//			"마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지.", "그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어.\"",
//			"\"재귀함수는 자기 자신을 호출하는 함수라네\"", "라고 답변하였지." };
	static String[] sArr = { "1","2","3","4","5","6"};
	static String underBar = "____";
	static int real = 0;

	static void printUnderbar(int n) {
		for (int k = 0; k < real - n; k++) {
			System.out.print(underBar);
		}
	}

	static void recursive(int n) {
		if (n < 0) {
			return;
		}

		// 1. 항상 반복되는 0번째 5번째 말.
		printUnderbar(n);
		System.out.println(sArr[0]);

		// 2. 234와 5를 선택
		if (n != 0) {
			for (int i = 1; i < 4; i++) {
				printUnderbar(n);
				System.out.println(sArr[i]);
			}
			n = n - 1;
			recursive(n);

		} else {
			printUnderbar(n);
			System.out.println(sArr[4]);
			n = n - 1;
		}
		printUnderbar(n + 1);
		System.out.println(sArr[5]);
	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		real = n;
		System.out.println("어느 한 컴퓨터공학과 학생이 유명한 교수님을 찾아가 물었다.");
		recursive(n);

		sc.close();
	}
}
