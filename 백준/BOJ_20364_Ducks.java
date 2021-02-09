package tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

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

			// 1 2 3 4 5 6 7 이라고 한다면, 7을 가려면 1-3-7 을 거쳐가야함.
			while (n > 0) {

				// 이미 방문했다면 break;
				if (visited.contains(n)) {
					//System.out.println("\t우앵 "+n+"에서 불가능");
					sb.append(n).append("\n");
					possible = false;
					break;
				}
				// 가능하다면 계속 위로 올라간다.
				//System.out.println("\t" + n + "가능! -> " + n / 2);
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
