import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


//Return the set of complete sentences that can be formed from breaking a string into dictionary words
public class WordBreak2 {
    public static List<String> wordBreak(String s, List<String> wordDict) {
        int n=s.length();

        List<String> resultList=new ArrayList<>();
        if(n==0){
            return resultList;
        }
        List<String>[] sol=new List[n+1];
        sol[0]=new ArrayList<>();
      //Putting down all words

        for(int i=0;i<n;i++){
            if(sol[i]!=null) {
                for (int j = i + 1; j <= n; j++) {
                   String k=s.substring(i,j);
                   if(wordDict.contains(k)){
                     if(sol[j]==null){
                         List<String> res=new ArrayList<>();
                         res.add(k);
                         sol[j]=res;
                     }else{
                         sol[j].add(k);
                     }
                    // sol[j]=res;
                   }
                }
            }
        }

        //Construct Word list from the array
        if(sol[n]==null){
            return resultList;
        }
        constructList(sol,resultList,"",n);
        return resultList;

    }

    public static void constructList(List<String>[] temp, List<String> resultList, String curr, int i){
        if(i==0){
            resultList.add(curr.trim());
            return;
        }

            for(String string:temp[i]){
                String res=string+" "+curr;
                constructList(temp,resultList,res,i-string.length());
            }
    }

    public static void main(String args[]){
        String s = "catsanddog";
        List<String> dict = Arrays.asList("cat", "cats", "and", "sand", "dog");

        List<String> resultList= wordBreak(s,dict);

        for(String res:resultList){
            System.out.println(res);
        }
    }

    }

