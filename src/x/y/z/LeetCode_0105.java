package x.y.z;

import java.util.HashMap;
import java.util.Map;

public class LeetCode_0105 {
    private Map<Integer, Integer> cache = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n = inorder.length;
        for (int i = 0; i < n; i++) {
            cache.put(inorder[i], i);
        }
        return myBuildTree(preorder, inorder, 0, n - 1, 0, n - 1);
    }

    public TreeNode myBuildTree(int[] preorder, int[] inorder, int preorder_left, int preorder_right, int inorder_left, int inorder_right) {
        if (preorder_left > preorder_right) {
            return null;
        }
        int preorder_root = preorder_left;
        int inorder_root = cache.get(preorder[preorder_root]);
        int left_subtree_size = inorder_root - inorder_left;

        TreeNode root = new TreeNode(preorder[preorder_root]);
        root.left = myBuildTree(preorder, inorder, preorder_left + 1, preorder_left + left_subtree_size, inorder_left, inorder_root - 1);
        root.right = myBuildTree(preorder, inorder, preorder_left + left_subtree_size + 1, preorder_right, inorder_root + 1, inorder_right);
        return root;
    }
}
