public class BestTimeToBuySellStock {
    public static int maxProfit(int[] prices) {
       int n = prices.length;
       if(n==0 || prices==null){
           return 0;
       }
       int maxprofit = 0;

       for(int i=1;i<n;i++){
          int diff  = prices[i]-prices[i-1];
          if(diff>0){
              maxprofit=maxprofit+diff;
          }
       }

       return maxprofit;
    }

    public static void main(String args[]){
        int[] prices = {7,1,5,3,6,4};
        System.out.println(maxProfit(prices));
    }
}
