private class Trie {
    Trie[] kids = new Trie[26];
    boolean isWord = false;

    private void addWord(String word) {
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

class Solution {
    boolean[][] visited;
    Set<String> res;
    public List<String> findWords(char[][] board, String[] words) {
        Trie root = new Trie();
        for (String word : words) {
            root.addWord(word);
        }

        int R = board.length, C = board[0].length;
        visited = new boolean[R][C];
        res = new HashSet();
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                buildWordsDfs(board, root, i, j, "");
            }
        }
        return new ArrayList(res);
    }

    private void buildWordsDfs(char[][] board, Trie node, int r, int c, String word) {
        if (r < 0 || c < 0 || r >= board.length || c >= board[0].length || visited[r][c]
            || node.kids[board[r][c] - 'a'] == null) {
            return;
        }

        visited[r][c] = true;
        word += board[r][c];
        node = node.kids[board[r][c] - 'a'];

        if (node.isWord) {
            res.add(word);
        }

        buildWordsDfs(board, node, r + 1, c, word);
        buildWordsDfs(board, node, r - 1, c, word);
        buildWordsDfs(board, node, r, c + 1, word);
        buildWordsDfs(board, node, r, c - 1, word);

        visited[r][c] = false;
    }
}
