import java.util.ArrayList;
import java.util.List;

public class FindNumPathsHackerearth {
    public static int findMaxPaths(int[][] matrix){
        int[][] visited= new int[matrix.length][matrix[0].length];

        List<Integer> list = new ArrayList<>();
                if( matrix[1][1]==1){
                    return -1;
                }else{
                   dfs(1,1,matrix,visited,list,0);
                }
           return list.size();
    }

    public static void dfs(int i, int j, int[][] matrix,int[][] visited,List<Integer> list,int count){

        if(i==matrix.length-1 && j==matrix[0].length-1){
            list.add(count);
            return;
        }

        visited[i][j]=1;
        if(j+1<matrix.length && visited[i][j+1]==0 && matrix[i][j+1]==0){
            dfs(i,j+1,matrix,visited,list,count+1);
        }
            if(j>0 && visited[i][j-1]==0 && matrix[i][j-1]==0){
            dfs(i,j-1,matrix,visited,list,count+1);
        }
        if(i>0 && visited[i-1][j]==0 && matrix[i-1][j]==0){
            dfs(i-1,j,matrix,visited,list,count+1);
        }
        if(i+1<matrix.length && visited[i+1][j]==0 &&matrix[i+1][j]==0){
            dfs(i+1,j,matrix,visited,list,count+1);
        }
        visited[i][j]=0;
       return;
    }

    public static void main(String args[]){
        int[][] matrix ={{0,1,1,0},{0,0,1,0},{0,0,0,0},{0,1,1,0}};
        System.out.println("The number of paths="+findMaxPaths(matrix));
    }
}
