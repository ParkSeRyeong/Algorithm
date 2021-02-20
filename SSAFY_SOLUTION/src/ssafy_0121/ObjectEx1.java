package ssafy_0121;

/*  -(private) , +(public) , #(protected)
클래스명 : Person
+name:String            
+age:int
+score:float

+setPerson(na:String, a:int, s:float) : void
+viewPerson():void 
*/
class Person {
	public String name; // 멤버변수(field)
	public int age;
	public float score;

	public void setPerson(String name, int age, float score) { // 멤버메서드
		this.name = name;
		this.age = age;
		this.score = score;
	}

	public void viewPerson() {
		System.out.println("이름:" + name);
		System.out.println("나이:" + age);
		System.out.println("점수:" + score);
	}
}

public class ObjectEx1 {
	public static void main(String[] args) {
		Person ob1 = new Person();
		ob1.setPerson("강호동", 25, 75.3f);
		ob1.viewPerson();
		
		Person ob2 = new Person();
		ob2.setPerson("강호동", 25, 75.3f);
		ob2.viewPerson();
	}
}
