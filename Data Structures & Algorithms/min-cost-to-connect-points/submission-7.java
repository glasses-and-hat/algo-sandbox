class Solution {
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        int[] minDist = new int[n];
        int node = 0;
        Arrays.fill(minDist, Integer.MAX_VALUE);
        minDist[node] = 0;
        boolean[] visited = new boolean[n];

        int edges = 0;
        int cost = 0;

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
