public class MinimumCostClimbingStairs {
    public static int minCostClimbingStairs(int[] cost) {
        int n= cost.length;

        if(n==0 || cost==null){
            return 0;
        }

        int[] sol=new int[n+1];

        for(int i=0;i<n;i++){
          if(i==0){
              sol[i]=cost[i];
          }else if(i==1){
             sol[i]=Math.min(cost[i],sol[i-1]);
          }else{
              sol[i]=Math.min(cost[i-1]+sol[i-1],cost[i-2]+sol[i-2]);
          }
        }

        return sol[n];
    }

    public static void main(String args[]){
        int[] cost = {10,15,20};

        System.out.println("The minimum cost="+minCostClimbingStairs(cost));
    }
}
