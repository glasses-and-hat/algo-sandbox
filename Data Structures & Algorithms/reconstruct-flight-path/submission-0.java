class Solution {
    public List<String> findItinerary(List<List<String>> tickets) {
        Map<String, PriorityQueue<String>> map = new HashMap<>();

        for(List<String> ticket: tickets) {
            map.computeIfAbsent(ticket.get(0), k -> new PriorityQueue<String>()).offer(ticket.get(1));
        }

        List<String> res = new ArrayList<String>();
        dfs(map, res, "JFK");
         Collections.reverse(res);
         return res;
    }

    private void dfs(Map<String, PriorityQueue<String>> map, List<String> res, String org) {
        PriorityQueue<String> queue = map.get(org);
        while(queue != null && !queue.isEmpty()) {
            String des = queue.poll();
            dfs(map, res, des);
        }
        res.add(org);
    }
}
