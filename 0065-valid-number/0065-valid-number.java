class Solution {
    public boolean isNumber(String s) {
        boolean digit = false, dot = false, exp = false, expDigit = true;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                digit = true;
                if (exp) expDigit = true;
            } 
            else if (c == '.') {
                if (dot || exp) return false;
                dot = true;
            } 
            else if (c == 'e' || c == 'E') {
                if (exp || !digit) return false;
                exp = true;
                expDigit = false;
            } 
            else if (c == '+' || c == '-') {
                if (i != 0 && s.charAt(i - 1) != 'e' && s.charAt(i - 1) != 'E')
                    return false;
            } 
            else {
                return false;
            }
        }
        return digit && expDigit;
    }
}