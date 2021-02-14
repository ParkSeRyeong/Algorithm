package tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/* ducks2가 더 효율적. */
public class BOJ_20364_Ducks {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		StringBuilder sb = new StringBuilder();
		ArrayList<Integer> visited = new ArrayList<>();

		// N : 땅의 개수
		// Q : 오리 수
		int N = Integer.parseInt(st.nextToken());
		int Q = Integer.parseInt(st.nextToken());

		// ducks : 각 오리들이 원하는 땅 번호
		int[] ducks = new int[Q];

		for (int i = 0; i < Q; i++) {
			// possible : 가능한지를 판단해 줄 flag. 갈 수 있다면 true;
			boolean possible = true;

			int n = Integer.parseInt(br.readLine());
			ducks[i] = n;

			while (n > 0) {

				// 이미 방문했다면 break;
				if (visited.contains(n)) {
					sb.append(n).append("\n");
					possible = false;
					break;
				}
				// 가능하다면 계속 위로 올라간다.
				n /= 2;
			}
			// 해당하는 땅 까지 갈 수 있다면 0을 출력, 방문리스트에 이 땅(ducks[i])을 넣는다.
			if (possible) {
				visited.add(ducks[i]);
				sb.append(0).append("\n");
			}
		}
		System.out.println(sb);
	}
}
