package ssafy_algo_0209;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Node {
	int data;
	Node next;

	public Node() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Node(int data) {
		super();
		this.data = data;
	}
}

class Circle {
	Node head = null;
	Node tail = null;

	public void add(int data) {
		Node New = new Node(data);
		New.next = null;

		if (head == null) {
			head = New;
			return;
		}
		Node cur = head;
		while (cur.next != null) {
			cur = cur.next;
		}
		cur.next = New;
		tail = New;
	}

	public void remove(Node Node) {
		if (head == null)
			return;

		Node cur = head;
		Node prev = cur;
		while (cur.next != null) {
			if (cur == Node)
				break;
			prev = cur;
			cur = cur.next;
		}
		prev.next = cur.next;
		cur = null;
	}
}

public class BOJ_1158_Yosepus {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		Circle circle = new Circle();
		for (int i = 1; i < N + 1; i++) {
			circle.add(i);
		}
		circle.tail.next = circle.head;

		Node cur = circle.head;
		Node next = cur;

		while(cur.next!=null) {
			cur=next;
			for(int i=0;i<K-1;i++) {
				cur=cur.next;
			}
			next=cur.next;
			circle.remove(cur);
		}
	}

}
