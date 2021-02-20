package ssafy_0127;

abstract class AA {
	//추상 클래스로 만들어두고 안에 일반 메서드
	public void view1() {}	// 1

	public void view2() {} 	// 2
}

class BB extends AA {
	// 위에 이미 정의돼있기 때문에 오버라이딩이 필수가 아님
}

public class AbstractEx1 {
	public static void main(String[] args) {
		//AA ob = new AA();	// 추상클래스이기 때문에 AA로 객체 생성 불가능!

		AA ob2 = new BB();
		ob2.view1(); // 자식인 BB가 재정의를 했으므로 3. view1 호출
		ob2.view2(); // 자식인 BB에 view2가 없으므로 2. view2 호출
	}
}



// --------------- 추상 메서드가 있는 추상 클래스 ----------------------
/*abstract class AA {
	abstract public void view1();	// 1

	public void view2() {} 	// 2
}

class BB extends AA {

}

public class AbstractEx1 {
	public static void main(String[] args) {
		AA ob = new AA();	// AA로 객체 생성 불가능!

		AA ob2 = new BB();
		ob2.view1(); // 자식인 BB가 재정의를 했으므로 3. view1 호출
		ob2.view2(); // 자식인 BB에 view2가 없으므로 2. view2 호출
	}
}*/

/*class AA {
	public void view1() {
	} // 1

	public void view2() {
	} // 2
}

class BB extends AA {

	@Override
	public void view1() {
	} // 3. 강제성이 없는 재정의

}

public class AbstractEx1 {
	public static void main(String[] args) {
		AA ob = new AA();
		ob.view1(); // AA 자신의 view1 호출(당연)

		AA ob2 = new BB();
		ob2.view1(); // 자식인 BB가 재정의를 했으므로 3. view1 호출
		ob2.view2(); // 자식인 BB에 view2가 없으므로 2. view2 호출
	}
}*/
