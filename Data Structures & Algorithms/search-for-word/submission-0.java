class Solution {
    Set<String> set = new HashSet<>();
    int ROWS;
    int COLS;
    String word;
    char[][] board;

    public boolean exist(char[][] board, String word) {
        this.board = board;
        ROWS = board.length;
        COLS = board[0].length;
        this.word = word;
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                if (dfs(i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(int r, int c, int i) {
        if (i == word.length()) {
            return true;
        }

        if (r < 0 || c < 0 || r >= ROWS || c >= COLS || set.contains(r + "," + c)
            || word.charAt(i) != board[r][c]) {
            return false;
        }

        set.add(r + "," + c);
        boolean res = (dfs(r + 1, c, i + 1) || dfs(r - 1, c, i + 1) || dfs(r, c + 1, i + 1)
            || dfs(r, c - 1, i + 1));
        set.remove(r + "," + c);
        return res;
    }
}
