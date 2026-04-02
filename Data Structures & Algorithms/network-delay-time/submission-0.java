class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        int[] delay = new int[n + 1];
        Arrays.fill(delay, Integer.MAX_VALUE);
        delay[k] = 0;

        // Bellman-Ford relaxation (n-1 iterations)
        for (int i = 1; i < n; i++) {
            boolean updated = false;

            for (int[] time : times) {
                int u = time[0];
                int v = time[1];
                int w = time[2];

                if (delay[u] != Integer.MAX_VALUE && delay[u] + w < delay[v]) {
                    delay[v] = delay[u] + w;
                    updated = true;
                }
            }

            if (!updated) break; // optimization
        }

        int max = 0;
        for (int i = 1; i <= n; i++) {
            if (delay[i] == Integer.MAX_VALUE) return -1;
            max = Math.max(max, delay[i]);
        }

        return max;
    }
}