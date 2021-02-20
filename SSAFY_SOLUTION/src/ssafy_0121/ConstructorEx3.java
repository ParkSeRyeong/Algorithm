package ssafy_0121;

/*클래스명 : UserInfo
+name:String   
+addr:String

+UserInfo()
+UserInfo(name:String, addr:String)   
+getter
*/
class UserInfo{
	String name;
	String Addr;
	public UserInfo() {
		System.out.println("** 주소록 **");
	}
	public UserInfo(String name, String address) {
		this();
		this.name=name;
		this.Addr=address;
	}
	public String getName() {
		return name;
	}
	public String getAddr() {
		return Addr;
	}
	
	
	
}
public class ConstructorEx3 {
	public static void main(String[] args) {
		UserInfo ob=new UserInfo("도라에몽","경남 창원시 150 태크노파크");
		System.out.println("이름: " + ob.getName());
		System.out.println("주소: " + ob.getAddr());
	}
}
/*
 * [출력 화면] *주소록 * 	<---기본생성자에서 출력
 * 이름 : 도라에몽 	<---main()함수에서 getter를 이용해서 출력
 * 주소 : 경남 창원시 150 태크노파크
 */