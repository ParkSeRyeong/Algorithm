package ssafy_algo_0204;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class T12_5432_IronBar {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int tc = Integer.parseInt(br.readLine());
		Stack<Integer> stack = new Stack<>();

		for (int t = 1; t < tc + 1; t++) {
			sb.append("#");
			sb.append(t);
			sb.append(" ");
			
			String input = br.readLine();
			char[] arr = new char[input.length()];
			
			for (int i = 0; i < input.length(); i++) {
				arr[i] = input.charAt(i);
			}

			// 0. 전체 조각의 개수, slice
			// 1. 이 스택의 사이즈는 (의 개수가 될 것,즉 안에 들어있는 요소의 개수 =  쇠막대기의 개수!
			int slice = 0;
			for (int i = 0; i < input.length(); i++) {
				
				// 2. ( 들어오면 쇠막대긴지 레이전지는 모르지만, 일단 push
				if (arr[i] == '(') {
					stack.push(i);
				} 
				// 3. ) 들어오면 두 가지 경우 : 레이저거나, 막대기 끝이거나!
				else {
					
					// 3-1. 레이저라면? : 방금 전에 들어온 (가 레이저랑 한 쌍이니까, pop한다!
					if (i - stack.peek() == 1) {
						
						// 바로 앞의 하나는 레이저의 ( 니까 pop해서 없애브러.
						stack.pop();
						
						// 그럼 지금까지 stack에 남아있는건? -> 쇠막대기 개수가 되겠지 : 쇠막대기 시작인 (의 개수니까.
						slice += stack.size();

					}
					// 3-2. 레이저가 아니라면? : 쇠막대기의 끝 = 쇠막대기 개수를 하나 줄여야하니까 pop, 조각은 하나 증가하니까 ++
					else {
						slice++;
						stack.pop();
					}
				}

			}
			sb.append(slice);
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}
}
