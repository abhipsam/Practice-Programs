import java.util.*;

public class ReconstructItenaryLeetCode {
    static HashMap<String,PriorityQueue<String>> hashMap = new HashMap<>();
   static  LinkedList<String> resultlist = new LinkedList<>();
    public static List<String> findItinerary(String[][] tickets) {

        int n = tickets.length;

        if(n==0 || tickets==null){
            return resultlist;
        }

        for(String[] ticket : tickets){
            PriorityQueue<String> queue;
            if(!hashMap.containsKey(ticket[0])){
                queue = new PriorityQueue<>();
                queue.add(ticket[1]);
            }else{
                queue = hashMap.get(ticket[0]);
                queue.add(ticket[1]);
            }
            hashMap.put(ticket[0],queue);
        }
        findItineraryHelper("JFK");

        return resultlist;
    }

    public static void findItineraryHelper(String string){

        PriorityQueue<String> queue = hashMap.get(string);

        while(queue!=null && !queue.isEmpty()){
            findItineraryHelper(queue.poll());
        }

        resultlist.addFirst(string);

    }

    public static void main(String args[]){
        String[][] strings = {{"JFK","SFO"},{"JFK","ATL"},{"SFO","ATL"},{"ATL","JFK"},{"ATL","SFO"}};
        List<String> resultList = findItinerary(strings);

        for(String string: resultList){
            System.out.print(string+" ");
        }
    }
}
