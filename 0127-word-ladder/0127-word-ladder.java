class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> set = new HashSet<>(wordList);
        if (!set.contains(endWord)) {
            return 0;
        }
        Queue<String> q = new LinkedList<>();
        q.add(beginWord);
        int level = 1;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int k = 0; k < size; k++) {
                String word = q.poll();
                if (word.equals(endWord)) {
                    return level;
                }
                char[] arr = word.toCharArray();
                for (int i = 0; i < arr.length; i++) {
                    char old = arr[i];
                    for (char c = 'a'; c <= 'z'; c++) {
                        arr[i] = c;
                        String next = new String(arr);
                        if (set.contains(next)) {
                            q.add(next);
                            set.remove(next);
                        }
                    }
                    arr[i] = old;
                }
            }
            level++;
        }
        return 0;
    }
}
