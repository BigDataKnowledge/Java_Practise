package spark.StackPractise;

public class StackMain {

	public static void main(String[] args) {
		CreateStack stack = new CreateStack(5);
		
		stack.push(1);
		stack.push(2);
		stack.push(1);
		stack.push(2);
		stack.push(5);
		
		System.out.println(stack.peek());
		System.out.println(stack.size());
		
		stack.pop();
		
		System.out.println(stack.peek());
		System.out.println(stack.size());
		
		
		
		

	}

}
