package stack_queue;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class BOJ_1662_Compression_Description {
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("src/stack_queue/compression_test.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String tmp = br.readLine();
		int bracket_idx = 0;
		String[] arr = new String[tmp.length()];
		for (int i = 0; i < tmp.length(); i++) {
			arr[i] = String.valueOf(tmp.charAt(i));
			if (arr[i].equals("(")) {
				bracket_idx++;
			}
		}
		// 괄호의 순서?를 사용하기 위해서 배열을 만들어줌.
		// 들어오는 '('괄호는 차례대로 인덱스 증가해서 부여받음.
		int[] bracket = new int[bracket_idx];

		bracket_idx = 0;
		// result : 마지막 결과값을 담을 변수
		int result = 0;

		Stack<String> stack = new Stack<>();
		for (String s : arr) {
			// 1. 닫는 괄호가 아니라면 : 스택에 push
			if (!s.equals(")")) {
				
				// 1-1. 여는 괄호가 들어올 땐 괄호 인덱스 증가
				if (s.equals("(")) {
					bracket_idx++;
				}
				stack.push(s);
			}
			
			// 2. 닫는 괄호가 들어왔다면
			else {
				// 2-1. 괄호 인덱스를 하나 줄임 : ')'가 들어왔으니, '('하나도 없앨거라서 인덱스-1
				bracket_idx--;
				
				// 2-2. cnt : '('가 나올 때까지 숫자가 몇 개 있는지 카운트
				int cnt = 0;
				while (!stack.peek().equals("(")) {
					stack.pop();
					cnt++;
				}
				// 2-3. 그럼 while문 이후엔 스택의 peek이 '('이니까 pop해서 스택에서 없애주고 (아까 배열 인덱스 하나 줄인 이유)
				stack.pop();

				// 이전 괄호의 배열 인덱스의 값이랑 더하기
				// ex) 2(71(9)3(18)) 라고 한다면 : 
				// (1) 9 뒤에 오는 괄호가 들어온다면 괄호인덱스 --, 1번 * 1개(9) = 1과, 본인 배열 인덱스값에 들어있는 값(0, 아직 없음)을 더해서 1뒤에 오는 괄호 인덱스(1)의 배열값에 넣어줌. 
				// (2) 그리고 ')'들어올 때까지 계속 push
				
				// (3) 현재 스택 상태 : 2(73(18
				// (4) 그다음 3 뒤에 오는 괄호에서 다시 괄호인덱스가 ++되고 -> 괄호인덱스 2
				// (5) 얘도 마찬가지로 8뒤에 오는 괄호에서 다시 괄호 인덱스 --, 1뒤에 오는 괄호 인덱스(1)의 배열값에 [(3번 * 2개(18) = 6) + 본인 배열 인덱스값(0)]을 더해준다.
				// (6) 그럼 1뒤에 오는 괄호 인덱스엔 1+6, 7이 들어있음.
				
				// (7) 현재 스택 상태 : 2(7
				// (8) 이제 7은 본인 배열 인덱스값에 들어있는 7과 + '('이 될 때까지의 숫자개수를 더해줌 = 7개 + 1개(7하나) = 8개
				// (9) 그리고 이제 '(' 앞에 2랑 더해주는 거지.
				cnt += bracket[bracket_idx];

				cnt *= Integer.parseInt(stack.pop());
				bracket[bracket_idx] = 0;
				// 이전 브라켓에 cnt 더함
				if (bracket_idx - 1 < 0) {
					result += cnt;
					continue;
				}
				bracket[bracket_idx - 1] += cnt;
			}
		}
		result += stack.size();
		bw.write(String.valueOf(result));
		bw.flush();
		bw.close();
		br.close();

	}
}
