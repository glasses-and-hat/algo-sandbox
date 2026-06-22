class Solution {
    private static final int[][] DIRECTIONS = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        Queue<int[]> pacificQ = new LinkedList<>();
        Queue<int[]> atlanticQ = new LinkedList<>();

        int rows = heights.length, cols = heights[0].length;

        for (int c = 0; c < cols; c++) {
            pacificQ.add(new int[] {0, c});
            atlanticQ.add(new int[] {rows - 1, c});
        }
        for (int r = 0; r < rows; r++) {
            pacificQ.add(new int[] {r, 0});
            atlanticQ.add(new int[] {r, cols - 1});
        }
        int ROWS = heights.length, COLS = heights[0].length;
        boolean[][] pac = new boolean[ROWS][COLS];
        boolean[][] atl = new boolean[ROWS][COLS];
        bfs(pacificQ, pac, heights);
        bfs(atlanticQ, atl, heights);

        List<List<Integer>> res = new ArrayList<>();
        for (int r = 0; r < ROWS; r++) {
            for (int c = 0; c < COLS; c++) {
                if (pac[r][c] && atl[r][c]) {
                    res.add(Arrays.asList(r, c));
                }
            }
        }
        return res;
    }

    private void bfs(Queue<int[]> q, boolean[][] ocean, int[][] heights) {
        while (!q.isEmpty()) {
            int[] cell = q.poll();
            int row = cell[0], col = cell[1];
            ocean[row][col] = true;

            for (int[] dir : DIRECTIONS) {
                int r = dir[0] + row;
                int c = dir[1] + col;
                if (r >= 0 && c >= 0 && r < heights.length && c < heights[0].length && !ocean[r][c]
                    && heights[r][c] >= heights[row][col]) {
                    q.add(new int[] {r, c});
                }
            }
        }
    }
}
