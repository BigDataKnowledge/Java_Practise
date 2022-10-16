package spark.javapractise.ProducerConsumer;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ProducerConsumerMain {

	public static void main(String[] args) {
		
		int MAX_QUEUE_CAPACITY = 10;
		
		DataQueue dataQueue = new DataQueue(MAX_QUEUE_CAPACITY);
		
		Producer producer = new Producer(dataQueue);
	//	Thread producerThread = new Thread(producer);
		
		Consumer consumer = new Consumer(dataQueue);
	//	Thread consumerThread = new Thread(consumer);
		
		
		ExecutorService executorSerProducer
        = Executors.newFixedThreadPool(4);
		
		executorSerProducer.submit(producer);
		
		ExecutorService executorSerConsumer
        = Executors.newFixedThreadPool(4);
		
		executorSerConsumer.submit(consumer);
		
	//	producerThread.start();
	//	consumerThread.start();
		
		/*
		 * try {
		 * 
		 * // producer.stop(); consumer.stop();
		 * 
		 * } catch (InterruptedException e) {
		 * 
		 * e.printStackTrace(); }
		 */
	}

}
