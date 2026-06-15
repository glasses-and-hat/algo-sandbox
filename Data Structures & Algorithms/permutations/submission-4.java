class Solution {
    public List<List<Integer>> permute(int[] nums) {
        // List<List<Integer>> res = new ArrayList();
        // helper(nums, 0, new ArrayList());
        return helper(nums);
    }

    private List<List<Integer>> helper(int[] nums) {
        if(nums.length == 0) {
            return Arrays.asList(new ArrayList());
        }

        List<List<Integer>> subPerm = helper(Arrays.copyOfRange(nums, 1, nums.length));
        List<List<Integer>> res = new ArrayList();
        for(List<Integer> p: subPerm) {
            for(int i = 0; i <= p.size(); i++) {
                List<Integer> pCopy = new ArrayList(p);
                pCopy.add(i, nums[0]);
                res.add(pCopy);
            }
        }
        return res;
    }
}
