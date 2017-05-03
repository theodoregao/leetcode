package p157;

class Reader4 {
    int[] counts = new int[] {4,4,4,3};
    static int index;
    int read4(char[] buf) {
        return counts[index++];
    }
}

public class Solution extends Reader4 {
    /**
     * @param buf Destination buffer
     * @param n   Maximum number of characters to read
     * @return    The number of characters read
     */
    public int read(char[] buf, int n) {
        int bytesRead = 0;
        int bytesRead4 = 4;
        char[] buffer = new char[4];
        while (bytesRead < n && bytesRead4 == 4) {
            bytesRead4 = read4(buffer);
            for (int i = 0; i < Math.min(n - bytesRead, bytesRead4); i++) buf[bytesRead + i] = buffer[i];
            bytesRead += Math.min(n - bytesRead, bytesRead4);
        }
        return bytesRead;
    }
    
    public static void main(String[] args) {
        char[] buf = new char[1024];
        System.out.println(new Solution().read(buf, 3));
    }
}