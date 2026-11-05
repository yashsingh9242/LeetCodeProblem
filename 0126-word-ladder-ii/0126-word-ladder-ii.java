class Solution {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> result = new ArrayList<>();
        Set<String> words = new HashSet<>(wordList);
        if (!words.contains(endWord)) {
            return result;
        }
        Map<String, List<String>> parents = new HashMap<>();
        Set<String> currentLevel = new HashSet<>();
        currentLevel.add(beginWord);
        words.remove(beginWord);
        boolean found = false;
        while (!currentLevel.isEmpty() && !found) {
            Set<String> nextLevel = new HashSet<>();
            for (String word : currentLevel) {
                char[] chars = word.toCharArray();
                for (int i = 0; i < chars.length; i++) {
                    char old = chars[i];
                    for (char c = 'a'; c <= 'z'; c++) {
                        if (c == old) continue;
                        chars[i] = c;
                        String next = new String(chars);
                        if (words.contains(next)) {
                            nextLevel.add(next);
                            parents.computeIfAbsent(next, k -> new ArrayList<>()).add(word);
                            if (next.equals(endWord)) {
                                found = true;
                            }
                        }
                    }
                    chars[i] = old;
                }
            }
            words.removeAll(nextLevel);
            currentLevel = nextLevel;
        }
        if (!found) {
            return result;
        }
        LinkedList<String> path = new LinkedList<>();
        path.add(endWord);
        buildPaths(endWord, beginWord, parents, path, result);
        return result;
    }
    private void buildPaths(String word, String beginWord,
                            Map<String, List<String>> parents,
                            LinkedList<String> path,
                            List<List<String>> result) {
        if (word.equals(beginWord)) {
            List<String> ans = new ArrayList<>(path);
            Collections.reverse(ans);
            result.add(ans);
            return;
        }
        for (String parent : parents.getOrDefault(word, new ArrayList<>())) {
            path.add(parent);
            buildPaths(parent, beginWord, parents, path, result);
            path.removeLast();
        }
    }
}