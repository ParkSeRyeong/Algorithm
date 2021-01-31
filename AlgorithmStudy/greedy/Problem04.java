package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem04 {
	public static void main(String[] args) throws IOException {		
		
		// Scanner보다 BufferedReader가 훨씬 빠름.
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// split보다 Tokenizer가 빠름.
//		int n = Integer.parseInt(str.split(" ")[0]);
//		int k = Integer.parseInt(str.split(" ")[1]);
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		long startTime = System.currentTimeMillis();
		int cnt = 0;
		
		while (n != 1) {
			cnt++;
			if (n % k == 0) {
				n = n / k;
			} else {
				n -= 1;
			}
		}
		br.close();
		System.out.println(cnt);
		long endTime = System.currentTimeMillis();
		System.out.println((endTime - startTime)/1000.00+"초 수행");
	}
}
