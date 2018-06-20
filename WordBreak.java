import java.util.Arrays;
import java.util.List;

//Find if the string S can be segmented into dictionary words
public class WordBreak {
    public static boolean wordBreak(String s, List<String> wordDict) {
        int n=s.length();
        if(n==0){
            return false;
        }

        boolean[] sol=new boolean[n+1];
        Arrays.fill(sol,false);

       sol[0]=true;
        for(int i=0;i<n;i++){
            if(sol[i]) {
                for (int j = i + 1; j <= n; j++) {
                    if (wordDict.contains(s.substring(i, j))) {
                       sol[j]=true;
                    }
                }
            }
        }
        return sol[n];
    }

    public static void main(String args[]){
        String s="a";
        List<String> words=Arrays.asList("a");

        System.out.println(wordBreak(s,words));
    }
}
