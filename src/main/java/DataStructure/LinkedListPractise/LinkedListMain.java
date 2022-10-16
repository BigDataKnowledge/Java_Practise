package spark.LinkedListPractise;

public class LinkedListMain {

	public static void main(String[] args) {
		
		CreateLinkedList ll = new CreateLinkedList();
		
		ll.addNode(10);
		ll.addNode(15);
		ll.addNode(5);
		ll.addNode(2);
		ll.addNode(20);
		System.out.println("size = "+ll.size());
		ll.printLinkedList();
		ll.reverse();
		ll.printLinkedList();

	}

}
