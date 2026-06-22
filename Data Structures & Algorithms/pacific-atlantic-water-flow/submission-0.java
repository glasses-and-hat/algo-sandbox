class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int m = heights.length;
        int n = heights[0].length;

        boolean[][] pacific = new boolean[m][n];
        boolean[][] atlantic = new boolean[m][n];

        // DFS from Pacific (top row + left column)
        for (int c = 0; c < n; c++) {
            dfs(heights, 0, c, pacific, heights[0][c]);
        }
        for (int r = 0; r < m; r++) {
            dfs(heights, r, 0, pacific, heights[r][0]);
        }

        // DFS from Atlantic (bottom row + right column)
        for (int c = 0; c < n; c++) {
            dfs(heights, m - 1, c, atlantic, heights[m - 1][c]);
        }
        for (int r = 0; r < m; r++) {
            dfs(heights, r, n - 1, atlantic, heights[r][n - 1]);
        }

        // Collect cells reachable by both oceans
        List<List<Integer>> res = new ArrayList<>();
        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                if (pacific[r][c] && atlantic[r][c]) {
                    res.add(Arrays.asList(r, c));
                }
            }
        }

        return res;
    }

    private void dfs(int[][] heights, int r, int c, boolean[][] visited, int prevHeight) {
        int m = heights.length;
        int n = heights[0].length;

        // Out of bounds or already visited or cannot flow uphill
        if (r < 0 || c < 0 || r >= m || c >= n || visited[r][c] || heights[r][c] < prevHeight) {
            return;
        }

        visited[r][c] = true;

        dfs(heights, r + 1, c, visited, heights[r][c]);
        dfs(heights, r - 1, c, visited, heights[r][c]);
        dfs(heights, r, c + 1, visited, heights[r][c]);
        dfs(heights, r, c - 1, visited, heights[r][c]);
    }
}
