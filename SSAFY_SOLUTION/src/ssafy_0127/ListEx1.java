package ssafy_0127;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ListEx1 {
	
	public static void main(String[] args) {
		List <Object> list = new ArrayList<>();
		list.add("one");
		list.add(2);				// int -> Integer(자동형변환, Autoboxing)
		list.add(new Float(3.0f));
		list.add(new Integer(2));
		list.add(4.0f);				// float -> Float
		list.add(new Double(4.00));
		list.add(new String("one"));
		System.out.println(list);
		
		//list.remove(2);			s	// 인덱스를 의미
		list.remove(new Integer(2));
		System.out.println(list);
		
		for(Object o : list) {
	         System.out.println(o);
	      }
	}
}

/*@SuppressWarnings({ "unchecked", "rawtypes" })	// type 확인 안 하겠다 / 제네릭스도 확인 안 하겠다!
public static void main(String[] args) {
	List list = new ArrayList();
	list.add("one");
	list.add(2);				// int -> Integer(자동형변환, Autoboxing)
	list.add(new Float(3.0f));
	list.add(new Integer(2));
	list.add(4.0f);				// float -> Float
	list.add(new Double(4.00));
	list.add(new String("one"));
	System.out.println(list);
	
	//list.remove(2);				// 인덱스를 의미
	list.remove(new Integer(2));
	System.out.println(list);
	
	Iterator iter=list.iterator();
	while(iter.hasNext()) {
		System.out.println(iter.next());
	}
}*/