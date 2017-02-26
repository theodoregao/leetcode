package p271;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Codec {

    // Encodes a list of strings to a single string.
    public String encode(List<String> strs) {
        StringBuffer lengths = new StringBuffer();
        StringBuffer buffer = new StringBuffer();
        for (String str: strs) {
            buffer.append(str);
            lengths.append(str.length()).append(":");
        }
        int size = lengths.length();
        return new StringBuffer(String.format("%16d", size)).append(lengths).append(buffer).toString();
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
        int size = Integer.parseInt(s.substring(0, 16).trim());
        String[] lengths = s.substring(16, 16 + size).split(":");
        String buffer = s.substring(16 + size);
        List<String> strs = new ArrayList<>();
        int index = 0;
        for (String length: lengths) {
            if (length.length() > 0) {
                int sz = Integer.parseInt(length);
                strs.add(buffer.substring(index, index + sz));
                index += sz;
            }
        }
        return strs;
    }
    
    public static void main(String[] args) {
        System.out.println(new Codec().decode(new Codec().encode(Arrays.asList(new String[] {"a", "", "b\na", "\nc"}))).toString());
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(strs));