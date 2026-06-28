class Solution {
    int ans = 0;

    public int longestUnivaluePath(TreeNode root) {
        dfs(root);
        return ans;
    }

    int dfs(TreeNode r) {
        if (r == null) return 0;

        int l = dfs(r.left), rr = dfs(r.right);
        int a = 0, b = 0;

        if (r.left != null && r.left.val == r.val) a = l + 1;
        if (r.right != null && r.right.val == r.val) b = rr + 1;

        ans = Math.max(ans, a + b);
        return Math.max(a, b);
    }
}