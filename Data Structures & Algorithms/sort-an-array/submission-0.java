class Solution {
    public int[] sortArray(int[] nums) {
        for(int i=1;i<nums.length;i++){
            int num = nums[i];
            int j = i-1;
            while(j>=0 && num < nums[j]){
                swap(nums,j,j+1);
                j--;
            }
        }
        return nums;
    }

    private void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}