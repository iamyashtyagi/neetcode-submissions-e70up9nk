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
    public List<Integer> inorderTraversal(TreeNode root) {
         List<Integer> result = new ArrayList();
        if(root == null){
            return result;
        }
        inorderTraversalHelp(root,result);
        return result;
    }

    void inorderTraversalHelp(TreeNode root,  List<Integer> result ){
        if(root == null){
            return;
        }
        inorderTraversalHelp(root.left,result);
        result.add(root.val);
        inorderTraversalHelp(root.right,result);
    }
}