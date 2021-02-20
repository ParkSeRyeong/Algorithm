package ssafy_0118;

public class DigitTest2 {
	public static void main(String[] args) {

		int blank = 0;
		boolean isIncrease = true;
		int no = 1;
		
		while(no<=31) {
			for(int i=0;i<blank;i++) {
				System.out.printf("%3s", " ");
			}
			for (int i = 0; i < 7-(2*blank); i++) {
				System.out.printf("%3d", no++);
			}
			System.out.println();
			
			if(isIncrease) {
				++blank;
			}else {
				--blank;
			}
			if(blank==3) {
				isIncrease=false;
			}
		}
		
	}
}
