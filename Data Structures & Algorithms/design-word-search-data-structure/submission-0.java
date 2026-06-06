class WordDictionary {
    class Node {
        public Node[] child = new Node[26];
        public boolean isWord = false;
    }

    Node root;
    public WordDictionary() {
        this.root = new Node();
    }

    public void addWord(String word) {
        Node curr = this.root;

        for (char c : word.toCharArray()) {
            if (curr.child[c - 'a'] == null) {
                curr.child[c - 'a'] = new Node();
            }
            curr = curr.child[c - 'a'];
        }
        curr.isWord = true;
    }

    public boolean search(String word) {
        return search(word, 0, this.root);
    }

    public boolean search(String word, int j, Node root) {
        Node curr = root;
        for (int i = j; i < word.length(); i++) {
            char c = word.charAt(i);
            int index = c - 'a';
            if (c == '.') {
                for (Node kid : curr.child) {
                    if (kid != null && search(word, i + 1, kid)) {
                        return true;
                    }
                }
                return false;
            } else if (curr.child[index] == null) {
                return false;
            }
            curr = curr.child[index];
        }
        return curr.isWord;
    }
}
