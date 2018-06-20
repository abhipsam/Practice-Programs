import java.util.Stack;

public class EqualStacks {
    static int equalStacks(int[] h1, int[] h2, int[] h3) {
        /*
         * Write your code here.
         */
        int x = findSum(h1);
        int y = findSum(h2);
        int z = findSum(h3);

        if (x == y && y == z) {
            return x;
        }

        Stack<Integer> stack1=new Stack();
        Stack<Integer> stack2=new Stack();
        Stack<Integer> stack3=new Stack();

        populateStack(stack1,h1);
        populateStack(stack2,h2);
        populateStack(stack3,h3);

        int min = Math.min(x,Math.min(y,z));
       // int i=0,j=0,k=0;
        while(!stack1.empty() && !stack2.empty() && !stack3.empty()){
           while(x>min){
             x=x-stack1.pop();
             if(x<=min){
                 min=x;
             }
           }
            while(y>min){
                y=y-stack2.pop();
                if(y<=min){
                    min=y;
                }
            }
            while(z>min){
                z=z-stack3.pop();
                if(z<=min){
                    min=z;
                }
            }

            if(x==y && y==z){
               break;
            }
        }

        if(stack1.empty()|| stack2.empty() || stack3.empty()){
            return 0;
        }

        return min;
    }

    public static int findSum(int[] arr){
        int sum=0;
        for(int i=0;i<arr.length;i++){
          sum=sum+arr[i];
        }
        return sum;
    }
    public static void populateStack(Stack<Integer> stack,int[] arr){

        for(int i=arr.length-1;i>=0;i--){
            stack.push(arr[i]);
        }
    }

    public static void main(String args[]){
        int[] arr1={1,1,1};
        int[] arr2={3,2};
        int[] arr3={4,1};

        System.out.println("Equal Height="+equalStacks(arr1,arr2,arr3));
        }
    }
