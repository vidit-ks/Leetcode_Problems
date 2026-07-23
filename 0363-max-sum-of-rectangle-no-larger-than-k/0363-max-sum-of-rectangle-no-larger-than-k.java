class Solution {

    public int maxSumSubmatrix(int[][] matrix, int k) {

        int rows = matrix.length;
        int cols = matrix[0].length;

        int ans = Integer.MIN_VALUE;

        for (int left = 0; left < cols; left++) {

            int[] rowSum = new int[rows];

            for (int right = left; right < cols; right++) {

                for (int r = 0; r < rows; r++)
                    rowSum[r] += matrix[r][right];

                TreeSet<Integer> set = new TreeSet<>();

                set.add(0);

                int prefix = 0;

                for (int sum : rowSum) {

                    prefix += sum;

                    Integer ceil = set.ceiling(prefix - k);

                    if (ceil != null)
                        ans = Math.max(ans, prefix - ceil);

                    set.add(prefix);
                }
            }
        }

        return ans;
    }
}