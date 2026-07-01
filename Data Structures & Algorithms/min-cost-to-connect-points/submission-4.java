class Solution {
    public int minCostConnectPoints(int[][] points) {
        Map<String, List<int[]>> adjList = new HashMap<>();
        int n = points.length;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int distance = distance(points[i], points[j]);
                adjList.computeIfAbsent(pointToString(points[i]), k -> new ArrayList<>())
                    .add(new int[] {distance, points[j][0], points[j][1]});

                adjList.computeIfAbsent(pointToString(points[j]), k -> new ArrayList<>())
                    .add(new int[] {distance, points[i][0], points[i][1]});
            }
        }

        int cost = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        pq.offer(new int[] {0, points[0][0], points[0][1]});
        Set<String> visited = new HashSet<>();

        while (!pq.isEmpty()) {
            int[] poll = pq.poll();
            int d = poll[0], x = poll[1], y = poll[2];
            String key = pointToString(new int[] {x, y});
            if (visited.contains(key))
                continue;
            visited.add(key);
            cost += d;
            for (int[] nei : adjList.getOrDefault(key, new ArrayList<>())) {
                int nd = nei[0], nx = nei[1], ny = nei[2];
                String curr = pointToString(new int[] {nx, ny});
                pq.offer(nei);
            }
        }
        return cost;
    }

    private int distance(int[] p1, int[] p2) {
        return Math.abs(p1[0] - p2[0]) + Math.abs(p1[1] - p2[1]);
    }
    public String pointToString(int[] point) {
        return point[0] + "," + point[1];
    }
}
