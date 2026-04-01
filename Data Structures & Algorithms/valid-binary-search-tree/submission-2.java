/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    public boolean isValidBST(TreeNode root) {
        if(root == null){
            return true;
        }

        return true && isValidBST(root.left,-1001, root.val) && isValidBST(root.right,root.val, 1001);
    }

    public boolean isValidBST(TreeNode root, int left, int right) {
        if(root == null){
            return true;
        }
        if(root.val < right && root.val >left){
            return isValidBST(root.left,left, root.val) && isValidBST(root.right,root.val, right);
        }
        return false;
    }
}
