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
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList();
        if(root!=null)
        queue.add(root);
        List<List<Integer>> level = new ArrayList();
        while(!queue.isEmpty()){
            int size = queue.size();
            List<Integer> temp = new ArrayList();
            while(size>0){
                TreeNode node = queue.poll();
                temp.add(node.val);
                if(node.left!=null)
                queue.add(node.left);
                if(node.right!=null)
                queue.add(node.right);
                size--;
            }
            level.add(temp);

        }
        return level;
    }
}
