package ssafy_algo_0201;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class T02_0201_D3_MemoryOfWonjae {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int tc = Integer.parseInt(br.readLine());
		
		String[] arr = new String[tc];

		for (int i = 0; i < tc; i++) {
			arr = br.readLine().split("");

			int cnt = 0;
			for (int j = 0; j < arr.length - 1; j++) {
				if (!(arr[j].equals(arr[j + 1]))) {
					cnt++;
				}
			}
			if (arr[0].equals("1"))
				cnt++;
			System.out.println("#" + (i+1) + cnt);

		}

		br.close();
	}
}
