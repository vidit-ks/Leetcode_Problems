class Solution {
    public int hIndex(int[] a) {
        int l = 0, r = a.length - 1, n = a.length;
        while (l <= r) {
            int m = (l + r) / 2;
            if (a[m] == n - m) return n - m;
            if (a[m] < n - m) l = m + 1;
            else r = m - 1;
        }
        return n - l;
    }
}