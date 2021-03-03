package bst;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

class node {
	int n;
	node left;
	node right;

	public node(int n, node left, node right) {
		super();
		this.n = n;
		this.left = left;
		this.right = right;
	}
}

class BinaryTree {
	node root;

	public void add(int n) {
		node New = new node(n, null, null);
		if (root == null) {
			root = New;
			return;
		}

		node cur = root;
		while (true) {
			if (New.n < cur.n) {
				if (cur.left == null) {
					cur.left = New;
					break;
				}
				cur = cur.left;
			} else {
				if (cur.right == null) {
					cur.right = New;
					break;
				}
				cur = cur.right;
			}
		}
	}

	public boolean search(int n) {
		node cur = root;
		while (cur != null) {
			if (cur.n == n)
				return true;
			else if (n < cur.n)
				cur = cur.left;
			else
				cur = cur.right;
		}
		return false;
	}

	public void inorder(node v) {
		if (v.left != null) {
			inorder(v.left);
		}
		System.out.println(v.n);
		if (v.right != null) {
			inorder(v.right);
		}
	}
}

public class BOJ_10815_NumberCard {
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("src/bst/bt_test.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		BinaryTree bt = new BinaryTree();

		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		while (st.hasMoreElements()) {
			bt.add(Integer.parseInt(st.nextToken()));
		}

		int M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		while (st.hasMoreTokens()) {
			if (bt.search(Integer.parseInt(st.nextToken())))
				sb.append(1);
			else
				sb.append(0);
			sb.append(" ");
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}
}
