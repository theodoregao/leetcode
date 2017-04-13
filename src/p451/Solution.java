package p451;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public String frequencySort(String s) {
        int[] counts = new int[256];
        for (char c: s.toCharArray()) {
            counts[c]++;
        }
        List<Frequency> frequencies = new ArrayList<>();
        for (int i = 0; i < counts.length; i++) if (counts[i] != 0) {
//            System.out.println((char)i + ": " + counts[i]);
            frequencies.add(new Frequency((char)i, counts[i]));
        }
        Frequency[] array = new Frequency[frequencies.size()];
        for (int i = 0; i < array.length; i++) array[i] = frequencies.get(i);
        Arrays.sort(array);
        String str = "";
        for (int i = 0; i < array.length; i++) str = multiple(array[i].c, array[i].count) + str;
        return str;
    }
    
    private String multiple(char c, int n) {
        StringBuffer str = new StringBuffer();
        for (int i = 0; i < n; i++) str.append(c);
        return str.toString();
    }
    
    private static class Frequency implements Comparable<Frequency> {
        char c;
        int count;
        public Frequency(char c, int count) {
            this.c = c;
            this.count = count;
        }
        @Override
        public int compareTo(Frequency o) {
            return count - o.count;
        }
        @Override
        public boolean equals(Object obj) {
            return obj instanceof Frequency && c == ((Frequency)obj).c
                    || obj instanceof Character && c == (char) obj;
        }
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().frequencySort("tree"));
        System.out.println(new Solution().frequencySort("abababababababababababbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbababababababab"));
    }
}