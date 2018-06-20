public class DPBuySellStock {
    public static int maxProfit(int[] prices) {
       int n=prices.length;

       int min=Integer.MAX_VALUE;
       int[] sol= new int[n];

       for(int i=0;i<n;i++){
           if(i==0){
               sol[0]=0;
           }else {
               sol[i]=sol[i-1];
               if(prices[i]>min){
                   sol[i]=Math.max(sol[i],prices[i]-min);
               }
           }
           min=Math.min(min,prices[i]);
       }

       return sol[n-1];
    }

    public static void main(String args[]){
        int[] prices={2,4,1};

        System.out.println(maxProfit(prices));
    }
}
