package linkedlist;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

import javax.naming.LinkLoopException;

public class HashmapTest {
	public static void main(String[] args) {
		HashMap<Integer, Character> arr = new HashMap<>();
		ArrayList<ArrayList<Integer>> list = new ArrayList<>();
		LinkedList<Integer> ll = new LinkedList<>();
		
		arr.put(1, 'A');
		arr.put(2, 'C');

		for (int i = 0; i < 5; i++) {
			ArrayList<Integer> a = new ArrayList<>();
			a.add(i);
			a.add(i + 48);
			list.add(a);
		}
//		for (int i = 0; i < 5; i++) {
//			System.out.println(list.get(i).get(0));
//		}
	}
}
