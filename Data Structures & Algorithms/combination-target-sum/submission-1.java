class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        helper(nums, 0, target, new ArrayList(), res);
        return res;
    }

    private void helper(
        int[] nums, int i, int target, List<Integer> subset, List<List<Integer>> res) {
        if (i >= nums.length || target < 0) {
            return;
        }

        if (target == 0) {
            res.add(new ArrayList(subset));
            return;
        }

        subset.add(nums[i]);
        helper(nums, i, target - nums[i], subset, res);
        subset.remove(subset.size() - 1);
        helper(nums, i + 1, target, subset, res);
    }
}
