class Solution {
    public List<List<Integer>> permute(int[] nums) {
        if (nums.length == 0) {
            return Arrays.asList(new ArrayList<>());
        }

        List<List<Integer>> subPerm = permute(Arrays.copyOfRange(nums, 1, nums.length));

        List<List<Integer>> res = new ArrayList();

        for (List<Integer> p : subPerm) {
            for (int i = 0; i <= p.size(); i++) {
                List<Integer> pCopy = new ArrayList(p);
                pCopy.add(i, nums[0]);
                res.add(pCopy);
            }
        }
        return res;
    }
}
