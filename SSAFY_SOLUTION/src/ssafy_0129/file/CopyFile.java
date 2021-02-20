package ssafy_0129.file;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;

/*
$ java CopyFile storage/data3.txt  storage/data7.txt
					원본					사본
					얜 args[0]으로			얜 args[1]로 들어오는 것!
  파일이 복사되었습니다
*/
public class CopyFile {
	public static void main(String[] args) {
		String file1 = args[0];
		String file2 = args[1];
		
		try {
			File file=new File(file1);
			FileInputStream fis=new FileInputStream(file);
			BufferedInputStream bis=new BufferedInputStream(fis);
			
			byte[]buf=new byte[(int)file.length()];
			bis.read(buf,0,buf.length);
			
			FileWriter fw=new FileWriter(file2);
			fw.write(new String(buf));
			System.out.println("파일을 복사했습니다");
			
			fw.close();
			bis.close();
			fis.close();
			
		}catch(IOException e){
			e.printStackTrace();
		}
	}
}
