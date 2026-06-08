class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList();
        Arrays.sort(candidates);

        helper(candidates, target, 0, new ArrayList(), res);
        return res;
    }

    private void helper(
        int[] nums, int target, int start, List<Integer> curr, List<List<Integer>> res) {
        if (target == 0) {
            res.add(new ArrayList(curr));
            return;
        }

        for (int i = start; i < nums.length; i++) {
            if (i > start && nums[i] == nums[i - 1])
                continue;

            if (nums[i] > target)
                break;

            curr.add(nums[i]);
            helper(nums, target - nums[i], i + 1, curr, res);
            curr.remove(curr.size() - 1);
        }
    }
}
