package p345;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    private static Set<Character> VowelSet = new HashSet<>();
    static {
        VowelSet.add('a');
        VowelSet.add('e');
        VowelSet.add('i');
        VowelSet.add('o');
        VowelSet.add('u');
        VowelSet.add('A');
        VowelSet.add('E');
        VowelSet.add('I');
        VowelSet.add('O');
        VowelSet.add('U');
    }
    public String reverseVowels(String s) {
        char[] vowels = new char[s.length()];
        char[] str = s.toCharArray();
        int n = 0;
        for (int i = 0; i < str.length; i++)
            if (VowelSet.contains(str[i]))
                vowels[n++] = str[i];
        for (int i = 0; i < str.length; i++)
            if (VowelSet.contains(str[i]))
                str[i] = vowels[--n];
        return new String(str);
    }
}