
class Node {
    public HashMap<Character, Node> kids = new HashMap<>();
    public boolean isEOW = false;
}
class PrefixTree {
    private Node node;

    public PrefixTree() {
        this.node = new Node();
    }

    public void insert(String word) {
        Node curr = this.node;

        for (char c : word.toCharArray()) {
            curr.kids.putIfAbsent(c, new Node());
            curr = curr.kids.get(c);
        }
        curr.isEOW = true;
    }

    public boolean search(String word) {
        Node curr = this.node;

        for (char c : word.toCharArray()) {
            if (!curr.kids.containsKey(c)) {
                return false;
            }
            curr = curr.kids.get(c);
        }
        return curr.isEOW;
    }

    public boolean startsWith(String prefix) {
        Node curr = this.node;

        for (char c : prefix.toCharArray()) {
            if (!curr.kids.containsKey(c)) {
                return false;
            }
            curr = curr.kids.get(c);
        }
        return true;
    }
}
