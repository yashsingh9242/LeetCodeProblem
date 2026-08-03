class Solution {
    public boolean isPowerOfTwo(int n) {
        if (n <= 0) {
            return false;
        }
        double x = Math.log(n) / Math.log(2);
        return Math.abs(x - Math.round(x)) < 1e-10;
    }
}