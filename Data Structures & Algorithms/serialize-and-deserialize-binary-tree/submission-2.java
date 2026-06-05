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

public class Codec {
    private static final String NULL = "N";
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        // dfs preOrderTrev
        List<String> list = new ArrayList<>();
        serialize(root, list);
        return String.join(",", list);
    }

    private void serialize(TreeNode root, List<String> list) {
        if (root == null) {
            list.add(NULL);
            return;
        }
        list.add("" + root.val);
        serialize(root.left, list);
        serialize(root.right, list);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] arr = data.split(",");
        int[] i = {0};
        return deserialize(arr, i);
    }

    private TreeNode deserialize(String[] arr, int[] i) {
        if (arr[i[0]].equals(NULL)) {
            i[0]++;
            return null;
        }
        TreeNode node = new TreeNode(Integer.parseInt(arr[i[0]++]));
        node.left = deserialize(arr, i);
        node.right = deserialize(arr, i);
        return node;
    }
}
