package x.y.z;

public class LeetCode_0124 {
    private int result = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        getMax(root);
        return result;
    }

    public int getMax(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = Math.max(0, getMax(root.left));
        int right = Math.max(0, getMax(root.right));
        result = Math.max(left + right + root.val, result);
        return Math.max(left, right) + root.val;
    }
}
