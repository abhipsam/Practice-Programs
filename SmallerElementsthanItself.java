import java.util.*;

//This will be done by creating BST- Binary search tree - easiest emthod
public class SmallerElementsthanItself {
    static class TreeNode{
        TreeNode right;
        TreeNode left;
        int value;
        int count;

        public TreeNode(int data){
            this.value=data;
            this.right=null;
            this.left=null;
            this.count=1;
        }
    }
    public static List<Integer> countSmaller(int[] nums) {
        List<Integer> resultList=new LinkedList<>();
        int n=nums.length;

        if(n==0 || nums==null){
            return resultList;
        }

       TreeNode root = new TreeNode(nums[n-1]);
        resultList.add(0);

        for(int i=n-2;i>=0;i--){
            int count=insertNode(root,nums[i]);
            resultList.add(count);
        }

        Collections.reverse(resultList);


      return resultList;
    }

    public static int insertNode(TreeNode root, int value) {
        int smallCount = 0;

        while (true) {
            if (value <= root.value) {
                root.count = root.count + 1;

                if (root.left != null) {
                    root = root.left;
                } else {
                    TreeNode left = new TreeNode(value);
                    root.left = left;
                    break;
                }
            } else {
                smallCount = root.count+smallCount;
                if (root.right == null) {
                    TreeNode right = new TreeNode(value);
                    root.right = right;
                    break;

                } else {
                    root = root.right;
                }
            }
        }
        return smallCount;

    }


    public static void main(String args[]){
        int[] arr={26,78,27,100,33,67,90,23,66,5,38,7,35,23,52,22,83,51,98,69,81,32,78,28,94,13,2,97,3,76,99,51,9,21,84,66,65,36,100,41};
        int[] arr2={5,2,6,1};
        List<Integer> integerList = countSmaller(arr);
        for(Integer x : integerList){
            System.out.print(x+" ");
        }
    }
}
