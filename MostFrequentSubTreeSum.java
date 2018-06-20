import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MostFrequentSubTreeSum {
    static public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }

  static HashMap<Integer, Integer> hashMap = new HashMap<>();

    public static int[] findFrequentTreeSum(TreeNode root) {
        if(root==null){
            return new int[hashMap.size()];
        }

        findFrequentHelper(root);

        int max=Integer.MIN_VALUE;

        for(Integer y : hashMap.values()){
            max=Math.max(max,y);
        }
        List<Integer> result = new ArrayList<>();
        for(Integer x : hashMap.keySet()){
         if(hashMap.get(x)==max){
           result.add(x);
         }
        }
        int[] res = new int[result.size()];
        for(int i=0;i<result.size();i++){
            res[i]=result.get(i);
        }

        return res;

    }

    public static int findFrequentHelper(TreeNode root){

        if(root==null){
            return 0;
        }
        int sum= root.val+findFrequentHelper(root.left)+findFrequentHelper(root.right);

        hashMap.put(sum,hashMap.containsKey(sum)?hashMap.get(sum)+1:1);
        return sum;
    }


    public static void main(String args[]){
        TreeNode root = new TreeNode(1);
        //root.left=new TreeNode(2);
       // root.right=new TreeNode(-5);

        int[] res = findFrequentTreeSum(root);

        for(int i=0;i<res.length;i++){
            System.out.println(res[i]);
        }
    }
}
