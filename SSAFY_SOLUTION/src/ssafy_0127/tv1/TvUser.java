package ssafy_0127.tv1;

public class TvUser {
	public static void main(String[] args) {
		String in=args[0];       // lg or samsung
		Tv tv=null;
		
		if(in.equals("lg")) {
			tv=new LgTv();
			}else if(in.equals("samsung")) {
				tv=new SamsungTv();
		}else {
			System.out.println("error");
		}	
		
		tv.powerOn();
		tv.powerOff();
		tv.soundUp();
		tv.soundDown();
	}
}
