import java.util.Scanner;


public class autoHanoi {
	
	public int n;
	public int[][] towers;
	static Scanner scan = new Scanner(System.in);
	
	public autoHanoi(int n) { //CONSTRUCTOR
		this.n = n;
		towers = new int[n][];

		for (int i = 0; i < n; i++) {
			towers[i] = new int[3];

			for (int j = 0; j < 3; j++) {
				towers[i][j] = 0;
			}
		}

		for (int i = n - 1; i >= 0; i--) {
		    towers[i][0] = i + 1; //adds the rings from n to 1 
		}
	}
	
	
	//-----------------------------------SOLVE---------------------//
	
//									x			y		z
	public void solve(int n, char from, char inter, char to) { 

		if (n == 1) {
			System.out.println("Disk 1 from " + from + " to " + to);
			updateTowers(n,from,to);
			display();
		} else {
			solve(n - 1, from, to, inter);
			System.out.println("Disk " + n + " from " + from + " to " + to);
			updateTowers(n,from,to);
			display();
			solve(n - 1, inter, from, to);
		}


	}
	
	public void updateTowers(int n, char from, char to) {
		int topForTo = topForTower(to);
		int topForFrom = topForTower(from);
		towers[topForTo][to - 88] = towers[topForFrom + 1][from - 88];
		towers[topForFrom + 1][from - 88] = 0;
	}
	
	public int topForTower(char tower) {
		int i = n - 1;

		while (i >= 0 && towers[i][tower - 88] != 0) {
			i--;
		}
		return i;
	}


	
	
	
	//---------------------------DISPLAY----------------------------//

	public void display() {
		System.out.println("\n Towers");

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < 3; j++) {
				System.out.print((towers[i][j]
						== 0 ? " " : towers[i][j]) + "\t");		// == 0 ? " " : towers[i][j]) condition to change the 0 per empty space 

			}

			System.out.println();
		}

		for (int i = 0; i < 3; i++) {
			System.out.print((char)(i + 88) + "\t");
		}

		System.out.println();

	}

	
	//----------------------MAIN---------------------------//
	
	public static void main(String[] args) {

		int n = 4
				; //numero de columnas (X,Y,Z)
		autoHanoi autoHanoi = new autoHanoi(n); //Calls the constructor
		
		autoHanoi.display(); //Show the status of the towers
		
		autoHanoi.solve(n,'X', 'Y', 'Z'); //Resuelve la torre
	}
}
