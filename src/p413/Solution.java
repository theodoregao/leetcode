package p413;
public class Solution {
    public int numberOfArithmeticSlices(int[] arr) {
        int dp = 0;
        int count = 0;
        if (arr.length >= 3) {
            dp = arr[1] - arr[0] == arr[2] - arr[1] ? 1 : 0;
            count += dp;
        }
        for (int i = 3; i < arr.length; i++) {
            dp = arr[i] - arr[i - 1] == arr[i - 1] - arr[i - 2] ? dp + 1 : 0;
            count += dp;
        }
        return count;
    }
}