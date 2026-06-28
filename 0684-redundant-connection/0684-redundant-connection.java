class Solution {
    int[] p;

    int f(int x) {
        return p[x] == x ? x : (p[x] = f(p[x]));
    }

    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        p = new int[n + 1];

        for (int i = 1; i <= n; i++)
            p[i] = i;

        for (int[] e : edges) {
            int a = f(e[0]), b = f(e[1]);
            if (a == b)
                return e;
            p[a] = b;
        }

        return new int[0];
    }
}