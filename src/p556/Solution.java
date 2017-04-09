package p556;

public class Solution {
    public int nextGreaterElement(int n) {
        char[] str = Integer.toString(n).toCharArray();
        nextPermutation(str);
        int v = -1;
        try {
            v = Integer.parseInt(new String(str));
        } catch(NumberFormatException e) {
            v = -1;
        }
        return v > n ? v : -1;
    }
    
    public void nextPermutation(char[] nums) {
        if(nums == null || nums.length<2)
            return;
     
        int p = 0;            
        for(int i = nums.length-2; i >= 0; i--){
            if(nums[i] <nums [i+1]){
                p = i;
                break;
            }    
        }
     
        int q = 0;
        for(int i = nums.length-1; i > p; i--){
            if(nums[i] > nums[p]){
                q = i;
                break;
            }    
        }
     
        if(p==0 && q==0){
            reverse(nums, 0, nums.length-1);
            return;
        }
     
        swap(nums, p, q);
     
        if(p < nums.length - 1){
            reverse(nums, p + 1, nums.length - 1);
        }
    }
     
    private void reverse(char[] str, int lo, int hi) {
        while (lo < hi) swap(str, lo++, hi--);
    }
    
    private void swap(char[] str, int i, int j) {
        char c = str[i];
        str[i] = str[j];
        str[j] = c;
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().nextGreaterElement(12));
        System.out.println(new Solution().nextGreaterElement(21));
        System.out.println(new Solution().nextGreaterElement(1999999999));
        System.out.println(new Solution().nextGreaterElement(999999991));
        System.out.println(new Solution().nextGreaterElement(198765432));
    }
}