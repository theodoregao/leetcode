package p551;
public class Solution {
    public boolean checkRecord(String s) {
        int countAbsent = 0;
        int countLate = 0;
        for (char c: s.toCharArray()) {
            if (c == 'L') {
                if (++countLate == 3) return false;
            }
            else {
                if (c == 'A') countAbsent++;
                countLate = 0;
            }
        }
        return countAbsent <= 1;
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().checkRecord("LALPPL"));
        System.out.println(new Solution().checkRecord("PPALLP"));
        System.out.println(new Solution().checkRecord("PPALLL"));
        System.out.println(new Solution().checkRecord("AAAA"));
    }
}