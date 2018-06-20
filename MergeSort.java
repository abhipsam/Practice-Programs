public class MergeSort {
   public static int[] mergeSort(int[] arr){

       if(arr.length<=1){
           return arr;
       }
       int mid=arr.length/2;

       int[] left=new int[mid];
       int[] right=new int[arr.length-mid];

       for(int i=0;i<left.length;i++){
           left[i]=arr[i];
       }
       for(int i=0;i<right.length;i++){
           right[i]=arr[i+left.length];
       }
       left=mergeSort(left);
       right=mergeSort(right);
       
       return merge(left,right);
   }

    private static int[] merge(int[] left, int[] right) {
       int[] result= new int[left.length+right.length];

       int leftIndex=0;
       int rightIndex=0;
       int resultIndex=0;

       while(leftIndex<left.length || rightIndex<right.length){
           if(leftIndex<left.length && rightIndex<right.length){
               if(left[leftIndex]<right[rightIndex]){
                   result[resultIndex++]=left[leftIndex++];
               }else{
                   result[resultIndex++]=right[rightIndex++];
               }
           }else if(leftIndex<left.length){
               result[resultIndex++]=left[leftIndex++];
           }else if(rightIndex<right.length){
               result[resultIndex++]=right[rightIndex++];
           }
       }

       return result;
    }

    public static void main(String args[]){
       int[] arr = {4,8,1,2,9,5,6,8,3,7,11,1,4,89};
        int[] res=mergeSort(arr);
        for (Integer x:res){
            System.out.print(x+" ");
        }
    }
}
