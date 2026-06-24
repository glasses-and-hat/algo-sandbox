class Solution {
    private static final char TEMP = 'T';
    public void solve(char[][] board) {
        int rows = board.length;
        int cols = board[0].length;

        // Top and bottom rows
        for (int c = 0; c < cols; c++) {
            if (board[0][c] == 'O')
                bfsOtoT(board, 0, c);
            if (board[rows - 1][c] == 'O')
                bfsOtoT(board, rows - 1, c);
        }

        // Left and right columns
        for (int r = 0; r < rows; r++) {
            if (board[r][0] == 'O')
                bfsOtoT(board, r, 0);
            if (board[r][cols - 1] == 'O')
                bfsOtoT(board, r, cols - 1);
        }

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (board[r][c] == 'O') {
                    board[r][c] = 'X';
                }
            }
        }
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (board[r][c] == TEMP) {
                    board[r][c] = 'O';
                }
            }
        }
    }

    private void bfsOtoT(char[][] board, int r, int c) {
        if (r < 0 || c < 0 || r >= board.length || c >= board[0].length || board[r][c] != 'O') {
            return;
        }
        board[r][c] = TEMP;
        bfsOtoT(board, r + 1, c);
        bfsOtoT(board, r - 1, c);
        bfsOtoT(board, r, c + 1);
        bfsOtoT(board, r, c - 1);
    }
}
