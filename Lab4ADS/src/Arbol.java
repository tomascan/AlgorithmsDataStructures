
public class Arbol {

	Node root;

	public Arbol() {
		root = null;
	}

	public void insert(int k) {
		Node n = new Node(k);

		if (root == null) {
			root = n;
		} else {
			Node aux = root;
			while (aux != null) {
				n.parent = aux;
				if (n.key >= aux.key) {
					aux = aux.right;

				} else {
					aux = aux.left;
				}
			}

			if (n.key < n.parent.key) {
				n.parent.left = n;
			} else {
				n.parent.right = n;
			}
		}

	}
	
	
	public void recorrer(Node n) {
		if(n != null) {
			recorrer(n.left);
			System.out.println("Indice"+n.key);
			recorrer(n.right);
		}
	}
	
	
	public void relatives(Node n) {
		
		if (n == null) {
			System.out.println("Node Not Found.");
		} else {
			System.out.println("Node found =" + n.key);
			if (n.parent == null) {
				System.out.println("The node is the root");
			} else {
				System.out.println("Parent Node of "+n.key+": "+n.parent.key);
			}
			if (n.left == null) {
				System.out.println("The node does not have children.");
			} else {
				System.out.println("Left Node of "+n.key+": "+n.left.key);
			}
			if (n.right == null) {
				System.out.println("The node doesnt have children");
			} else {
				System.out.println("Right Node of "+n.key+": "+n.right.key);
			}
		}
	}
	
	
	public static Node search_iterative(int key, Node n) {
		while(n != null) {
			if(key == n.key) {
				return n;
			}
			if(key < n.key) {
				n = n.left;
			}else {
				n = n.right;
			}
		}
		return n;
		
	}

	static class Node {

		public Node parent;
		public Node right;
		public Node left;
		public int key;

		public Node(int key) {
			this.key = key;
			parent = null;
			right = null;
			left = null;
		}
	}

}
