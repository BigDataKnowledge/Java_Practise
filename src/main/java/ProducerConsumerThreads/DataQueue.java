package spark.javapractise.ProducerConsumer;

import java.util.LinkedList;
import java.util.Queue;

public class DataQueue {
	
    private final Queue<Message> queue = new LinkedList<Message>();
    private final int maxSize;
    private final Object FULL_QUEUE = new Object();
    private final Object EMPTY_QUEUE = new Object();
    
    private boolean isFull = false;
    private boolean isEmpty =true;
    
    boolean producerwaitFlag = false;
    boolean consumerwaitFlag = false;
    
    

    DataQueue(int maxSize) {
        this.maxSize = maxSize;
    }
      
    
     public boolean isProducerwaitFlag() {
		return producerwaitFlag;
	}

	public void setProducerwaitFlag(boolean producerwaitFlag) {
		this.producerwaitFlag = producerwaitFlag;
	}

	public boolean isConsumerwaitFlag() {
		return consumerwaitFlag;
	}


	public void setConsumerwaitFlag(boolean consumerwaitFlag) {
		this.consumerwaitFlag = consumerwaitFlag;
	}

	public int sizeOfqueue() {
    	 
    	 return queue.size();
    	 
     }
     
    public boolean isFull() {
    	
    	if(queue.size()==maxSize)
    		isFull = true;
    	else
    		isFull = false;
    	
    	return isFull;
    	
    }
    
    public boolean isEmpty() {
    	
    	if(queue.size()!=0)
    		isEmpty = false;
    	else
    		isEmpty = true;
    	
    	return isEmpty;
    }
    
    // The producer process calls the waitOnFull method:
    public void waitOnFull() throws InterruptedException {
        synchronized (FULL_QUEUE) {
        	System.out.println(" Producer thread is going in wait as queue is full");
            FULL_QUEUE.wait();
        }
    }
    
    //the consumer process notifies the producer through the notifyAllForFull method: that is consumes the message you can produce more
    public void notifyAllForFull() throws InterruptedException {
        synchronized (FULL_QUEUE) {
        	System.out.println(" Messages consumed Producer invoked from wait");
            FULL_QUEUE.notifyAll();;
        }
    }
    
    //If the queue is empty, the consumer waits on the EMPTY_QUEUE object. And, the producer notifies it as soon as a message is added to the queue.
    public void waitOnEmpty() throws InterruptedException {
        synchronized (EMPTY_QUEUE) {
        	System.out.println("Consumer is waiting as queue is empty");
        	EMPTY_QUEUE.wait();
        }
    }
    
    //The producer notifies the consumer using the notifyAllForEmpty method:
    public void notifyAllForEmpty() throws InterruptedException {
        synchronized (EMPTY_QUEUE) {
        	System.out.println("Producer produced the message Consumer invoked");
        	EMPTY_QUEUE.notifyAll();;
        }
    }
    
    //the producer uses the add() method to add a message to the queue:
    public void add(Message message) {
        synchronized (queue) {
            queue.add(message);
        }
    }
    
    //The consumer calls the remove method to retrieve a message from the queue:
    public Message remove() {
        synchronized (queue) {
            return queue.poll();
        }
    }
    

    // other methods
}
