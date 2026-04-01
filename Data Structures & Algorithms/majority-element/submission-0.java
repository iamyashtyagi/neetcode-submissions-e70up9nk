class Solution {
    public int majorityElement(int[] nums) {
        int element = 0;
        int freq = 0;

        for(int i=0;i<nums.length;i++){
            if(element==nums[i]){
                freq++;
            }
            else if(freq==0){
                freq++;
                element = nums[i];
            }
            else{
                freq--;
            }
        }
        return element;
    }
}