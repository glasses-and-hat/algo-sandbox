class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> count = new HashMap<>();
        for (int num : nums) {
            count.put(num, count.getOrDefault(num, 0) + 1);
        }

        PriorityQueue<int[]> heap = new PriorityQueue<>((a, b) -> a[1] - b[1]);

        for (Map.Entry<Integer, Integer> entry : count.entrySet()) {
            heap.offer(new int[] {entry.getKey(), entry.getValue()});
            if (heap.size() > k) {
                heap.poll();
            }
        }

        int[] res = new int[k];
        int index = 0;
        while (!heap.isEmpty()) {
            res[index++] = heap.poll()[0];
        }

        return res;
    }
}
