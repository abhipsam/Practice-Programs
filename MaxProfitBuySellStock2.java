public class MaxProfitBuySellStock2 {
    public static int maxProfit(int[] prices, int fee) {
        int n = prices.length;

        if(n==0 || prices==null){
            return 0;
        }

        if(n==1){
            return (prices[0]-fee>0?prices[0]-fee:0);
        }

        int profit_sell =0;
        int profit_buy = -prices[0];

        // Two cases here while transitioning from day 1 to day 2
        //either we retain what we have - if we don't have anything, we buy, if not we sell to have a profit
        for(int i=1;i<n;i++){
           profit_sell = Math.max(profit_sell,profit_buy+prices[i]-fee);
           profit_buy = Math.max(profit_buy,prices[i]-profit_sell);
        }

        return profit_sell;
    }
}
