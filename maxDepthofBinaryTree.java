//import javax.swing.tree.TreeNode;


//Attempt 1 -> 0ms beat 100%
//tree traversal
 class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }

class maxDepthofBinaryTree {
    public int maxDepth(TreeNode root) {
        int max = 0;
        if(root ==  null) return max;

        max=preOrder(root, max);
        return max;


    }

    private int preOrder(TreeNode node, int cur) {
        if(node==null){
            return cur;
        }
        cur++;
        int ret1=preOrder(node.right, cur);

        int ret2=preOrder(node.left,cur);

        cur=Math.max(ret1, ret2);

        return cur;

    }
}