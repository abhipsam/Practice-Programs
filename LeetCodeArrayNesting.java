import java.util.ArrayList;
import java.util.Arrays;
import java.util.Queue;

public class LeetCodeArrayNesting {
    public static int arrayNesting(int[] nums) {
      int n = nums.length;
      if(n==0 || nums == null){
          return 0;
      }

      boolean[] visited = new boolean[n];
        Arrays.fill(visited,false);
      int max = Integer.MIN_VALUE;

        ArrayList<Integer> list = new ArrayList<>();

      for(int i =0;i<n;i++){
          int j=i;
          while(!visited[j]){
             list.add(nums[j]);
             visited[j]=true;
             j=nums[j];
         }

         max=Math.max(max,list.size());
         list=new ArrayList<>();
      }
      return max;
    }

    public static void main(String args[]){
        int[] arr={5,4,0,3,1,6,2};
        System.out.println(arrayNesting(arr));
    }
}
