class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        Set<String> set = new HashSet<>(wordDict);
        Map<Integer, List<String>> memo = new HashMap<>();
        return dfs(0, s, set, memo);
    }

    private List<String> dfs(int start, String s, Set<String> set, Map<Integer, List<String>> memo) {
        if (memo.containsKey(start))
            return memo.get(start);

        List<String> ans = new ArrayList<>();

        if (start == s.length()) {
            ans.add("");
            return ans;
        }

        for (int end = start + 1; end <= s.length(); end++) {
            String word = s.substring(start, end);

            if (set.contains(word)) {
                List<String> suffix = dfs(end, s, set, memo);

                for (String str : suffix) {
                    if (str.isEmpty())
                        ans.add(word);
                    else
                        ans.add(word + " " + str);
                }
            }
        }

        memo.put(start, ans);
        return ans;
    }
}