public class LongestPalindromicSubstring {
    public static String longestPalindrome(String s) {
       int n= s.length();

       boolean[][] sol = new boolean[n][n];
       String longest = null;
       int maxLength = 1;

       for(int len = 0;len<s.length();len++){
           for(int i=0;i<n-len;i++){
               int j = i+len;
               if(s.charAt(i)==s.charAt(j) && (j-i<=2 || sol[i+1][j-1])){
                   sol[i][j]=true;

                   if(maxLength > j-i+1){
                       maxLength = j-i+1;
                       longest=s.substring(i,j+1);
                   }
               }

           }
       }
      return longest;
    }
}
