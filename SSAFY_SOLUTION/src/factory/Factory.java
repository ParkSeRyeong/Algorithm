package factory;

public class Factory {
	private int product=0;
	
	public synchronized void produce() {  //생산
		if(product > 4) {
			try {
				System.out.println("생산 중단:" + product);
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}			
		} // end if
		product++;
		System.out.println("생산:" + product);
		try {
			Thread.sleep(300);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		notify();   // or notifyAll();
	}
	//---------------------------------------------------------
	public synchronized void sell() {   // 소비
		if(product < 1) {
			try {
				System.out.println("소비 중단:" + product);
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}// end if
		product--;
		System.out.println("소비:" + product);
		try {
			Thread.sleep(300);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		notify();   // or notifyAll();
	}
}






