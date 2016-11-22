package p165;
public class Solution {
    
    public int compareVersion(String version1, String version2) {
        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");
        
        int value = 0;
        
        for (int i = 0; (i < v1.length || i < v2.length)
                && (value = getValue(getVersion(v1, i), getVersion(v2, i))) == 0; i++);
        return value;
    }
    
    private int getValue(int x, int y) {
        if (x == y) return 0;
        else if (x > y) return 1;
        else return -1;
    }
    
    private int getVersion(String[] v, int index) {
        if (index < v.length) return Integer.parseInt(v[index]);
        else return 0;
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().compareVersion("1.1.10.0", "1.1.10"));
    }
    
}