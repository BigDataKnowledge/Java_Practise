package spark.java;



public class ThreadsRunningAlternate {

	public static void main(String[] args) throws InterruptedException {
		
		Counter obj1 = new Counter(1);
		Counter obj2 = new Counter(2);
		Counter obj3 = new Counter(0);
		
		Thread t1 = new Thread(obj1,"t1");
		Thread t2 = new Thread(obj2,"t2");
		Thread t3 = new Thread(obj3,"t3");
		
		t1.start();
		t2.start();
		t3.start();
	
	}
}

 class Counter implements Runnable {
	 
	 static int counterNumber = 1;
	 int stop = 10;
	 static Object lock = new Object();
	 int reminder;
	 
	 public Counter(int reminder) {
		 this.reminder = reminder;
	 }
	 
	@Override
	public void run() {
		
		while(counterNumber < stop) {
			synchronized(lock) {
				while(counterNumber % 3 != reminder) {
					try {
						lock.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				System.out.println("Thread = "+Thread.currentThread().getName()+" counterNumber = "+counterNumber);
				counterNumber++;
				lock.notifyAll();
			}
		}
	}
}
 

