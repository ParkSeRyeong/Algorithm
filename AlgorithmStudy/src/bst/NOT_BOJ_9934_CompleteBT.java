package bst;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class NOT_BOJ_9934_CompleteBT {
	static int[] arr;
	static int n;
	static StringBuilder ss = new StringBuilder();

	public static void func(int start, int end) {
		if (start > end) {
			return;
		}

	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		System.setIn(new FileInputStream("src/bst/cbt_test.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		int K = Integer.parseInt(br.readLine());
		n = (int) Math.pow(2, K);

		arr = new int[n];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Queue<Integer> q = new LinkedList<Integer>();

	}
}
