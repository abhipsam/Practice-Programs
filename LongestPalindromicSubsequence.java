public class LongestPalindromicSubsequence {

    static public int longestPalindromeSubseq(String s) {
       int n = s.length();

       int[][] sol = new int[n][n];

        for (int len=0; len<n; len ++)
        {
            for (int i=0; i<n-len; i++)
            {
                int j = i+len;
                if (s.charAt(i) == s.charAt(j)){
                    if(j-i <=2){
                        sol[i][j] = j-i;
                    }else{
                        sol[i][j] = sol[i+1][j-1] + 2;
                    }
                }


                else
                    sol[i][j] = Math.max(sol[i][j-1], sol[i+1][j]);
            }
        }

        return sol[0][n-1];
    }



    public static void main(String args[]){
        String string = "BBABCBCAB";
        System.out.println(longestPalindromeSubseq(string));


    }
}
