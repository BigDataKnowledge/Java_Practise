package spark.QueueImplementation;

public class QueueMain {

	public static void main(String[] args) {
		CreateQueue queue = new CreateQueue(5);
		
	//	queue.deQueue();
		queue.enQueue(1);
		queue.enQueue(2);
		queue.enQueue(3);
		queue.enQueue(4);
		
		System.out.println(queue.size());
		
		queue.deQueue();
		
		System.out.println(queue.queueFront());
		queue.deQueue();
		System.out.println(queue.queueFront());
		
		System.out.println(queue.queueRear());
		

	}

}
