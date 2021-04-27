package study;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_6137_문자열생성 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		System.setIn(new FileInputStream("src/study/문자열_test.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine());
		char[] arr = new char[N];

		for (int i = 0; i < N; i++) {
			arr[i] = br.readLine().charAt(0);
			sb.append(arr[i]);
		}

		String str = sb.toString();
		sb=new StringBuilder();

		int left = 0;
		int right = N - 1;
		int cnt = 0;
		while (left <= right) {
			if (arr[left] < arr[right]) {
				sb.append(arr[left]);
				left++;
			} else if (arr[left] > arr[right]) {
				sb.append(arr[right]);
				right--;
			} else if(left==right){
				sb.append(arr[left]);
				break;
			}else {
				int tmp_l = left;
				int tmp_r = right;
				int tmp_cnt = 0;
				while (true) {
					if (tmp_l > tmp_r) {
						System.out.println(str);
						return;
					}
					if (arr[tmp_l] != arr[tmp_r])
						break;
					tmp_l++;
					tmp_r--;
					tmp_cnt++;
				}
				if (arr[tmp_l] < arr[tmp_r]) {
					for (int i = 0; i < tmp_cnt; i++) {
						sb.append(arr[left]);
						left++;
					}
				} else {
					for (int i = 0; i < tmp_cnt; i++) {
						sb.append(arr[right]);
						right--;
					}
				}
			}
			cnt++;
			if (cnt % 80 == 0)
				sb.append("\n");
		}
		System.out.println(sb);
		br.close();
	}
}
