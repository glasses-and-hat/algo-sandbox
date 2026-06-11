class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList();
        helper(nums, target, 0, new ArrayList(), res);
        return res;
    }

    private void helper(int[] nums, int target, int i, List<Integer> curr, List<List<Integer>> res) {
        if (i >= nums.length || target < 0) {
            return;
        }

        if (target == 0) {
            res.add(new ArrayList(curr));
            return;
        }

        curr.add(nums[i]);
        helper(nums, target - nums[i], i, curr, res);
        curr.remove(curr.size() - 1);
        helper(nums, target, i + 1, curr, res);
    }
}
