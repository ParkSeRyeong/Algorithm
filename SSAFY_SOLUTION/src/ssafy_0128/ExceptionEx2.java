package ssafy_0128;

public class ExceptionEx2 {
public static void main(String[] args) {
	try {
		int[]num= {10,20,30};
		
		for(int i=0;i<5;i++) {
			System.out.println(num[i]);
		}
	} catch (ArrayIndexOutOfBoundsException e) {
		//System.out.println("배열 개수를 초과함");
	}
}
}
