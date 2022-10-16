package spark.javapractise.ProducerConsumer;

public class Consumer implements Runnable {
    private final DataQueue dataQueue;
    private volatile boolean runFlag;

    public Consumer(DataQueue dataQueue) {
        this.dataQueue = dataQueue;
        runFlag = true;
    }

    public void run() {
        try {
			consume();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    
    public void consume() throws InterruptedException {
    	
    	long messagesConsumed = 0;
        while (runFlag) {
            Message message;
            while (dataQueue.isEmpty()) {
                try {
                	dataQueue.setConsumerwaitFlag(true);
                    dataQueue.waitOnEmpty();
                } catch (InterruptedException e) {
                    break;
                }
            }
            dataQueue.setConsumerwaitFlag(false);
            if (!runFlag) {
                break;
            }
            message = dataQueue.remove();
            messagesConsumed++;
            System.out.println("Number of messages consumed = "+messagesConsumed+ " size = "+dataQueue.sizeOfqueue());
            Thread.sleep(10000);
            if(dataQueue.isProducerwaitFlag())
            	dataQueue.notifyAllForFull();
        }
    }
    
    
    public void stop() throws InterruptedException {
        runFlag = false;
        dataQueue.notifyAllForEmpty();
    }

    // Other methods
}
