package ssafy_0129.io;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class OutputStreamEx {
	public static void main(String[] args) throws IOException {
		OutputStreamWriter osw = new OutputStreamWriter(System.out);
		BufferedWriter bw = new BufferedWriter(osw);

		String str1 = "가나다라 abcd1234#$%^";
		bw.write("test 1:" + str1);
		//버퍼를 한 번 사용한 다음엔 꼭 내보내고 버퍼를 비워줘야함!
		bw.flush();

		String str2 = "원우 보고싶다";
		bw.write("\ntest 2:" + str2);
		bw.flush();

		// OutputStreamWriter는 close를 꼭 해줘야 작동됨!ㄹ
		osw.close();
		bw.close();

		// -------------------------------------------------------------------------
		/*
		 * OutputStreamWriter osw = new OutputStreamWriter(System.out);
		 * 
		 * String str1 = "가나다라 abcd1234#$%^"; osw.write("test 1:" + str1);
		 * 
		 * String str2 = "원우 보고싶다"; osw.write("\ntest 2:" + str2);
		 * 
		 * // OutputStreamWriter는 close를 꼭 해줘야 작동됨!ㄹ osw.close();
		 */

	}
}
