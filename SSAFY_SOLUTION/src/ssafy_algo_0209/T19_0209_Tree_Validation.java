package ssafy_algo_0209;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/*못풀었음.*/
public class T19_0209_Tree_Validation {
	public static void main(String[] args) throws NumberFormatException, IOException {
		System.setIn(new FileInputStream("src/ssafy_algo_0209/validation_test.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		for (int t = 1; t < 2; t++) {
			sb.append("#").append(t).append(" ");
			boolean flag = true;
			for (int i = 0; i < N; i++) {
				String tmp = br.readLine();
				System.out.println(tmp);
				
				// 이 조건문에 안들어가..! 왜지?
				if (tmp.length() > 4 && !tmp.contains("*") && !tmp.contains("+") && !tmp.contains("-")
						&& !tmp.contains("/")) {
					System.out.println("뵹");
					flag = false;
					//break;
				}
			}
			sb.append(flag == true ? 1 : 0).append("\n");
		}
		System.out.println(sb);
	}
}
