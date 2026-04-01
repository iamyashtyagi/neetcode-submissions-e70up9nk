class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        findCombination(nums, 0, target, new ArrayList<>(), result);
        return result;
    }

    private void findCombination(
            int[] nums,
            int index,
            int target,
            List<Integer> temp,
            List<List<Integer>> result
    ) {
        if (target == 0) {
            result.add(new ArrayList<>(temp));
            return;
        }

        if (target < 0 || index >= nums.length) {
            return;
        }

        // Pick current number (can reuse)
        temp.add(nums[index]);
        findCombination(nums, index, target - nums[index], temp, result);
        temp.remove(temp.size() - 1);

        // Skip current number
        findCombination(nums, index + 1, target, temp, result);
    }
}
