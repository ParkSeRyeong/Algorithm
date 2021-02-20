package ssafy_0127;

import java.util.ArrayList;
import java.util.Iterator;

public class ListEx3 {
	public static void main(String[] args) {
		Book2 ob1 = new Book2("java", "kim", 100);
		Book2 ob2 = new Book2("c++", "lee", 250);
		Book2 ob3 = new Book2("oracle", "park", 300);

		// ArrayList 객체에 ob1,2,3담기

		ArrayList<Book2> list = new ArrayList<>();
		list.add(ob1);
		list.add(ob2);
		list.add(ob3);

		Iterator<Book2> iter = list.iterator();
		while(iter.hasNext()) {
			System.out.println(iter.next());
		}
		
		ArrayList<Integer>a=new ArrayList<>();
		a.add(2);
		a.add(4);
		a.add(6);
		a.add(8);
		a.add(10);
		
		System.out.println(a.remove((Integer)6));
		System.out.println(a);

	}
}
