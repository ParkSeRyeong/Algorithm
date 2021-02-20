package ssafy_0129.stream;

import java.util.Arrays;
import java.util.stream.Collectors;

public class StreamEx1 {
	public static void main(String[] args) {
//		int[] n = { 1, 2, 3, 4, 5, 6 };
//		for (int i : n) {
//			System.out.println(i);
//		}

		// ----------------------------------------------------------------------
		// ::를 스코프연산자 라고 부른다
		// Arrays.asList(1,2,3,4,5,6).stream().forEach(System.out::println);
		// asList가 뭐지?
		// 똑같이 배열인가?

		// ---------------------------------------------------------------------
//	Arrays.asList(1,2,3,4,5,6).stream()
//	.map(i->i*i)
//	.forEach(System.out::println);		// 각 요소별로 연산	/	1,4,9,16,25,36

		// ---------------------------------------------------------------------
//		Arrays.asList(5,7,4,2).stream()
//		.limit(3)
//		.forEach(System.out::println);	//3개만 출력하도록 제한 / 5,7,4

		// ---------------------------------------------------------------------
//		Arrays.asList(3,5,7,4,2).stream()
//		.skip(2)
//		.forEach(System.out::println);	//2개 스킵 / 3,5,7

		// ---------------------------------------------------------------------
//			Arrays.asList(1,2,3,4,5,6).stream()
//			.filter(i->i%2==0)
//			.forEach(System.out::println);	//조건주기

		// ---------------------------------------------------------------------
//		Arrays.asList(Arrays.asList(1, 2, 3, 4), Arrays.asList(5, 6, 7, 8), Arrays.asList(9, 10)).stream()
//				.flatMap(i -> i.stream()).forEach(System.out::println);

		// ---------------------------------------------------------------------
		System.out.println(Arrays.asList(1, -2, 3, -1, 5).stream().reduce((a, b) -> a - b).get()); // 거리 구할 때 쓴다고 함.
		Arrays.asList(1, 2, 3, 4, 5).stream().collect(Collectors.toList()).forEach(System.out::println);
	}
}
