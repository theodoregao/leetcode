package p071;

import java.util.Stack;

public class Solution {
    public String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();
        String[] tokens = path.split("/");
        for (String token: tokens) {
            if (token.trim().length() == 0) continue;
            String folder = token.trim();
            if (folder.equals("..")) {
                if(!stack.isEmpty()) stack.pop();
            }
            else if (!folder.equals(".")) stack.push(folder);
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) sb.insert(0, "/" + stack.pop());
        return sb.length() == 0 ? "/" : sb.toString();
    }
}