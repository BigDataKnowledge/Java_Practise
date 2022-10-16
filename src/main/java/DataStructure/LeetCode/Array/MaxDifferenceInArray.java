package spark.java;

public class MaxDifferenceInArray {

	public static void main(String[] args) {
		
		int inputArray [] = {12,19,5,9,2,45,1,45};
		
		int maxDiff = maxDiff(inputArray);
		
		System.out.println("MaxDiff = "+maxDiff);

	}
	
	private static int maxDiff(int inputArray[]) {
		int maxDiff = 0;
		int sortedArray[] = sortedArray(inputArray);
		return sortedArray[sortedArray.length -1] - sortedArray[0];
	}
	
	private static int[] sortedArray(int inputArray[]) {
		int temp;
		
		boolean isSorted = true;
		for(int i=0; i < inputArray.length -1 ;i++) {
			for(int j=0;j<inputArray.length -1 -i;j++) {
			
				if(inputArray[j]> inputArray[j+1]) {
					isSorted = false;
					temp = inputArray[j];
					inputArray[j] =inputArray[j+1];
					inputArray[j+1] = temp;
				}
			}
			if(isSorted) {
				break;
			}
		}
		return inputArray;
	}

}
