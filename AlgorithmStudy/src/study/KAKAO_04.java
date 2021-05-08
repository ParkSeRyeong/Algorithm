package study;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

public class KAKAO_04 {

	private static class Pos implements Comparable<Pos> {
		int to;
		int dist;
		boolean dir;

		public Pos(int to, int dist, boolean dir) {
			super();
			this.to = to;
			this.dist = dist;
			this.dir = dir;
		}

		@Override
		public int compareTo(Pos o) {
			return this.dist - o.dist;
		}

	}

	static public int solution(int n, int start, int end, int[][] roads, int[] traps) {
		int answer = 0;
		ArrayList<Pos>[] list = new ArrayList[n];
		for (int i = 0; i < n; i++) {
			list[i] = new ArrayList<>();
		}
		for (int i = 0; i < roads.length; i++) {
			list[roads[i][0]].add(new Pos(roads[i][1], roads[i][2], true));
			list[roads[i][1]].add(new Pos(roads[i][0], roads[i][2], false));
		}
		HashSet<Integer> trap = new HashSet<>();
		for (int i : traps) {
			trap.add(i);
		}
		
		for(int i=0;i<n;i++) {
			Collections.sort(list[i]);
		}

		boolean dir = true;
		int now = start;
		while (now != end) {
			
		}

		return answer;
	}

	public static void main(String[] args) {
	}
}
