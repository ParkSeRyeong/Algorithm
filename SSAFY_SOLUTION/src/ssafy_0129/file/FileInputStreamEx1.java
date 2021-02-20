package ssafy_0129.file;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class FileInputStreamEx1 {
	public static void main(String[] args) throws InterruptedException, IOException {
		InputStreamReader isr = new FileReader("src/ssafy_0129/file/data1.txt");
		BufferedReader br=new BufferedReader(isr);
		
		String str;
		while((str=br.readLine())!=null) {
			System.out.println(str);
			Thread.sleep(100);
		}
		isr.close();
		br.close();
		
		/*InputStreamReader is = new FileReader("src/ssafy_0129/file/data1.txt");
		
		int readdata;
		while (true) {
			readdata = is.read();		// char로 읽는다 : 한글 처리 가능
			if (readdata == -1) {		// -1 (EOL : 파일의 끝)
				break;
			}
			System.out.print((char) readdata);	// 읽어서 문자로 바꿔준당
			Thread.sleep(10);
		}
		is.close();*/
		
		/*InputStream is = new FileInputStream("src/ssafy_0129/file/data1.txt");

		int readdata;
		while (true) {
			readdata = is.read();		// byte로 읽는다 : 한글 깨짐
			if (readdata == -1) {		// -1 (EOL : 파일의 끝)
				break;
			}
			System.out.println((char) readdata);	// 읽어서 문자로 바꿔준당
			Thread.sleep(10);
		}
		is.close();*/
	}
}
