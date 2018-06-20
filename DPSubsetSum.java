public class DPSubsetSum {
    public static boolean findSubSetSum(int[] arr , int m, int n){
       boolean [][] sol = new boolean[n+1][m];

        for(int i =0 ; i<n+1;i++){
            for(int j = 0;j<m;j++){
                if(i==0){
                  sol[i][j]=true;
                } else if (j==0){
                    sol[i][j] = false;
                }else{
                    sol[i][j]=sol[i][j-1];
                    if(arr[j]<=i){
                        sol[i][j] = sol[i][j-1] || sol[i-arr[j]][j-1];
                    }
                }

            }
        }

        return sol[n][m-1];
    }

    public static void main(String args[]){
        int[] arr = {3,34,4,12,5,2};
        int n = 10;

        boolean x = findSubSetSum(arr,arr.length,n);
        if(x){
            System.out.println("exists");
        }else{
            System.out.println("Not exists");
        }
    }
}
