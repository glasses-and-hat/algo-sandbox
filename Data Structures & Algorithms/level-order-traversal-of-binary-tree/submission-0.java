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
    List<List<Integer>> list = new ArrayList<>();
    public List<List<Integer>> levelOrder(TreeNode root) {
        buildList(root, 0);
        return list;
    }

    private void buildList(TreeNode root, int height) {
        if (root == null) {
            return;
        }

        if (list.size() == height) {
            list.add(height, new ArrayList<Integer>());
        }

        list.get(height).add(root.val);

        buildList(root.left, height + 1);
        buildList(root.right, height + 1);
    }
}
