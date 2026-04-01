class Solution {
    public int missingNumber(int[] nums) {
        int x = 0;
        int len = nums.length;
        for(int i=0;i<len;i++){
            x = x^(i+1)^nums[i];
        }
        return x;
    }
}
