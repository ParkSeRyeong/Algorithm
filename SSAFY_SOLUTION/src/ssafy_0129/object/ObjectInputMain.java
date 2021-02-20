package ssafy_0129.object;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class ObjectInputMain {
	
	
	public static void main(String[] args) {
		//IO Stream : 갖고오는 거니까, 역직렬화(데이터를 저장하는 길)
		try {
			ObjectInputStream ois=new ObjectInputStream(new FileInputStream("Storage/user.txt"));
			User ob1=(User)ois.readObject();
			User ob2=(User)ois.readObject();
			
			ob1.disp();
			ob2.disp();
			
			ois.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
