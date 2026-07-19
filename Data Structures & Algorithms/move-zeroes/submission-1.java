class Solution {
    public void moveZeroes(int[] nums) {
        int l = 0, r = 0, n = nums.length;

        while (r < n) {
            if (nums[r] != 0) {
                int temp = nums[r];
                nums[r] = nums[l];
                nums[l] = temp;
                l++;
            }
            r++;
        }
    }
}