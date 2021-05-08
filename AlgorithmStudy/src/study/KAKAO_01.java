package study;
import java.util.HashMap;

class KAKAO_01{
    public static int solution(String s) {
		StringBuilder sb = new StringBuilder();
		HashMap<String, int[]> map = new HashMap<>();
		// 앞 두자리 - 길이, 원래 숫자
		map.put("ze", new int[] { 4, 0 });
		map.put("on", new int[] { 3, 1 });
		map.put("tw", new int[] { 3, 2 });
		map.put("th", new int[] { 5, 3 });
		map.put("fo", new int[] { 4, 4 });
		map.put("fi", new int[] { 4, 5 });
		map.put("si", new int[] { 3, 6 });
		map.put("se", new int[] { 5, 7 });
		map.put("ei", new int[] { 5, 8 });
		map.put("ni", new int[] { 4, 9 });

		int len = s.length();

		int i = 0;
		while (i < len) {
			if (s.charAt(i) - '0' >= 0 && s.charAt(i) - '0' < 10) {
				sb.append(s.charAt(i));
				i++;
			} else {
				String prefix = String.valueOf(s.charAt(i)) + String.valueOf(s.charAt(i + 1));
				sb.append(map.get(prefix)[1]);
				i += map.get(prefix)[0];
			}
		}
		return Integer.valueOf(sb.toString());
    }
    
    public static void main(String[] args) {
		System.out.println(solution("1zerotwozero3"));
	}
}