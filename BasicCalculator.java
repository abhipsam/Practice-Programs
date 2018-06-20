import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BasicCalculator {
    public static int calculate(String s) {
        int n = s.length();

        if (n == 0 || s == null) {
            return 0;
        }

        Stack<String> stack = new Stack<>();
        Queue<String> queue = new LinkedList<>();
        boolean noOperator=false;
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == ' ') {
                continue;
            }
            if(s.charAt(i)=='/' || s.charAt(i)=='*' || s.charAt(i)=='+' || s.charAt(i)=='-'){
                queue.add(stringBuilder.toString());
                queue.add(Character.valueOf(s.charAt(i)).toString());
                stringBuilder=new StringBuilder();
                noOperator=true;
            }else {
                stringBuilder.append(s.charAt(i));
            }
        }

        queue.add(stringBuilder.toString());

        if(!noOperator){
            StringBuilder sb = new StringBuilder();
            for(String x: queue){
                sb.append(x);
            }
            return Integer.valueOf(sb.toString());
        }

        while (!queue.isEmpty()) {
            String curr = queue.poll();

            if (!curr.equals("*") && !curr.equals("/")) {
                stack.push(curr);
            } else {
                int x = Integer.valueOf(stack.pop());
                int y = Integer.valueOf(queue.poll());
                int z = -1;
                if (curr.equals("/")) {
                    z = x / y;
                } else if (curr.equals("*")) {
                    z = x * y;
                }
                stack.push(String.valueOf(z));
            }
        }

        queue.clear();
        for (String x : stack) {
            queue.add(x);
        }
        stack.clear();
        while (!queue.isEmpty()) {
            String chr = queue.poll();
            if (!chr.equals("+") && !chr.equals("-")) {
                stack.push(chr);
            } else {
                int x = Integer.valueOf(stack.pop());
                int y = Integer.valueOf(queue.poll());
                int z = -1;
                if (chr.equals("+")){
                    z = x + y;
                } else {
                    z = x - y;
                }
                stack.push(String.valueOf(z));
            }
        }

        return Integer.valueOf(stack.pop());
    }

    public static  void main(String args[]){
        String string = "0-2147483647";
        System.out.println(calculate(string));
    }
}
