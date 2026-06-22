class Solution {
    private static final int TREASURE = 0;
    private static final int INF = Integer.MAX_VALUE;

    private static final int[][] DIRECTIONS = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    public void islandsAndTreasure(int[][] grid) {
        Queue<int[]> q = new LinkedList<>();
        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {
                if (grid[r][c] == TREASURE) {
                    q.add(new int[] {r, c});
                }
            }
        }

        while (!q.isEmpty()) {
            int[] cell = q.poll();
            int row = cell[0];
            int col = cell[1];

            for (int[] dir : DIRECTIONS) {
                int r = row + dir[0];
                int c = col + dir[1];

                if (r < 0 || c < 0 || r >= grid.length || c >= grid[0].length
                    || grid[r][c] != INF) {
                    continue;
                }
                q.add(new int[] {r, c});
                grid[r][c] = 1 + grid[row][col];
            }
        }
    }
}
