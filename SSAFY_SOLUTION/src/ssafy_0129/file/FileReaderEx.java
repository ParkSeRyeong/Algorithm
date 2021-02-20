package ssafy_0129.file;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class FileReaderEx {
public static void main(String[] args) throws IOException, InterruptedException {
	File file=new File("Storage/data3.txt");
	BufferedInputStream bis=new BufferedInputStream(new FileInputStream(file));

	// File 클래스는 파일의 길이, 속성 등등을 다 알 수 있음.
	// data3 파일을 열어서 -> file.length로 파일의 길이를 받아서 -> 그만큼 바이트형 배열을 만든당 -> 길이가 75라고 한다면 75칸의 배열을 할당받음
	// 그 다음 read : buf 배열에서 0번부터 길이만큼 bis가 하나씩 읽어다가 버퍼에 넣음.
	// println은 string을 읽어서 출력하니까, byte타입을 string타입으로 바꿔서 출력해주는 것.
	

	
	byte[]buf=new byte[(int)file.length()];
	bis.read(buf,0,buf.length);
	System.out.println(new String(buf));
	bis.close();
	
	
	/*File file=new File("Storage/data3.txt");
	Reader reader=new FileReader(file);
	
	// data3 파일을 열어서 -> 하나 읽어서 출력하고 -> 하나 읽어서 출력하고-> .....
	// 이 방법으로는 보관이 안 됨 -> 복사를 못하자나 그럼...?
	 
	int ch;
	while((ch=reader.read())!=-1) {
		System.out.println((char)ch);
		Thread.sleep(100);
	}*/
}
}
