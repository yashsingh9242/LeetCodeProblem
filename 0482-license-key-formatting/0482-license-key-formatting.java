class Solution {
    public String licenseKeyFormatting(String s, int k) {
        StringBuilder sb = new StringBuilder();

        for (int i = s.length() - 1; i >= 0; i--) {
            char ch = s.charAt(i);

            if (ch == '-') {
                continue;
            }

            if (sb.length() > 0 && sb.length() % (k + 1) == k) {
                sb.append('-');
            }

            sb.append(Character.toUpperCase(ch));
        }
        return sb.reverse().toString();
    }
}