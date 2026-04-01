class Solution {
    public boolean canJump(int[] nums) {
        int left = 0;
        for(int i=0;i<=left && i<nums.length;i++){
            left = Math.max(left,i+nums[i]);
            // System.out.println("I is "+i + " left is "+left+" nums is "+nums[i]);
            if(i==nums.length-1){
                return true;
            }
        }
        return false;
    }
}
