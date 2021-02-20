package ssafy_0129.lambda;

import java.util.ArrayList;
import java.util.List;

public class LambdaEx7 {
	public static void main(String[] args) {
		List<String> list=new ArrayList<>();
		list.add("월");
		list.add("화");
		list.add("수");
		list.add("목");
		list.add("금");
		
		for(String s:list) {
			System.out.println(s);
		}
		System.out.println("---------------------");
		list.forEach((m)->System.out.println(m+"요일"));
	}
}
