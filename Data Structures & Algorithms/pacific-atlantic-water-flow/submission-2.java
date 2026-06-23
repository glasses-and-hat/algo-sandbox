class Solution {
    private static final int[][] DIRECTIONS = {
        {0, 1}, {0, -1}, {1, 0}, {-1, 0}
        };

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int rows = heights.length;
        int cols = heights[0].length;

        Queue<int[]> pacQ = new LinkedList<>();
        Queue<int[]> atlQ = new LinkedList<>();

        for (int r = 0; r < rows; r++) {
            pacQ.add(new int[] {r, 0});
            atlQ.add(new int[] {r, cols - 1});
        }

        for (int c = 0; c < cols; c++) {
            pacQ.add(new int[] {0, c});
            atlQ.add(new int[] {rows - 1, c});
        }

        boolean[][] pacific = new boolean[rows][cols];
        boolean[][] atlantic = new boolean[rows][cols];

        bfs(heights, pacQ, pacific);
        bfs(heights, atlQ, atlantic);
        List<List<Integer>> res = new ArrayList<>();
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (pacific[r][c] && atlantic[r][c]) {
                     res.add(Arrays.asList(r, c));
                }
            }
        }
        return res;
    }

    private void bfs(int[][] heights, Queue<int[]> q, boolean[][] visited) {
        while (!q.isEmpty()) {
            int[] cell = q.poll();
            int row = cell[0];
            int col = cell[1];
            visited[row][col] = true;

            for (int[] dir : DIRECTIONS) {
                int r = row + dir[0];
                int c = col + dir[1];
                if (r >= 0 && c >= 0 && r < heights.length && c < heights[0].length
                    && !visited[r][c] && heights[r][c] >= heights[row][col]) {
                    q.add(new int[] {r, c});
                }
            }
        }
    }
}
