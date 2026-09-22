class LRUCache {
    Node head; 
    Node tail; 
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
        } else {
            return -1; 
        }
    }
    
    public void put(int key, int value) {
        if (cache.containsKey(key)) {
            remove(cache.get(key)); 
        }

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
        Node prev = node.prev; 
        Node next = node.next; 

        prev.next = next; 
        next.prev = prev; 
    }

    // node <-> newNode <-> tail 
    private void insertAtTail(Node node) {
        Node prev = tail.prev; 
        Node next = tail; 

        prev.next = node; 
        next.prev = node; 
        
        node.next = next; 
        node.prev = prev; 
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
    }
}
