package google.leetcode224;

import java.util.Stack;

public class Solution {
    public int calculate(String s) {
        s = s.replace("(", " ( ")
                .replace(")", " ) ")
                .replace("+", " + ")
                .replace("-", " - ")
                .replace("*", " * ")
                .replace("/", " / ");
        
        Stack<Integer> operands = new Stack<Integer>();
        Stack<String> operators = new Stack<String>();
        
        String[] tokens = s.split("\\s+");
        
        for (String token: tokens) {
            String thisToken = token.trim();
            if (thisToken.equals("")) continue;
            if (thisToken.equals("+") || thisToken.equals("-")) {
                while (!operators.isEmpty() && !operators.peek().equals("(")) {
                    performeCalculation(operands, operators);
                }
                operators.push(thisToken);
            }
            else if (thisToken.equals("*") || thisToken.equals("/")) {
                while (!operators.isEmpty() &&
                        (operators.peek().equals("*")) ||
                        operators.peek().equals("/")) {
                    performeCalculation(operands, operators);
                }
                operators.push(thisToken);
            }
            else if (thisToken.equals("(")) {
                operators.push(thisToken);
            }
            else if (thisToken.equals(")")) {
                while (!operators.isEmpty() && !operators.peek().equals("(")) {
                    performeCalculation(operands, operators);
                }
                operators.pop();
            }
            else {
                operands.push(Integer.parseInt(thisToken));
            }
        }
        
        while (!operators.isEmpty()) performeCalculation(operands, operators);
        
        return operands.pop();
    }

    private void performeCalculation(Stack<Integer> operands, Stack<String> operators) {
        String operator = operators.pop();
        int right = operands.pop();
        int left = operands.pop();
        switch (operator) {
        case "+":
            operands.push(left + right);
            break;
            
        case "-":
            operands.push(left - right);
            break;
            
        case "*":
            operands.push(left * right);
            break;
            
        case "/":
            operands.push(left / right);
            break;
            
        default:
            break;
        }
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().calculate("(1+(4+5+2)-3)+(6+8)"));
    }
}