package linkedlist;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class BOJ_7785_RemainPeople {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		// 와 바로 역순 가능가능 
		TreeMap<String, String> map = new TreeMap<>(Comparator.reverseOrder());

		int N = Integer.parseInt(br.readLine());
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String name = st.nextToken();
			String status = st.nextToken();
			if (!map.containsKey(name)) {
				map.put(name, status);
			} else {
				map.remove(name);
			}
		}

		//Set<String> keyset = map.keySet();

		//Iterator<String> iter = map.descendingKeySet().iterator();
		Iterator<String> iter = map.keySet().iterator();

		while(iter.hasNext()) {
			bw.write(String.valueOf(iter.next()));
			bw.write("\n");
		}

		bw.flush();
		bw.close();
		br.close();
	}
}
