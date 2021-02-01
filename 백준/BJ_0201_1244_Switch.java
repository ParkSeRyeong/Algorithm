package recursive;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BJ_0201_1244_Switch {
	static int[] switches = null;

	public static void prints() {
		for (int i = 0; i < switches.length; i++) {
			System.out.print(switches[i] + " ");
			if (i % 19 == 0 && i != 0) {
				System.out.println();
			}
		}
	}

	public static void onoff(int n) {
		if (switches[n] == 0) {
			switches[n] = 1;
		} else {
			switches[n] = 0;
		}
	}

	public static void boy(int num) {
		for (int i = num; i < switches.length; i += num) {
			onoff(i - 1);
		}
	}

	public static void girl(int num) {
		// 인덱스가 0~n-1인데, 우리가 사용하는 스위치는 1~n번이라서.
		num = num - 1;

		onoff(num);
		for (int i = 1; i <= switches.length / 2; i++) {
			// 범위 벗어나면 break;
			if (num - i < 0 || num + i == switches.length) {
				break;
			}
			int left = switches[num - i];
			int right = switches[num + i];

			if (left != right) {
				break;
			}
			onoff(num - i);
			onoff(num + i);
		}
	}

	@SuppressWarnings("unused")
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 1. 스위치 개수 입력받기
		int switchNum = Integer.parseInt(br.readLine());
		
		// 2. 스위치 개수만큼 예제 입력 받기
		String[] str = br.readLine().split(" ");
		switches = Arrays.stream(str).mapToInt(Integer::parseInt).toArray();
		
		// 3. 학생 수 입력 받기
		int sNum = Integer.parseInt(br.readLine());

		// 4. 학생수만큼 각각 성별과 숫자 배정해준 후 입력하기
		for (int i = 0; i < sNum; i++) {
			int[] s = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

			if (s[0] == 1) {
				boy(s[1]);
			} else {
				girl(s[1]);
			}

		}

		// 스위치의 마지막 상태를 출력
		prints();
		br.close();
	}
}
