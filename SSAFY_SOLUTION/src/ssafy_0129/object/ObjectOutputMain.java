package ssafy_0129.object;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class ObjectOutputMain {
	public static void main(String[] args) {
		User ob1 = new User("이도겸", 25, 21.8);
		User ob2=new User("전원우",26, 71.7);
		
		//IO Stream : 직렬화(데이터를 저장하는 길)
		try {
			ObjectOutputStream oos=new ObjectOutputStream(new FileOutputStream("Storage/user.txt"));
			oos.writeObject(ob1);
			oos.writeObject(ob2);
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
