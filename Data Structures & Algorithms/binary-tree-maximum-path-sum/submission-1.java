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
    int maxSum = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        maxPathSumHelper(root);
        return maxSum;
    }
    public int maxPathSumHelper(TreeNode root) {
        if(root == null){
            return 0;
        }
        int leftSum = maxPathSumHelper(root.left);
        int rightSum = maxPathSumHelper(root.right);
        int mySum = root.val + Math.max(leftSum, 0) + Math.max(rightSum, 0);
        maxSum = Math.max(mySum,maxSum);
        return Math.max(Math.max(leftSum,rightSum)+root.val,root.val);
    }

}
