import java.util.Arrays;

public class LongestIncreasingPathInMatrix {
    public static int longestIncreasingPath(int[][] matrix) {
        int n = matrix.length;
        int m= matrix[0].length;

        int[][] lip = new int[n][m];
        Arrays.fill(lip,1);

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
               if(i==0 || j==0){
                   lip[i][j]=1;
               }
               else
               {

               }
            }
        }
        return 0;

    }
}
