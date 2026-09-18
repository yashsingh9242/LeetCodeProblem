class Solution {
    public String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();
        for (String s : path.split("/")) {
            if (s.equals("") || s.equals(".")) {
                continue;
            } else if (s.equals("..")) {
                if (!stack.isEmpty()) stack.pop();
            } else {
                stack.push(s);
            }
        }
        StringBuilder ans = new StringBuilder();

        for (String s : stack) {
            ans.append("/").append(s);
        }
        return ans.length() == 0 ? "/" : ans.toString();
    }
}