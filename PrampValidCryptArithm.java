import java.util.HashMap;

public class PrampValidCryptArithm {
    static boolean isCryptSolution(String[] crypt, char[][] solution) {

        if(solution==null || crypt==null){
            return false;
        }

        if(crypt.length<3){
            return false;
        }

        HashMap<Character,Character> hashMap = new HashMap<>();

        for(int i=0;i<solution.length;i++){
            for(int j=0;j<2;j++){
                hashMap.put(solution[i][0],solution[i][1]);
            }
        }

        StringBuilder stringBuilder = new StringBuilder();
        String w1 = " ";
        String w2=  " ";
        String w3=  " ";


            String word1 = crypt[0];
            String word2 = crypt[1];
            String word3 = crypt[2];

            for(int i1=0;i1<word1.length();i1++){
                if(!hashMap.containsKey(word1.charAt(i1))){
                   return false;
                }
                stringBuilder.append(hashMap.get(word1.charAt(i1)));
            }

            w1=stringBuilder.toString();
            stringBuilder=new StringBuilder();

        for(int i1=0;i1<word2.length();i1++){
            if(!hashMap.containsKey(word2.charAt(i1))){
                return false;
            }
            stringBuilder.append(hashMap.get(word2.charAt(i1)));
        }

        w2=stringBuilder.toString();

        stringBuilder=new StringBuilder();

        for(int i1=0;i1<word3.length();i1++){
            if(!hashMap.containsKey(word3.charAt(i1))){
                return false;
            }
            stringBuilder.append(hashMap.get(word3.charAt(i1)));
        }
        w3=stringBuilder.toString();

        if(w1.charAt(0)=='0' && w2.charAt(0)=='0' && w3.charAt(0)!='0'){
            return false;
        }

        if(word1.length()>Integer.valueOf(w1).toString().length() || word2.length()>Integer.valueOf(w2).toString().length()){
            return false;
        }
        if(Integer.valueOf(w1)+Integer.valueOf(w2)==Integer.valueOf(w3)){
            return true;
        }

        return false;
    }

    public static void main(String args[]){
        String[] crypt ={"AA",
                "AA",
                "AA"};
        char[][] solution= {{'A','0'}};

        System.out.print(isCryptSolution(crypt,solution));
    }
}
