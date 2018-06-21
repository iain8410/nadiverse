package structures.stack;

public class MyStack {
	
	private StackNode <Integer> top;
	
	public static void main(String[] args) {
		MyStack myStack = new MyStack();
		if ( !myStack.isEmpty()){
			myStack.pop();
		}
		myStack.push(10);
		myStack.push(20);
		System.out.println( myStack.pop() );
		System.out.println( myStack.pop() );
		
		
		myStack.push(52);
		myStack.push(83);
		myStack.push(84);
		System.out.println( myStack.peek() );
		
		while ( !myStack.isEmpty() ){
			System.out.println( myStack.pop() );
		}
	}
	
	/** Inner class to model a node in the stack
	 * 
	 * @param args
	 */
	private static class StackNode <Integer>{
		private Integer data;
		
		private StackNode <Integer> next;
		
		public StackNode (Integer p_data){
			this.data = p_data;
		}
	}
	
	public Integer pop(){
		if (top == null){
			throw new RuntimeException("Empty state");
		}
		
		Integer number = top.data;
		top = top.next;
		return number;
	}
	
	public void push(Integer number){
		StackNode <Integer> newNumber = new StackNode(number);
		newNumber.next = top;
		top = newNumber;
	}
	
	public Integer peek(){
		if (top == null){
			throw new RuntimeException("Empty state");
		}
		
		return top.data;
	}
	
	public boolean isEmpty(){
		return top == null;
	}

}
