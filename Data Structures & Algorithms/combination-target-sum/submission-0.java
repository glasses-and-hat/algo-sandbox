class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        helper(nums, 0, 0, target, new ArrayList<Integer>(), res);
        return res;
    }

    private void helper(
        int[] nums, int i, int total, int target, List<Integer> curr, List<List<Integer>> res) {
        if (i >= nums.length || total > target) {
            return;
        }

        if (total == target) {
            res.add(new ArrayList(curr));
            return;
        }
        curr.add(nums[i]);
        helper(nums, i, total + nums[i], target, curr, res);
        curr.remove(curr.size() - 1);
        helper(nums, i + 1, total, target, curr, res);
    }
}
