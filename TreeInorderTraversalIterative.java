import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class TreeInorderTraversalIterative {
    //For iterative traversal, we always need to use stack

     // Definition for a binary tree node.
      public static class TreeNode {
          int val;
          TreeNode left;
          TreeNode right;
          TreeNode(int x) { val = x; }
      }

    public static List<Integer> inorderTraversal(TreeNode root) {
          List<Integer> resultList = new LinkedList<>();
       if(root==null){
           return resultList;
       }

       Stack<TreeNode> stack= new Stack<>();
       TreeNode curr=root;

       while(curr!=null){
           stack.push(curr);
           curr=curr.left;
       }

       while(stack.size()>0){
           curr = stack.pop();
           resultList.add(curr.val);
           if(curr.right!=null) {
               curr = curr.right;
               while (curr != null) {
                   stack.push(curr);
                   curr = curr.left;
               }
           }


       }
       return resultList;
    }

    public static void main(String args[]){
          TreeNode root = new TreeNode(1);
          root.left=new TreeNode(2);
          root.right=new TreeNode(3);
          root.left.left=new TreeNode(4);
          root.left.right=new TreeNode(5);
          root.left.right.left=new TreeNode(6);

          List<Integer> resultList=inorderTraversal(root);

          for(Integer x : resultList){
              System.out.print(x+" ");
          }
    }
}
