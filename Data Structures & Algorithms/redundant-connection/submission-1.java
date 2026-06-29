class Solution {
    List<List<Integer>> adj = new ArrayList<>();
    public int[] findRedundantConnection(int[][] edges) {
        for (int i = 0; i <= edges.length; i++) {
            adj.add(i, new ArrayList<>());
        }

        for (int[] edge : edges) {
            int m = edge[0];
            int n = edge[1];
            adj.get(m).add(n);
            adj.get(n).add(m);

            boolean[] visited = new boolean[edges.length + 1];
            if (helper(m, -1, visited)) {
                return edge;
            }
        }
        return new int[0];
    }

    private boolean helper(int node, int prev, boolean[] visited) {
        if (visited[node])
            return true;
        visited[node] = true;
        for (int nei : adj.get(node)) {
            if (nei == prev)
                continue;
            if (helper(nei, node, visited)) {
                return true;
            }
        }
        return false;
    }
}
