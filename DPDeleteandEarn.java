import java.util.Arrays;

public class DPDeleteandEarn {
    public static int deleteAndEarn(int[] nums) {
       int n = nums.length;

       if(n==0 || nums==null){
           return 0;
       }

       int x = 0;
       for(int i=0;i<n;i++){
          x=Math.max(x,nums[i]);
       }

        Arrays.sort(nums);

       int max=0;
       int maxOverall=0;
       int min=Integer.MAX_VALUE;

       for(int i=0;i<n;i++){
           min=Math.min(min,nums[i]);
           max=Math.max(max,nums[i]);
       }

       int[] sol = new int[max+1];
       int[] count= new int[max+1];

       for(int i=0;i<n;i++){
           count[nums[i]]=count[nums[i]]+nums[i];
       }

       for(int i=min;i<=max;i=i+1) {
           if(i==min){
               sol[i]=count[i];
           }else if(i==min+1) {
               sol[i] = Math.max(sol[i - 1], count[i]);
           }else{
               sol[i]=Math.max(sol[i-1],count[i]+sol[i-2]);
           }
       }

       return sol[max];
    }

    public static void main(String args[]){
        int[] nums = {8,10,4,9,1,3,5,9,4,10};
        System.out.println(deleteAndEarn(nums));
    }
}
