import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class MaxChunksSortArray {
    public static int maxChunksToSorted(int[] arr) {
        if(arr.length==1){
            return 1;
        }
        Stack<Object> stack=new Stack<>();
        int i=1;

        List<Integer> resList=new ArrayList<>();
        if(arr[0]>arr[1]){
            resList.add(arr[0]);
        }else{
            stack.push(arr[0]);
        }
        while(i<=arr.length-1){
            if(i==arr.length-1) {
                if (arr[i] > arr[i - 1]) {
                   stack.push(arr[i]);
                } else {
                 resList.add(arr[i]);              }
            }
            else if(arr[i-1]>arr[i] && arr[i] > arr[i+1]){
              resList.add(arr[i]);
            }
            else if(arr[i-1]< arr[i] && arr[i] < arr[i+1]){
                if(resList.size()!=0) {
                    stack.push(resList);
                }
                stack.push(arr[i]);
                resList.clear();
            }
            i++;
        }
        if(resList.size()!=0){
            stack.push(resList);
        }
        return stack.size();
    }

    public static void main(String args[]){
        int[] arr= {0,2,1};
        System.out.println("The number of chunks="+maxChunksToSorted(arr));

    }
}
