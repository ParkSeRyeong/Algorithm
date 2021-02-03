package ssafy_algo_0203;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class T07_0203_Babygin {
	static int N = 6;
	static int[] num = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };

	static int[] visited = new int[10];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int t = 0; t < tc; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int[] arr = new int[st.countTokens()];

			boolean flag = false;

			sb.append("#" + (t + 1));
			int i = 0;
			while (st.hasMoreTokens()) {
				arr[i] = Integer.parseInt(st.nextToken());
				visited[arr[i]]++;
				i++;
			}

			int total = 0;
			
			//-------------------sb append 다시 짜기-------------------
			for (i = 0; i < visited.length; i++) {
				if (total == 2) {
					break;
				}
				if (visited[i] >= 3) {
					// 얘가 triplet..?이니까...?
					visited[i] -= 3;
					total++;
					continue;
				}
			}
			for (i = 0; i < visited.length - 2; i++) {
				if (total == 2) {
					break;
				}
				if (visited[i] > 0) {
					if (visited[i + 1] == 0 || visited[i + 2] == 0) {
						break;
					}
					total++;
					visited[i]=0;
					visited[i+1]=0;
					visited[i+2]=0;
				}
			}
			if (total==2)
				sb.append(" yes\n");
			else
				sb.append(" no\n");
		}
		System.out.println(sb.toString());

	}
}
