public class DPCoinChange1 {
    public static int MakeCoinChange(int[] coins, int m, int n){
        //Create the Dp Solution table - Let sol[i][j] be denoting the number of ways to make sum i using j coins.

        int[][] sol = new int[n+1][m];

        for( int i =0; i<n+1; i++){
            for(int j = 0;j<m;j++){
                if(i==0){
                    sol[i][j]=1;
                }

               else if(j==0){
                    if(i%coins[j]==0){
                        sol[i][j]=1;
                    }else{
                        sol[i][j]=0;
                    }
                }
              else if(coins[j]>i){
                    sol[i][j]= sol[i][j-1];
            } else {
                    sol[i][j]=sol[i-coins[j]][j]+ sol[i][j-1];
            }
        }
    }

    return sol[n][m-1];
}

public static void main(String args[]){
        int[] coins = {1,2,3};
        int n = 5;

        int x = MakeCoinChange(coins,coins.length,n);

        System.out.println("The number of ways of making change ="+ x);
}
}
