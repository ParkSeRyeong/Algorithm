package linkedlist;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Node {
	public int data;
	public int index;
	public Node link;

	public Node() {
	}

	public Node(int data) {
		super();
		this.data = data;
	}

	public Node(int data, int index) {
		super();
		this.data = data;
		this.index = index;
	}

	public Node(int data, int index, Node link) {
		super();
		this.data = data;
		this.index = index;
		this.link = link;
	}

}

class SLL {
	Node head = null;
	Node tail = null;

	public void add(int data, int index) {
		Node newNode = new Node(data, index);
		if (head == null) {
			head = newNode;
			return;
		}
		Node cur = head;
		while (cur.link != null) {
			cur = cur.link;
		}
		cur.link = newNode;
		tail = newNode;
	}

	public Node find(int index) {
		if (head == null) {
			return null;
		}
		Node cur = head;
		while (cur != null) {
			if (cur.index == index) {
				return cur;
			}
			cur = cur.link;
		}
		return null;
	}
}

public class BOJ_17827_SnailList {
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("src/linkedlist/snail_test.txt"));
		long start = System.currentTimeMillis();
		// --------------------------------------------------------------------------
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());

		int nodeNum = Integer.parseInt(st.nextToken());
		int question = Integer.parseInt(st.nextToken());
		int v = Integer.parseInt(st.nextToken());

		SLL sll = new SLL();

		int[] data = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

		// --------------------------------------------------------------------------
		for (int i = 0; i < nodeNum; i++) {
			sll.add(data[i], i + 1);
		}
		sll.tail.link = sll.find(v);

		for (int i = 0; i < question; i++) {
			int n = Integer.parseInt(br.readLine());
			Node cur = sll.head;

			if (n <= nodeNum) {
				for (int j = 0; j < n; j++) {
					cur = cur.link;
				}
			} else {
				int cycle = nodeNum - (v - 1);
				for (int j = 1; j < v; j++) {
					cur = cur.link;
				}
				for (int j = 0; j < (n - 2) % cycle; j++) {
					cur = cur.link;
				}
			}
			sb.append(cur.data).append("\n");
		}
		sb.setLength(sb.length() - 1);
		System.out.println(sb);
		long end = System.currentTimeMillis();
		System.out.println("---------------\n실행 시간 : " + (end - start) / 1000.0);
	}
}
