import java.util.Stack;

public class AbsolutePathUnixFile {
    public static String simplifyPath(String path) {
        if(path==null){
            return path;
        }
        Stack<String> stack = new Stack<>();

        int n = path.length();

        StringBuilder stringBuilder = new StringBuilder();
        Character prev=null;
        for(int i=0;i<n;i++){

            if(path.charAt(i)=='.'){
                if(!stringBuilder.toString().equals("")) {
                    stack.push(stringBuilder.toString());
                    stringBuilder = new StringBuilder();
                }
            }
            else if(path.charAt(i)=='/' && prev!=null && prev=='/'){
                continue;
            }else {
                stringBuilder.append(path.charAt(i));
            }
            prev=path.charAt(i);
        }
        if(!stringBuilder.toString().equals("")){
                stack.push(stringBuilder.toString());
        }

        String result= stack.pop();
        return (result.length()==1?result:result.substring(0,result.length()-1));

    }

    public static void main(String args[]){
        String x = "/.";

        System.out.println(simplifyPath(x));
    }
}
