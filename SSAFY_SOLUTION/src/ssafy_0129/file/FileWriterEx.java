package ssafy_0129.file;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

/*
[경로]
절대경로: 루트(root)를 기준으로 파일을 찾는다
상대경로: 현재위치를 기준으로 파일을 찾는다
         ./   --> 현재위치(생략가능)
         ../  --> 상위(한 단계 위로)
         /    --> 루트(최상위)
*/
public class FileWriterEx {
	public static void main(String[] args) throws IOException {
		// 역슬러시 두번 or 그냥 슬러시/ 한 번 똑같다..!!!!
//		FileWriter w = new FileWriter("C:/SSAFY/javawork/JavaProject2/Storage/data3.txt");	//절대 경로
//		FileWriter w = new FileWriter("Storage/data3.txt");	//상대경로
		
		File f=new File("Storage/data5.txt");
		Writer w=new FileWriter(f);
		
		StringBuilder str = new StringBuilder();
		str.append("애옹이 짱\n");
		str.append("저너누 짱\n");
		str.append("전애옹 짱\n");
		str.append("원우야!!!!!!!!!\n");

		// StringBuilder에서는 toString이 기본값이 아니기 때문에 꼭 toString해야함...!!!!!!!!!!!!!!!!!!!!!
		w.write(str.toString());
		w.close();
		System.out.println("저장했습니다");
	}
}
