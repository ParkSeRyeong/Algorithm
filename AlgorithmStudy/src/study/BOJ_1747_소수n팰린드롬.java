package study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;

public class BOJ_1747_소수n팰린드롬 {
	static ArrayList<Integer> list = new ArrayList<>();

	public static boolean[] getPrimes() {
		boolean[] primes = new boolean[1003002];
		primes[1] = true;

		for (int i = 2; i < 1003002; ++i) {
			if (primes[i])
				continue; // 소수가 아닌(true) 수는 넘어가기

			for (int j = i + i; j < 1003002; j += i) { // i를 제외한 i의 배수 모두 체크하기
				primes[j] = true;
			}
			list.add(i);
		}

		return primes;
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		boolean[] primes = getPrimes();

		Iterator<Integer> it = list.iterator();
		while (it.hasNext()) {
			int now = it.next();
			String str = Integer.toString(now);
			boolean flag = true;
			for (int i = 0; i < str.length() / 2; i++) {
				if (str.charAt(i) != str.charAt(str.length() - i - 1)) {
					flag = false;
					break;
				}
			}
			if (flag && now >= N) {
				System.out.println(now);
				return;
			}

		}
		System.out.println(list.size());
	}
}
