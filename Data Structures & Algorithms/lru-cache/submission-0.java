class LRUCache {

    Node head;
    Node tail;
    Map<Integer, Node> map;
    int capacity;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        head = tail = null;
        map = new HashMap<>();
    }
    
    public int get(int key) {
        Node node = map.getOrDefault(key, null);

        if (node == null) return -1;
        
        int val = node.val;
        map.put(key, addNode(val, key));
        removeNode(node);
        return val;
    }
    
    public void put(int key, int value) {
        Node node = map.getOrDefault(key, null);
        if (node != null) removeNode(node);
        else if (map.keySet().size() == capacity) {
            map.remove(tail.key);
            removeNode(tail);
        }
        map.put(key, addNode(value, key));
    }

    private Node addNode(int val, int key) {
        Node node = new Node(val, key, null, null);
        node.next = head;
        if (head != null) head.prev = node;
        head = node;
        if (tail == null) tail = node;

        return node;
    }

    private void removeNode(Node node) {
        Node next = node.next;
        Node prev = node.prev;

        if (next != null) next.prev = prev == null ? null : prev;
        else tail = prev;

        if (prev != null) prev.next = next == null ? null : next;
        else head = next;

        node.next = null;
        node.prev = null;
        node = null;
    }
}

class Node {
    int val;
    int key;
    Node next;
    Node prev;
    
    Node(int val, int key, Node next, Node prev) {
        this.val = val;
        this.key = key;
        this.next = next;
        this.prev = prev;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */