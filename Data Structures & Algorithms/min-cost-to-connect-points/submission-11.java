class Solution {
    public int minCostConnectPoints(int[][] points) {
        Random rand = new Random();
        int n = points.length;
        int node = rand.nextInt((n - 0)) + 0;
        int[] minDist = new int[n];
        Arrays.fill(minDist, Integer.MAX_VALUE);
        minDist[node] = 0;
        int edges = 0, cost = 0;
        boolean[] visited = new boolean[n];

        while (edges < n - 1) {
            int nextNode = -1;
            visited[node] = true;
            for (int i = 0; i < n; i++) {
                if (visited[i])
                    continue;
                int dis = Math.abs(points[i][0] - points[node][0])
                    + Math.abs(points[i][1] - points[node][1]);
                minDist[i] = Math.min(minDist[i], dis);
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
