package factory;

public class Worker extends Thread {
	private Factory factory;

	public Worker(Factory factory) {
		super();
		this.factory = factory;
	}

	@Override
	public void run() {   // 생산 작업
		for(int i=1; i<=500; i++) {
			factory.produce();
		}
	}
}
