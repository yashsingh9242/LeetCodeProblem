class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes, (a, b) -> {
            if (a[0] == b[0]) {
                return Integer.compare(b[1], a[1]);
            }
            return Integer.compare(a[0], b[0]);
        });
        int n = envelopes.length;
        int[] dp = new int[n];
        int len = 0;
        for (int[] envelope : envelopes) {
            int height = envelope[1];
            int left = 0;
            int right = len;
            while (left < right) {
                int mid = left + (right - left) / 2;
                if (dp[mid] < height) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }
            dp[left] = height;
            if (left == len) {
                len++;
            }
        }
        return len;
    }
}

