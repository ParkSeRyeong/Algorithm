package tree;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Node {
	int data;
	Node left;
	Node right;

	public Node() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Node(int data) {
		super();
		this.data = data;
		left = null;
		right = null;
	}

	public Node(int data, Node left, Node right) {
		super();
		this.data = data;
		this.left = left;
		this.right = right;
	}

}

class BinaryTree {
	Node root = null;

	public void addNewNode(int data) {
		Node NewNode = new Node(data, null, null);
		if (root == null) {
			root = NewNode;
			return;
		}
	}

	public void addLeft(int data) {
		Node NewNode = new Node(data, null, null);
		if (root == null) {
			root = NewNode;
			return;
		}
		Node cur = root;
		while (cur.left != null) {
			cur = cur.left;
		}
		cur.left = NewNode;
	}

	public void addRight(int data) {
		Node NewNode = new Node(data, null, null);
		if (root == null) {
			root = NewNode;
			return;
		}
		Node cur = root;
		while (cur.right != null) {
			cur = cur.right;
		}
		cur.right = NewNode;
	}

}

public class BOJ_4256_Tree {
	static int[] Pre = { 3, 6, 5, 4, 8, 7, 1, 2 };
	static int[] In = { 5, 6, 8, 4, 3, 1, 2, 7 };
	static BinaryTree bt = new BinaryTree();

	static ArrayList<Integer> pre = new ArrayList<>();
	static ArrayList<Integer> in = new ArrayList<>();

	static ArrayList<Integer> left = new ArrayList<>();
	static ArrayList<Integer> right = new ArrayList<>();

	public static void left(List<Integer> list, int start, int end) {
		
	}

	public static void right(int index, int start, int end) {

	}

	public static void main(String[] args) {

		pre.add(3);
		pre.add(6);
		pre.add(5);
		pre.add(4);
		pre.add(8);
		pre.add(7);
		pre.add(1);
		pre.add(2);

		in.add(5);
		in.add(6);
		in.add(8);
		in.add(4);
		in.add(3);
		in.add(1);
		in.add(2);
		in.add(7);

		bt.root = new Node(Pre[0]);

		List<Integer> list1 = in.subList(0, in.indexOf(pre.get(0)));
		List<Integer> list2 = in.subList(in.indexOf(pre.get(0)) + 1, 8);
		for (int i : list1) {
			System.out.print(i + " ");
		}

	}
}
