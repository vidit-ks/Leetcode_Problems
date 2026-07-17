class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<>();
        backtrack(s, 0, 0, new StringBuilder(), result);
        return result;
    }

    private void backtrack(String s, int index, int parts, StringBuilder current, List<String> result) {
        if (parts == 4 && index == s.length()) {
            result.add(current.toString());
            return;
        }

        if (parts == 4 || index == s.length()) {
            return;
        }

        int len = current.length();

        for (int i = 1; i <= 3 && index + i <= s.length(); i++) {
            String segment = s.substring(index, index + i);

            // Leading zero check
            if (segment.length() > 1 && segment.charAt(0) == '0') {
                break;
            }

            int value = Integer.parseInt(segment);
            if (value > 255) {
                continue;
            }

            if (len != 0) {
                current.append('.');
            }
            current.append(segment);

            backtrack(s, index + i, parts + 1, current, result);

            current.setLength(len); // Backtrack
        }
    }
}