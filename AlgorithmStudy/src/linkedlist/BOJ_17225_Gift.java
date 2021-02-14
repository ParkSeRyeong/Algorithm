package linkedlist;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.StringTokenizer;

class Gift {
	int time;
	char color;
	int giftNum;

	public Gift() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Gift(int time, char color) {
		super();
		this.time = time;
		this.color = color;
	}

	public Gift(int time, char color, int giftNum) {
		super();
		this.time = time;
		this.color = color;
		this.giftNum = giftNum;
	}

}

public class BOJ_17225_Gift {
	@SuppressWarnings("unused")
	public static void main(String[] args) throws IOException {
		long start = System.currentTimeMillis();
		System.setIn(new FileInputStream("src/linkedlist/gift_test.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder s = new StringBuilder();
		StringBuilder j = new StringBuilder();

		// -----------입력부--------------
		StringTokenizer st = new StringTokenizer(br.readLine());
		int sangmin = Integer.parseInt(st.nextToken());
		int jisoo = Integer.parseInt(st.nextToken());
		int people = Integer.parseInt(st.nextToken());

		int sangmin_can_start = 0;
		int jisoo_can_start = 0;

		int sCnt = 0;
		int jCnt = 0;

		LinkedList<Gift> list = new LinkedList<>();

		for (int i = 0; i < people; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int time = Integer.parseInt(st.nextToken());
			char color = st.nextToken().charAt(0);
			int buy = Integer.parseInt(st.nextToken());

			if (color == 'B') {
				time = Math.max(sangmin_can_start, time);
				for (int t = 0; t < buy; t++) {
					Gift g = new Gift(time, 'B');
					list.add(g);
					time += sangmin;
				}
				sangmin_can_start = time;
			}

			else {
				time = Math.max(time, jisoo_can_start);
				for (int t = 0; t < buy; t++) {
					Gift g = new Gift(time, 'R');
					list.add(g);
					time += jisoo;
				}
				jisoo_can_start = time;
			}
		}

		Collections.sort(list, new Comparator<Gift>() {
			public int compare(Gift a, Gift b) {
				return (a.time > b.time) ? +1 : -1;
			}
		});
		
		// 4
		// 1 2 4 6
		// 3
		// 3 5 7

		int idx = 1;
		for (Gift g : list) {
			g.giftNum = idx;
			idx++;
			if (g.color == 'B') {
				s.append(g.giftNum).append(" ");
				sCnt++;
			} else {
				j.append(g.giftNum).append(" ");
				jCnt++;
			}
		}
		System.out.println(sCnt);
		System.out.println(s);
		System.out.println(jCnt);
		System.out.println(j);
		//long end = System.currentTimeMillis();
	}
}
