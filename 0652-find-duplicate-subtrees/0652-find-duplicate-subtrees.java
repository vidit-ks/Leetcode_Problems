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
 class Solution{
HashMap<String, Integer> map = new HashMap<>();
    List<TreeNode> ans = new ArrayList<>();

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        dfs(root);
        return ans;
    }

    private String dfs(TreeNode root) {
        if (root == null) return "#";

        String serial = root.val + "," + dfs(root.left) + "," + dfs(root.right);

        int freq = map.getOrDefault(serial, 0);

        if (freq == 1)
            ans.add(root);

        map.put(serial, freq + 1);

        return serial;
    }
}