class Solution {
    boolean[][] visited;
    int ROWS;
    int COLS;
    public boolean exist(char[][] board, String word) {
        ROWS = board.length;
        COLS = board[0].length;
        visited = new boolean[ROWS][COLS];
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                if (wordExists(board, word, i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean wordExists(char[][] board, String word, int r, int c, int i) {
        if (i == word.length()) {
            return true;
        }

        if (r < 0 || c < 0 || r >= ROWS || c >= COLS || visited[r][c]
            || board[r][c] != word.charAt(i)) {
            return false;
        }

        visited[r][c] = true;

        boolean res = wordExists(board, word, r + 1, c, i + 1)
            || wordExists(board, word, r - 1, c, i + 1) || wordExists(board, word, r, c + 1, i + 1)
            || wordExists(board, word, r, c - 1, i + 1);
        visited[r][c] = false;
        return res;
    }
}
