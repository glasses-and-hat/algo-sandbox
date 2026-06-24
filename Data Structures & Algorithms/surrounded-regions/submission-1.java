class Solution {
    private static final char TEMP = 'T';
    private static final char OH = 'O';
    private static final char EX = 'X';
    public void solve(char[][] board) {
        int rows = board.length;
        int cols = board[0].length;

        // Top and bottom rows
        for (int c = 0; c < cols; c++) {
            if (board[0][c] == OH)
                bfsOtoT(board, 0, c);
            if (board[rows - 1][c] == OH)
                bfsOtoT(board, rows - 1, c);
        }

        // Left and right columns
        for (int r = 0; r < rows; r++) {
            if (board[r][0] == OH)
                bfsOtoT(board, r, 0);
            if (board[r][cols - 1] == OH)
                bfsOtoT(board, r, cols - 1);
        }

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (board[r][c] == OH) {
                    board[r][c] = EX;
                }
            }
        }
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (board[r][c] == TEMP) {
                    board[r][c] = OH;
                }
            }
        }
    }

    private void bfsOtoT(char[][] board, int r, int c) {
        if (r < 0 || c < 0 || r >= board.length || c >= board[0].length || board[r][c] != OH) {
            return;
        }
        board[r][c] = TEMP;
        bfsOtoT(board, r + 1, c);
        bfsOtoT(board, r - 1, c);
        bfsOtoT(board, r, c + 1);
        bfsOtoT(board, r, c - 1);
    }
}
