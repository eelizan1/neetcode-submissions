class LRUCache {
    Node head; 
    Node tail; 
    Map<Integer, Node> cache; 
    int capacity; 

    public LRUCache(int capacity) {
        head = new Node(0, 0); 
        tail = new Node(0, 0); 
        this.capacity = capacity; 
        cache = new HashMap<>(capacity); 

        head.next = tail; 
        tail.prev = head; 
    }
    
    public int get(int key) {
        if (cache.containsKey(key)) {
            remove(cache.get(key)); 
            insertAtTail(cache.get(key)); 

            return cache.get(key).val; 
        }

        return -1; 
    }
    
    public void put(int key, int value) {
        if (cache.containsKey(key)) {
            remove(cache.get(key)); 
        }

        Node node = new Node(key, value);
        cache.put(key, node); 
        insertAtTail(node);

        if (cache.size() > capacity) {  // FIXED: typo 'capcity' → 'capacity'
            Node lru = head.next; 
            remove(lru); 
            cache.remove(lru.key); 
        }
    }

    // remove any node from list 
    private void remove(Node node) {
        Node prevNode = node.prev; 
        Node nextNode = node.next; 

				// connect the previous node to the next node of the node to remove 
        prevNode.next = nextNode; 
        nextNode.prev = prevNode; 
    }

    // insert at tail 
    private void insertAtTail(Node node) {
        Node prevNode = tail.prev; 
        Node nextNode = tail; 

				// connect prev and tail to new node
        prevNode.next = node; 
        nextNode.prev = node; 

				// connect new node's pointers to the previous and next node
        node.next = nextNode; 
        node.prev = prevNode; 
    }
}

class Node {
    int key; 
    int val; 
    Node next; 
    Node prev; 

    Node(int key, int val) {
        this.key = key; 
        this.val = val; 
        this.next = null; 
        this.prev = null; 
    }
}