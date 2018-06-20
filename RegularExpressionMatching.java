public class RegularExpressionMatching {
    public static boolean isMatch(String s, String p) {
      int n = s.length();
      int m = p.length();
        if(n==0 && m==0){
            return true;
        }
        if(n==0 || m==0){
            return false;
        }
      int i=0,j=0;
      int starIndex=-1;
      int iIndex=-1;

      while(i<n){
         if(j<m && (s.charAt(i)==p.charAt(j) || p.charAt(j)=='.')){
             i++;
             j++;
         }else if(p.charAt(j)=='*'){
             starIndex=j;
             iIndex=i;
         }else if(starIndex!=-1){
             j=starIndex+1;
             i=iIndex+1;
             iIndex++;
         }else{
             return false;
         }
      }
      if(j<m && p.charAt(j)=='*'){
          j++;
      }

      return j==p.length();
    }

    public static void main(String args[]){
        String s="aa";
        String p="*";
        System.out.println(isMatch(s,p));
    }
}
