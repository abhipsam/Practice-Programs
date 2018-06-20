public class UniquePaths {
    public static int uniquePaths(int m, int n) {
        if(m==0 || n==0){
            return 1;
        }
        if(m==0 && n==0){
            return 0;
        }
       int[][] sol= new int[m][n];

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(i==0 || j==0){
                    sol[i][j]=1;
                }
                else{
                    sol[i][j]=sol[i-1][j]+sol[i][j-1];
                }
            }
        }
        return sol[m-1][n-1];

    }

    public static void main(String args[]){
        System.out.println(uniquePaths(7,6));
    }
}
