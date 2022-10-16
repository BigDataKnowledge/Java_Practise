package spark.QueueImplementation;

public class CreateQueue {
	
	int queue[];
	int front, rear;
	int capacity;
	int size=0;
	
	public CreateQueue(int capacity) {
		
		queue = new int[capacity];
		front = rear = 0;
		
	}
	
	public void enQueue(int element) {
		
		if(isFull()) {
			System.out.println("Queue is full");
			System.exit(-1);
		}else {
			queue[rear] = element;
			rear = rear+1;
		}
		
	}
	
	public int deQueue() {
		
		if(isEmpty()) {
			System.out.println("Queue is empty can not delete");
			System.exit(-1);
		}else {
			for(int i=0;i<rear -1;i++) {
				queue[i] = queue[i+1];
				
			}
			queue[rear] =0;
			rear = rear -1;
			
		}
		return queue[front];
	}
	
	public int size() {
		if(isEmpty()) {
			return 0;
		}
		return rear;
		
	}
	
	public boolean isFull() {
		return rear == capacity -1;
		
	}
	
	public boolean isEmpty() {
		return front==rear;
		
	}
	
	public int queueFront() {
		return queue[front];
		
	}
	
	public int queueRear() {
		return queue[rear-1];
		
	}
}
