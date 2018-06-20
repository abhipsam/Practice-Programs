import java.util.Arrays;

public class LongestIncreasingPathMatrix {
    public static int longestIncreasingPath(int[][] matrix) {
        int result = 1;

        int n=matrix.length;
        int m = matrix[0].length;

        // Create a lookup table and fill all entries in it as -1
        int[][] dp = new int[n][m];
        for(int i=0;i<n;i++)
            for(int j=0;j<m;j++)
                dp[i][j] = -1;

        // Compute longest path beginning from all cells
        for (int i=0; i<n; i++)
        {
            for (int j=0; j<m; j++)
            {
                if (dp[i][j] == -1)
                    findLongestFromACell(i, j,matrix, dp);

                //  Update result if needed
                result = Math.max(result, dp[i][j]);
            }
        }

        return result;
       }

    static int findLongestFromACell(int i, int j, int mat[][], int dp[][])
    {
        int n = mat.length;
        if (i<0 || i>=n || j<0 || j>=n) {
            return 0;
        }
        int m = mat[0].length;
        // Base case

        // If this subproblem is already solved
        if (dp[i][j] != -1)
            return dp[i][j];


        if (j<n-1 && ((mat[i][j] < mat[i][j+1]))) {
            return dp[i][j] = 1 + findLongestFromACell(i, j + 1, mat, dp);
        }

        if (j>0 && (mat[i][j] < mat[i][j-1])) {
            return dp[i][j] = 1 + findLongestFromACell(i, j - 1, mat, dp);
        }

        if (i>0 && (mat[i][j] < mat[i-1][j])) {
            return dp[i][j] = 1 + findLongestFromACell(i - 1, j, mat, dp);
        }

     if (i<n-1 && (mat[i][j] < mat[i+1][j])) {
         return dp[i][j] = 1 + findLongestFromACell(i + 1, j, mat, dp);
     }

        // If none of the adjacent fours is one greater
        return dp[i][j] = 1;
    }


       public static void main(String args[]){
        int[][] matrix = {{7,8,9},
                          {9,7,6},
                          {7,2,3}};
        int[][] matrix1 ={};

        System.out.println(longestIncreasingPath(matrix));
       }
    }

