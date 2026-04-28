class Solution {
    public int findMin(int[] nums) {
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] < nums[r]) {
                // search left
                r = mid;
            } else {
                // search right
                l = mid + 1;
            }
        }
        return nums[l];
    }
}
