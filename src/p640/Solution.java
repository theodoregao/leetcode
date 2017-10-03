package p640;
public class Solution {
    public String solveEquation(String equation) {
        int posEquals = equation.indexOf('=');
        String left = equation.substring(0, posEquals);
        String right = equation.substring(posEquals + 1);
        int xLeft = getX(left);
        int xRight = getX(right);
        int v = getValue(right) - getValue(left);
        if (xLeft == xRight) {
            if (v == 0) return "Infinite solutions";
            else return "No solution";
        }
        return "x=" + (v / (xLeft - xRight));
    }
    
    private int getX(String str) {
//        System.out.println("getX() " + str);
        int count = 0;
        int start = 0;
        for (int i = 0; i <= str.length(); i++) {
            if (i == str.length() || str.charAt(i) == '+' || str.charAt(i) == '-') {
                String token = str.substring(start, i);
                if (token.length() > 0 && token.charAt(token.length() - 1) == 'x') {
                    count += parseInt(token.substring(0, token.length() - 1));
                }
                start = i;
            }
        }
//        System.out.println("return " + count + "x");
        return count;
    }
    
    private int getValue(String str) {
//        System.out.println("getValue() " + str);
        int count = 0;
        int start = 0;
        for (int i = 0; i <= str.length(); i++) {
            if (i == str.length() || str.charAt(i) == '+' || str.charAt(i) == '-') {
                String token = str.substring(start, i);
                if (token.length() > 0 && token.charAt(token.length() - 1) != 'x')
                    count += parseInt(token.substring(0, token.length()));
                start = i;
            }
        }
//        System.out.println("return " + count);
        return count;
    }
    
    private int parseInt(String token) {
//        System.out.println("parseInt() " + token);
        if (token.length() == 0) return 1;
        else if (token.length() == 1) {
            if (token.charAt(0) == '+') return 1;
            else if (token.charAt(0) == '-') return -1;
        }
        return Integer.parseInt(token);
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().solveEquation("x+5-3+x=6+x-2"));
        System.out.println(new Solution().solveEquation("x=x"));
        System.out.println(new Solution().solveEquation("2x=x"));
        System.out.println(new Solution().solveEquation("2x+3x-6x=x+2"));
        System.out.println(new Solution().solveEquation("x=x+2"));
        System.out.println(new Solution().solveEquation("-x=-1"));
    }
}