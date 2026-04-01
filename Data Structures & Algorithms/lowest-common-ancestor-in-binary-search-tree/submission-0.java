class Solution {
    List<TreeNode> pPath;
    List<TreeNode> qPath;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        pPath = new ArrayList<>();
        qPath = new ArrayList<>();

        findPath(root, p, new ArrayList<>(), pPath);
        findPath(root, q, new ArrayList<>(), qPath);

        int i = 0;
        TreeNode lca = null;
        while (i < pPath.size() && i < qPath.size()) {
            if (pPath.get(i) == qPath.get(i)) {
                lca = pPath.get(i);
            } else {
                break;
            }
            i++;
        }
        return lca;
    }

    // returns true if target found in this subtree; finalPath is filled with the path (root -> target)
    public void findPath(TreeNode root, TreeNode target, List<TreeNode> currentPath, List<TreeNode> finalPath) {
        if (root == null) return ;

        currentPath.add(root);

        if (root == target || root.val == target.val) {
            finalPath.clear();
            finalPath.addAll(currentPath);
            return ;
        }
        findPath(root.left,target,currentPath,finalPath);
        findPath(root.right,target,currentPath,finalPath);
        currentPath.remove(currentPath.size() - 1);
        return ;
    }
}