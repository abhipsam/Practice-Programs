import java.util.Arrays;
import java.util.List;

public class ReplaceWords {
    public static String replaceWords(List<String> dict, String sentence) {
       int n= dict.size();

       if(n==0 || dict==null){
           return sentence;
       }
       if(sentence==null){
           return sentence;
       }
      // int min=Integer.MAX_VALUE;
       StringBuilder stringBuilder = new StringBuilder();

       String[] input= sentence.split(" ");

       for(int i=0;i<input.length;i++){
           String word=input[i];
           int min =Integer.MAX_VALUE;
           boolean isPresent=false;
           for(int j=0;j<dict.size();j++){
             String dictWord=dict.get(j);

             if(word.length()>=dictWord.length()) {
                 if (word.substring(0, dictWord.length()).equals(dictWord)) {
                     if (dictWord.length() < min) {
                         stringBuilder.append(dictWord + " ");
                         min = dictWord.length();
                     }

                     isPresent = true;
                 }
             }
           }
           if(!isPresent){
               stringBuilder.append(input[i]+" ");
           }
       }
       return stringBuilder.toString().trim();
    }

    public static void main(String args[]){
        String sentence= "a aa a aaaa aaa aaa aaa aaaaaa bbb baba ababa";
        List<String> dict= Arrays.asList("a", "aa", "aaa", "aaaa");


        System.out.println(replaceWords(dict,sentence));
    }
}
