package stack_queue;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

/* BufferedWriter 써보기!*/
public class BOJ_2504_Bracket_Description {
	public static void main(String[] args) throws IOException {
		// 0. 입력부 선언
		System.setIn(new FileInputStream("src/stack_queue/Bracket_test.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		// 1. 괄호 배열 입력 받기
		String tmp = br.readLine();
		String[] arr = new String[tmp.length()];
		for (int i = 0; i < tmp.length(); i++) {
			arr[i] = String.valueOf(tmp.charAt(i));
		}

		// 2. 스택 만들기
		Stack<String> stack = new Stack<>();
		String bracket = "()[]";
		// System.out.println(bracket.contains(")"));

		for (String c : arr) {
			// 3. 여는 괄호라면 -> 그냥 push
			if (c.equals("(") || c.equals("[")) {
				stack.push(c);
			}
			// 4. 닫는 괄호라면
			else {
				if (stack.isEmpty())
					break;
				// 4-1. 스택의 peek값이 여는 괄호라면
				if (stack.peek().equals("(") || stack.peek().equals("[")) {
					// 나랑 짝이다 -> 스택에서 여는 괄호 pop 후 ()면 2, []면 3을 스택에 push
					if (c.equals(")") && stack.peek().equals("(")) {
						stack.pop();
						stack.push("2");
					} else if (c.equals("]") && stack.peek().equals("[")) {
						stack.pop();
						stack.push("3");
					}
					// 나랑 짝이 안 맞는다 -> 바로 0 출력 후 파토
					else {
						stack.clear();
						break;
					}
				}
				// 4-2. 스택의 peek값이 여는 괄호가 아닌 정수라면 ->
				// 여는 괄호가 나올 때까지 계속 pop하면서 정수를 더해줌 (sum에다)
				// 그러다 여는 괄호가 나오면 지금까지 더한 정수의 합(sum)에 *2, *3해줌
				else {
					int sum = 0;
					// 정수면 계속 pop해서 합을 구해줌
					while (!stack.isEmpty() && !bracket.contains(stack.peek())) {
						sum += Integer.parseInt(stack.pop());
					}
					if (stack.isEmpty())
						break;
					if (c.equals(")") && stack.peek().equals("(")) {
						stack.pop();
						stack.push(Integer.toString(sum * 2));
					} else if (c.equals("]") && stack.peek().equals("[")) {
						stack.pop();
						stack.push(Integer.toString(sum * 3));
					}
					// 나랑 짝이 안 맞는다 -> 바로 0 출력 후 파토
					else {
						stack.clear();
						break;
					}
				}

			}
		}
		int total = 0;
		if (stack.isEmpty()) {
			System.out.println(0);
		} else {
			while (!stack.isEmpty()) {
				if (bracket.contains(stack.peek())) {
					total = 0;
					break;
				}
				total += Integer.parseInt(stack.pop());
			}
			System.out.println(total);
		}

		// 5. br, bw는 꼭 flush+close 해주기. 잊지 말기 기억기억
		br.close();
		bw.flush();
		bw.close();
	}
}
