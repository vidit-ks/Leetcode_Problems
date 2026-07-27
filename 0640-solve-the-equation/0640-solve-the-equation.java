class Solution {

    public String solveEquation(String equation) {

        String[] parts = equation.split("=");

        int[] left = parse(parts[0]);
        int[] right = parse(parts[1]);

        int coeff = left[0] - right[0];
        int constant = right[1] - left[1];

        if (coeff == 0) {
            if (constant == 0)
                return "Infinite solutions";
            return "No solution";
        }

        return "x=" + (constant / coeff);
    }

    private int[] parse(String s) {

        int coeff = 0;
        int constant = 0;

        int sign = 1;
        int i = 0;
        int n = s.length();

        while (i < n) {

            if (s.charAt(i) == '+') {
                sign = 1;
                i++;
            } else if (s.charAt(i) == '-') {
                sign = -1;
                i++;
            }

            int num = 0;
            boolean hasNum = false;

            while (i < n && Character.isDigit(s.charAt(i))) {
                num = num * 10 + (s.charAt(i) - '0');
                hasNum = true;
                i++;
            }

            if (i < n && s.charAt(i) == 'x') {
                coeff += sign * (hasNum ? num : 1);
                i++;
            } else {
                constant += sign * num;
            }
        }

        return new int[]{coeff, constant};
    }
}