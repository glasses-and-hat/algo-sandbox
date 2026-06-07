
class TrieNode {
    TrieNode[] children = new TrieNode[26];
    boolean isWord = false;

    public void addWord(String word) {
        TrieNode curr = this;
        for (char c : word.toCharArray()) {
            if (curr.children[c - 'a'] == null) {
                curr.children[c - 'a'] = new TrieNode();
            }
            curr = curr.children[c - 'a'];
        }
        curr.isWord = true;
    }
}

class Solution {
    private Set<String> res;
    private boolean[][] visit;

    public List<String> findWords(char[][] board, String[] words) {
        TrieNode root = new TrieNode();
        int ROWS = board.length;
        int COLS = board[0].length;

        for (String word : words) {
            root.addWord(word);
        }

        res = new HashSet<>();
        visit = new boolean[ROWS][COLS];
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                dfsFindWord(board, root, i, j, "");
            }
        }
        return new ArrayList<>(res);
    }

    private void dfsFindWord(char[][] board, TrieNode node, int r, int c, String word) {
        int ROWS = board.length, COLS = board[0].length;
        if (r < 0 || c < 0 || r >= ROWS || c >= COLS || visit[r][c]
            || node.children[board[r][c] - 'a'] == null) {
            return;
        }

        visit[r][c] = true;
        word = word + board[r][c];
        node = node.children[board[r][c] - 'a'];

        if (node.isWord) {
            res.add(word);
        }
        dfsFindWord(board, node, r + 1, c, word);
        dfsFindWord(board, node, r - 1, c, word);
        dfsFindWord(board, node, r, c + 1, word);
        dfsFindWord(board, node, r, c - 1, word);

        visit[r][c] = false;
    }
}
