class Solution {
    public int swimInWater(int[][] grid) {
        int n = grid.length;
        int minH = grid[0][0], maxH = grid[0][0];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                minH = Math.min(minH, grid[i][j]);
                maxH = Math.max(maxH, grid[i][j]);
            }
        }

        boolean[][] visited = new boolean[n][n];
        for (int t = minH; t < maxH; t++) {
            if (dfs(grid, visited, 0, 0, n, t)) {
                return t;
            }

            for (int i = 0; i < n; i++) {
                Arrays.fill(visited[i], false);
            }
        }
        return maxH;
    }

    private boolean dfs(int[][] grid, boolean[][] visited, int r, int c, int n, int t) {
        if (r < 0 || c < 0 || r >= n || c >= n || visited[r][c] || grid[r][c] > t) {
            return false;
        }

        if (r == n - 1 && c == n - 1) {
            return true;
        }

        visited[r][c] = true;
        return 
            dfs(grid, visited, r + 1, c, n, t) || 
            dfs(grid, visited, r - 1, c, n, t) || 
            dfs(grid, visited, r, c + 1, n, t) || 
            dfs(grid, visited, r, c - 1, n, t);
    }
}
