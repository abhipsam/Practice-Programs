public class ProductOfArrayExceptSelf {
    public static int[] productExceptSelf(int[] nums) {
        int n=nums.length;
       int[] res = new int[n];

       if(n==0 || nums==null){
           return res;
       }
       int prod=1;
       for(int i=0;i<n;i++){
           res[i]=prod;
           prod=prod*nums[i];
       }
       prod=1;
       for(int j=n-1;j>=0;j--){
           res[j]=res[j]*prod;
           prod=prod*nums[j];
       }

       return res;
    }

    public static void main(String args[]){
        int[] arr= {1,2,3,4};
        int[] res = productExceptSelf(arr);

        for(int i=0;i<res.length;i++){
           System.out.println(res[i]);
        }
    }
}
