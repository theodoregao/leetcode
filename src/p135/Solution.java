package p135;
public class Solution {
    public int candy(int[] ratings) {
        int n = ratings.length;
        if (n == 0) return 0;
        if (n == 1) return 1;
        int[] candies = new int[n];
        for (int i = 0; i < n; i++) candies[i] = 1;
        for (int i = 1; i < n; i++)
            if (ratings[i] > ratings[i - 1]) candies[i] = candies[i - 1] + 1;
        for (int i = n - 2; i >= 0; i--)
            if (ratings[i] > ratings[i + 1]) candies[i] = Math.max(candies[i], candies[i + 1] + 1);
            else if (ratings[i] == ratings[i + 1]) candies[i] = Math.max(1, candies[i]);
        int m = 0;
        for (int i = 0; i < n; i++) {
//            System.out.println(candies[i]);
            m += candies[i];
        }
        return m;
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().candy(new int[] {1,7,7,6,4,4,8,2,5,5,3,1,4}));
        System.out.println(new Solution().candy(new int[] {4,2,3,4,1}));
    }
}