class Solution {
    public int maximalRectangle(char[][] matrix) {
        if (matrix.length == 0) return 0;
        int n = matrix[0].length;
        int[] h = new int[n];
        int best = 0;
        for (char[] row : matrix) {
            for (int j = 0; j < n; j++) {
                h[j] = row[j] == '1' ? h[j] + 1 : 0;
            }
            best = Math.max(best, largest(h));
        }
        return best;
    }
    private int largest(int[] h) {
        int[] st = new int[h.length + 1];
        int top = -1;
        int max = 0;
        for (int i = 0; i <= h.length; i++) {
            int cur = i == h.length ? 0 : h[i];
            while (top >= 0 && cur < h[st[top]]) {
                int height = h[st[top--]];
                int left = top >= 0 ? st[top] : -1;
                max = Math.max(max, height * (i - left - 1));
            }
            st[++top] = i;
        }
        return max;
    }
}