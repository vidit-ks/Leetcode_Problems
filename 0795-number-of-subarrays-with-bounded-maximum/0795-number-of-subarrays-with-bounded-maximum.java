class Solution {
    public int numSubarrayBoundedMax(int[] nums, int left, int right) {
        return count(nums, right) - count(nums, left - 1);
    }

    private int count(int[] nums, int bound) {
        int ans = 0, cur = 0;
        for (int x : nums) {
            if (x <= bound) {
                cur++;
            } else {
                cur = 0;
            }
            ans += cur;
        }
        return ans;
    }
}