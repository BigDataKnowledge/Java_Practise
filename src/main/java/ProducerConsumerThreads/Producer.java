package spark.javapractise.ProducerConsumer;

public class Producer implements Runnable {
	
	
	private final DataQueue dataQueue;
    private volatile boolean runFlag;

    public Producer(DataQueue dataQueue) {
        this.dataQueue = dataQueue;
        runFlag = true;
    }

	public void run() {
		
		try {
			produceMessage();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	public void produceMessage() throws InterruptedException{
		
		
		long messagesProduced = 0;
		boolean waitCalled = false;
		
		while(runFlag) {
			
			while (dataQueue.isFull()) {
				try {
					dataQueue.setProducerwaitFlag(true);
	                dataQueue.waitOnFull();
	                System.out.println("notify by consumer");
	            } catch (InterruptedException e) {
	            	break;
	            }
	        }
			dataQueue.setProducerwaitFlag(false);
	        if (!runFlag) {
	            break;
	        }
	        Message message = generateMessage(messagesProduced);
	        dataQueue.add(message);
	        messagesProduced++;
	        System.out.println("Number of messages produced = "+messagesProduced+ " size = "+dataQueue.sizeOfqueue());
	        Thread.sleep(5000);
	        
	        if(dataQueue.isConsumerwaitFlag())
	        	dataQueue.notifyAllForEmpty();
		}
		
	}
	
	
	public void stop() throws InterruptedException {
	    runFlag = false;
	    dataQueue.notifyAllForFull();
	}
	
	
	public Message generateMessage(long messagesProduced) {
		
		Message message = new Message();
		message.setEmployeeName("Sahil"+messagesProduced);
		message.setEmployeeId(messagesProduced);
		return message;
		
	}
	
	

}
