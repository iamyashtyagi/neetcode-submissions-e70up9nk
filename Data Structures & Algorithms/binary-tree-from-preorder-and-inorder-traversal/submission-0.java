class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            hm.put(inorder[i], i);
        }
        return buildTreeHelper(
            preorder, 0, preorder.length - 1,
            inorder, 0, inorder.length - 1,
            hm
        );
    }

    private TreeNode buildTreeHelper(
        int[] preorder, int px, int py,
        int[] inorder, int ix, int iy,
        HashMap<Integer, Integer> hm
    ) {
        if (px > py || ix > iy) return null;

        int rootVal = preorder[px];
        TreeNode root = new TreeNode(rootVal);

        int idx = hm.get(rootVal);
        int leftSize = idx - ix;

        root.left = buildTreeHelper(
            preorder,
            px + 1,
            px + leftSize,
            inorder,
            ix,
            idx - 1,
            hm
        );

        root.right = buildTreeHelper(
            preorder,
            px + leftSize + 1,
            py,
            inorder,
            idx + 1,
            iy,
            hm
        );

        return root;
    }
}
