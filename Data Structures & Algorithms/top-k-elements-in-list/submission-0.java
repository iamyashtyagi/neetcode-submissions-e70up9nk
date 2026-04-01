class Solution {
    public int[] topKFrequent(int[] nums, int k) {

        Map<Integer,Integer> freqMap = new HashMap<>();

        for(int num : nums){
            freqMap.merge(num, 1, Integer::sum);
        }

        Map<Integer, Integer> sorted =
            freqMap.entrySet()
                   .stream()
                   .sorted(Map.Entry.<Integer, Integer>comparingByValue().reversed())
                   .collect(Collectors.toMap(
                       Map.Entry::getKey,
                       Map.Entry::getValue,
                       (a, b) -> a,
                       LinkedHashMap::new
                   ));

        int i = 0;
        int[] result = new int[k];

        for (Map.Entry<Integer, Integer> entry : sorted.entrySet()) {
            result[i++] = entry.getKey();
            if(i == k) break;
        }

        return result;
    }
}
