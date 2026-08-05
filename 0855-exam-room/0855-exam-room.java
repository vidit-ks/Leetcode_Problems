class ExamRoom {

    private int n;
    private TreeSet<Integer> seats;

    public ExamRoom(int n) {
        this.n = n;
        seats = new TreeSet<>();
    }

    public int seat() {
        if (seats.isEmpty()) {
            seats.add(0);
            return 0;
        }

        int prev = -1;
        int dist = seats.first();
        int ans = 0;

        for (int curr : seats) {
            if (prev != -1) {
                int d = (curr - prev) / 2;
                if (d > dist) {
                    dist = d;
                    ans = prev + d;
                }
            }
            prev = curr;
        }

        if (n - 1 - seats.last() > dist)
            ans = n - 1;

        seats.add(ans);
        return ans;
    }

    public void leave(int p) {
        seats.remove(p);
    }
}