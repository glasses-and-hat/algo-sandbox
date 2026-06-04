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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0 || inorder.length == 0)
            return null;
        TreeNode root = new TreeNode(preorder[0]);
        int m = -1;
        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == preorder[0]) {
                m = i;
                break;
            }
        }
        root.left =
            buildTree(Arrays.copyOfRange(preorder, 1, m + 1), Arrays.copyOfRange(inorder, 0, m));
        root.right = buildTree(Arrays.copyOfRange(preorder, m + 1, preorder.length),
            Arrays.copyOfRange(inorder, m + 1, inorder.length));
        return root;
    }
}
