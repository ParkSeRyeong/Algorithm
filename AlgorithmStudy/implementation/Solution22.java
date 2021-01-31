package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution22 {
	@SuppressWarnings("unused")
	public static void main(String[] args) throws NumberFormatException, IOException {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);

		// 1. test case 입력받고,
		int t_c = Integer.parseInt(br.readLine());
		
		// 살아남은 소금쟁이의 수를 기록할 가변배열 survive 생성 (소금쟁이 수를 계속 다르게 받을 거라서)
		ArrayList<Integer> survive = new ArrayList<>();

		// 2. 입력받은 방향대로 이동하기 위해
		// 	     방향 배열 만들어 주기 		1.상			2.하		 3.좌		 4.우
		int[][] dir = { { 0, 0 }, { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

		
		// 3. 테스트케이스만큼 반복할 예정
		for (int i = 0; i < t_c; i++) {
			
		/*----------------------------------------------------------*/
			// 4. 배열 크기인 N과 소금쟁이 수인 salt 받기 (소금쟁이가 영어로 뭔지 모름)
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");

			int N = Integer.parseInt(st.nextToken());
			int salt = Integer.parseInt(st.nextToken());

			// 5. 살아남은 소금쟁이 수를 저장할 변수
			int survivecnt = salt;

			// 6. 가로세로 크기 N인 연못 생성
			int[][] pond = new int[N][N];
		/*----------------------------------------------------------*/
			for (int num = 1; num <= salt; num++) {

				// 7. 소금쟁이의 행(r), 열(c), 방향(d)를 한 번에 받아와서 띄어쓰기로 자른 후에 각각 저장
				StringTokenizer st2 = new StringTokenizer(br.readLine(), " ");
				int r = Integer.parseInt(st2.nextToken());
				int c = Integer.parseInt(st2.nextToken());
				int d = Integer.parseInt(st2.nextToken());

				// 8. 해당 위치의 연못에 소금쟁이 번호를 넣고 시작!
				pond[r][c] = num;
				
		
				// 9. 3칸-2칸-1칸 순으로 뛸 거니까, 3부터 하나씩 for문으로 깎기
				for (int k = 3; k > 0; k--) {
					
		/*----------------------------------내가 이해하려고 나눈 if문----------------------------------------*/
					// 10. nr과 nc에 소금쟁이가 뛰어서 이동할 위치를 저장해 둠
					int nr = r + k * dir[d][0];
					int nc = c + k * dir[d][1];

					/*// 11. 소금쟁이가 이동할 위치가 범위를 벗어난다면
					// 살아남은 소금쟁이 수(survivecnt)를 깎고,
					// 기존에 소금쟁이가 있던 위치도 0으로 해준다.
					if (nr >= N || nr < 0) {
						pond[r][c] = 0;
						survivecnt--;
						// System.out.println("으악 가로로 넘어감! "+num+"번째 소금쟁이 깨꼬닥!");
						break;
					}
					if (nc >= N || nc < 0) {
						pond[r][c] = 0;
						survivecnt--;
						// System.out.println("으악 세로로 넘어감! "+num+"번째 소금쟁이 깨꼬닥!");
						break;
					}

					// 12. 이동할 위치가 0이 아니라면 = 이미 다른 소금쟁이가 있다는 소리
					// 마찬가지로 살아남은 소금쟁이 수(survivecnt)를 깎고,
					// 기존에 소금쟁이가 있던 위치도 0으로 해준다.
					if (pond[nr][nc] != 0) {
						pond[r][c] = 0;
						survivecnt--;
						// System.out.println("으악 다른 소금쟁이 있음! "+num+"번째 소금쟁이 깨꼬닥!");
						break;
					}*/

		/*--------------------------------------------------------------------------------------------*/			
					 
					if((nr >= N || nr < 0)||(nc >= N || nc < 0)||(pond[nr][nc] != 0)) {
					 pond[r][c] = 0; survivecnt--; break; }
					 

					// 13. 원래 있던 위치는 0으로 바꿔주고 (이동했으니까)
					pond[r][c] = 0;

					// 14. 얘는 이동하려고 했던 위치로 진짜 이동!
					r = nr;
					c = nc;
					pond[r][c] = num;
				}

			}
			survive.add(survivecnt);
		}
		
		// 15. 가변배열에서 각각 출력
		for (int i = 1; i <= t_c; i++) {
			System.out.println("#" + i + " " + survive.get(i-1));
		}
	}
}
