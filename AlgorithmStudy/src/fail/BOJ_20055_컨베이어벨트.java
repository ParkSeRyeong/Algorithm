package fail;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.HashSet;
import java.util.Iterator;
import java.util.StringTokenizer;

public class BOJ_20055_컨베이어벨트 {
	static ArrayList<Integer> list;
	static HashSet<Integer> set = new HashSet<>();
	static BitSet b = new BitSet();
	static int[] belt;
	static int N;
	static int cnt;

	public static void show() {

		Iterator<Integer> it = list.iterator();
		System.out.println("-----show------");
		while (it.hasNext()) {
			System.out.print(it.next() + " ");
		}
		System.out.println();
	}

	public static void rotate(int down) {
		int i = N, now = i;

		while (true) {
			now = b.previousSetBit(i);
			System.out.println("현재 로봇 위치 : " + now);
			// 이제 그 전 값이 없다면 그만.
			if (now == -1) {
				break;
			}
			// 다음 위치에 로봇 없고 + N-1칸도 아니라면
			if (!b.get(now + 1) && (now + 1) != down) {
				System.out.println(now + "에서 한 칸 이동.");
				b.clear(now);
				belt[now + 1]--;
				cnt++;
				b.set(now + 1);
			} else if (b.get(now + 1)) {
				System.out.println("다음 칸에 로봇이 있군요. 아쉽습니다.");
			} else {
				System.out.println("끝 칸이네용. 로봇 빠이.");
				b.clear(now);
				belt[now]--;
				cnt++;
			}
			i = now - 1;
		}
		System.out.println("현재 카운트 : " + cnt);
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		belt = new int[N * 2];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			belt[i] = belt[i * 2 + 1] = Integer.parseInt(st.nextToken());
		}

		list = new ArrayList<>();
		cnt = 0;
		int step = 0;
		int up = 0;
		int down = N - 1;

		System.out.println(b.toString());
		while (true) {

			// stage 0 : 벨트 한 바퀴 회전
			System.out.println("---------\n벨트 한 바퀴 회전 : " + step + "단계");
			up = up > 0 ? up - 1 : 2 * N - 1;
			down = down > 0 ? down - 1 : 2 * N - 1;
			step++;

			// stage 1 : 로봇 하나 이동
			System.out.println("---------\n로봇 이동 시작 : " + step + "단계");
			rotate(down);
			if (cnt >= K)
				break;
			step++;

			// stage 2 : 로봇 올리기
			System.out.println("---------\n로봇 올리기 : " + step + "단계");
			if (!b.get(up)) {
				b.set(up);
				belt[up]--;
				cnt++;
			}
			if (cnt >= K)
				break;
			step++;
		}
		System.out.println((step + 1) + "단계");
	}
}
