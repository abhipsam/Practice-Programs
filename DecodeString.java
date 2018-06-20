import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class DecodeString {

    public static String decodeString(String string) {
        StringBuilder stringBuilder = new StringBuilder();
        StringBuilder num = new StringBuilder();
        StringBuilder res = new StringBuilder();

        Stack<Object> stack = new Stack<>();
        HashMap<Character, Integer> hashMap = new HashMap<>();

        int i = 0;
        int n = string.length();
        int startBracket = 0;
        int endBracket = 0;

        for (int j = 0; j <= 9; j++) {
            hashMap.put(Integer.toString(j).charAt(0), 1);
        }
        int k = 0;
        for (i = 0; i < n; i++) {
            Character x = string.charAt(i);
            if(x!='[' && x!=']') {
                if (!hashMap.containsKey(x)) {
                    stringBuilder.append(x.toString());
                } else {
                    num.append(x.toString());
                }
            }
            if(string.charAt(i)=='['){
               if(!stringBuilder.toString().equals("")){
                   StringBuilder st=new StringBuilder(stringBuilder);
                   stack.add(st);
               }
               StringBuilder n1=new StringBuilder(num);
               stack.add(n1);
               stack.add('[');
               stringBuilder.delete(0,stringBuilder.length());
               num.delete(0,num.length());
            }

            if(string.charAt(i)==']'){
                StringBuilder again = new StringBuilder(stringBuilder);
                if(!stringBuilder.equals("")) {
                    stack.add(again);
                }
                StringBuilder sb1 = new StringBuilder();
                while(!stack.isEmpty() && !(stack.peek().equals('['))){
                    Object temp = stack.pop();
                    sb1.insert(0,temp);
                }
                if(!stack.isEmpty()) {
                    stack.pop();
                }
                StringBuilder sb2 = new StringBuilder();
                if (!stack.isEmpty()) {
                    Integer q = Integer.parseInt(stack.pop().toString());
                    for(int j=0;j<q;j++){
                        sb2.append(sb1);
                    }
                }
                stack.push(sb2.toString());
                stringBuilder.delete(0,stringBuilder.length());
            }

        }
        while(!stack.isEmpty()){
            res.insert(0,stack.pop());
        }
        res.append(stringBuilder);
        return res.toString();
    }
        public static void main(String args[]){
        String string = "3[a2[c]]";
        String res = decodeString(string);
        System.out.println(res);
        }
}
