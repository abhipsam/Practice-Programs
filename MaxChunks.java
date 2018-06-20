import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class MaxChunks {
    public static int maxChunksToSorted(int[] arr) {
        if(arr.length==0){
            return 0;
        }
        if(arr.length==1){
            return 1;
        }
        Stack<int[]> stack=new Stack<>();
        for(int i=0;i<=arr.length-1;i++) {
            int min=arr[i];
            int max=arr[i];

            while(!stack.empty()){
                int[] top=stack.peek();
                if(arr[i]<top[1]){
                  max=Math.max(top[1],max) ;
                  min=Math.min(top[0],min);
                  stack.pop();
                }else{
                  break;
                }
            }
                stack.push(new int[]{min,max});
        }
        return stack.size();
    }

    public static void main(String args[]){
        int[] arr= {1,0,2,3,4};
        System.out.println("The number of chunks="+maxChunksToSorted(arr));

    }
}
