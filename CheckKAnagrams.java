import java.util.Arrays;
import java.util.HashMap;

public class CheckKAnagrams {
    public static boolean checkKAnagrams(String string1, String string2, int k) {
        int str1 = string1.length();
        int str2 = string2.length();
        int diff=0;

        if (string1.length() != string2.length()) {
            return false;
        }
        int[] count = new int[26];
        Arrays.fill(count,0);


        for (int i = 0; i < str1; i++) {
            count[string1.charAt(i)-'a']++;
        }

        for(int j=0;j<str2;j++){
            if(count[string2.charAt(j)-'a']>0) {
                count[string2.charAt(j) - 'a']--;
            }else{
               diff++;
            }
        }


        /*for(int i=0;i<26;i++){
            diff=diff+count[i];
        }*/
        if(diff>k){
            return false;
        }
        return true;
    }

    public static void main(String args[]){
        String string1 = "anagram";
        String string2 = "grammar";

        if(checkKAnagrams(string1,string2,3)){
            System.out.println("K-anagrams");
        }else {
            System.out.println("Not K-anagrams");
        }

    }

}
