package imple_simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;

public class BOJ_1747_소수n팰린드롬_SR {

	public static boolean[] getPrimes() {
		boolean[] primes = new boolean[10000000];
		primes[1] = true;
		primes[0] = true;

		for (int i = 2; i < 10000000; ++i) {
			if (primes[i])
				continue; // 소수가 아닌(true) 수는 넘어가기
			for (int j = i + i; j < 10000000; j += i) { // i를 제외한 i의 배수 모두 체크하기
				primes[j] = true;
			}
		}
		return primes;
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		ArrayList<ArrayList<Integer>> list = new ArrayList<>();

		boolean[] primes = getPrimes();

		for (int i = 0; i < 7; i++) {
			list.add(new ArrayList<>());
		}

		list.get(0).add(0);
		for (int i = 1; i < 10; i++) {
			list.get(0).add(i);
			list.get(1).add(i * 10 + i);
		}
		if (N < 100) {
			for (ArrayList i : list) {
				Iterator<Integer> it = i.iterator();
				while (it.hasNext()) {
					int ans = it.next();
					if (ans >= N && !primes[ans]) {
						System.out.print(ans);
						return;
					}
				}
			}
		}

		for (int i = 2; i < 7; i++) {

			for (int j = 1; j < 10; j++) {
				
				// 길이가 짝수
				if (i % 2 == 0) {
					for (int k = 0; k < 10; k++) {
						int tmp = (int) (j * Math.pow(10, i) + (k * Math.pow(10, i / 2))) + j;
						if (tmp >= N && !primes[tmp]) {
							System.out.println(tmp);
							return;
						}
						list.get(i).add(tmp); 
					}
				}
				
				// 길이가 홀수
				for (int k : list.get(i - 2)) {
					int num = (int) (j * Math.pow(10, i)) + k * 10 + j;
					if (num >= N && !primes[num]) {
						System.out.println(num);
						return;
					}
					list.get(i).add(num);
				}
			}
		}
	}
}
