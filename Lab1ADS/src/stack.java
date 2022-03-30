import java.util.Scanner;

public class stack {

	static Scanner scan = new Scanner(System.in);
	static Scanner read = new Scanner(System.in);
	static int MAX = read.nextInt();

	static int op;

	static int top = -1;
	static int[] S = new int[MAX];

	static int[] Q = new int[MAX];
	static int new_tail;
	static int head = 0;
	static int tail;

	public static void main(String[] args) {

		int num, bucle;
		bucle = 0;

		if (MAX <= 0) {
			System.out.println("Pls, enter a valid number");
			MAX = read.nextInt();
		}

		while (bucle != 1) {

			System.out.println("STACK OPTIONS:\n");
			System.out.println("1.Insert a number. \t 2.Read a number. \t 3.Print the stack.\n");

			System.out.println("QUEUE OPTIONS.\n");
			System.out.println("4.Insert a number. \t 5.Read a number. \t 6.Print the queue.\n");
			System.out.println("7.EXIT.\n");

			System.out.println("Choose an option:");
			op = scan.nextInt();
			System.out.println("\tChosen option --> " + op);

			switch (op) {
			case 1: // ADD A NUMBER TO LAST POSITION OF THE STACK
				System.out.println("Type the number to push on the stack:\n");
				num = scan.nextInt();
				push(S, num);
				System.out.println("\t Number added --> " + num);
				break;
			case 2: // READ THE NUMBER LIFO
				int pop = pop(S);
				System.out.println("Last number on the stack:" + pop);
				break;
			case 3: // Print el Stack
				printStack(S);
				break;
			case 4: // ENQUEUE ;
				System.out.println("Type a number to be added to the queue:\n");
				num = scan.nextInt();
				enqueue(Q, num);
				System.out.println("\t Number added --> " + num);
				break;
			case 5: // READ THE NUMBER FIFO
				int dequeue = dequeue(Q);
				System.out.println("First number in the queue:" + dequeue);
				break;
			case 6: // Print queue
				printQueue(Q);
				break;
			case 7: // Exit
				bucle = 1;
				break;
			default:
			}

		}
		scan.close();
	}

	// ----------------------------DECLARAR FUNCIONES---------------------------

	// PUSH STACK

	public static void push(int[] stack, int num) {
		if (top + 1 >= MAX) {
			System.out.println("Error --> FULL");
		} else {
			top++;
			S[top] = num;
		}
	}

	// POP STACK

	public static int pop(int[] stack) {
		int num;

		if (top == -1) {
			System.out.println("Error --> EMPTY");
		} else {
			top--;
		}
		num = S[top + 1];
		S[top + 1] = 0;
		return num;

	}

	// PRINT STACK
	public static void printStack(int[] stack) {

		for (int i = 0; i < stack.length; i++) {
			System.out.println(" = " + stack[i]);
		}
	}

//--------------------------------------------QUEUE------------------------------------------------------------

	// ENQUEUE WRITE

	public static void enqueue(int[] queue, int num) {

		new_tail = tail + 1;
		if (new_tail > MAX) {
			new_tail = 0;
		}

		if (new_tail == MAX) {
			System.out.println("error --> full");
		} else {

			queue[tail] = num;
			tail = new_tail;
		}
	}

	// DEQUEUE READ

	public static int dequeue(int[] queue) {
		int num = 0;
		if (head == tail) {
			System.out.println("Error --> Empty");
			head = 0;

		} else {
			num = queue[head];
			tail = head-1;
			head++;
			if (head >= MAX) {
				head = 1;
			}

		}
		return num;
	}

	// PRINT QUEUE
	public static void printQueue(int[] queue) {

		if(tail<head) {
			for(int i = tail; i<head;i++) {
				System.out.println(" = " + queue[i]);
			}
		if(tail>=head) {
			for(int i = head; i<queue.length;i++) {
				System.out.println(" = " + queue[i]);
		}
		}	
		}else {
		
		for (int i = 0; i < tail; i++) {
			System.out.println(" = " + queue[i]);
		}
	}
}
}