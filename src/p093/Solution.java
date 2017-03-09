package p093;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> ips = new ArrayList<>();
        List<String> ip = new ArrayList<>();
        restoreIpAddresses(ips, ip, s, 0);
        return ips;
    }
    
    private void restoreIpAddresses(List<String> ips, List<String> ip, String s, int n) {
        if (s.length() == n) {
            if (ip.size() == 4) ips.add(combine(ip));
            return;
        }
        for (int i = 1; i <= 3 && n + i <= s.length(); i++) {
            String num = s.substring(n, n + i);
            if (num.length() > 1 && num.charAt(0) == '0') continue;
            if (Integer.parseInt(num) <= 255 && ip.size() < 4) {
                ip.add(num);
                restoreIpAddresses(ips, ip, s, n + i);
                ip.remove(ip.size() - 1);
            }
        }
    }
    
    private String combine(List<String> ip) {
        return ip.get(0) + "." + ip.get(1) + "." + ip.get(2) + "." + ip.get(3);
    }
    
    public static void main(String[] args) {
        for (String ip: new Solution().restoreIpAddresses("010010"))
            System.out.println(ip);
    }
}