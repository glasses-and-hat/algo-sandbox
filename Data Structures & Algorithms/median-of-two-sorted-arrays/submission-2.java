class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int total = nums1.length + nums2.length;
        int half = (total + 1) / 2;

        if (nums2.length < nums1.length) {
            int[] temp = nums1;
            nums1 = nums2;
            nums2 = temp;
        }

        int l = 0, r = nums1.length;
        while (l <= r) {
            int i = l + (r - l) / 2;
            int j = half - i;

            int aLeft = i > 0 ? nums1[i - 1] : Integer.MIN_VALUE;
            int aRight = i < nums1.length ? nums1[i] : Integer.MAX_VALUE;
            int bLeft = j > 0 ? nums2[j - 1] : Integer.MIN_VALUE;
            int bRight = j < nums2.length ? nums2[j] : Integer.MAX_VALUE;

            if (aLeft <= bRight && bLeft <= aRight) {
                // odd
                if (total % 2 != 0) {
                    return Math.max(aLeft, bLeft);
                } else {
                    return (Math.min(aRight, bRight) + Math.max(aLeft, bLeft)) / 2.0;
                }
            } else if (aLeft > bRight) {
                r = i - 1;
            } else {
                l = i + 1;
            }
        }
        return -1.0;
    }
}
