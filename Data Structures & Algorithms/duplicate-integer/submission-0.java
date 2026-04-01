class Solution {
    public boolean hasDuplicate(int[] nums) {
        Set<Integer> hs = new HashSet();
        for(int num : nums){
            if(hs.contains(num)){
                return true;
            }
            hs.add(num);
        }
        return false;
    }
}