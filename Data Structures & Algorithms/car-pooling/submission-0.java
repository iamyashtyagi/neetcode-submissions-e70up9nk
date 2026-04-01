class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        Arrays.sort(trips, (a,b) -> a[1] != b[1] ? a[1] - b[1] : a[2] - b[2]); // sort by start, then end
        int capLeft = capacity;

        // min-heap on drop-off location: [end, passengers]
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(x -> x[0]));

        for (int[] trip : trips) {
            int passengers = trip[0], start = trip[1], end = trip[2];

            if (passengers > capacity) return false; // quick prune (optional)

            // free seats for all who have already gotten off by 'start'
            while (!pq.isEmpty() && pq.peek()[0] <= start) {
                capLeft += pq.poll()[1];
            }

            // pick up current trip
            if (capLeft < passengers) return false;
            capLeft -= passengers;
            pq.offer(new int[]{end, passengers});
        }

        return true; // never exceeded capacity
    }
}
