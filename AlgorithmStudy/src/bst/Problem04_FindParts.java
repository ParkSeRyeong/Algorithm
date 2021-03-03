//package bst;
//
//import java.io.BufferedReader;
//import java.io.FileInputStream;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.Arrays;
//
//// 노드 자체! 데이터 / left / right 있음.
//class Node {
//	private int data;
//	private Node left;
//	private Node right;
//
//	/** 노드가 생성될 때 기본으로 left, right 초기화 */
//	public Node(int data) {
//		this.data = data;
//		this.left = null;
//		this.right = null;
//	}
//
//	public int getData() {
//		return data;
//	}
//
//	public void setData(int data) {
//		this.data = data;
//	}
//
//	public Node getLeft() {
//		return left;
//	}
//
//	public void setLeft(Node left) {
//		this.left = left;
//	}
//
//	public Node getRight() {
//		return right;
//	}
//
//	public void setRight(Node right) {
//		this.right = right;
//	}
//
//}
//
//class Bst {
//	public Node root;
//
//	/** 생성자 : Bst 클래스가 생성될 때, 루트를 null로 초기화 */
//	public Bst() {
//		this.root = null;
//	}
//
//	/** 1. 노드를 트리에 삽입 : void */
//	public void insert(int key) {
//		Node New = new Node(key);
//
//		// 1. 루트에 아무 것도 없다면 : 루트에 그냥 새 노드 넣기
//		if (root == null) {
//			root = New;
//			return;
//		}
//
//		Node cur = root;
//		Node parent = null;
//
//		while (true) {
//			// cur은 left든 right든 내려갈거라, parent에 현재 위치인 cur 저장
//			parent = cur;
//			// 작으면 left로 내려가되, 내려갈 수 없으면 -> parent의 left로 넣기!
//			// 없으면 더 내려가면 안 되니까 !!!!리턴 필수!!!!
//			if (key < cur.getData()) {
//				cur = cur.getLeft();
//				if (cur == null) {
//					parent.setLeft(New);
//					return;
//				}
//			}
//
//			// 크면 right로 내려가되, 내려갈 수 없으면 -> parent의 right로 넣기!
//			else {
//				cur = cur.getRight();
//				if (cur == null) {
//					parent.setRight(New);
//					return;
//				}
//			}
//		}
//	}
//
//	/** 2. 트리에서 노드를 검색 : true, false 반환 */
//	public boolean find(int key) {
//		Node cur = root;
//
//		// 더 이상 내려갈 노드가 없을 때 까지
//		while (cur != null) {
//
//			// 1. 앗 찾았당
//			if (cur.getData() == key) {
//				return true;
//			}
//
//			// 2. 찾는 값 < 현재 값 : left로 내려가자
//			else if (key < cur.getData()) {
//				cur = cur.getLeft();
//			}
//
//			// 3. 찾는 값 > 현재 값 : right로 내려가자
//			else {
//				cur = cur.getRight();
//			}
//		}
//
//		// 4. 아 없엉
//		return false;
//	}
//
//	/** 3. 전위순회해서 값 보여줌 */
//	public void display(Node root) {
//		if (root != null) {
//			display(root.getLeft());
//			System.out.println(" " + root.getData());
//			display(root.getRight());
//		}
//	}
//
//	public boolean delete(int key) {
//		Node parent = root;
//		Node cur = root;
//		boolean isLeftChild = false;
//
//		// key : 내가 지워야 할 노드
//		// cur : 노드를 찾아내면 이 cur이 지워야할 노드가 됨.
//		// isLeftChild : cur이 부모의 left 노드면 true, right 노드면 false
//
//		// key를 가진 노드를 찾아낼 때까지 반복
//		// cur이 더 이상 못 찾으면, 아 지울 노드 없나보다 = false 반환
//		while (cur.getData() != key) {
//
//			parent = cur;
//			if (cur.getData() > key) {
//				isLeftChild = true;
//				cur = cur.getLeft();
//			} else {
//				isLeftChild = false;
//				cur = cur.getRight();
//			}
//			if (cur == null) {
//				return false;
//			}
//		}
//
//		/** 이제 지워야할 노드 cur과 그 부모 parent를 찾은 상태. */
//		// ----------------------------------------------------------------
//		// Case 1. 자식 노드가 없는 경우 : 최상의 상태
//		if (cur.getLeft() == null && cur.getRight() == null) {
//			// 1-1. cur가 root라면?
//			if (cur == root) {
//				root = null;
//			}
//			// 여기 원 코드랑 다르니까 혹시 에러나면 여기 고치기.
//			// 1-2. 지우려는 노드가 부모의 left 노드였으면 -> 부모의 left를 null로 해주기
//			else if (isLeftChild == true) {
//				parent.setLeft(null);
//			}
//			// 1-3. 지우려는 노드가 부모의 right 노드였으면 -> 부모의 right를 null로 해주기
//			else {
//				parent.setRight(null);
//			}
//		}
//		// ----------------------------------------------------------------
//		// Case 2. 자식 노드가 하나 있는 경우 : left든 right든 하나만
//		// 2-1. left자식만 있을 때 :
//		else if (cur.getRight() == null) {
//			if (cur == root) {
//				root = cur.getLeft();
//			} else if (isLeftChild) {
//				parent.setLeft(cur.getLeft());
//			} else {
//				parent.setRight(cur.getLeft());
//			}
//		} else if (cur.getLeft() == null) {
//			if (cur == root) {
//				root = cur.getRight();
//			} else if (isLeftChild) {
//				parent.setLeft(cur.getRight());
//			} else {
//				parent.setRight(cur.getRight());
//			}
//		}
//		// ----------------------------------------------------------------
//		// Case 3. 자식 노드가 둘 다 있는 경우 : 으악
//		else {
//			// replace : 지울 노드를 대체할 오른족 서브트리의 최소값
//			Node replace = getReplace(cur);
//			if (cur == root) {
//				root = replace;
//			} else if (isLeftChild) {
//				parent.setLeft(replace);
//			} else {
//				parent.setRight(replace);
//			}
//			replace.setLeft(cur.getLeft());
//		}
//
//		return true;
//	}
//
//	/** 지울 때 오른쪽 서브트리의 최소값 가져올 메서드. */
//	public Node getReplace(Node deleteNode) {
//		Node replace = null;
//		Node replaceParent = null;
//		// 일단 지울 노드의 오른쪽으로 가서 -> 거기서부터 계속 left로만 내려갈 거니까
//		Node cur = deleteNode.getRight();
//
//		while (cur != null) {
//			replaceParent = replace;
//			replace = cur;
//			cur = cur.getLeft();
//		}
//
//		// 지울 노드에서 오른쪽으로 내려가자마자 걔가 replace가 아닌 이상!
//		// 지울 노드 바로 right노드면, 차피 replace가 이미 right노드라 걍 반환해줘도 됨.
//		if (replace != deleteNode.getRight()) {
//			replaceParent.setLeft(null);
//			replace.setRight(deleteNode.getRight());
//		}
//		return replace;
//	}
//}
//
//public class Problem04_FindParts {
//
//	static int[] arr;
//
//	static int N;
//	static int M;
//
//	public static void main(String[] args) throws NumberFormatException, IOException {
//		System.setIn(new FileInputStream("src/bst/bst_tc.txt"));
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//
//		/** 1. 전체 부품 개수 N */
//		N = Integer.parseInt(br.readLine());
//
//		/** 2. 부품 요소 입력 받기 */
//		String str = br.readLine();
//		arr = Arrays.stream(str.split(" ")).mapToInt(Integer::parseInt).toArray();
//
//		Bst b = new Bst();
//		for (int i = 0; i < arr.length; i++) {
//			b.insert(arr[i]);
//		}
//
//		/** 3. 손님이 찾는 부품 개수 */
//		M = Integer.parseInt(br.readLine());
//		String[] tmp = br.readLine().split(" ");
//
//		boolean flag = true;
//		for (int i = 0; i < M; i++) {
//			if (!b.find(Integer.parseInt(tmp[i]))) {
//				flag = false;
//				break;
//			}
//			/* 이건 bst안 쓰고 걍 가능 */
////			if(!str.contains(tmp[i])) {
////				flag=false;
////			}
//		}
//		System.out.println(flag == true ? "yes" : "no");
//
//	}
//}
