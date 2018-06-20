import java.util.Stack;

public class LeetCodeTemperatures {
    public static int[] dailyTemperatures(int[] temperatures) {
        int[] result = new int[temperatures.length];

        if(temperatures==null){
            return result;
        }

        int n = temperatures.length;

        Stack<Integer> stack= new Stack<>();
        int sum=0;
        result[n-1]=0;
        stack.push(temperatures[n-1]);
        if(stack.add(0))
        for(int i = n-3;i>=0;i-- ){
                   while(temperatures[i]>stack.peek()){
                       sum=sum+1;
                       stack.pop();
                   }
               result[i]=sum+1;
              stack.push(temperatures[i]);

        }

        return result;
    }

    public static void main(String args[]){
        int[] nums= {73,74,75,71,69,72,76,73};
        int[] res = dailyTemperatures(nums);

        for(int i=0;i<res.length;i++){
           System.out.print(res[i]+" ");
        }
    }
}
