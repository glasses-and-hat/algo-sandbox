class Solution {
    public int largestRectangleArea(int[] heights) {
        int area = 0, n = heights.length;
        Stack<Integer> stack = new Stack();

        for (int i = 0; i <= n; i++) {
            while (!stack.isEmpty() && (i == n || heights[stack.peek()] >= heights[i])) {
                int height = heights[stack.pop()];
                int width = stack.isEmpty() ? i : i - stack.peek() - 1;
                area = Math.max(area, width * height);
            }
            stack.push(i);
        }

        return area;
    }
}
