class Solution {
    int[][][] memo;
    String a, b;
    public boolean isScramble(String s1, String s2) {
        if (s1.length() != s2.length()) return false;
        int n = s1.length();
        a = s1;
        b = s2;
        memo = new int[n][n][n + 1];
        return solve(0, 0, n);
    }

    private boolean solve(int i, int j, int len) {
        if (memo[i][j][len] != 0) {
            return memo[i][j][len] == 1;
        }
        if (a.substring(i, i + len).equals(b.substring(j, j + len))) {
            memo[i][j][len] = 1;
            return true;
        }
        int[] count = new int[26];
        for (int k = 0; k < len; k++) {
            count[a.charAt(i + k) - 'a']++;
            count[b.charAt(j + k) - 'a']--;
        }
        for (int c : count) {
            if (c != 0) {
                memo[i][j][len] = 2;
                return false;
            }
        }
        for (int k = 1; k < len; k++) {
            if (solve(i, j, k) && solve(i + k, j + k, len - k)) {
                memo[i][j][len] = 1;
                return true;
            }
            if (solve(i, j + len - k, k) && solve(i + k, j, len - k)) {
                memo[i][j][len] = 1;
                return true;
            }
        }
        memo[i][j][len] = 2;
        return false;
    }
}