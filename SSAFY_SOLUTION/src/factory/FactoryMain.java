package factory;

public class FactoryMain {
	public static void main(String[] args) {
		Factory factory=new Factory();
		Buyer buyer=new Buyer(factory);
		Worker worker=new Worker(factory);
		
		buyer.start();
		worker.start();
	}
}
/*
Thread간의 조정
두개의 스레드가 데이터를 주고 받는 경우에 발생하는데
이를 해결하기 위해 스레드에서 wait() / notify() 를 이용한다.

wait() : 스레드를 일시정지 시켜 대기 상태로 만든다.
notify() : 스레드를 깨워 다시 실행시킨다.
notifyAll() : 모든 스레드를 깨워 다시 실행시킨다. 

다중쓰레드를 사용할 경우 nofity() 를 사용하면 어떤 쓰레드가 깨어날지 알 수 없기 때문에
우선순위가 높은 쓰레드가 계속 wait 상태로   머무를 수 있다.
그렇기 때문에 notifyAll();을 통해 JVM이 쓰레드의 우선 순위에 따라 처리하게 하는 것이 좋다.
*/