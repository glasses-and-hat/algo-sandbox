class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList();
        Arrays.sort(nums);
        backtrack(nums, 0, new ArrayList(), res);
        return res;
    }

    private void backtrack(int[] nums, int i, List<Integer> subset, List<List<Integer>> res) {
        if (i == nums.length) {
            res.add(new ArrayList(subset));
            return;
        }

        subset.add(nums[i]);
        backtrack(nums, i + 1, subset, res);
        subset.remove(subset.size() - 1);

        while (i < nums.length - 1 && nums[i] == nums[i + 1]) {
            i++;
        }
        backtrack(nums, i + 1, subset, res);
    }
}
