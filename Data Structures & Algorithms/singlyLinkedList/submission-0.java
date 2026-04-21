class LinkedList {
    private class Node {
        Node next;
        int val;
        public Node(int val) {
            this.next = null;
            this.val = val;
        }
        public Node(int val, Node next) {
            this.val = val;
            this.next = next;
        }
    }

    Node head;
    Node tail;

    public LinkedList() {
        head = new Node(-1);
        tail = head;
    }

    public int get(int index) {
        Node curr = head.next;
        int i = 0;
        while (curr != null) {
            if (i == index) {
                return curr.val;
            }
            i++;
            curr = curr.next;
        }
        return -1;
    }

    public void insertHead(int val) {
        Node newNode = new Node(val);
        newNode.next = head.next;
        head.next = newNode;
        if (newNode.next == null) {
            tail = newNode;
        }
    }

    public void insertTail(int val) {
        this.tail.next = new Node(val);
        tail = tail.next;
    }

    public boolean remove(int index) {
        int i = 0;
        Node curr = this.head;
        while (i < index && curr != null) {
            i++;
            curr = curr.next;
        }

        // Remove the node ahead of curr
        if (curr != null && curr.next != null) {
            if (curr.next == this.tail) {
                this.tail = curr;
            }
            curr.next = curr.next.next;
            return true;
        }
        return false;
    }

    public ArrayList<Integer> getValues() {
        ArrayList<Integer> list = new ArrayList();
        Node runner = head.next;
        while (runner != null) {
            list.add(runner.val);
            runner = runner.next;
        }
        return list;
    }
}
