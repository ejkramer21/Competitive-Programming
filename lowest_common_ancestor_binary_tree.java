/**
 *  * Definition for a binary tree node.
 *   * public class TreeNode {
 *    *     int val;
 *     *     TreeNode left;
 *      *     TreeNode right;
 *       *     TreeNode(int x) { val = x; }
 *        * }
 *         */
class Solution {
	    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		            /*
			     *
			     *         DFS on left,right,parent -> both found then return the node
			     *
			     *                 5,6-> f
			     *                         5,2,7->false
			     *                                 5,2,4->true
			     *                                         5,2->true
			     *                                                 5->true and found p and q so return
			     *
			     *                                                         5,6-f
			     *                                                                 5,2,7-f
			     *                                                                         5,2,4-f
			     *                                                                                 5,3,1,0-f
			     *                                                                                         5,3,1,8-t
			     *
			     *                                                                                                 */

		            if (root==null || root==p || root==q) return root;

					TreeNode l = lowestCommonAncestor(root.left,p,q);
					TreeNode r = lowestCommonAncestor(root.right,p,q);

					if(l==null) return r;
					else if (r==null) return l;
					return root;
				}
}
