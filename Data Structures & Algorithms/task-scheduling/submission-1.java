class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] taskCounter = new int[26];
        for (char c : tasks) {
            taskCounter[c - 'A']++;
        }

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
        for (int count : taskCounter) {
            if (count > 0) {
                maxHeap.add(count);
            }
        }

        int total = 0;
        Queue<int[]> q = new LinkedList(); // { count, time}

        while (!maxHeap.isEmpty() || !q.isEmpty()) {
            total++;
            if (maxHeap.isEmpty()) {
                // total = q.peek()[1];
            } else {
                int cnt = maxHeap.poll() - 1;
                if (cnt > 0) {
                    q.add(new int[] {cnt, total + n});
                }
            }

            if (!q.isEmpty() && q.peek()[1] == total) {
                maxHeap.add(q.poll()[0]);
            }
        }
        return total;
    }
}
