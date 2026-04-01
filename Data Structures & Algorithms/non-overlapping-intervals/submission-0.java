class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        int count =0;
        Arrays.sort(intervals,(a,b)-> a[0]!=b[0]?a[0]-b[0]: a[1]-b[1] );
         int[] prev = intervals[0];
        for (int i = 1; i < intervals.length; i++) {
            if (prev[1] > intervals[i][0]) { // overlap
                // remove the one with the larger end to keep future chance minimal
                if (intervals[i][1] < prev[1]) {
                    prev = intervals[i];
                }
                count++;
            } else {
                // no overlap -> advance prev
                prev = intervals[i];
            }
        }
        return count;
    }
}
