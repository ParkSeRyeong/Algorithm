package ssafy_algo_0221;

import java.util.Arrays;
import java.util.Comparator;

class ABC {
	String name;
	int score;

	public ABC(String name, int score) {
		super();
		this.name = name;
		this.score = score;
	}
	
	

}

public class Exam05 {
	public static void main(String[] args) {
		ABC[] arr = new ABC[3];
		arr[0] = new ABC("Dalex", 80);
		arr[1] = new ABC("Berom", 90);
		arr[2] = new ABC("Cate", 80);

		Arrays.sort(arr, new Comparator<ABC>() {
			public int compare(ABC a, ABC b) {
				if (a.score == b.score) {
					return a.name.compareTo(b.name);
				}
				return b.score - a.score;
			}
		});

		for (ABC a : arr) {
			System.out.println(a.name + " " + a.score);
		}
	}
}
