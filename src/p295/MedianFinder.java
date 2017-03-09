package p295;

public class MedianFinder {
    
    private PriorityQueue min;
    private PriorityQueue max;
    private boolean even; 

    /** initialize your data structure here. */
    public MedianFinder() {
        min = new PriorityQueue(false);
        max = new PriorityQueue(true);
        even = true;
    }
    
    public void addNum(int num) {
        if (even) {
            max.enqueue(num);
            min.enqueue(max.dequeue());
        }
        else {
            min.enqueue(num);
            max.enqueue(min.dequeue());
        }
        even = !even;
    }
    
    public double findMedian() {
        return even ? (max.peek() + min.peek()) / 2.0 : min.peek(); 
    }

//    /** initialize your data structure here. */
//    public MedianFinder() {
//        min = new PriorityQueue(false);
//        max = new PriorityQueue(true);
//    }
//    
//    public void addNum(int num) {
//        if (min.size() == 0) min.enqueue(num);
//        else if (num > min.peek()) min.enqueue(num);
//        else max.enqueue(num);
//        if (min.size() > max.size() + 1)
//            max.enqueue(min.dequeue());
//        else if (min.size() + 1 < max.size())
//            min.enqueue(max.dequeue());
//    }
//    
//    public double findMedian() {
//        if (min.size() == 0 && max.size() == 0) return 0.0;
//        else if (min.size() == max.size()) return (min.peek() + max.peek()) / 2.0;
//        else if (min.size() > max.size()) return min.peek();
//        else return max.peek();
//    }
    
    private static class PriorityQueue {
        private static final int DEFAULT_SIZE = 16;
        
        private boolean isMax;
        private int[] values;
        private int size = 0;
        
        public PriorityQueue(boolean isMax) {
            this.isMax = isMax;
            values = new int[DEFAULT_SIZE];
        }
        
        private void resize() {
            int[] newValues = new int[values.length * 2];
            for(int i = 0; i < values.length; i++) newValues[i] = values[i];
            values = newValues;
        }
        
        public void enqueue(int value) {
            if (size == values.length - 1) resize();
            values[++size] = value;
            swim(size);
        }
        
        private void swim(int k) {
            while (k > 1 && less(k / 2, k)) {
                swap(k / 2, k);
                k /= 2;
            }
        }
        
        public int dequeue() {
            int value = values[1];
            swap(1, size--);
            sink(1);
            return value;
        }
        
        private void sink(int k) {
            while (2 * k <= size) {
                int j = k * 2;
                if (j < size && less(j, j + 1)) j++;
                if (!less(k, j)) break;
                swap(k, j);
                k = j;
            }
        }
        
        private boolean less(int i, int j) {
            return isMax ? values[i] < values[j] : values[i] > values[j];
        }
        
        public int peek() {
            return values[1];
        }
        
        public int size() {
            return size;
        }
        
        private void swap(int i, int j) {
            int temp = values[i];
            values[i] = values[j];
            values[j] = temp;
        }
        
        private void print() {
            for (int i = 0; i < size; i++) System.out.println(values[i]);
            System.out.println();
        }
    }
    
    public static void main(String[] args) {
        MedianFinder medianFinder = new MedianFinder();
        medianFinder.addNum(1);
        medianFinder.addNum(2);
        System.out.println(medianFinder.findMedian());
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */