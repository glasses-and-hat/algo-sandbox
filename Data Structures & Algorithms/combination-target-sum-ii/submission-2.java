class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList();
        Arrays.sort(candidates);
        dfs(candidates, target, 0, new ArrayList<Integer>(), res);
        return res;
    }

    private void dfs(int[] nums, int target, int i, List<Integer> curr, List<List<Integer>> res) {
        if (target == 0) {
            res.add(new ArrayList(curr));
            return;
        }
        if (target < 0 || i >= nums.length) {
            return;
        }
        curr.add(nums[i]);
        dfs(nums, target - nums[i], i + 1, curr, res);
        curr.remove(curr.size() - 1);
        while (i + 1 < nums.length && nums[i] == nums[i + 1]) {
            i++;
        }
        dfs(nums, target, i + 1, curr, res);
    }
}
