public class SearchForARange {
    public static int[] searchRange(int[] nums, int target) {
       int n=nums.length;
       int[] result= new int[2];
        result[0]=-1;
        result[1]=-1;
       if(n==0 || nums==null){
           return result;
       }
       int start=-1;
       int end=-1;

       for(int i=0;i<n;i++) {
           if (nums[i] == target) {
               if (start == -1) {
                   start = i;
               } else {
                   end = i;
               }
           }
       }

       if(start!=-1 && end==-1){
           end=start;
       }
       result[0]=start;
       result[1]=end;
       return result;
    }

    public static void main(String args[]){
        int[] nums={5,7,7,8,8,10};
        int k=9;
        int[] res = searchRange(nums,k);
        System.out.println(res[0]+" "+res[1]);
    }
}
