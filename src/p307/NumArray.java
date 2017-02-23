package p307;
public class NumArray {
	
	private int[] items;
	private int n;

    public NumArray(int[] nums) {
        items = new int[nums.length + 1];
        n = nums.length;
        
        for (int i = 0; i < nums.length; i++) put(i, nums[i]);
    }
    
    private int lowbit(int pos) {
    	return pos & -pos;
    }
    
    public void put(int pos, int val) {
    	pos++;
        while (pos <= n) {
        	items[pos] += val;
        	pos += lowbit(pos);
        }
    }
    
    public void update(int pos, int val) {
//    	System.out.println("update " + pos);
//    	System.out.println("update " + get(pos + 1));
//    	System.out.println("update " + get(pos));
//    	System.out.println("update " + (get(pos + 1) - get(pos)));
    	put(pos, (val - (get(pos + 1) - get(pos))));
    }
    
    private int get(int pos) {
    	int sum = 0;
    	while(pos > 0) {
    		sum += items[pos];
    		pos -= lowbit(pos);
    	}
    	return sum;
    }
    
    public int sumRange(int i, int j) {
        return get(j + 1) - get(i);
    }
    
    public void print() {
    	for (int i = 1; i < items.length; i++) System.out.println("\t" + get(i));
    }
    
    public static void main(String[] args) {
		NumArray na = new NumArray(new int[] {1,3,5});
//		na.print();
		System.out.println(na.sumRange(0, 2));
		na.update(1, 2);
//		na.print();
		System.out.println(na.sumRange(0, 2));
	}
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(i,val);
 * int param_2 = obj.sumRange(i,j);
 */