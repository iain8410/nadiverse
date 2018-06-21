package structures.stack;

import java.util.Scanner;

public class StackWArray {

	private static Integer [] stack;
	static int pointer = -1;
	
	public static void main(String[] args) {
		stack = new Integer[100];
		
		Scanner scanner = new Scanner(System.in);
		String lineIn = scanner.nextLine();
		String [] values = lineIn.split(",");
		
		for (int x=0; x < values.length;x++){
			int i = Integer.parseInt(values[x]);
			if (i == 1){
				push( Integer.parseInt(values[x+1]) );
			}
			else if (i == 2){
				pop();
			}
		}
		
		scanner.close();
	}
	
	private static void push(int i){
		pointer++;
		stack[pointer] = i;
	}
	
	private static void pop(){
		System.out.println(stack[pointer]);
		stack[pointer] = null;
		pointer--;
	}

}
