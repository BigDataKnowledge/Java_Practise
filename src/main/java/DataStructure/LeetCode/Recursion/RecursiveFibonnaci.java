package spark.java;

public class RecursiveFibonnaci {

	public static void main(String[] args) {
		
		int n=10;
		
		for (int i=1;i<=n;i++) {
			System.out.println(" "+printFibonnaci(i));
		}
	}
	
	private static int printFibonnaci(int n) {
		if(n <=1) {
			return 1;
		}
		return printFibonnaci(n-2)+printFibonnaci(n-1);
	}

}
