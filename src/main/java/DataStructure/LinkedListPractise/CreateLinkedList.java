package spark.LinkedListPractise;

public class CreateLinkedList {
	
	public Node head;
	Node previousNode;

	
	
	
	public void addNode(int data) {
		
		Node node = new Node(data);
		
		if(head==null) {
			head = node;
			node.setNext(null);
			previousNode = head;
		}else {
			previousNode.setNext(node);
			previousNode = node;
		}
	}
	
	public void printLinkedList() {
		Node current = head;
		while(current!=null) {
			System.out.println(current.getData());
			current = current.next;
			
		}
	}
	
	public void deleteNode(int data) {
		Node current = head;
		Node previousNode = current;
		
		while(current!=null) {
			if(head.getData()==data) {
				head = current.next;
				current = head;
				break;
			}
			else if(current.getData()==data) {
				previousNode.next = current.next;
				break;
				
			}else {
				previousNode = current;
				current = current.next;
			}
		}
	}
	
	public void deleteFromStart() {
		Node current = head;
		head = current.next;
	}
	
	public void deleteFromEnd() {
		Node current = head;
		Node previousNode = head;
		while(current.next!=null) {
			previousNode = current;
			current = current.next;
		}
		previousNode.next = null;
	}
	
	public void addAtStart(int data) {
		Node node = new Node(data);
		node.next = head;
		head = node;
	}
	
	public void addAtEnd(int data) {
		
		Node node = new Node(data);
		Node current = head;
		
		while(current.next!=null) {
			current = current.next;
		}
		current.next = node;
		current = node;
	}
	
	public void reverse() {
		
		Node current = head;
		Node nextptr = head;
		Node preptr = null;
		
		while(current !=null) {
			nextptr = nextptr.next;
			current.next = preptr;
			preptr= current;
			current = nextptr;
		}
		head = preptr;
	}
	
	public boolean findLoop() {
		
		return false;
		
	}
	
	public int size() {
		Node current  = head;
		int count = 0;
		while(current!=null) {
			current = current.next;
			count++;
		}
		return count;
		
	}

}


