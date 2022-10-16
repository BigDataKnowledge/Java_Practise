package spark.java;

public class StockPriceMaxProfit {

	public static void main(String[] args) {
		int inputStockPrice [] = {13,18,12,14,32,16,2,10};
		
		int maxProfit = calMaxProfit(inputStockPrice);
		
		System.out.println("maxProfit = "+maxProfit);

	}
	
	private static int calMaxProfit(int inputStockPrice[]) {
		int maxProfit = 0;
		int minIndex = 0;
		int buyDay = 0;
		int sellDay = 0;
		
		for(int i=0;i<inputStockPrice.length -1 ;i++) {
			
			if(i==0) {
				minIndex = i;
				continue;
			}
			if(inputStockPrice[i] < inputStockPrice[minIndex]) {
				minIndex = i;	
			}
			if((inputStockPrice[i] - inputStockPrice[minIndex]) > maxProfit) {
				maxProfit = inputStockPrice[i] - inputStockPrice[minIndex];
				buyDay = minIndex +1;
				sellDay = i+1;
			}
		}
		System.out.println("buyDay = "+buyDay+ " SellDay = "+sellDay);
		return maxProfit;
	}

}
