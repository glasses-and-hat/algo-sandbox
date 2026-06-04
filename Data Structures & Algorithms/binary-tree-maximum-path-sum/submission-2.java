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
    Integer res = null;
    public int maxPathSum(TreeNode root) {
        this.res = root.val;
        dfs(root);
        return res;
    }

    private int dfs(TreeNode root) {
        if (root == null)
            return 0;

        int left = Math.max(dfs(root.left), 0);
        int right = Math.max(dfs(root.right), 0);

        this.res = Math.max(this.res, left + root.val + right);
        return root.val + Math.max(left, right);
    }
}
