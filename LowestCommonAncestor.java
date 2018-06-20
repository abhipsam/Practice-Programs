public class LowestCommonAncestor {

    public static class TreeNode {
    int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null){
            return  root;
        }

        if(root==p || root==q){
            return root;
        }


        TreeNode left=lowestCommonAncestor(root.left,p,q);
        TreeNode right = lowestCommonAncestor(root.right,p,q);

        if(left!=null && right!=null){
            return root;
        }

        return (left!=null?left:right);
    }

    //For a Binary Search Tree

    public TreeNode lowestCommonAncestorBST(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null){
            return  root;
        }

        if(root==p || root==q){
            return root;
        }

          if(p.val > root.val && q.val>root.val){
            return lowestCommonAncestorBST(root.right,p,q);
          }
          else if(p.val<root.val && q.val<root.val){
            return lowestCommonAncestorBST(root.left,p,q);
          }else{
            return root;
          }

    }
}
