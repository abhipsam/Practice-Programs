import java.util.HashMap;
import java.util.Stack;

public class BalancedString {
    public static String isBalanced(String s){
        HashMap<Character,Character> hashMap = new HashMap<>();
        hashMap.put('{','}');
        hashMap.put('(',')');
        hashMap.put('[',']');

        Stack<Character> stack= new Stack<>();

        for(int i=0;i<s.length();i++){
            if((s.charAt(i)=='{') || (s.charAt(i)=='(')|| (s.charAt(i)=='[')){
               stack.push(s.charAt(i));
            }
            else {
                if (!stack.empty()) {
                    Character x = stack.pop();
                    if (hashMap.get(x) != s.charAt(i)) {
                        return "NO";
                    }
                }else{
                    return "NO";
                }
            }
        }
        if(!stack.empty()){
            return "NO";
        }
        return "YES";
    }

    public static void main(String args[]){
        String s ="([][{[()]}]{})}()})}{{}}{})]()(){}}(()({()}[([](){[]()}[])])[])[])][{[{[]}]{}([])}]()(()))}){([{}])}[(([]){[]{}})]{}({}{})}){}({{}([][](){{[][{()([[{}()]]{()}{{}{[()]}})[()[]{}](){[{}()[]][{{}}{[{}][]()}[]](())[[][]][]()}}[({}([[{([]){}}]()([()(){}]){([()]())}]";
        String x="((()))[]{[(()({[()({[]}{})]}))]}{[]}{{({}{})[{}{}]{()([()])[{()}()[[]{}()]{}{}[]()]}[[]{[]}([])]}}";
        System.out.println(isBalanced(x));
    }
}
