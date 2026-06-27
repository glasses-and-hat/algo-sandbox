class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        List<List<Integer>> adjList = new ArrayList<>();

        int n = edges.length;
        for (int i = 0; i <= n; i++) {
            adjList.add(i, new ArrayList<>());
        }

        for (int[] edge : edges) {
            int a = edge[0], b = edge[1];
            adjList.get(a).add(b);
            adjList.get(b).add(a);
            boolean[] visited = new boolean[n + 1];

            if (dfs(a, -1, adjList, visited)) {
                return edge;
            }
        }
        return new int[0];
    }

    private boolean dfs(int node, int prev, List<List<Integer>> adjList, boolean[] visited) {
        if (visited[node])
            return true;
        visited[node] = true;
        for (int i : adjList.get(node)) {
            if (i == prev)
                continue;
            if (dfs(i, node, adjList, visited)) {
                return true;
            }
        }
        return false;
    }
}
