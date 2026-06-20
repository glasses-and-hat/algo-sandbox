class Solution {
    private static final int WATER = 0;
    private static final int LAND = 1;

    private static final int[][] DIRECTIONS = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    public int maxAreaOfIsland(int[][] grid) {
        if (grid.length == 0)
            return 0;

        int maxArea = 0;
        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {
                if (grid[r][c] == LAND) {
                    maxArea = Math.max(maxArea, bfs(grid, r, c));
                }
            }
        }
        return maxArea;
    }

    private int bfs(int[][] grid, int row, int col) {
        Queue<int[]> q = new LinkedList();
        q.add(new int[] {row, col});
        grid[row][col] = WATER;

        int count = 0;

        while (!q.isEmpty()) {
            int[] cell = q.poll();
            count++;
            for (int[] dir : DIRECTIONS) {
                int r = dir[0] + cell[0];
                int c = dir[1] + cell[1];

                if (r >= 0 && c >= 0 && r < grid.length && c < grid[0].length
                    && grid[r][c] != WATER) {
                    grid[r][c] = WATER;
                    q.add(new int[] {r, c});
                }
            }
        }
        return count;
    }
}
