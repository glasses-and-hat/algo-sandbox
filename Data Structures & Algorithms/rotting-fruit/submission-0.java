class Solution {
    private static final int[][] DIRECTIONS = {
        {0, 1}, {0, -1}, {1, 0}, {-1, 0}
        };
    private static final int ROTTEN = 2;
    private static final int FRESH = 1;

    public int orangesRotting(int[][] grid) {
        if (grid.length == 0)
            return 0;

        Queue<int[]> q = new LinkedList<>();
        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {
                if (grid[r][c] == ROTTEN) {
                    q.add(new int[] {r, c});
                }
            }
        }

        int mins = ROTTEN;
        while (!q.isEmpty()) {
            int[] cell = q.poll();
            int row = cell[0];
            int col = cell[1];

            for (int[] dir : DIRECTIONS) {
                int r = row + dir[0];
                int c = col + dir[1];
                if (r >= 0 && c >= 0 && r < grid.length && c < grid[0].length
                    && grid[r][c] == FRESH) {
                    q.add(new int[] {r, c});
                    grid[r][c] = grid[row][col] + 1;
                    mins = Math.max(mins, grid[r][c]);
                }
            }
        }
        
        for (int[] row : grid)
            for (int cell : row)
                if (cell == FRESH)
                    return -1;

        return mins - ROTTEN;
    }
}
