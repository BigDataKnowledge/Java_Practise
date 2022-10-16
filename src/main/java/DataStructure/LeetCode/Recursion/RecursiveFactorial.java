package spark.java;

public class RecursiveFactorial {

	public static void main(String[] args) {
		
		int n =7;
		int fact = recursiveFact(n);
		System.out.println("fact = "+fact);

	}
	
	private static int recursiveFact(int n) {
		
		if(n<=1) {
			return 1;
		}
		return n * recursiveFact(n-1);
	}

}
