import java.util.Scanner;



public class BinaryTree {
	static Scanner scan = new Scanner(System.in);
	static int op;
	
	
	private static Node root;	
	
	private static class Node{

		private int  key;
		private Node parent;
		private Node left;
		private Node right;
			

		public Node(int  key)
		{
			this.key =  key;
			this.parent = null;
			this.left = null;
			this.right = null;
		}
	}
	
	public static void createBinaryTree() {
		Node a = new Node(2);
		Node b = new Node(3);
		Node c = new Node(4);
		Node d = new Node(5);
		Node e = new Node(6);
		Node f = new Node(7);
		Node g = new Node(8);
		
		root = a;		// second <----- first -----> third
		
		a.left = b;
		a.right = c; 
		
		b.parent = a;
		b.left = d;
		b.right = e;
		
		d.parent = b;
		e.parent = b;
		
		c.parent = a;
		c.left = f;
		c.right = g;
		
		f.parent = c;
		g.parent = c;
	}




	public static void main(String[] args) {
		
		int num, bucle;
		bucle = 0;
		
		createBinaryTree();

		while (bucle != 1) {
			
			System.out.println("\t\tLINKED LIST OPTIONS:\n");
			
			System.out.println("1.INSERT VALUE . \t 2.ORDERED PRINT OF KEYS.\t 3.PRINT OF CONNECTIONS.\n");
			System.out.println("\t4.SEARCH. \t  \t 5.PRINT MIN/MAX.\n");
			System.out.println("\t6.PRINT SUCCESSOR AND PREDECESSOR.\t 7.REMOVE A NODE.\n");
			System.out.println("8.EXIT.\n");

			System.out.println("Choose an option:");
			op = scan.nextInt();
			System.out.println("\tChosen option --> " + op);

			switch (op) {
			case 1: // INSERT VALUE
				System.out.println("Type the number to insert in the Node: \n");
				num = scan.nextInt();
				insert(num,root);
				System.out.println("\t Number inserted in node: "+root.key+"--> " + num);
				break;
			case 2: //  ORDERED PRINT OF KEYS
				ordered(root);
				System.out.println("Type the number to insert into the HEAD: \n");

				break;
			case 3: // PRINT OF CONNECTIONS
				System.out.println("Type the number to insert: \n");
				num = scan.nextInt();
				System.out.println("\t Number inserted --> " + num);
				System.out.println("Type the number where" +num+ "will be inserted after: \n");
				// position
				break;
			case 4: //SEARCH
				System.out.println("Type the number to SEARCH in the Tree: \n");
				num = scan.nextInt();
				Node x = search(num,root);
				System.out.println("Parent node: &i "+x.parent);
				System.out.println("Sucessors left node: %d "+x.left);
				System.out.println("Sucessor right node: %r "+x.right);

				break;
			case 5: // PRINT MIN/MAX
				int min = 0; int max = 0;
				System.out.println("root.key:" +root.key+ " left key: "+root.left.key);
				while(root.key<root.left.key) {
					System.out.println("     root.key:" +root.key+ "min =  "+min+ "left key: "+root.left.key);
					min = minimum(root);
					System.out.println("           root.key:" +root.key+ "min =  "+min+  " left key: "+root.left.key);
				}
				while(root.key>root.right.key) {
					max = maximum(root);
				}
					System.out.println("Min: "+min+"\n Max: "+max);
				break;
			case 6: // PRINT SUCCESSOR AND PREDECESSOR
				break;
			case 7: // REMOVE A NODE
				break;
			case 8: // Exit
				bucle = 1;
				break;
			default:
			}

		}
		scan.close();

}
	
	
	// ------------------------------- 1. INSERT KEY ----------------------------
		
	public static void insert(int k, Node root) {

			if(root == null) {
				root = new Node(k);
			}
			if(root.key>k) {
				if(root.left == null) {
					root.left = new Node(k);
					
				}
			
				insert(k,root.left);
			}
			if(root.key<k) {
				if(root.right == null) {
					root.right = new Node(k);
				}
				insert(k,root.right);			}
			
	}
	
	//-------------------------------- 2.ORDERED TREE ---------------------------
	
	public static void ordered( Node root) {
		if(root == null) {
			System.out.println("Empty tree for order.");
		}
		
		if(root != null) {
			ordered(root.left);
			System.out.println("Indice: " +root.key);
			ordered(root.right);
		}
		
	}
	
	
	
	//--------------------------------- 4. SEARCH ---------------------------------
	
	public static Node search_recursive( int k,Node root) {
		if(root == null) {
			System.out.println("The tree is empty");
			System.out.println("Search couldn't be found");
		}
		
		Node current = root;
		
		if(current.key == k) {
			return current;
		}
		if(current.key>k) {
			return search_recursive(k,current.left);
		}
	
		if(current.key<k) {
			return search_recursive(k, current.right);
		}
		
		return current;
	}
	
	
	
	
	//--------------------------------- 5. MIN/MAX --------------------------------
	
	public static int minimum( Node x) {
		int min = x.key;
		System.out.println("x.key: "+x.key+" min: "+min+ "left key:"+x.left.key);
		while(x.left.key>x.key) {

			System.out.println("x.key: "+x.key+" min: "+min+ "left key:"+x.left.key);
			
			x.left = x;
			x = x.left;
			
			System.out.println("x.key: "+x.key+" min: "+min+ "left key:"+x.left.key);
		}
		
		return min;
	}
	public static int maximum( Node x) {
		int max = x.key;
		
		while(x.right.key>x.key) {
			
			max = x.right.key;
			x = x.right;
		}
		
		return max;
	}
	
	
	// ----------------------------- 7. PRINT ------------------------------
	
	public static Node printTree( Node x) {
		
		while(x.key < x.left.key) { //otra condicion
			x.left = x;
			
			}
		if(x.key > x.left) {
			System.out.println(""+x.key);
		}
	}
}
