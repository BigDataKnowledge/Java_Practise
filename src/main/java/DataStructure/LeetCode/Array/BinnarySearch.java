package spark.java;

public class BinnarySearch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a [] = {3,6,9,13,18,29,41,62,84,97,124,158,201,258,320,402,510,680,840,1123,1480} ;
		
		int searchMe = 402;
		
		int searchIndex = binarysearch(a,searchMe);
		if(searchIndex!=-1)
			System.out.println(" Index of searchMe = "+searchIndex+ " and searchMe = "+a[searchIndex]);
		else
			System.out.println("searchMe is not present in Array");

	}
	
	private static int binarysearch(int a [], int searchMe) {
		
		int searchedIndex = -1;
		
		int low = 0;
		int high = a.length -1;
		int mid ;
		
		for(int index = 0; index < high; index++) {
			mid = (low + high)/2;
			
			if(searchMe < a[mid]) {
				high = mid -1;
			} else if(searchMe > a[mid]) {
				low = mid +1;
			} else if(searchMe == a[mid])
			{
				searchedIndex = mid;
				break;
			}
			
		}
		
		return searchedIndex;
		
	}

}
