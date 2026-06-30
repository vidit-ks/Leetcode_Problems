class Solution {
    public int subarrayBitwiseORs(int[] arr) {
        java.util.Set<Integer> ans = new java.util.HashSet<>();
        java.util.Set<Integer> cur = new java.util.HashSet<>();

        for (int x : arr) {
            java.util.Set<Integer> next = new java.util.HashSet<>();
            next.add(x);

            for (int y : cur)
                next.add(y | x);

            cur = next;
            ans.addAll(cur);
        }

        return ans.size();
    }
}