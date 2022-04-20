
import java.util.Scanner;

public class Estrcuturas {

	static Scanner scan = new Scanner(System.in);
	static int op;
	static Arbol.Node aux = new Arbol.Node(0);

	public static void main(String[] args) {

		Arbol arbol = new Arbol();

		int b = 0;
		int key = 0;

		while (b != 1) {
			System.out.println("TREE OPTIONS");
			System.out.println("1.Insert \t 2. Order 3.S/P");
			System.out.println("4.Search \t 5. Order 6.Exit");
			System.out.println("Chose an option:");
			op = scan.nextInt();

			switch (op) {
			case 1: // INSERT VALUE
				System.out.println("Numero to add al Tree: ");
				key = scan.nextInt();
				arbol.insert(key);
				break;
			case 2: // ODER PRINT OF KEYS
				arbol.recorrer(arbol.root);
				break;

			case 3: // SUCCESSORS AND PREDECESSORS
				System.out.println("Enter Node to search relatives:");
				int sp = scan.nextInt();
				aux = Arbol.search_iterative(sp, arbol.root);
				arbol.relatives(aux);
				break;
			case 4: // SEARCH
				System.out.println("Enter Node to search in the Tree:");
				int k = scan.nextInt();
				aux = Arbol.search_iterative(k, arbol.root);
				if (aux == null) {
					System.out.println("Node Not Found.");
				} else {
					System.out.println("Node found =" + aux.key);
				}
				break;
			case 5: // Exit
				b = 1;
				break;
			default:
			}

		}

	}

}
