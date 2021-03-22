package x.y.z;

import java.util.LinkedList;
import java.util.Queue;

public class LeetCode_0111 {
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int depth = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node.left == null && node.right == null) {
                    return depth;
                }
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            depth++;
        }
        return depth;
    }

    public int minDepth_recursion(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right != null) {
            return 1 + minDepth_recursion(root.right);
        }
        if (root.right == null && root.left != null) {
            return 1 + minDepth_recursion(root.left);
        }
        return 1 + Math.min(minDepth_recursion(root.left), minDepth_recursion(root.right));
    }
}
