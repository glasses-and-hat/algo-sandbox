class Solution {
    class Trie {
        Trie[] kids = new Trie[26];
        boolean isWord = false;

        public void addWord(String word) {
            Trie curr = this;
            for (char c : word.toCharArray()) {
                if (curr.kids[c - 'a'] == null) {
                    curr.kids[c - 'a'] = new Trie();
                }
                curr = curr.kids[c - 'a'];
            }
            curr.isWord = true;
        }
    }

    Trie root;
    boolean[][] visited;
    int ROWS;
    int COLS;
    Set<String> res;
    public List<String> findWords(char[][] board, String[] words) {
        this.ROWS = board.length;
        this.COLS = board[0].length;
        this.root = new Trie();
        for (String word : words) {
            root.addWord(word);
        }

        this.visited = new boolean[ROWS][COLS];
        this.res = new HashSet();

        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                dfs(board, root, i, j, "");
            }
        }
        return new ArrayList(res);
    }

    public void dfs(char[][] board, Trie curr, int i, int j, String word) {
        if (i < 0 || j < 0 || i >= ROWS || j >= COLS || visited[i][j]
            || curr.kids[board[i][j] - 'a'] == null) {
            return;
        }

        visited[i][j] = true;
        word += board[i][j];
        curr = curr.kids[board[i][j] - 'a'];
        if (curr.isWord) {
            res.add(word);
        }
        dfs(board, curr, i + 1, j, word);
        dfs(board, curr, i - 1, j, word);

        dfs(board, curr, i, j + 1, word);
        dfs(board, curr, i, j - 1, word);
        visited[i][j] = false;
    }
}
