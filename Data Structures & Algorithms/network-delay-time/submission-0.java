class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        Map<Integer, List<int[]>> adj = new HashMap<>();

        for (int i = 1; i <= n; i++) {
            adj.put(i, new ArrayList<>());
        }

        for (int[] time : times) {
            adj.get(time[0]).add(new int[] {time[1], time[2]}); // <ui, [vi, ti]>
        }
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        int total = 0;
        Set<Integer> visited = new HashSet<>();
        minHeap.offer(new int[] {0, k});

        while (!minHeap.isEmpty()) {
            int[] poll = minHeap.poll();
            int t1 = poll[0];
            int v1 = poll[1];

            if (visited.contains(v1))
                continue;

            visited.add(v1);
            total = t1;

            for (int[] nei : adj.get(v1)) {
                int t2 = nei[1];
                int v2 = nei[0];
                if (!visited.contains(v2)) {
                    minHeap.offer(new int[] {t1 + t2, v2});
                }
            }
        }

        return visited.size() == n ? total : -1;
    }
}
