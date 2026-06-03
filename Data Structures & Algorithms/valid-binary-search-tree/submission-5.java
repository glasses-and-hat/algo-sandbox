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
    public boolean isValidBST(TreeNode root) {
        if (root == null)
            return true;

        Queue<Object[]> q = new LinkedList<>();
        q.offer(new Object[] {root, Integer.MIN_VALUE, Integer.MAX_VALUE});

        while (!q.isEmpty()) {
            Object[] ob = q.poll();
            TreeNode node = (TreeNode) ob[0];
            int left = (Integer) ob[1];
            int right = (Integer) ob[2];

            if (!(left < node.val) || !(node.val < right)) {
                return false;
            }

            if (node.left != null) {
                q.offer(new Object[] {node.left, left, node.val});
            }
            if (node.right != null) {
                q.offer(new Object[] {node.right, node.val, right});
            }
        }
        return true;
    }
}
