class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList();
        Map<Integer,Integer> hm = new HashMap();
        Set<String> set = new HashSet();
        for(int i=0;i<nums.length;i++){
            hm.put(nums[i],i);
        }
        for(int i=0;i<nums.length;i++){
            for(int j=i+1;j<nums.length-1;j++){
                int val = hm.getOrDefault(-(nums[i]+nums[j]),-1);
                if(val!=-1&& val!=j && val!=i){
                    List<Integer> temp = new ArrayList();
                    temp.add(nums[i]);
                    temp.add(nums[j]);
                    temp.add(-(nums[i]+nums[j]));
                    Collections.sort(temp);
                    String key = temp.get(0)+"_"+temp.get(1)+"_"+temp.get(2);
                    if(!set.contains(key)){
                        result.add(temp);
                        set.add(key);
                    }
                }
            }
        }
        return result;
    }
}
