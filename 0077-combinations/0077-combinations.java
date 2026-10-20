class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    List<Integer> list = new ArrayList<>();
    public List<List<Integer>> combine(int n, int k) {
        backtrack(1, n, k);
        return ans;
    }
    void backtrack(int start, int n, int k) {
        if (list.size() == k) {
            ans.add(new ArrayList<>(list));
            return;
        }
        for (int i = start; i <= n; i++) {
            list.add(i);
            backtrack(i + 1, n, k);
            list.remove(list.size() - 1);
        }
    }
}