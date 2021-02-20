package ssafy_0120;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BufferTest {@SuppressWarnings("unused")
public static void main(String[] args) throws NumberFormatException, IOException {
	InputStreamReader isr = new InputStreamReader(System.in);
	BufferedReader br = new BufferedReader(isr);

	// 1. test case 입력받기
	int t_c = Integer.parseInt(br.readLine());

	// 2. 배열 크기인 N과 소금쟁이 수인 salt 받기 (소금쟁이가 영어로 뭔지 모름)
	StringTokenizer st = new StringTokenizer(br.readLine(), " ");

	int N = Integer.parseInt(st.nextToken());
	int salt = Integer.parseInt(st.nextToken());
	
	// 3. 살아남은 소금쟁이 수를 저장할 변수
	int survivecnt = salt;

	// 4. 연못을 만들고
	int[][] pond = new int[N][N];
	
	// 5. 입력받은 방향대로 이동하기 위해
	//    방향 배열 만들어 주기			1.상			2.하		  3.좌		 4.우
	int[][] dir = { { 0, 0 }, { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

	
	// 6. 소금쟁이 수만큼 반복할 예정
	for (int num = 1; num <= salt; num++) {
		
		// 7. 소금쟁이의 행(r), 열(c), 방향(d)를 한 번에 받아와서 띄어쓰기로 자른 후에 각각 저장
		StringTokenizer st2 = new StringTokenizer(br.readLine(), " ");
		int r = Integer.parseInt(st2.nextToken());
		int c = Integer.parseInt(st2.nextToken());
		int d = Integer.parseInt(st2.nextToken());
		
		
	}

}

}
