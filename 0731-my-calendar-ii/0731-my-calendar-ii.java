class MyCalendarTwo {

    List<int[]> books = new ArrayList<>();
    List<int[]> overlap = new ArrayList<>();

    public MyCalendarTwo() {
    }

    public boolean book(int start, int end) {
        for (int[] o : overlap)
            if (Math.max(start, o[0]) < Math.min(end, o[1]))
                return false;

        for (int[] b : books)
            if (Math.max(start, b[0]) < Math.min(end, b[1]))
                overlap.add(new int[]{
                    Math.max(start, b[0]),
                    Math.min(end, b[1])
                });

        books.add(new int[]{start, end});
        return true;
    }
}