package ssafy_0121;

/*   
클래스명 : User
+name:String              
+k:int
+e:int
+m:int

+setUser(name:String, k:int, e:int, m:int):void
+getTotal():int
+getUser():String
*/
public class User {
	public String name;
	public int k;
	public int e;
	public int m;

	public void setUser(String name, int k, int e, int m) {
		this.name = name;
		this.k = k;
		this.e = e;
		this.m = m;
	}

	public int getTotal() {
		return k + e + m;
	}

	public String getUser() {
		return "나의 이름은 "+name+"이고, 총점은 "+getTotal()+"점 입니다.";
	}
}
