class Solution {
    int n;
    char[][] board;

    boolean[] cols, posD, negD;

    List<List<String>> res;
    public List<List<String>> solveNQueens(int n) {
        this.n = n;
        board = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }

        cols = new boolean[n];
        posD = new boolean[2 * n];
        negD = new boolean[2 * n];

        res = new ArrayList();
        backtrack(0);
        return res;
    }

    public void backtrack(int r) {
        if (r == n) {
            List<String> l = new ArrayList();
            for (char[] row : board) {
                l.add(new String(row));
            }
            res.add(l);
            return;
        }

        for (int c = 0; c < n; c++) {
            if (cols[c] || posD[r + c] || negD[r - c + n]) {
                continue;
            }

            board[r][c] = 'Q';
            cols[c] = true;
            posD[r + c] = true;
            negD[r - c + n] = true;

            backtrack(r + 1);

            board[r][c] = '.';
            cols[c] = false;
            posD[r + c] = false;
            negD[r - c + n] = false;
        }
    }
}
