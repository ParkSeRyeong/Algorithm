package fail;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2281_DeathNote {
	static int[] name;
	static int [][]dp;
	static int N, M;

	public static int write(int len, int cur) {
		
		int ret=dp[len][cur];
		if(ret!=-1) return ret;
		
		ret=write(name[cur]+1, cur+1)+(M-len+1)*(M-len+1);
		
		return ret;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		name = new int[N];
		dp = new int[1000][1000];
		for (int i = 0; i < N; i++) {
			name[i] = Integer.parseInt(br.readLine());
		}
	}
}
