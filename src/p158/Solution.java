package p158;
class Reader4 {
    int[] counts = new int[] {4,4,4,2};
    static int index;
    int read4(char[] buf) {
        return index < counts.length ? counts[index++] : 0;
    }
}

public class Solution extends Reader4 {
    /**
     * @param buf Destination buffer
     * @param n   Maximum number of characters to read
     * @return    The number of characters read
     */
    
    private char[] stream = new char[4];
    private int index = 0;
    private int bufferSize = 0;
    
    public int read(char[] buf, int n) {
        int bytesRead = 0;
        if (index < bufferSize) bytesRead = consumeStream(buf, bytesRead, n);
        while (bytesRead < n && prepareStream() > 0) bytesRead = consumeStream(buf, bytesRead, n);
        return bytesRead;
    }
    
    private int prepareStream() {
        bufferSize = read4(stream);
        index = 0;
        return bufferSize;
    }
    
    private int consumeStream(char[] buf, int bytesRead, int n) {
        while (bytesRead < n && index < bufferSize) buf[bytesRead++] = stream[index++];
        return bytesRead;
    }
    
    public static void main(String[] args) {
        char[] buf = new char[1024];
        Solution solution = new Solution();
        System.out.println(solution.read(buf, 3));
        System.out.println(solution.read(buf, 3));
        System.out.println(solution.read(buf, 3));
        System.out.println(solution.read(buf, 3));
        System.out.println(solution.read(buf, 3));
        System.out.println(solution.read(buf, 3));
    }
}