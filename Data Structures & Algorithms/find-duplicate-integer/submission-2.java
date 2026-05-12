class Solution {
    /**
     * Using Floyd’s Fast & Slow Pointer technique:
     *
     * The slow pointer moves one step at a time.
     * The fast pointer moves two steps at a time.
     * If there’s a cycle, they will eventually meet.
     **/
    public int findDuplicate(int[] nums) {
        int fast = 0, slow = 0;
        while (true) {
            slow = nums[slow];
            fast = nums[nums[fast]];
            if (slow == fast) {
                break;
            }
        }

        int slow2 = 0;
        while (true) {
            slow = nums[slow];
            slow2 = nums[slow2];
            if (slow == slow2) {
                return slow;
            }
        }
    }
}
