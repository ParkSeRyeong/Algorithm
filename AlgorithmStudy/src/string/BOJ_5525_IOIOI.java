package string;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BOJ_5525_IOIOI {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
		int pLen = 2 * N + 1;
		char[] original = new char[pLen];

		for (int i = 0; i < pLen; i++) {
			if (i % 2 == 0) {
				original[i] = 'I';
			} else {
				original[i] = 'O';
			}
		}
		int strLen = Integer.parseInt(br.readLine());
		String str = br.readLine();
		int cnt = 0;

		int index = 0;
		while (index < strLen) {

			boolean flag = true;
			int rightLen = 0;
//		-----------------------------------------------------
			//System.out.println("\t*** "+index+" ***");
			for (int i = 0; i < pLen; i++) {
				//System.out.println("----------- "+i+" -------------");
				if (index + i >= strLen)
					break;
				// 다르면?
				if (str.charAt(index + i) != original[i]) {
					if (i == 0)
						index++;
					else
						index += i;
					flag = false;
					//System.out.println("\t탈락");
					break;
				}
				rightLen++;
			}
//		-----------------------------------------------------
			if (flag) {
				//System.out.println("일치 인덱스 : "+index);
				index += 2;
				if (rightLen == pLen)
					cnt++;
			}
		}
		bw.write(String.valueOf(cnt));
		bw.flush();
		bw.close();
		br.close();
	}
}
