package dp;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class NOT_Problem05_MoneyOrganize {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		// dt : 최소 단위를 저장할 테이블
		int[] dt = new int[M + 1];
		Arrays.fill(dt, M + 1);

		// money : 화폐단위를 저장할 배열
		int[] money = new int[N];
		for (int i = 0; i < N; i++) {
			money[i] = Integer.parseInt(br.readLine());
			dt[money[i]] = 1;
		}

		//
		for (int i = 1; i < M + 1; i++) {
			// 기본 화폐단위면 그냥 넘깁시다
			if (dt[i] == 1) {
				continue;
			}

			// 화폐 단위만큼 인덱스를 이전으로 이동해서, 그 값이 최소인 값 + 1...? 알아듣겠냐
			// 그니까 화폐가 3 5 7이 있고 내가 지금 10을 계산중이다!
			// dt[10]에서 인덱스를 3,5,7만큼 전으로 이동시켜서 값을 보는 거지
			// dt[7] d[5] dt[3] -> 이 중 가장 최소값을 찾아서, 거기다 +1해주기.
			// 불가능한 화폐는 초기값인 M+1이 들어가있을것.ㅇㅇ.

			int min = M + 1;
			for (int j = 0; j < N; j++) {
				// 범위 아웃이면 무시!
				if (i - money[j] < 1)
					continue;
				min = Math.min(min, dt[i - money[j]] + 1);
			}
			dt[i] = min;
		}
		bw.write(String.valueOf(dt[M]==M+1?-1:dt[M]));
		bw.flush();
		bw.close();
		br.close();
	}
}
