class Solution {
    public int findPoisonedDuration(int[] timeSeries, int duration) {
        int ans = duration;

        for (int i = 1; i < timeSeries.length; i++) {
            ans += Math.min(duration, timeSeries[i] - timeSeries[i - 1]);
        }

        return ans;
    }
}
