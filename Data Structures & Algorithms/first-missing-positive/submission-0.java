class Solution {
    public int firstMissingPositive(int[] nums) {
        Set<Integer> hs = new HashSet();
        for(int num : nums){
            if(num>0){
                hs.add(num);
            }
        }
        for(int i=1;i<=hs.size();i++){
            if(!hs.contains(i)){
                return i;
            }
        }
        return hs.size()+1;
    }
}