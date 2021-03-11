package backtracking;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import java.util.StringTokenizer;

public class BOJ_16928_Snake_and_Ladder {

	public static void print(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			if (i % 10 == 0) {
				System.out.println(arr[i]);
			} else {
				System.out.print(arr[i] + " ");
			}
		}
	}

	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("src/backtracking/ladder_test.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int ladder = Integer.parseInt(st.nextToken());
		int snake = Integer.parseInt(st.nextToken());
		int[] map = new int[101];
		int tmp = 0;

		HashMap<Integer, Integer> hash = new HashMap<>();

		for (int i = 0; i < ladder; i++) {
			st = new StringTokenizer(br.readLine());
			tmp = Integer.parseInt(st.nextToken());

			hash.put(Integer.parseInt(st.nextToken()), tmp);
		}
		for (int i = 0; i < snake; i++) {
			st = new StringTokenizer(br.readLine());
			tmp = Integer.parseInt(st.nextToken());
			hash.put(tmp, -Integer.parseInt(st.nextToken()));
		}

		int index = 1;
		for (int i = 2; i < 101; i++) {
			for (int k = 1; k <= 6; k++) {
				if(i>100) break;
				// 사다리나 뱀 정보가 있다면
				if (hash.get(i) != null) {

					// 1. 사다리타고 올라온 값이라면?
					if (hash.get(i) > 0) {
						// 2 -> 72인 사다리가 있을 때, hash에 <72,2>가 있는 상황
						// 72번칸 값을 = 2번칸값으로 바꿔주세용
						map[i] = map[hash.get(i)];
						index = map[i] +1;
						k = 0;
						print(map);
						System.out.println("==============");
					}

					// 2. 이 자리에 뱀이 있다면?
					else {
						// 51 -> 19인 뱀이 있을 때, hash에 <51,-19>가 있는 상황
						// 일단 51번칸엔 index 넣고
						map[i] = index;
						int arrive = -hash.get(i);
						// 19번칸 값이 > 51번칸값보다 크다면?
						if (map[arrive] > map[i]) {
							map[arrive] = map[i]; // 바꿔주세용

							// 그리고 19+1번칸부터 최소값갱신 다시 시작 ㄱㄱ
							i = arrive + 1;
							index++;
							k = 0;
							print(map);
							System.out.println("---------------");
							continue;
						}
					}
				}
				// 그냥 기본 칸이라면
				else {
					// 벌써 값이 있다 = 사다리타고 올라왔나보다
					if (map[i] != 0 && map[i] < index) {
						// 걔 값으로 최소값 바꾸자
						index = map[i];
						print(map);
						System.out.println("---------------");
					} else {
						map[i] = index;
					}

				}
				i++;
			}
			index++;
			i--;
		}
//
//		Set<Integer> set = hash.keySet();
//		Iterator<Integer> iter = set.iterator();
//		while (iter.hasNext()) {
//			int i = iter.next();
//			System.out.println(i + " " + hash.get(i));
//		}
//
//		print(map);

		bw.write(String.valueOf(map[100]));
		bw.flush();
		bw.close();
		br.close();
		// print(map);
	}
}
