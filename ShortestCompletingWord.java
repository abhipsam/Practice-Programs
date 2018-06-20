import java.util.HashMap;

public class ShortestCompletingWord {
    public static HashMap<Character,Integer> integerHashMap = new HashMap<>();

    public static class Result{
        int len;
        String res;

        public Result(int len, String res){
            this.len=len;
            this.res=res;
        }
    }
    public static void fillHashMap(HashMap<Character,Integer> hashMap,String temp){
        for(int i =0;i<temp.length();i++){
            if(!hashMap.containsKey(temp.charAt(i))){
                hashMap.put(temp.charAt(i),1);
            }else{
                Character x = temp.charAt(i);
                hashMap.put(x,hashMap.get(x)+1);
            }
        }
    }

    public static boolean isHashMapEmpty(HashMap<Character,Integer> hashMap){
        for ( Character character:hashMap.keySet()){
            if(!(integerHashMap.containsKey(character)) && !(character.toString().equals(" "))){
                if(!(hashMap.get(character)<=0)){
                    return false;
                }
            }
        }
        return true;
    }
    public static String shortestCompletingWord(String licensePlate, String[] words) {
        for (int j = 0; j <= 9; j++) {
            integerHashMap.put(Integer.toString(j).charAt(0), 1);
        }
        Result res = new Result(Integer.MAX_VALUE,"");

        HashMap<Character, Integer> hashMap = new HashMap<>();
        String temp = licensePlate.toLowerCase();

      //  HashMap<Character,Integer> hashMap1 = new HashMap<>();

        for(String word:words){
            fillHashMap(hashMap,temp);
            String temp2=word.toLowerCase();
            for(int i=0;i<temp2.length();i++){
               if(hashMap.containsKey(temp2.charAt(i))){
                   Integer x =hashMap.get(temp2.charAt(i));
                   x=x-1;
                   hashMap.put(temp2.charAt(i),x);
               }
            }
            if(isHashMapEmpty(hashMap)){
                if(res!=null) {
                    if(word.length()<res.len){
                        res=new Result(word.length(),word);
                    }
                }
            }
            hashMap.clear();
        }
        return res.res;
    }

    public static void main(String args[]){
        String licensePlate = "GrC8950" ;
        String [] words2= {"measure","other","every","base","according","level","meeting","none","marriage","rest"};
        String[] words1 = {"looks", "pest", "stew", "show"};
        String[] words = {"step", "steps", "stripe", "stepple"};

        System.out.println(shortestCompletingWord(licensePlate,words2));
    }
}
