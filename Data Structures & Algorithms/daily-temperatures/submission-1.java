class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] res = new int[n];
        Stack<int[]> stack = new Stack<>(); // [temp, index]

        for (int i = 0; i < n; i++) {
            int temp = temperatures[i];
            while (!stack.isEmpty() && stack.peek()[0] < temp) {
                int[] tempIndex = stack.pop();
                res[tempIndex[1]] = i - tempIndex[1];
            }
            stack.push(new int[] {temp, i});
        }
        return res;
    }
}
