class Solution {
    int ROW;
    int COL;
    Set<Pair<Integer, Integer>> path = new HashSet();
    public boolean exist(char[][] board, String word) {
        ROW = board.length;
        COL = board[0].length;

        for (int i = 0; i < ROW; i++) {
            for (int j = 0; j < COL; j++) {
                if (existDfs(board, word, i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean existDfs(char[][] board, String word, int r, int c, int i) {
        if (i == word.length()) {
            return true;
        }

        if (r < 0 || c < 0 || r >= ROW || c >= COL || board[r][c] != word.charAt(i)
            || path.contains(new Pair<>(r, c))) {
            return false;
        }

        path.add(new Pair<>(r, c));

        boolean res = existDfs(board, word, r + 1, c, i + 1)
            || existDfs(board, word, r - 1, c, i + 1) || existDfs(board, word, r, c + 1, i + 1)
            || existDfs(board, word, r, c - 1, i + 1);

        path.remove(new Pair<>(r, c));
        return res;
    }
}
