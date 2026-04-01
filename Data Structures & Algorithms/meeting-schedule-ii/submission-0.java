/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public int minMeetingRooms(List<Interval> intervals) {
        List<Integer> start = intervals.stream().map(a -> a.start).collect(Collectors.toList());
        List<Integer> end = intervals.stream().map(a -> a.end).collect(Collectors.toList());
        Collections.sort(start);
        Collections.sort(end);
        int i =0;
        int j =0;
        int n = intervals.size();
        int days =0;
        int maxDays = 0;
        while(i<n && j<n){
            if(start.get(i)<end.get(j)){
                days++;
                maxDays = Math.max(days,maxDays);
                i++;
            }
            else{
                j++;
                days--;
            }
        }
        return maxDays;
    }
}
