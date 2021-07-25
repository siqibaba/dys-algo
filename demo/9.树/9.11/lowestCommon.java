/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode A, TreeNode B) {
          // write your code here
            if(root == null || root == A || root == B) {
                return root;
            }
            TreeNode left = lowestCommonAncestor(root.left, A, B);
            TreeNode right = lowestCommonAncestor(root.right, A, B);
            if (left != null && right != null) {
                return root;
            }
            if (left != null) {
                return left;
            }
            if (right != null) {
                return right;
            }
        
            return null;
        
    }
}
