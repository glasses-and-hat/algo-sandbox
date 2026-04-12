class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> feq = new HashMap<>();
        for(int num: nums) {
            feq.put(num, feq.getOrDefault(num, 0) + 1);
        }

        Queue<int[]> pq = new PriorityQueue<>((a,b) -> a[0] - b[0]);

        for(Map.Entry<Integer, Integer> entry : feq.entrySet()) {
            pq.offer(new int[]{entry.getValue(), entry.getKey()});
            if(pq.size() > k) {
                pq.poll();
            }
        }

        int[] result = new int[k];
        for(int i =0; i< k; i++) {
            result[i] = pq.poll()[1];
        }
        return result;

    }
}
