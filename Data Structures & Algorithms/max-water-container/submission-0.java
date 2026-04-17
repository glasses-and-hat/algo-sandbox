class Solution {
    public int maxArea(int[] heights) {
        int l =0, r = heights.length - 1, result = 0;
        while(l < r) {
            int area = area(heights, l, r);
            result = Math.max(result, area);
            if(heights[l] <= heights[r]) {
                l++;
            } else {
                r--;
            }
        }
        return result;
    }

    public int area(int[] heights, int l, int r) {
        int length = r - l;
        int height = Math.min(heights[l], heights[r]);
        return length * height;
    }
}
