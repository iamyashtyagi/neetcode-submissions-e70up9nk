class Solution {
    public int maxArea(int[] heights) {
        int left = 0;
        int water = 0;
        int right = heights.length-1;
        while(left<right){
            water = Math.max(Math.min(heights[left],heights[right])*(right-left), water);
            if(heights[left]<=heights[right]){
                left++;
            }
            else{
                right--;
            }
        }
        return water;
    }
}
