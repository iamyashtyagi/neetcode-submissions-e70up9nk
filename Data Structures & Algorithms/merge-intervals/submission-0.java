class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> 
            a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]
        );

        List<int[]> result = new ArrayList<>();

        int start = -1, end = -1;

        for (int i = 0; i < intervals.length; i++) {
            if (start == -1) {
                start = intervals[i][0];
                end = intervals[i][1];
            } else {
                if (end >= intervals[i][0]) {
                    end = Math.max(end, intervals[i][1]);
                } else {
                    result.add(new int[]{start, end});
                    start = intervals[i][0];
                    end = intervals[i][1];
                }
            }
        }

        // add last interval
        result.add(new int[]{start, end});

        return result.toArray(new int[result.size()][]);
    }
}