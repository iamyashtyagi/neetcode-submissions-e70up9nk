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
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        return parseParent(root, subRoot);
    }

    private boolean parseParent(TreeNode root, TreeNode subRoot) {
        if (root == null) {
            return subRoot == null;
        }

        if (subRoot != null && root.val == subRoot.val) {
            boolean validate = validateNodes(root, subRoot);
            if (validate) {
                return true;
            }
        }

        return parseParent(root.left, subRoot) || parseParent(root.right, subRoot);
    }

    private boolean validateNodes(TreeNode a, TreeNode b) {
        if (a == null && b == null) return true;
        if (a == null || b == null) return false;

        if (a.val != b.val) return false;

        return validateNodes(a.left, b.left) && validateNodes(a.right, b.right);
    }
}
