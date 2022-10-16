package spark.StackPractise;

public class CreateStack {
	
	int arr[];
	int top;
	int capacity;
	
	
	public CreateStack(int size) {
		
		arr = new int[size];
		capacity = size;
		top = -1;
		
	}
	
	public void push(int element) {
		
		if(!isFull()) {
			arr[++top] = element;
			System.out.println("element  = "+element+ " is added at"+top);
			
		}else {
			System.out.println("Stack is overflow");
			System.exit(-1);
		}
		
	}
	
	public int pop() {
		
		if(isEmpty()) {
			System.out.println("Stack is empty");
			System.exit(-1);
		}
		System.out.println("element = "+arr[top]+ " is removed from "+top);
		return arr[top--];
		
	}
	
	public int peek() {
		
		if (!isEmpty()) {
            return arr[top];
        }
        else {
            System.exit(-1);
        }
 
        return -1;
	}
	
	public boolean isFull() {
		return top == capacity -1;
		
	}
	
	public boolean isEmpty() {
		
		return top ==-1;
	}
	
	public int size() {
        return top + 1;
    }

}
