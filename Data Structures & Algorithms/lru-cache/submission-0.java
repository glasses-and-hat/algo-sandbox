class LRUCache {
    private final int capacity;
    private final Map<Integer, Node> cacheMap;
    private final DoubleLinkedList dll;

    private class Node {
        Node prev, next;
        Integer key, value;
        Node(Integer key, Integer value) {
            this.key = key;
            this.value = value;
        }
    }

    private class DoubleLinkedList {
        Node head, tail;
        DoubleLinkedList() {
            head = new Node(null, null);
            tail = new Node(null, null);
            head.next = tail;
            tail.prev = head;
        }

        public void moveToFront(Node node) {
            remove(node);
            addFront(node);
        }

        public void remove(Node node) {
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }

        public void addFront(Node node) {
            node.next = head.next;
            node.prev = head;
            head.next.prev = node;
            head.next = node;
        }

        public Node removeLast() {
            if (tail.prev == head)
                return null;
            Node last = tail.prev;
            remove(last);
            return last;
        }
    }

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.cacheMap = new HashMap<>();
        this.dll = new DoubleLinkedList();
    }

    public int get(int key) {
        Node node = cacheMap.get(key);
        if (node != null) {
            dll.moveToFront(node);
            return node.value;
        }
        return -1;
    }

    public void put(int key, int value) {
        Node node = cacheMap.get(key);
        if (node != null) {
            node.value = value;
            dll.moveToFront(node);
            return;
        }
        if (capacity == 0)
            return;

        if (cacheMap.size() >= capacity) {
            Node removed = dll.removeLast();
            if (removed != null) {
                cacheMap.remove(removed.key);
            }
        }
        Node newNode = new Node(key, value);
        dll.addFront(newNode);
        cacheMap.put(key, newNode);
    }
}
