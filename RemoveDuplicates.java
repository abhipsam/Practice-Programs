import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Stack;

public class RemoveDuplicates {
    public static String removeDuplicateLetters(String s) {
        if (s == null) {
            return s;
        }

        int n = s.length();
        Stack<Character> stack = new Stack<>();
        int[] count = new int[26];

        for(int i=0;i<s.length();i++){
            count[s.charAt(i)-'a']++;
        }
        boolean[] visited = new boolean[26];
        Arrays.fill(visited,false);

        for (int i = 0; i < n; i++) {
            Character x = s.charAt(i);
            count[x - 'a']--;

            if (visited[x - 'a']) {
                continue;
            }
            while (!stack.empty() && x < stack.peek() && count[stack.peek() - 'a'] > 0) {
                Character p = stack.pop();
                visited[p - 'a'] = false;
            }

            stack.push(x);
            visited[x - 'a'] = true;
        }

        StringBuilder stringBuilder = new StringBuilder();
        for(Character x:stack){
            stringBuilder.append(x);
        }
        return stringBuilder.toString();

    }

    public static void main(String args[]){
        String x="bcacdcbc";
        System.out.println(removeDuplicateLetters(x));
    }
}
