class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();

        for (int i = 0; i < nums.length - 1; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int j = i + 1;
            int k = nums.length - 1;
            while (j < k) {
                int threeSum = nums[i] + nums[j] + nums[k];
                if (threeSum > 0) {
                    k--;
                } else if (threeSum < 0) {
                    j++;
                } else {
                    result.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    List<Integer> comb = new ArrayList<>();
                    // comb.add(nums[i]);
                    // comb.add(nums[j]);
                    // comb.add(nums[k]);
                    // result.add(comb);
                    j++;
                    k--;
                    while (j < k && nums[j] == nums[j - 1]) {
                        j++;
                    }
                }
            }
        }
        return result;
    }
}
