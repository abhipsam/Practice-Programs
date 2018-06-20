public class RemoveDuplicatesFromSortedArray2 {
    public static int removeDuplicates(int[] nums) {

        int n=nums.length;
        if(n==0 || nums==null){
            return 0;
        }
        int count=0;
        int prev=nums[0];
        for(int i=1;i<n;i++){
            if(nums[i]==prev){
                count++;
            }else{
                if(count>2){

                }
                count=0;
                prev=nums[i];
            }

        }
   return 0;
    }
}
