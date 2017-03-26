package p507;
public class Solution {
    public boolean checkPerfectNumber(int num) {
        int sum = 1;
        int sqrt = (int) Math.sqrt(num);
        for(int i = 2; i <= sqrt; i++) if(num % i == 0) {
            sum += i;
            sum += num / i;
        }
        if (sqrt != 0 && sqrt * sqrt == num) sum -= sqrt;
        return sum == num;
    }
    
    public static void main(String[] args) {
        for (int i = 1; i <= 1000000000; i++)
            if (new Solution().checkPerfectNumber(i))
                System.out.println(i + ": " + new Solution().checkPerfectNumber(i));
    }
}