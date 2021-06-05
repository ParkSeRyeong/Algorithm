package study;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.AnnotatedArrayType;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1939_중량제한 {
	static LinkedList<island>[] list;
	static boolean[] visit;
	static int start, end;

	private static class island {
		int to, w;

		public island(int to, int w) {
			this.to = to;
			this.w = w;
		}
	}

	// 이 bfs를 한 번 돌면 출발지-도착지까지 가는 길 중 w이상 중량인 길만 골라서 간다.
	private static boolean bfs(int w) {
		Queue<Integer> q = new LinkedList<>();
		visit[start] = true;
		q.add(start);

		while (!q.isEmpty()) {
			int now = q.poll();
			
			// for문 -> 시간초과, for-each문 좀 습관화들이기
			for(island i:list[now]) {
				if (!visit[i.to] && i.w >= w) {
					visit[i.to] = true;
					// 같은 경로 다른 w가 있을 수도 있어서 안 될듯.
					// if(next.to==end) return true;
					q.add(i.to);
				}
			}
		}
		// 도착 못하면 false겠졍. 도착했으면 true.
		return visit[end];
	}
	

	public static void binarySearch(int max) {
		int start = 1;
		int end = max;
		int mid = 0;
		int result = 0;
		while (start <= end) {
			// 가운데 반갈라서 보기 시작합시다
			mid = (start + end) / 2;

			Arrays.fill(visit, false);
			
			// 도착점에 도달 할 수 있다 -> 오ㅋ 중량 업
			if (bfs(mid)) {
				result = Math.max(result, mid);
				start = mid + 1;
			}
			// 도착할 수 없다 -> ㅠㅠ중량 다운
			 else {
				end = mid - 1;	
			}
		}
		System.out.println(result);
	}

	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("src/study/중량제한_test.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		list = new LinkedList[N + 1];
		for (int i = 0; i < N + 1; i++) {
			list[i] = new LinkedList<>();
		}
		int max = Integer.MIN_VALUE;
		visit = new boolean[N + 1];

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());

			list[a].add(new island(b, w));
			list[b].add(new island(a, w));
			max = Math.max(max, w);
		}

		st = new StringTokenizer(br.readLine());
		start = Integer.parseInt(st.nextToken());
		end = Integer.parseInt(st.nextToken());

		binarySearch(max);
	}

}
