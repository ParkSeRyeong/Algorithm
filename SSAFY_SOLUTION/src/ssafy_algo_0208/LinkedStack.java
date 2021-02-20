package ssafy_algo_0208;

/*
[결과 화면]
### push ###
### peek ###
6
### pop ###
6
5
4
*/
class Node {
	String data;
	Node link;

	public Node() {
	}

	public Node(String data) {
		super();
		this.data = data;
	}

	public Node(String data, Node link) {
		super();
		this.data = data;
		this.link = link;
	}

}

public class LinkedStack {

	static Node head = null;

	public void push(String s) {

		Node newNode = new Node(s, null);

		if (head == null) {
			head = newNode;
			return;
		}

		Node cur = head;
//		cur.link = newNode;
//		head = newNode;

		while (cur != null) {
			if (cur.link == null) {
				cur.link = newNode;
				return;
			}
			cur = cur.link;
		}

	}

	public String peek() {
		Node cur = head;
		while (cur.link != null) {
			cur = cur.link;
		}
		return cur.data;
	}

	public String pop() {
		Node cur = head;
		Node prev = head;
		while (cur.link != null) {
			prev = cur;
			cur = cur.link;
		}
		prev.link = null;
		return cur.data;
	}

	public void show() {
		Node cur = head;
		while (cur != null) {
			System.out.print(cur.data + " ");
			cur = cur.link;
		}
		System.out.println();
	}

	public static void main(String[] args) {
		LinkedStack listStack = new LinkedStack();

		System.out.println("### push ###");
		listStack.push("1");
		listStack.push("2");
		listStack.push("3");
		listStack.push("4");
		listStack.push("5");
		listStack.push("6");
		System.out.println("### show ###");
		listStack.show();
		System.out.println("### peek ###");
		System.out.println(listStack.peek());

		System.out.println("### pop ###");
		System.out.println(listStack.pop());
		System.out.println(listStack.pop());
		System.out.println(listStack.pop());
		System.out.println("### show ###");
		listStack.show();
	}
}
