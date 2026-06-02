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
    List<Integer> result = new ArrayList<>();
    public List<Integer> rightSideView(TreeNode root) {
        dfs(root, 0, false);
        return result;
    }

    private void dfs(TreeNode root, int height, boolean checkLeft) {
        if (root == null) {
            return;
        }
        if (result.size() == height) {
            result.add(height, root.val);
        }

        if (checkLeft) {
            dfs(root.left, height + 1, checkLeft);
            dfs(root.right, height + 1, checkLeft);
        } else {
            dfs(root.right, height + 1, checkLeft);
            dfs(root.left, height + 1, checkLeft);
        }
    }
}
