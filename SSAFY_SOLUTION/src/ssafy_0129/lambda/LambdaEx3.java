package ssafy_0129.lambda;

@FunctionalInterface
interface Item {
	public String getItem();
}

class Mymy implements Item {
	

	@Override
	public String getItem() {
		return "컴퓨터";
	}

}

public class LambdaEx3 {
	public static void main(String[] args) {
//		Item ob=()->"컴퓨터";
//		System.out.println(ob.getItem());
		
		Item m=new Item() {
			
			@Override
			public String getItem() {
				return "컴퓨터";
			}
		};
		System.out.println(m.getItem());
		
		
//		Mymy items=new Mymy();
//		System.out.println(items.getItem());
	}
}
