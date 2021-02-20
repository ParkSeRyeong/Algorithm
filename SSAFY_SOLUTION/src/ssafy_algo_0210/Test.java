package ssafy_algo_0210;
public class Test {
	public static void main(String[] args) {
		int sum=0, odd=0, even=0;
		
		for(int i=1; i<=100; i++) {
			sum += i;
			switch(i%2) {
				case 0: even += i; break;
				case 1: odd += i; break;
			}
		}
		System.out.println("전체합:" + sum);
		System.out.println("홀수합:" + odd);
		System.out.println("짝수합:" + even);
	}
}
