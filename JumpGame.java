import java.util.Stack;

public class JumpGame {
    public static boolean canJump(int[] nums) {
       int n=nums.length;

        Stack<Integer> stack=new Stack<>();

       if(n==0 || nums==null){
           return false;
       }

       if(n==1){
           return true;
       }

       boolean[] res=new boolean[n];
       res[0] = true;
      // int index=0;
       for(int i=0;i<n;i++){
          int index=i+nums[i];

          if(!stack.isEmpty()){
              int x = stack.peek();
              if(i<=x){
                  res[i]=true;
              }
              }

           if(index!=i && res[i] ) {
               if (!stack.isEmpty()) {
                 if(index>=stack.peek()){
                     stack.push(index);
                 }
               } else {
                   stack.push(index);
               }
           }

       }
       return res[n-1] ;
    }

    public static void main(String args[]){
        int[] arr ={4,3,4,10,0,7,5,5,1,0,5,7,7,9,6,7,3,10,8,2};
        int[] arr2={0,5,0,0};
        System.out.println(canJump(arr2));
    }
}
