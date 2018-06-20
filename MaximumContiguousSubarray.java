public class MaximumContiguousSubarray {
    public static int maxSubArray(int[] nums) {
        int n = nums.length;
        if(n==0 || nums==null){
            return 0;
        }

        int[] sol = new int[n];

        sol[0]=nums[0];
        for(int i=1;i<n;i++){
           int sum = nums[i]+sol[i-1];
           sol[i]=Math.max(nums[i],sum);
        }

        int max=Integer.MIN_VALUE;
       for(int i=0;i<n;i++){
            max=Math.max(max,sol[i]);
       }

       return max;
    }

    public static void main(String args[]){
        int[] arr = {-2};
        System.out.println(maxSubArray(arr));
    }
}
