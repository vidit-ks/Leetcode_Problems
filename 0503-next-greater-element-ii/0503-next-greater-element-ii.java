class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        Arrays.fill(ans, -1);

        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < 2 * n; i++) {
            int idx = i % n;

            while (!stack.isEmpty() && nums[stack.peek()] < nums[idx]) {
                ans[stack.pop()] = nums[idx];
            }

            // Only push indices during the first pass
            if (i < n) {
                stack.push(idx);
            }
        }

        return ans;
    }
}