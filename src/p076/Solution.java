package p076;
public class Solution {
    public String minWindow(String s, String t) {
        int[] map = new int[256];
        int count = 0;
        for (char ct: t.toCharArray()) {
            if (map[ct] == 0) count++;
            map[ct]--;
        }
        int head = 0, tail = Integer.MAX_VALUE;
        int ps = 0, pe = 0;
        for (ps = 0, pe = 0; pe < s.length(); pe++) {
            if (++map[s.charAt(pe)] == 0) count--;
            while (ps < s.length() && map[s.charAt(ps)] > 0) map[s.charAt(ps++)]--;
            if (count == 0 && pe - ps < tail - head) {
                head = ps;
                tail = pe;
            }
        }
        return tail == Integer.MAX_VALUE ? "" : s.substring(head, tail + 1);
    }
    
    public static void main(String[] args) {
        System.out.println("result: " + new Solution().minWindow("a", "b"));
    }
}