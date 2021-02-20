package ssafy_0120;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
3
3 4 5 1 3 4 5 1 4 5
6 7 8 5 4 2 1 5 6 7
4 5 6 7 2 5 7 6 1 1
 
 * #1 35
 * #2 51
 * #3 44
 * */
public class BufferedReaderEx2 {
	public static void main(String[] args) throws IOException {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);

		int count = Integer.parseInt(br.readLine());
		int[] sum = new int[count];
		for (int i = 0; i < count; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			while (st.hasMoreElements()) {
				sum[i] += Integer.parseInt(st.nextToken());
			}
		}
		System.out.println(Arrays.toString(sum));

	}
}

/*
 * String s = "학원#학교,도서관/pc방 영화관"; StringTokenizer st = new StringTokenizer(s,
 * "#,/ "); System.out.println(st.countTokens());
 * 
 * while (st.hasMoreElements()) { System.out.println(st.nextElement()); }
 */