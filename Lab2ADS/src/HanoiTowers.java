import java.util.Scanner;

public class HanoiTowers {

	public int n;
	public int[][] towers;
	static Scanner scan = new Scanner(System.in);

	public HanoiTowers(int n) { // CONSTRUCTOR
		this.n = n;
		towers = new int[n][];

		for (int i = 0; i < n; i++) {
			towers[i] = new int[3];

			for (int j = 0; j < 3; j++) {
				towers[i][j] = 0;
			}
		}

		for (int i = n - 1; i >= 0; i--) {
			towers[i][0] = i + 1; // adds the rings from n to 1
		}
	}

	// -----------------------------------SOLVE---------------------//

//									x			y		z
	public void solve(int n, char from, char inter, char to) {

		if (n == 1) {
			System.out.println("Disk 1 from " + from + " to " + to);
			updateTowers(n, from, to);
			display();
		} else {
			solve(n - 1, from, to, inter);
			System.out.println("Disk " + n + " from " + from + " to " + to);
			updateTowers(n, from, to);
			display();
			solve(n - 1, inter, from, to);
		}

		// -------------------------UPDATE TOWERS------------------------//

	}

	public void updateTowers(int n, char from, char to) {
		int topTo = topForTower(to); // Search disk on top to the tower to be moved
		int topFrom = topForTower(from); // Search disk on top from the tower gonna move
		towers[topTo][to - 88] = towers[topFrom + 1][from - 88]; // Change the number to the other tower
		towers[topFrom + 1][from - 88] = 0; // Equals the position left to 0
	}

	// -----------------------------UPDATE---------------------------//

	public void update(int n, char from, char to) {

		int topFrom = topForTower(from);
		int topTo = topForTower(to);

		if (topTo == n - 1) {
			towers[topTo][to - 88] = towers[topFrom + 1][from - 88];
			towers[topFrom + 1][from - 88] = 0;
		} else {

			if ((towers[topFrom + 1][from - 88] > towers[topTo + 1][to - 88])) {

				System.out.println("ERROR --> Number of "+from+" is greater than number of "+to+".");
					System.out.println("\t\t\t"+towers[topFrom + 1][from - 88]+" > "+towers[topTo + 1][to - 88]);
			} else {
				towers[topTo][to - 88] = towers[topFrom + 1][from - 88];
				towers[topFrom + 1][from - 88] = 0;
			}
		}
	}

	public int topForTower(char tower) { // Search the top number on the tower and return the position
		int i = n - 1;

		while (i >= 0 && towers[i][tower - 88] != 0) {
			i--;

		}
		return i;
	}

	// ---------------------------DISPLAY----------------------------//

	public void display() {
		System.out.println("\n Towers");

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < 3; j++) {
				System.out.print((towers[i][j]) + "\t"); // == 0 ? " " : towers[i][j]) condition to change the 0 per empty space

			}

			System.out.println();
		}

		for (int i = 0; i < 3; i++) {
			System.out.print((char) (i + 88) + "\t");
		}

		System.out.println();
	}

	// ----------------------MAIN---------------------------//

	public static void main(String[] args) {

		int bucle = 0;
		int op = 0;

		System.out.println("Introduce a number of rows for the Hanoi Towers: \n");
		int n = scan.nextInt(); // rows

		HanoiTowers hanoiTowers = new HanoiTowers(n); // Calls the constructor

		while (bucle != 1) {

			hanoiTowers.display(); // Show the status of the towers

			System.out.println("TOWER OPTIONS:\n");
			System.out.println("1.From X to Y.\t 2.From X to Z. \t 3.From Y to X.\n");
			System.out.println("4.From Y to Z. \t 5.From Z to X. \t 6.From Z to Y. \n");
			System.out.println("7.EXIT.\n");

			System.out.println("Choose an option:");
			op = scan.nextInt();
			System.out.println("\tChosen option --> " + op);

			switch (op) {
			case 1: // X -- Y
				hanoiTowers.update(n, 'X', 'Y');
				break;
			case 2: // X -- Z
				hanoiTowers.update(n, 'X', 'Z');
				break;
			case 3: // Y -- X
				hanoiTowers.update(n, 'Y', 'X');
				break;
			case 4: // Y -- Z
				hanoiTowers.update(n, 'Y', 'Z');
				break;
			case 5: // Z -- X
				hanoiTowers.update(n, 'Z', 'X');
				break;
			case 6: // Z -- Y
				hanoiTowers.update(n, 'Z', 'Y');
				break;
			case 7: // Exit
				bucle = 1;
				break;
			default:
			}

		}

//		
//		System.out.println("Chose the tower to take the first number: \n");
//		from = scan.next().charAt(0);  
//
//		System.out.println("Chose the tower to leave the number: \n");
//		to =  scan.next().charAt(0);
//		
//		
//		hanoiTowers.move(n,from, to); //Resuelve la torre
		// hanoiTowers.solve(n,from, 'Z', to); //Resuelve la torre

	}
}
