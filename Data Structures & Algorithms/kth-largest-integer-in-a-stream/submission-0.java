class KthLargest {
    // private int kthLargest;
    private PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    private int k;
    public KthLargest(int k, int[] nums) {
        this.k = k;
        for (int num : nums) {
            minHeap.offer(num);
            while (minHeap.size() > k) {
                minHeap.poll();
            }
        }
    }

    public int add(int val) {
        minHeap.offer(val);
        while (minHeap.size() > k) {
            minHeap.poll();
        }
        return minHeap.peek();
    }
}
