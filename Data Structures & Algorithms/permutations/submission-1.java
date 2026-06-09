class Solution {
    /**
     * Iterative
     **/
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList();
        res.add(new ArrayList());

        for (int num : nums) {
            List<List<Integer>> perm = new ArrayList();
            for (List<Integer> p : res) {
                for (int i = 0; i <= p.size(); i++) {
                    List<Integer> pCopy = new ArrayList(p);
                    pCopy.add(i, num);
                    perm.add(pCopy);
                }
            }
            res = perm;
        }
        return res;
    }

    /**
     * recursive
     **/
    // public List<List<Integer>> permute(int[] nums) {
    //     if(nums.length == 0) {
    //         return Arrays.asList(new ArrayList());
    //     }

    //     List<List<Integer>> subPerms = permute(Arrays.copyOfRange(nums, 1, nums.length));
    //     List<List<Integer>> res = new ArrayList();
    //     for(List<Integer> p: subPerms) {
    //         for(int i =0; i<= p.size(); i++) {
    //             List<Integer> pCopy = new ArrayList(p);
    //             pCopy.add(i, nums[0]);
    //             res.add(pCopy);
    //         }
    //     }
    //     return res;
    // }
}
