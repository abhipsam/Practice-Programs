import java.util.Arrays;

public class UniquePaths2 {
    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
       int n=obstacleGrid.length;
       int m=obstacleGrid[0].length;

       if(n==0 && m==0){
           return 0;
       }
       if(obstacleGrid[0][0]==1 || obstacleGrid[n-1][m-1]==0){
           return 0;
       }

       int[][] sol = new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                sol[i][j]=-1;
            }
        }
        sol[0][0]=1;

       for(int i=0;i<n;i++){
           for(int j=0;j<m;j++) {
               if (i == 0) {
                   if (obstacleGrid[i][j] == 1) {
                       for(int k=j;k<=m-1;k++){
                           sol[i][k]=0;
                       }
                   } else {
                       if(sol[i][j]==-1) {
                           sol[i][j] = 1;
                       }
                   }

               } else if (j == 0) {
                   if (obstacleGrid[i][j] == 1) {
                       for(int k=i;k<=n-1;k++){
                          sol[k][j]=0;
                       }
                   } else {
                       if(sol[i][j]==-1) {
                           sol[i][j] = 1;
                       }
                   }
               } else{
                   if(obstacleGrid[i-1][j]==1 && obstacleGrid[i][j-1]==1){
                       sol[i][j]=0;
                   }else if(obstacleGrid[i-1][j]==1){
                       sol[i][j]=sol[i][j-1];
                   }else if(obstacleGrid[i][j-1]==1){
                       sol[i][j]=sol[i-1][j];
                   }else{
                       sol[i][j] = sol[i - 1][j] + sol[i][j - 1];
                   }
               }
           }
       }
       return sol[n-1][m-1];
    }

    public static void main(String args[]){
        int[][] matrix={{0,0,1,0,0,0},
                        {0,0,0,0,0,0},
                      {0,0,0,0,0,0},{0,0,0,0,0,0},{0,0,0,0,0,0},{0,0,0,0,0,0},{0,0,0,0,0,0}};

        System.out.println(uniquePathsWithObstacles(matrix));
    }
}
