public class RotateArray {
    public static void rotate(int[] nums, int k) {
       int n = nums.length;
       if(n==0 || nums == null){
           return;
       }
       reverseArray(nums,0,n-k-1);
       reverseArray(nums,n-k,n-1);
       reverseArray(nums,0,n-1);

    }

    public static void reverseArray(int[] nums, int start, int end){
        int i= start;
        int j = end;
        while(i<j){
            int temp= nums[i];
            nums[i]=nums[j];
            nums[j]=temp;
            i++;
            j--;
        }
    }


    public static void main(String args[]){
        int[] arr = {1,2,3,4,5,6,7};
        int[] arr2={-1,-100,3,99};
        int k2=2;
        int k=3;
        rotate(arr2,k2);
        for(Integer x : arr2){
            System.out.print(x+" ");
        }
    }
}
