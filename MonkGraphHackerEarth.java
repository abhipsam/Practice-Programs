import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class MonkGraphHackerEarth {
    public static int findMaxEdges(int n, int[][] edges){
       boolean[] visited = new boolean[n+1];
        Arrays.fill(visited,false);

        List<Integer> result = new ArrayList<>();

        int max = 0;
        for(int i=1;i<=n;i++){
            if(!visited[i]) {
                int x = dfs(i, edges, 0,0, visited);
                max=Math.max(max,x);
            }
        }

        return max;
    }

    public static int dfs(int i, int[][] edges,int count, int max, boolean[] visited){

        visited[i] = true;

        for(int j=1;j<edges.length;j++){
            if(i!=j && !visited[j] && edges[i][j]==1){
                count=count+1;
                max=Math.max(max,count);
                return dfs(j,edges,count,max,visited);
            }
        }

       return max;

    }

    public static void main(String args[]){
        int n =6;
        int[][] edges = new int[n+1][n+1];

        edges[1][2]=1;
        edges[2][3]=1;
        edges[4][5]=1;

        System.out.println("the maximum connected components="+findMaxEdges(n,edges));
    }
}
