class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] output = new int[n];
        int zeroes = 0;
        int product = 1;
        int sign = 0;
        for(int i=0;i<n;i++){
            if(nums[i]==0){
                zeroes++;
            }
            else{
                product = product * nums[i];
            }
        }
        if(product ==1 && zeroes == n)
        return output;
        for(int i=0;i<n;i++){
            if(nums[i]!=0 && zeroes >1){
                output[i]=0;
            }
            else if(nums[i]==0){
                output[i]=zeroes>1?0:product;
            }
            else{
                output[i]=zeroes>0?0:product/nums[i];
            }
        }
        return output;
    }
}  
