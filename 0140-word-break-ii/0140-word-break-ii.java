class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        Set<String> dict = new HashSet<>(wordDict);
        Map<Integer, List<String>> memo = new HashMap<>();

        return solve(s, 0, dict, memo);
    }

    private List<String> solve(String s, int start, Set<String> dict,
                               Map<Integer, List<String>> memo) {

        if (start == s.length()) {
            return new ArrayList<>(List.of(""));
        }

        if (memo.containsKey(start)) {
            return memo.get(start);
        }

        List<String> result = new ArrayList<>();

        for (int end = start + 1; end <= s.length(); end++) {
            String word = s.substring(start, end);

            if (dict.contains(word)) {
                List<String> nextWords = solve(s, end, dict, memo);

                for (String next : nextWords) {
                    if (next.isEmpty()) {
                        result.add(word);
                    } else {
                        result.add(word + " " + next);
                    }
                }
            }
        }

        memo.put(start, result);
        return result;
    }
}