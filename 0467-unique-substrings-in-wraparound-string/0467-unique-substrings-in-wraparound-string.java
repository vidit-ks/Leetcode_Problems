class Solution {
    public int findSubstringInWraproundString(String s) {
        int[] dp = new int[26];
        int k = 0;

        for (int i = 0; i < s.length(); i++) {
            if (i > 0 && (s.charAt(i) - s.charAt(i - 1) + 26) % 26 == 1) {
                k++;
            } else {
                k = 1;
            }
            int idx = s.charAt(i) - 'a';
            dp[idx] = Math.max(dp[idx], k);
        }

        int ans = 0;
        for (int x : dp) ans += x;
        return ans;
    }
}