class Solution {
    private static final char LAND = '1';
    private static final char WATER = '0';
    int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    public int numIslands(char[][] grid) {
        if (grid.length == 0)
            return 0;

        int islands = 0;

        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {
                if (grid[r][c] == '1') {
                    islands++;
                    bfs(grid, r, c);
                }
            }
        }
        return islands;
    }

    public void bfs(char[][] grid, int row, int col) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {row, col});

        while (!q.isEmpty()) {
            int[] cell = q.poll();
            grid[cell[0]][cell[1]] = WATER;
            for (int[] direction : directions) {
                int r = cell[0] + direction[0];
                int c = cell[1] + direction[1];

                if (r >= 0 && c >= 0 && r < grid.length && c < grid[0].length
                    && grid[r][c] == LAND) {
                    grid[r][c] = WATER;
                    q.add(new int[] {r, c});
                }
            }
        }
    }
}
