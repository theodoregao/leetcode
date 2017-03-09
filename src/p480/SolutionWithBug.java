package p480;

import java.util.HashMap;
import java.util.Map;

public class SolutionWithBug {

}

class Solution1 {
    private PriorityQueue min;
    private PriorityQueue max;
    
    public double[] medianSlidingWindow(int[] nums, int k) {
        initialize();
        double[] medians = new double[nums.length - k + 1];
        int i = 0;
        for (; i < k; i++) add(i, nums[i]);
        for (; i < nums.length; i++) {
            medians[i - k] = getMedian();
            remove(i - k);
            add(i, nums[i]);
        }
        medians[medians.length - 1] = getMedian();
        return medians;
    }
    
    private void initialize() {
        min = new PriorityQueue(false);
        max = new PriorityQueue(true);
    }
    
    private void add(int index, int num) {
        if (num < getMedian()) max.enqueue(new Item(index, num));
        else min.enqueue(new Item(index, num));
        if (min.size() < max.size()) min.enqueue(max.dequeue());
        else if (min.size() - max.size() > 1) max.enqueue(min.dequeue());
    }
    
    private void remove(int index) {
        if (min.has(index)) min.remove(index);
        else max.remove(index);
        if (min.size() < max.size()) min.enqueue(max.dequeue());
        else if (min.size() - max.size() > 1) max.enqueue(min.dequeue());
    }
    
    private double getMedian() {
        if (min.size() == 0) return 0;
        else if (min.size() == max.size()) return (min.peek() + max.peek()) / 2;
        else return min.peek();
    }
    
    private static class Item implements Comparable<Item> {
        int value;
        int index;
        
        public Item(int index, int value) {
            this.index = index;
            this.value = value;
        }
        
        @Override
        public int compareTo(Item o) {
            return value - o.value;
        }
        
        @Override
        public String toString() {
            return Item.class.getSimpleName() + "{" + index + ", " + value + "}";
        }
    }
    
    private static class PriorityQueue {
        private static final int DEFAULT_SIZE = 16;
        private Map<Integer, Integer> indices;
        private Item[] items;
        private int size;
        private boolean isMax;
        
        public PriorityQueue(boolean isMax) {
            items = new Item[DEFAULT_SIZE];
            indices = new HashMap<>();
            size = 0;
            this.isMax = isMax;
        }
        
        public int size() {
            return size;
        }
        
        public boolean has(int index) {
            return indices.containsKey(index);
        }
        
        public void enqueue(Item item) {
            if (size == items.length - 1) resize();
            items[++size] = item;
            indices.put(item.index, size);
            swim(size);
        }
        
        public Item dequeue() {
            Item item = items[1];
            swap(1, size--);
            sink(1);
            indices.remove(item.index);
            return item;
        }
        
        public double peek() {
            return items[1].value;
        }
        
        public boolean remove(int index) {
            if (indices.containsKey(index)) {
                int pos = indices.get(index);
                swap(pos, size--);
                sink(pos);
                indices.remove(index);
                return true;
            }
            return false;
        }
        
        private void resize() {
            Item[] newItems = new Item[items.length * 2];
            for (int i = 0; i < items.length; i++) newItems[i] = items[i];
            items = newItems;
        }
        
        private void swim(int k) {
            while (k > 1 && less(k / 2, k)) {
                swap(k / 2, k);
                k /= 2;
            }
        }
        
        private void sink(int k) {
            while (k * 2 <= size) {
                int j = k * 2;
                if (j < size && less(j, j + 1)) j++;
                if (!less(k, j)) break;
                swap(k, j);
                k = j;
            }
        }
        
        private boolean less(int i, int j) {
            return isMax ? items[i].compareTo(items[j]) < 0 : items[i].compareTo(items[j]) > 0;
        }
        
        private void swap(int i, int j) {
            Item item = items[i];
            items[i] = items[j];
            items[j] = item;
            indices.put(items[i].index, i);
            indices.put(items[j].index, j);
        }
        
        private void print() {
            System.out.println("size = " + size);
            for (int i = 1; i <= size; i++)
                System.out.println(items[i]);// + ", " + indices.get(items[i].index));
        }
    }
    
    public static void main(String[] args) {
        for (double median: new Solution().medianSlidingWindow(new int[] {1,3,-1,-3,5,3,6,7}, 3))
            System.out.println(median);
    }
}