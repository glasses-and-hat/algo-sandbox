
public class Solution {
    public int minCostConnectPoints(int[][] points) {
        int n = points.length, node = 0;
        int[] minDist = new int[n];
        boolean[] visit = new boolean[n];
        Arrays.fill(minDist, Integer.MAX_VALUE);
        int edges = 0, res = 0;

        while (edges < n - 1) {
            visit[node] = true;
            int nextNode = -1;
            for (int i = 0; i < n; i++) {
                if (visit[i]) continue;
                int curDist = Math.abs(points[i][0] - points[node][0]) +
                        Math.abs(points[i][1] - points[node][1]);
                minDist[i] = Math.min(minDist[i], curDist);
                if (nextNode == -1 || minDist[i] < minDist[nextNode]) {
                    nextNode = i;
                }
            }
            res += minDist[nextNode];
            node = nextNode;
            edges++;
        }
        return res;
    }
}
