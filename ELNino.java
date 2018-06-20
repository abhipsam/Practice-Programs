import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;


public class ELNino {
    public static class TreeNode{
       int data;
       TreeNode child;

       public TreeNode(int data){
           this.data=data;
           this.child=null;
       }

    }
    public static int findTriplets(int num,int[] arr, int[] distance, int[] parent){
        List<List<Integer>> lists = new ArrayList<>();
        HashSet<Integer> hashSet = new HashSet<>();

        for(int i=0;i<distance.length;i++){
            hashSet.add(distance[i]);
        }
        HashMap<Integer,Integer> hashMap = new HashMap<>();
        for(int i=0;i<arr.length;i++){
            hashMap.put(arr[i],i);
        }
        TreeNode root = new TreeNode(1);
        for(int i=0;i<=parent.length-1;i++){
            TreeNode child = new TreeNode(parent[i]+1);
            root.child=child;
            root=root.child;
        }

        TreeNode curr= root;
        while(curr!=null){

        }
        for(int i=0;i<parent.length;i++){
            dfs(parent[i],parent[i],arr,lists,hashSet,hashMap,-1);
        }
        return lists.size();
    }

    public static void dfs(int i, int parent, int[] arr, List<List<Integer>> resultList, HashSet<Integer> distance, HashMap<Integer,Integer> hashMap, int dist){

        if(dist!=-1 && !distance.contains(dist)){
            return;
        }

        for(int k=0;k<arr.length;k++){
            if(arr[k]==i && hashMap.containsKey(i+1)){
                int d=Math.abs(hashMap.get(parent) - hashMap.get(i + 1));
                if(distance.contains(d)){
                    List<Integer> temp = new ArrayList<>();
                    temp.add(parent);
                    temp.add(i+1);
                    temp.add(d);
                    resultList.add(temp);
                }
                dfs(i+1,parent,arr,resultList,distance,hashMap,d);
            }
        }
    }

    public static void main(String args[]){
        int[] arr = {1,2,3,4,5};
        int[] distance ={1,2,3};
        int[] parent={1,2,3,4};

       // System.out.println(findTriplets(arr,distance,parent));
    }
}
