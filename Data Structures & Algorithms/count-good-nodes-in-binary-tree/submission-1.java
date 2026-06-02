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
    int res = 0;
    public int goodNodes(TreeNode root) {
        dfs(root, Integer.MIN_VALUE);
        return res;
    }

    private void dfs(TreeNode root, int max) {
        if (root == null)
            return;

        if (root.val >= max) {
            res = res + 1;
        }

        dfs(root.left, Math.max(max, root.val));
        dfs(root.right, Math.max(max, root.val));
    }
}
