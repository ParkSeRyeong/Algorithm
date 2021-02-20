package ssafy_0127.tv1;

public class SamsungTv implements Tv{
	public void powerOn(){
		System.out.println("SamSung TV-전원을 켠다");
	}
	public void powerOff(){
		System.out.println("SamSung TV-전원을 끈다");
	}
	@Override
	public void soundUp() {
		System.out.println("SamSung TV-소리 업");
	}
	@Override
	public void soundDown() {
		System.out.println("SamSung TV-소리 다운");
	}
}
