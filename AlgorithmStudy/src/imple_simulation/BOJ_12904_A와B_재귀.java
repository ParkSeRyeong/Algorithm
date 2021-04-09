package imple_simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class BOJ_12904_A와B_재귀 {
	static HashSet<String>set=new HashSet<>();
	static boolean flag=false;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		String S = br.readLine();
		String T = br.readLine();
		for (int i = 0; i < S.length(); i++) {
			sb.append(S.charAt(i));
		}

		func2(sb, T, S.length(), T.length());
		System.out.println(flag?1:0);
		br.close();
	}

	private static void func2(StringBuilder sb, String T, int cnt, int length) {
		if(flag) return;
		if (sb.toString().equals(T)) {
			flag=true;
			return;
			
		}
		if (cnt == length) {
			return;
		}
		
		set.add(sb.toString());

		sb.append('A');
		if(!set.contains(sb.toString()) && !flag) {
			func2(sb, T, cnt + 1, length);
		}
		sb.setLength(sb.length() - 1);

		sb.reverse().append('B');
		if(!set.contains(sb.toString()) && !flag) {
			func2(sb, T, cnt + 1, length);
		}
		sb.setLength(sb.length()-1);
		sb.reverse();
	}

}
