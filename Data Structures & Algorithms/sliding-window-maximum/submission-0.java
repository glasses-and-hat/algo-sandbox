class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> q = new LinkedList<>();
        int n = nums.length, l = 0, r = 0;
        int[] ans = new int[n - k + 1];

        while (r < n) {
            while (!q.isEmpty() && nums[q.getLast()] < nums[r]) {
                q.removeLast();
            }

            q.addLast(r);
            if (l > q.getFirst()) {
                q.removeFirst();
            }

            if ((r + 1) >= k) {
                ans[l] = nums[q.getFirst()];
                l++;
            }
            r++;
        }
        return ans;
    }
}
