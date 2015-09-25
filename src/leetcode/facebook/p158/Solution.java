package leetcode.facebook.p158;


/* The read4 API is defined in the parent class Reader4.
      int read4(char[] buf); */

public class Solution extends Reader4 {
    
    private char[] buffer = new char[4];
    private int index = 0;
    private int bufferLength = 0;
    
    /**
     * @param buf Destination buffer
     * @param n   Maximum number of characters to read
     * @return    The number of characters read
     */
    public int read(char[] buf, int n) {
        int bytesRead = 0;
        
        if (bufferLength > 0) {
            if (bufferLength >= n) {
                System.arraycopy(buffer, index, buf, 0, n);
                index += n;
                bufferLength -= n;
                return n;
            }
            else {
                System.arraycopy(buffer, index, buf, 0, bufferLength);
                bytesRead += bufferLength;
                bufferLength = index = 0;
            }
        }
        
        int m;
        int k;
        
        do {
            m = read4(buffer);
            k = Math.min(m, n - bytesRead);
            System.arraycopy(buffer, 0, buf, bytesRead, k);
            bytesRead += k;
            if (k < m) {
                bufferLength = m - k;
                index = k;
            }
        } while (bytesRead < n && m == 4);
        
        return bytesRead;
    }
}