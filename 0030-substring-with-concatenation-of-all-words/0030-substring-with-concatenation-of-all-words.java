class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> res = new ArrayList<>();
        int n = words[0].length(), total = n * words.length;
        Map<String, Integer> map = new HashMap<>();

        for (String w : words)
            map.put(w, map.getOrDefault(w, 0) + 1);

        for (int i = 0; i < n; i++) {
            Map<String, Integer> win = new HashMap<>();
            int l = i, count = 0;

            for (int r = i; r + n <= s.length(); r += n) {
                String w = s.substring(r, r + n);

                if (!map.containsKey(w)) {
                    win.clear();
                    count = 0;
                    l = r + n;
                    continue;
                }

                win.put(w, win.getOrDefault(w, 0) + 1);
                count++;

                while (win.get(w) > map.get(w)) {
                    String x = s.substring(l, l + n);
                    win.put(x, win.get(x) - 1);
                    l += n;
                    count--;
                }

                if (count == words.length) {
                    res.add(l);
                    String x = s.substring(l, l + n);
                    win.put(x, win.get(x) - 1);
                    l += n;
                    count--;
                }
            }
        }
        return res;
    }
}