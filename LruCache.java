/*

LRU cache

Task is to implement a LRU cache, which is a cache with a limited amount of space. Items are added to the cache till it gets filled up. After that if we ask for any element that is not in the cache, we need to delete the item from the cache that was "Least recently used" and add the element that was requested now.

Example: If the cache has a size of 4
And we request the items, 1, 2, 3, 1, 4, 5

The cache looks as follows at each step

[1]
[2,1]
[3,2,1]
[1,3,2]
[4,1,3,2]
[5,4,1,3]


*/

class Node {
    int val;
    Node next;
    Node prev;
    
    Node (int val) {
        this.val = val;
        this.next = null;
        this.prev = null;
    }
}

class Cache {

    private final int capacity;
    private int size;
    private HashMap<Integer, Node> map;
    private Node head;
    private Node tail;
    
    Cache (int capacity) throws IllegalArgumentException {
        if (capcity < 1)
            throw new IllegalArgumentException("Size should be > 1");
        
        this.capacity = capacity;
        this.size = 0;
        this.map = new HashMap<Integer, Node>();
        this.head = null;
        this.tail = null;
    }
    
    private void insertAtHead(Node n) {
        if (this.head == null) {
            this.head = n;
            this.tail = n;
        }
        else {
            n.next = this.head;
            this.head.prev = n;
            this.head = n;
        }
    }
    
    private void deleteNode(Node n) {
        if (n == null || this.head == null)
            return;    // silent ignore error
        
        Node prev = n.prev;
        Node next = n.next;
        
        n.prev = null;    // unlink from linked list
        n.next = null;
        
        // unlink n
        if (prev != null)
            prev.next = next;
        if (next != null)
            next.prev = prev;
        
        // tail update
        if (next == null)
            this.tail = prev;
        
        // head update
        if (prev == null)
            this.head = next;
    }
    
    
    // return node.val
    int lookup(int key) {
    
        Node n;
        // cache hit
        if (this.map.containsKey()) {
            Node n = this.map.get(key);
            deleteNode(n);
            insertAtHead(n);
        }
        else {
            // cache full so delete least recently used
            // before new entry
            if (this.size > this.capacity) {
                this.map.remove(this.tail.val);
                deleteNode(this.tail);
                this.size--;
            }

            Node n = new Node(key);
            insertAtHead(n);
            this.map.put(key, n);
            this.size++;
        }
        return n.val;
    }
}