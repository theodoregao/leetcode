package p146;

import java.util.HashMap;
import java.util.Map;

class LRUCache {
    
    private DoubleLinkedList list;
    private Map<Integer, Node> map;

    public LRUCache(int capacity) {
        list = new DoubleLinkedList(capacity);
        map = new HashMap<>();
    }
    
    public int get(int key) {
        if (!map.containsKey(key)) return -1;
        Node node = map.get(key);
        list.insert(list.delete(node));
        return node.value;
    }
    
    public void put(int key, int value) {
        if (map.containsKey(key)) {
            map.remove(list.delete(map.get(key)));
        }
        if (list.isFull()) {
            Node removedNode = list.deleteTail();
            map.remove(removedNode.key);
        }
        map.put(key, list.insert(key, value));
    }
    
    public void printStatus() {
        System.out.println(list);
        System.err.println(map);
        for (Integer key: map.keySet()) System.out.println(key + ": " + map.get(key).value);
    }
    
    static class Node {
        int key;
        int value;
        Node pre, next;
        
        public Node() {
            pre = next = null;
        }
        
        public Node(int key, int value) {
            this();
            this.key = key;
            this.value = value;
        }
    }
    
    static class DoubleLinkedList {
        Node head, tail;
        int capacity;
        int size;
        
        public DoubleLinkedList(int capacity) {
            this.capacity = capacity;
            this.head = new Node();
            this.tail = new Node();
            this.size = 0;
        }
        
        public void clear() {
            while (size > 0) deleteTail();
        }
        
        public boolean isFull() {
            return size >= capacity;
        }
        
        public Node deleteTail() {
            return delete(tail.next);
        }
        
        public Node insert(int key, int value) {
            return insert(new Node(key, value));
        }
        
        public Node insert(Node node) {
            if (size == 0) {
                head.next = node;
                tail.next = node;
            }
            else {
                head.next.pre = node;
                node.next = head.next;
                head.next = node;
            }
            size++;
            return node;
        }
        
        public Node delete(Node node) {
            if (size == 1) {
                node.pre = node.next = null;
                head.next = tail.next = null;
                size = 0;
                return node;
            }
            else {
                size--;
                if (node == head.next) {
                    head.next = node.next;
                    head.next.pre = null;
                    node.next = null;
                    return node;
                }
                else if (node == tail.next) {
                    tail.next = node.pre;
                    tail.next.next = null;
                    node.pre = null;
                    return node;
                }
                else {
                    Node pre = node.pre;
                    Node next = node.next;
                    pre.next = next;
                    next.pre = pre;
                    node.pre = node.next = null;
                    return node;
                }
            }
        }
        
        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder(DoubleLinkedList.class.getSimpleName());
            sb.append("{");
            sb.append("}");
            return sb.toString();
        }
    }
    
    public static void main(String[] args) {
//        testDoubleLinkedList();
//        testCase1();
        testCase2();
    }
    
    private static void testCase2() {
        LRUCache cache = new LRUCache(2);
        System.out.println(cache.get(2));
        cache.put(2, 6);
        System.out.println(cache.get(1));
        cache.put(1, 5);
        cache.put(1, 2);
        System.out.println(cache.get(1));
        System.out.println(cache.get(2));
    }
    
    private static void testCase1() {
        LRUCache cache = new LRUCache(2);
        cache.put(1, 1);
        cache.put(2, 2);
        System.out.println(cache.get(1));
        cache.put(3, 3);
//        cache.printStatus();
        System.out.println(cache.get(2));
        cache.put(4, 4);
        System.out.println(cache.get(1));
        System.out.println(cache.get(3));
        System.out.println(cache.get(4));
    }
    
    private static void testDoubleLinkedList() {
        DoubleLinkedList list = new DoubleLinkedList(3);
        Node node = list.insert(1, 1);
        System.out.println(list.size);
        System.out.println(list.head.next.value);
        System.out.println(list.head.next == list.tail.next);
        Node deletedNode = list.deleteTail();
        System.out.println(list.size);
        System.out.println(deletedNode == node);
        System.out.println(list.head.next == list.tail.next);
        Node node1 = list.insert(1, 1);
        Node node2 = list.insert(2, 2);
        Node node3 = list.insert(3, 3);
        System.out.println(list.size);
        System.out.println(list.isFull());
        System.out.println(list.head.next == node3);
        System.out.println(list.tail.next == node1);
        list.deleteTail();
        System.out.println(list.head.next == node3);
        System.out.println(list.tail.next == node2);
        System.out.println(list.size);
        System.out.println(list.isFull());
        list.clear();
        System.out.println(list.size);
        System.out.println(list.head.next == null);
        System.out.println(list.tail.next == null);
        System.out.println(list.size);
        System.out.println(list.isFull());
    }
}