package greedy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.StringTokenizer;

class box {
	int size;
	int num;

	public box() {
		super();
		// TODO Auto-generated constructor stub
	}

	public box(int size, int num) {
		super();
		this.size = size;
		this.num = num;
	}

}

public class BOJ_1493_Box {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int length = Integer.parseInt(st.nextToken());
		int width = Integer.parseInt(st.nextToken());
		int height = Integer.parseInt(st.nextToken());

		int min = Math.min(length, Math.min(width, height));
		HashMap<Integer, Integer> hash = new HashMap<>();

		int N = Integer.parseInt(br.readLine());

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int size = Integer.parseInt(st.nextToken());
			int num = Integer.parseInt(st.nextToken());
			hash.put((int) Math.pow(2, size), num);
		}
		System.out.println(hash.get(3));
		while (true) {
			if (hash.get(min) == null || hash.get(min) == 0) {
				break;
			}
		}
	}
}
