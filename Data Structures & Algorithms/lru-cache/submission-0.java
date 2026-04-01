class LRUCache {

    Map<Integer, Node> map;
    Node head, tail;
    int capacity;

    public LRUCache(int capacity) {
        map = new HashMap<>();
        this.capacity = capacity;

        head = new Node();
        tail = new Node();

        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        if (!map.containsKey(key)) return -1;

        Node node = map.get(key);
        remove(node);
        insertToTail(node);

        return node.val;
    }
    
    public void put(int key, int value) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            node.val = value;
            remove(node);
            insertToTail(node);
            return;
        }

        Node node = new Node(key, value);
        map.put(key, node);
        insertToTail(node);

        if (map.size() > capacity) {
            Node lru = head.next;
            remove(lru);
            map.remove(lru.key);
        }
    }

    private void remove(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void insertToTail(Node node) {
        node.prev = tail.prev;
        node.next = tail;

        tail.prev.next = node;
        tail.prev = node;
    }
}

class Node {
    int key, val;
    Node next, prev;

    Node() {}

    Node(int key, int val) {
        this.key = key;
        this.val = val;
    }
}