class Solution {
    public int minCostConnectPoints(int[][] points) {
        int n = points.length, node = 0, edges = 0, cost = 0;
        int[] minDist = new int[n];
        Arrays.fill(minDist, Integer.MAX_VALUE);
        minDist[node] = 0;
        boolean[] visited = new boolean[n];

        while (edges < n - 1) {
            visited[node] = true;
            int nextNode = -1;

            for (int i = 0; i < n; i++) {
                if (visited[i])
                    continue;
                int currDist = Math.abs(points[i][0] - points[node][0])
                    + Math.abs(points[i][1] - points[node][1]);
                minDist[i] = Math.min(minDist[i], currDist);
                if (nextNode == -1 || minDist[i] < minDist[nextNode]) {
                    nextNode = i;
                }
            }
            edges++;
            node = nextNode;
            cost += minDist[nextNode];
        }
        return cost;
    }
}
