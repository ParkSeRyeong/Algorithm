package ssafy_0122;

// 싱글톤
public class Speaker2 {
	// static으로 선언 --> speaker는 method 영역에 있겠지?
	private static Speaker2 speaker;
	private int volume;

	public Speaker2() {
		volume = 5;
	}

	public static Speaker2 getInstance() {
		if(speaker==null) {
			speaker=new Speaker2();
		}
		return speaker;
	}

	public int getVolume() {
		return volume;
	}

	public void setVolume(int volume) {
		this.volume = volume;
	}

	/*
	 * @Override public String toString() { return "볼륨:" + volume; }
	 */

}
