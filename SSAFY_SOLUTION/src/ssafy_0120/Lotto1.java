package ssafy_0120;

import java.util.Arrays;

/* [문제]아래 결과와 같이 행운의 로또번호 생성기를 만들려고 한다
1. 서로 겹치지 않는 (중복되지 않는) 숫자 6개 생성
2. 각 숫자는 1~45 범위내의 숫자
3. 매번 실행시 다른 숫자 출력
   ---> 랜덤수 : Math사용 
[결과]
16 40 21  9 20 11
*/
public class Lotto1 {
	public static void main(String[] args) {
		int[] lotto = new int[6];
		for (int j = 0; j < 5; j++) {
			for (int i = 0; i < lotto.length; i++) {

				int n = (int) (Math.random() * 45 + 1);
				lotto[i] = n;

				//중복이면 브레이끄
				for (int k = 0; k < i; k++) {
					if (lotto[k] == n) {
						i--;
						
						break;
					}
				}

			}
			System.out.println(j + 1 + "회: " + Arrays.toString(lotto));
			Arrays.fill(lotto, 0);

		}
	}
}
