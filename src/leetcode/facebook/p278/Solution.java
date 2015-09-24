package leetcode.facebook.p278;
/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        int left = 1;
        int right = n;
        while (left < right) {
            int mid = (int)(((long)left + right) / 2);
            if (!isBadVersion(mid)) left = mid + 1;
            else right = mid;
        }
        return left;
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().firstBadVersion(2126753390));
    }
}