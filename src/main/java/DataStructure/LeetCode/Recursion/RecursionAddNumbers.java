package spark.java;

public class RecursionAddNumbers {

	public static void main(String[] args) {
		
		int n =10;
		int sum  = addrecursively(n);
		System.out.println(sum);

	}
	
	private static int addrecursively(int n) {
		if(n==1)
			return 1;
		return (n + addrecursively(n-1));
		
	}

}
