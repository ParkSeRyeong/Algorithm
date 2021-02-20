package ssafy_0129.file;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

// Reader <-- InputStreamReader <-- FileReader
public class FileInputStreamEx2 {
	public static void main(String[] args) throws InterruptedException, IOException {

		Reader ob = new FileReader("src/ssafy_0129/file/data2.txt");
		/*InputStreamReader ob2 = new FileReader("src/ssafy_0129/file/data2.txt");
		FileReader ob3 = new FileReader("src/ssafy_0129/file/data2.txt");*/
		
		int ch;
		while((ch=ob.read())!=-1) {
			System.out.print((char)ch);
			Thread.sleep(100);
		}
		ob.close();
	}
}
