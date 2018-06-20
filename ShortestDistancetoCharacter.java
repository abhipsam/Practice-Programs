import java.util.Stack;

public class ShortestDistancetoCharacter {
    public static int[] shortestToChar(String S, char C) {
        int n=S.length();
        int[] result = new int[n];
        if(n==0 || S==null){
            return result;
        }

        if(C==' '){
            return result;
        }

        int prev=-1;
        int curr=-1;

        Stack<Integer> stack= new Stack<>();

        for(int i=0;i<n;i++){
            if(S.charAt(i)!=C){
                stack.push(i);
            }else{
                prev=curr;
                curr=i;
                result[curr]=0;
                while(!stack.empty()){
                    int diff1=Integer.MAX_VALUE;
                    int diff2=Integer.MAX_VALUE;
                    int x = stack.pop();
                  if(prev!=-1){
                     diff1=Math.abs(prev-x);
                  }
                  diff2=Math.abs(curr-x);

                  result[x] = Math.min(diff1,diff2);
                }
            }
        }

        while(!stack.empty()){
            int x = stack.pop();
            result[x] = Math.abs(curr-x);
        }

       return result;
    }

    public static void main(String args[]){
        String S="abaa";
        Character C='b';

        int[] res = shortestToChar(S,C);

        for(int i=0;i<res.length;i++){
            System.out.print(res[i]+" ");
        }
    }
}
