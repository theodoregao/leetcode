package p357;
public class Solution {
    public int countNumbersWithUniqueDigits(int n) {
        if (n == 0) return 1;
        int result = 10;
        int available = 9;
        int uniqueCount = 9;
        while (--n > 0 && available > 0) {
            uniqueCount *= available;
            result += uniqueCount;
            available--;
        }
        return result;
    }
}