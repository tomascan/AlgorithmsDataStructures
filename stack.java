import java.util.Scanner;
import java.util.Arrays;




public class StackQueue{
    
    private static final int MAX = 10;
    static int top=0;
    

     public static void main(String []args){
         

        int op;
        Scanner scan = new Scanner(System.in); 
         
   
        
        int num;
        int bucle = 0;  
        int[] stack = new int[MAX];
        int[] queue = new int[MAX];
        String dayString;

    
  
  while(bucle != 1){

        System.out.println("\n STACK OPTIONS:\n");
        System.out.println("1.Insert a number.\n");
        System.out.println("2.Read a number.\n");
        System.out.println("3.Print the stack.\n");
                
        System.out.println("\n QUEUE OPTIONS.\n");
        System.out.println("4.Insert a number.\n");
        System.out.println("5.Read a number.\n");
        System.out.println("6.Print the queue from head to tail.\n");
        System.out.println("7.EXIT.\n");
    
         
        System.out.println("Introduzca una opcion:");
        op = scan.nextInt();
        System.out.println("Chosen option:" + op);
        

  
        // switch statement with int data type
        switch (op) {
        case 1:
            dayString = "push"; //ADD A NUMBER TO LAST POSITION OF THE STACK
            System.out.println("Escriba el numero a introducir:");
            num = scan.nextInt();
            System.out.println("El numero introducido es:" + num);
            Push(stack,num);
            break;
        case 2:
            dayString = "pop"; //READ THE NUMBER FIFO
            int last = Pop(stack);
            System.out.println("El ultimo numero del stack:" + last);
            break;
        case 3:
            dayString = "print stack"; //Imprimir el Stack
            PrintStack(stack);
            break;
        case 4:
            dayString = "enqueue"; //enqueue(queue, num);
            break;
        case 5:
            dayString = "dequeue"; //dequeue(queue);
            break;
        case 6:
            dayString = "print queue";//Imprimir queue
            break;
        case 7:
            dayString = "Exit"; //Exit
            break;
        default:
            dayString = "Invalid day";
        }
        System.out.println(dayString);
        
        System.out.println("Desea continuar?\n 0. Continuar \n 1. Salir \n ");
        bucle = scan.nextInt();
        
        
      
  }
}
    
    
    //----------------------------DECLARAR FUNCIONES--------------------------- 
    
    //PUSH STACK

    public static void Push(int[] stack, int num)
    {
        if(top == MAX){
            System.out.println("Error --> FULL");
        }
        else{
            top++;
            stack[top] = num;
        }
    }
    
    //POP STACK
    
        public static int Pop(int[] stack)
    {
        if(top == 0){
            System.out.println("Error --> EMPTY");
        }
        else{
            top--;
        }
        return stack[top+1];
         
    }
    
    //IMPRIMIR STACK
        public static void PrintStack(int[] stack)
    {
        
        for(int i=0;i<=MAX;i++)
        {
            System.out.println("= " + stack[i]);
        }
    }
 


}