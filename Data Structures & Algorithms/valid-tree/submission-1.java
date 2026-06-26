class Solution {
    Map<Integer, List<Integer>> graph = new HashMap<>();
    Set<Integer> visited = new HashSet<>();
    public boolean validTree(int n, int[][] edges) {
        for (int i = 0; i < n; i++) {
            graph.put(i, new ArrayList<>());
        }

        for (int[] edge : edges) {
            graph.get(edge[1]).add(edge[0]);
            graph.get(edge[0]).add(edge[1]);
        }

        return dfs(0, -1) && n == visited.size();
    }

    private boolean dfs(int i, int prev) {
        if (visited.contains(i))
            return false;

        visited.add(i);

        for (int j : graph.get(i)) {
            if (j != prev && !dfs(j, i)) {
                return false;
            }
        }
        return true;
    }
}
