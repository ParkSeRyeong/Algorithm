package ssafy_algo_0205;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class T15_1223_Calculator2 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		System.setIn(new FileInputStream("C:\\SSAFY\\javawork\\AlgorithmClass\\src\\ssafy_algo_0205\\clac_input.txt"));

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		Queue<Integer> q = new LinkedList<Integer>();
		Stack<Integer> s = new Stack<>();

		for (int t = 1; t < 11; t++) {
			sb.append("#");
			sb.append(t);
			sb.append(" ");
			q.clear();
			s.clear();

			int N = Integer.parseInt(br.readLine());

			String tmp = br.readLine();
			char[] arr = new char[tmp.length()];
			for (int i = 0; i < N; i++) {
				arr[i] = tmp.charAt(i);
			}

			for (int i = 0; i < tmp.length(); i++) {
				
				// 1. +도 아니고 *도 아닌건 -> 정수니까 -> 스택에 push!
				if (arr[i] != '+' && arr[i] != '*') {
					s.push(arr[i] - '0');
				}

				// 2. 더하기일 때
				else if (arr[i] == '+') {
					
					// 1+2*3*4*5*6+7 이라고 한다면
					// 큐에 2,3,4,5,6을 넣고, +가 들어오는 순간
					// 큐에 있는 값들을 모두 곱해서 다시 스택으로 넣음.
					
					if(!q.isEmpty()) {
						int product = 1;
						while (!q.isEmpty()) {
							int p = q.poll();
							product *= p;
						}
						s.push(product);
					}
				}
				
				// 3. 곱하기일 때
				else {
					// *연산자 바로 앞의 값은 정수니까 스택에 들어갔겠지 -> 빼버리자!
					s.pop();
					
					// 맨 끝연산자가 아니고 + 그 다음으로 +연산자가 오기 전까지
					// 계속 큐에 *연산자 왼쪽 값을 넣어줌
					// 1+2*3*4*5*6+7이라면, 2,3,4를 큐에 넣음.
					while (i + 2 < N && arr[i + 2] != '+') {
						q.offer(arr[i - 1] - '0');
						i += 2;
					}
					
					// 그리고  마지막 *연산자에선 왼쪽 + 오른쪽 값을 넣어줌.
					// 1+2*3*4*5*6+7 이면 나머지 5,6까지 넣음
					q.offer(arr[i - 1] - '0');
					q.offer(arr[i + 1] - '0');
					i++;
				}
				// 맨 마지막이 *면 안 들어가길래... 그냥 넣었다...
				if (i + 2 == N - 1) {
					if(!q.isEmpty()) {
						int product = 1;
						while (!q.isEmpty()) {
							int p = q.poll();
							product *= p;
						}
						s.push(product);
					}
				}
			}
			
			// 스택에 있는 값 다 더하기
			int sum = 0;
			while (!s.isEmpty()) {
				sum += s.pop();
			}
			sb.append(sum + "\n");
		}
		System.out.println(sb.toString());
	}
}
