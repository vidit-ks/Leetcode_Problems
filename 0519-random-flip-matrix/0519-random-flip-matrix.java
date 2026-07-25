import java.util.*;

class Solution {

    private int rows;
    private int cols;
    private int total;
    private Random random;
    private HashMap<Integer, Integer> map;

    public Solution(int m, int n) {
        rows = m;
        cols = n;
        total = m * n;
        random = new Random();
        map = new HashMap<>();
    }

    public int[] flip() {

        int r = random.nextInt(total);
        total--;

        int index = map.getOrDefault(r, r);

        map.put(r, map.getOrDefault(total, total));

        return new int[]{
                index / cols,
                index % cols
        };
    }

    public void reset() {
        total = rows * cols;
        map.clear();
    }
}