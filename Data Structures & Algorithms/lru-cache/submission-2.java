class LRUCache {
    Node head; // least recently used pointer 
    Node tail; // most recently used pointer
    HashMap<Integer, Node> cache; 
    int capacity; 

    public LRUCache(int capacity) {
        head = new Node(); 
        tail = new Node(); 
        cache = new HashMap<>(); 
        this.capacity = capacity;

        head.next = tail; 
        tail.prev = head; 
    }
    
    public int get(int key) {
        if (cache.containsKey(key)) {
            Node node = cache.get(key); 
            remove(node); 
            insertAtTail(node); 

            return node.val; 
        }

        return -1; 
    }
    
    public void put(int key, int value) {
        if (cache.containsKey(key)) remove(cache.get(key)); 

        Node node = new Node(key, value); 
        cache.put(key, node); 
        insertAtTail(node); 

        if (cache.size() > capacity) {
            Node lru = head.next;
            remove(lru); 
            cache.remove(lru.key); 
        }
    }

    private void remove(Node node) {
        Node prevNode = node.prev; 
        Node nextNode = node.next; 

        prevNode.next = nextNode; 
        nextNode.prev = prevNode; 
    }

    private void insertAtTail(Node node) {
        Node prevNode = tail.prev; 
        Node nextNode = tail; 
        
        prevNode.next = node; 
        nextNode.prev = node; 

        node.next = nextNode; 
        node.prev = prevNode; 
    }
}

class Node {
    int key; 
    int val; 
    Node next; 
    Node prev; 

    Node() {}

    Node(int key, int val) {
        this.key = key; 
        this.val = val; 
        this.next = null; 
        this.prev = null; 
    }
}