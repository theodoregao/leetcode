package p401;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    
    private int[] leds = new int[10];
    
    public List<String> readBinaryWatch(int num) {
        List<String> list = new ArrayList<>();
        recursive(list, num, 0);
        return list;
    }
    
    private void recursive(List<String> list, int n, int d) {
        if (d == 10 && n == 0) {
            String time = getTime();
            if (time.length() > 0) list.add(time);
        }
        else if (d < 10) {
            recursive(list, n, d + 1);
            leds[d] = 1;
            recursive(list, n - 1, d + 1);
            leds[d] = 0;
        }
    }
    
    private String getTime() {
        int hour = 0;
        for (int i = 0; i < 4; i++) {
            hour <<= 1;
            hour += leds[i];
            if (hour >= 12) return "";
        }
        int minute = 0;
        for (int i = 4; i < 10; i++) {
            minute <<= 1;
            minute += leds[i];
            if (minute >= 60) return "";
        }
        return String.format("%d:%02d", hour, minute);
    }
    
    public static void main(String[] args) {
        for (String time: new Solution().readBinaryWatch(1))
            System.out.println(time);
    }
}