package ssafy_0129.file;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.io.PrintWriter;

public class FileOutputStreamEx1 {
	public static void main(String[] args) throws IOException {
		OutputStream out = new FileOutputStream("src/ssafy_0129/file/data1.txt");

		String name = "전원우";
		int age = 26;
		double tall = 182.0;

		/*out.write(name.getBytes());
		// out.write(age); // 이렇게 출력하면 안 됨
		out.write(Integer.toString(age).getBytes());
		out.write(Double.toString(tall).getBytes());
*/
		// 출력 byte stream filtering
		PrintStream ps = new PrintStream(out);
		//ps.printf("\n\n\r이름:%s\t\t나이:%d\t키:%.1f\n", name, age, tall);
		
		// 출력 character stream filtering
		PrintWriter pw=new PrintWriter(out);
		pw.printf("\n\n\r이름:%s\t\t나이:%d\t키:%.1f\n", name, age, tall);
		pw.flush();
		
		System.out.println("Data1.txt로 저장했습니당");
		
		ps.close();
		pw.close();
		out.close();
	}
}
