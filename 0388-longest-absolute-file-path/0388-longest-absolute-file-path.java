class Solution {
    public int lengthLongestPath(String input) {

        Stack<Integer> stack = new Stack<>();
        stack.push(0); // dummy length for root

        int max = 0;

        String[] lines = input.split("\n");

        for (String line : lines) {

            int level = line.lastIndexOf("\t") + 1;

            while (stack.size() > level + 1) {
                stack.pop();
            }

            int len = stack.peek() + line.length() - level + 1;

            if (line.contains(".")) {
                max = Math.max(max, len - 1);
            } else {
                stack.push(len);
            }
        }

        return max;
    }
}