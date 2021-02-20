package ssafy_0129.lambda;

/* [문제]간단한 계산기를 람다식으로 작성하시오
 * 
 * 1. 인터페이스명 : Calc
 *  +calc(a:int,b:int):double
 *    
 * 2. LambdaEx6에서 
 *    Calc객체변수를 만들고 2,5값을 가지고 더하기/빼기/곱하기/나누기를 완성하시오
 *    
 * [실행결과]
 * 7
 * -3
 * 10
 * 0.4   
 */

@FunctionalInterface
interface Calc{
	public double calc(int a, int b);
}


public class LambdaEx5 {
	public static void main(String[] args) {
		Calc c1=(a, b)->(a+b);
		System.out.println((int)c1.calc(2, 5));
		Calc c2=(a, b)->(a-b);
		System.out.println((int)c2.calc(2, 5));
		Calc c3=(a, b)->(a*b);
		System.out.println((int)c3.calc(2, 5));
		Calc c4=(a, b)->(double)a/b;
		System.out.println(c4.calc(2, 5));
		
	}
}
//----------------------------------------------------
/*
interface Calc{
	public double add(int a, int b);
	public double sub(int a, int b);
	public double multi(int a, int b);
	public double divi(int a, int b);	
}
public class LambdaEx6 implements Calc{
	@Override
	public double add(int a, int b) {
		return a+b;
	}

	@Override
	public double sub(int a, int b) {
		return a-b;
	}

	@Override
	public double multi(int a, int b) {
		return a*b;
	}

	@Override
	public double divi(int a, int b) {
		return (double)a/b;
	}
	
	public static void main(String[] args) {
		LambdaEx6 ob=new LambdaEx6();
		System.out.println((int)ob.add(2,5));
		System.out.println((int)ob.sub(2,5));
		System.out.println((int)ob.multi(2,5));
		System.out.println(ob.divi(2,5));
	}
}
*/
