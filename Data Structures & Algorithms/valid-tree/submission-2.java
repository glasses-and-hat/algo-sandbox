class Solution {
    public boolean validTree(int n, int[][] edges) {
        Map<Integer, List<Integer>> graph = new HashMap<>();

        for (int i = 0; i < n; i++) {
            graph.put(i, new ArrayList<>());
        }

        for (int[] edge : edges) {
            graph.get(edge[1]).add(edge[0]);
            graph.get(edge[0]).add(edge[1]);
        }

        Set<Integer> visited = new HashSet<>();

        if (!dfs(0, -1, visited, graph))
            return false;

        return visited.size() == n;
    }

    private boolean dfs(int i, int prev, Set<Integer> visited, Map<Integer, List<Integer>> graph) {
        if (!visited.add(i))
            return false;

        for (int j : graph.get(i)) {
            if (j != prev && !dfs(j, i, visited, graph)) {
                return false;
            }
        }
        return true;
    }
}
