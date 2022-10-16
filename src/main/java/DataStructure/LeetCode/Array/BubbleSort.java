package spark.java;

public class BubbleSort {

	public static void main(String[] args) {
		
		int a [] = { 28,22,25,18,12,16,14,9,2,6,3,5};
		
		bubbleSort(a);

	}
	
	private static void printArray(int a[]) {
		
		System.out.println("=========Next==========");
		
		for(int i=0;i<a.length;i++) {
			System.out.println(a[i]);
		}
	}
	
	private static void bubbleSort(int a[]) {
		int temp;
		
		for(int i =0 ; i<a.length; i++) {
			for(int j =0 ; j<( a.length -(1 +i)); j++) {
				if(a[j] > a[j+1]) {
					temp = a[j+1];
					a[j+1]= a[j] ;
					a[j] = temp;
				}
			printArray(a);
				
			}
		}
	}
}
