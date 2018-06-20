public class UniqueWeightedPaths {
    public static int uniqueWeightedPaths(int[][] grid) {
        // write your codes here
        int n=grid.length;
        int m=grid[0].length;

        int sum=0;

        if(n==0 && m==0){
            return sum;
        }
        int[][] sol = new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(i==0 && j==0){
                    sol[i][j]=grid[0][0];
                }
                else if(i==0){
                  sol[i][j]=grid[i][j]+sol[i][j-1];
                }else if(j==0){
                    sol[i][j]=grid[i][j]+sol[i-1][j];
                }else{
                    sol[i][j]=grid[i-1][j]+sol[i][j-1];
                }
            }
        }
        return sol[n-1][m-1];
    }

    public static void main(String args[]){
        int[][] matrix={{1,1,2},{1,2,3}, {3,2,4}};
        System.out.println(uniqueWeightedPaths(matrix));
    }
}
