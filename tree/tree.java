import java.util.LinkedList;

public class tree {
	public static class Node {
		int data = 0;
		Node left = null;
		Node right = null;

		Node(int data, Node left, Node right) {
			this.data = data;
			this.left = left;
			this.right = right;
		}
	}

	public static void main(String[] args) {
		int[] arr = { 10, 20, 30, -1, -1, 40, -1, -1, 50, 60, 80, -1, -1, -1, 70, 90, -1, 100, -1, -1, -1 };
		Node root = create(arr);
		// display(root);

		solve(root);
	}

	static int idx = 0;

	public static Node create(int[] arr) {
		if (idx == arr.length || arr[idx] == -1) {
			idx++;
			return null;
		}
		Node nnode = new Node(arr[idx], null, null);
		idx++;
		nnode.left = create(arr);
		nnode.right = create(arr);
		return nnode;
	}

	public static void solve(Node root) {
		iterativePostOrder(root);
	}

	public static void iterativePostOrder(Node root) {
		LinkedList<Node> processStack = new LinkedList<>();
		LinkedList<Integer> resultStack = new LinkedList<>();
		if (root == null)
			System.out.println(-1);
		processStack.addLast(root);
		while (!processStack.isEmpty()) {
			Node removedEl = processStack.removeLast();

			if (removedEl != null) {
				resultStack.addLast(removedEl.data);
				processStack.addLast(removedEl.left);
				processStack.addLast(removedEl.right);
			}
		}

		while (!resultStack.isEmpty()) {
			int removedEl = resultStack.removeLast();
			System.out.println(removedEl + " ");
		}
	}
}