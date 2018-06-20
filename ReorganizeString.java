import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;

public class ReorganizeString {
    static class Frequent{
        Character character;
        Integer freq;

        public Frequent(Character ch, int count){
            this.character=ch;
            this.freq=count;
        }
    }
    public static String reorganizeString(String S) {
       int n = S.length();
       if(n==0 || S==null){
           return " ";
       }
       StringBuilder stringBuilder = new StringBuilder();

        PriorityQueue<Frequent> priorityQueue = new PriorityQueue<>(new Comparator<Frequent>() {
            @Override
            public int compare(Frequent o1, Frequent o2) {
                return o2.freq.compareTo(o1.freq);
            }
        });
        HashMap<Character,Integer> hashMap = new HashMap<>();

        for(int i=0;i<n;i++){
         if(!hashMap.containsKey(S.charAt(i))){
             hashMap.put(S.charAt(i),1);
         }else{
             hashMap.put(S.charAt(i),hashMap.get(S.charAt(i))+1);
         }
        }

        for(Character x: hashMap.keySet()){
            Frequent frequent = new Frequent(x,hashMap.get(x));
            priorityQueue.add(frequent);
        }

        Frequent prev=null;

        while(!priorityQueue.isEmpty()){
            Frequent frequent = priorityQueue.remove();

            stringBuilder.append(frequent.character);

            if(prev!=null && prev.freq>0){
                priorityQueue.add(prev);
            }
            frequent.freq--;
            prev=frequent;
        }

        if(n!=stringBuilder.length()){
            return  " ";
        }
       return stringBuilder.toString();
    }

    public static void main(String args[]){
        String S ="abb";
        System.out.println(reorganizeString(S));
    }
}
