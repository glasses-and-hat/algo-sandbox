class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();

        helper(nums, 0, new ArrayList<Integer>(), res);

        return res;
    }

    private void helper(int[] nums, int i, List<Integer> subset, List<List<Integer>> res) {
        if (i >= nums.length) {
            res.add(new ArrayList(subset));
            return;
        }

        subset.add(nums[i]);
        helper(nums, i + 1, subset, res);
        subset.remove(subset.size() - 1);
        helper(nums, i + 1, subset, res);
    }
}
