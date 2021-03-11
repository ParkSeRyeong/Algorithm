package backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ_1038_DecreasingNumber2 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		ArrayList<Long> list = new ArrayList<>();
		if (n < 10) {
			System.out.println(n);
			return;
		}

		for (long k = 0; k < 10; k++) {
			list = func(k, 1, list);
		}
		Collections.sort(list);
		System.out.println(n > 1022 ? -1 : list.get(n));
	}

	public static ArrayList<Long> func(long start, int len, ArrayList<Long> list) {
		if (len > 10)
			return list;
		list.add(start);
		for (int i = 0; i < start % 10; i++) {
			func((start * 10) + i, len + 1, list);
		}
		return list;
	}
}
