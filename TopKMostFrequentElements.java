import java.util.*;

public class TopKMostFrequentElements {
    public static List<Integer> topKFrequent(int[] nums, int k) {
         List<Integer> resultList = new LinkedList<>();
         int n=nums.length;

         if(n==0 || nums==null){
             return resultList;
         }

        HashMap<Integer,Integer> hashMap = new HashMap<>();

        for(int i=0;i<n;i++){
           if(!hashMap.containsKey(nums[i])){
               hashMap.put(nums[i],1);
           }else{
               hashMap.put(nums[i],hashMap.get(nums[i])+1);
           }
        }

        int max =Integer.MIN_VALUE;

        for(Integer x : hashMap.keySet()){
            max=Math.max(max,x);
        }
        ArrayList<Integer> [] count = new ArrayList[max+1];
           int m=hashMap.keySet().size()+1;

           if(max<0){
               for (int i = 1; i <= max+m; i++) {
                   count[i] = new ArrayList<Integer>();
               }
           }else {
               for (int i = 1; i <= max; i++) {
                   count[i] = new ArrayList<Integer>();
               }
           }

        for( Map.Entry<Integer,Integer> entry : hashMap.entrySet()){
           int x = entry.getKey();
           int y = entry.getValue();

           if(max<0){
              x=m+x;
           }
           count[x].add(y);
        }

        for(int j=max;j>=1;j--){
            if(count[j].size()>0) {
                for (int x : count[j]) {
                    resultList.add(x);
                    if (resultList.size()==k) {
                        return resultList;
                    }
                }
            }
        }
        return resultList;
    }

    public static void main(String args[]){
        int[] arr ={-1,-1};
        int k=1;

        List<Integer> resultList= topKFrequent(arr,k);

        for(Integer x : resultList){
            System.out.print(x+" ");
        }
    }
}
