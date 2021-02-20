package ssafy_algo_0216;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class T22_Refrigerator {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		ArrayList<int[]> list = new ArrayList<>();

		int N = Integer.parseInt(br.readLine());
		int[][] arr = new int[N][2];

		for (int i = 0; i < N; i++) {
			String tmp = br.readLine();
			arr[i][0] = Integer.parseInt(tmp.split(" ")[0]);
			arr[i][1] = Integer.parseInt(tmp.split(" ")[1]);
		}

		Arrays.sort(arr, new Comparator<int[]>() {
			public int compare(int[] a, int[] b) {
				return a[0] < b[0] ? -1 : 1;
			}
		});

		list.add(new int[] { arr[0][0], arr[0][1] });
		f1: for (int i = 1; i < N; i++) {
			for (int j = 0; j < list.size(); j++) {
				if (list.get(j)[0] <= arr[i][0] && list.get(j)[1] >= arr[i][0]) {
					list.get(j)[0] = Math.max(list.get(j)[0], arr[i][0]);
					list.get(j)[1] = Math.min(list.get(j)[1], arr[i][1]);
					continue f1;
				}
			}
			list.add(new int[] { arr[i][0], arr[i][1] });
		}
		System.out.println(list.size());
	}
}
