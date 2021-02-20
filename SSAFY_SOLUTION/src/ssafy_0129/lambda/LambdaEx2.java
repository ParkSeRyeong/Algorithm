package ssafy_0129.lambda;

class MyThread implements Runnable {

	@Override
	public void run() {
		System.out.println("Run! Hello Thread");
	}

}

public class LambdaEx2 {
	public static void main(String[] args) {
		new Thread(()->
		{ System.out.println("helloooo"); }
				).start(); 
	}
}

// ------------- 익명 함수 ---------------
/*public class LambdaEx2 {
	public static void main(String[] args) {
		new Thread(new Runnable() {

			@Override
			public void run() {
				System.out.println("hello thread");
			}
			}).start(); 
	}
}*/


// --------------- 일반 메서드 ---------------------
/*class MyThread implements Runnable {

	@Override
	public void run() {
		System.out.println("Run! Hello Thread");
	}

}


public class LambdaEx2 {
	public static void main(String[] args) {
		MyThread ob=new MyThread();
		Thread th=new Thread(ob);
		th.start();
		
		new Thread(new MyThread()).start();
	}
}*/
