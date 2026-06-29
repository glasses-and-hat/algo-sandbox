class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Map<String, List<String>> patternMap = new HashMap<>();

        for (String word : wordList) {
            for (int i = 0; i < word.length(); i++) {
                String pattern = word.substring(0, i) + "*" + word.substring(i + 1);
                patternMap.computeIfAbsent(pattern, k -> new ArrayList<>()).add(word);
            }
        }

        Queue<String> q = new LinkedList<>();
        q.offer(beginWord);

        int res = 0;
        Set<String> visited = new HashSet<>();

        while (!q.isEmpty()) {
            res++;
            int size = q.size();
            for (int i = 0; i < size; i++) {
                String node = q.poll();
                if (node.equals(endWord)) {
                    return res;
                }
                for (int j = 0; j < node.length(); j++) {
                    String pattern = node.substring(0, j) + "*" + node.substring(j + 1);
                    for (String nei : patternMap.getOrDefault(pattern, new ArrayList<>())) {
                        if (!visited.contains(nei)) {
                            q.offer(nei);
                            visited.add(nei);
                        }
                    }
                }
            }
        }
        return 0;
    }
}
