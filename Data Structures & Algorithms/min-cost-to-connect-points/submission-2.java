class Solution {
    public int minCostConnectPoints(int[][] points) {
        Map<String, List<int[]>> adjMap = new HashMap<>(); // <pi, [[pj, dist], [pj, dist]];

        for (int i = 0; i < points.length; i++) {
            for (int j = i + 1; j < points.length; j++) {
                int dist = distance(points[i], points[j]);
                adjMap.computeIfAbsent(pointToString(points[i]), k -> new ArrayList<>())
                    .add(new int[] {points[j][0], points[j][1], dist});
                adjMap.computeIfAbsent(pointToString(points[j]), k -> new ArrayList<>())
                    .add(new int[] {points[i][0], points[i][1], dist});
            }
        }

        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> a[2] - b[2]);
        minHeap.offer(new int[] {points[0][0], points[0][1], 0});
        int res = 0;
        Set<String> visited = new HashSet<String>();
        while (!minHeap.isEmpty()) {
            int[] poll = minHeap.poll();
            int x1 = poll[0];
            int y1 = poll[1];
            int d1 = poll[2];
            String cur = pointToString(new int[] {x1, y1});
            if (visited.contains(cur))
                continue;

            visited.add(cur);
            res += d1;

            for (int[] nei : adjMap.getOrDefault(cur, new ArrayList<>())) {
                int x2 = nei[0];
                int y2 = nei[1];
                int d2 = nei[2];
                String pointString = pointToString(new int[] {x2, y2});
                if (!visited.contains(pointString)) {
                    minHeap.offer(new int[] {x2, y2, d2});
                }
            }
        }

        return res;
    }

    private String pointToString(int[] p) {
        return p[0] + "," + p[1];
    }

    private int distance(int[] p1, int[] p2) {
        return Math.abs(p1[0] - p2[0]) + Math.abs(p1[1] - p2[1]);
    }
}
