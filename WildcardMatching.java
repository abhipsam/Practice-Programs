public class WildcardMatching {
    public static boolean isMatch(String s, String p) {
       int n=s.length();
       int m=p.length();

       if(n==0 && m==0){
           return true;
       }
       if(n==0 || m==0){
           return false;
       }

       return match(s,p,0,0);
    }

       public static boolean match(String s1, String s2, int i, int j){
        if(i==s1.length() && j==s2.length()){
            return true;
        }
        if(j==s2.length() && i!=s1.length()){
            return false;
        }
        if(s2.charAt(j)=='*' && j==s2.length() && i==s1.length()){
               return true;
           }
           if(s2.charAt(j)=='*' && j!=s2.length() && i==s1.length()){
               return true;
           }
           if(s2.charAt(j)=='*' && j+1==s2.length() && i==s1.length()){
               return false;
           }
        else if(s1.charAt(i)==s2.charAt(j)){
            return match(s1,s2,i+1,j+1);
        }

        else if(s2.charAt(j)=='?'){
            return match(s1,s2,i+1,j+1);
        }

        else if (s2.charAt(j)=='*'){
            if(i<s1.length()) {
                return match(s1, s2, i + 1, j + 1) || match(s1, s2, i + 1, j);
            }else{
                return match(s1,s2,i,j+1);
            }
        }

        else{
            return false;
        }
       }

       public static void main(String args[]){
        String s1="a";
        String s2="a*";

        System.out.println(isMatch(s1,s2));

       }


}
