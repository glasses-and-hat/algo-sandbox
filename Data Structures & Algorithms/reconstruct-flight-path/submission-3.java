class Solution {
    public List<String> findItinerary(List<List<String>> tickets) {
        Map<String, PriorityQueue<String>> adjMap = new HashMap();
        for(List<String> ticket : tickets) {
            adjMap.computeIfAbsent(ticket.get(0), k -> new PriorityQueue<>()).offer(ticket.get(1));
        }

        List<String> res = new ArrayList<>();
        dfs(adjMap, res, "JFK");
        Collections.reverse(res);
        return res;
    }

    private void dfs(Map<String, PriorityQueue<String>> adjMap, List<String> res, String org) {
        
        PriorityQueue<String> q = adjMap.get(org);
        while(q != null && !q.isEmpty()) {
            dfs(adjMap, res, q.poll());
        }
        res.add(org);
    }
}
