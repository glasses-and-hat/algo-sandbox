class Solution {
    public List<String> findItinerary(List<List<String>> tickets) {
        Map<String, PriorityQueue<String>> map = new HashMap<>();

        for (List<String> tick : tickets) {
            map.computeIfAbsent(tick.get(0), k -> new PriorityQueue<String>()).offer(tick.get(1));
        }

        List<String> res = new ArrayList<String>();
        dfs(map, res, "JFK");
        Collections.reverse(res);
        return res;
    }

    private void dfs(Map<String, PriorityQueue<String>> map, List<String> res, String org) {
        PriorityQueue<String> pq = map.get(org);
        while (pq != null && !pq.isEmpty()) {
            dfs(map, res, pq.poll());
        }
        res.add(org);
    }
}
