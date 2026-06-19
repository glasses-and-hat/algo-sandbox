class Solution {
    public int leastInterval(char[] tasks, int n) {
        // Count tasks
        int[] taskCounter = new int[26];
        for (char t : tasks) {
            taskCounter[t - 'A']++;
        }

        // build maxHeap
        PriorityQueue<Integer> mh = new PriorityQueue<>(Collections.reverseOrder());
        for (int c : taskCounter) {
            if (c > 0) {
                mh.offer(c);
            }
        }

        Queue<int[]> q = new LinkedList();
        int time = 0;
        while (!mh.isEmpty() || !q.isEmpty()) {
            time++;
            if (!mh.isEmpty()) {
                int cnt = mh.poll() - 1;
                if (cnt > 0) {
                    q.offer(new int[] {cnt, time + n});
                }
            }

            if (!q.isEmpty() && q.peek()[1] == time) {
                mh.offer(q.poll()[0]);
            }
        }
        return time;
    }
}
