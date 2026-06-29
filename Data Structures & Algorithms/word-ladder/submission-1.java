class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> set = new HashSet<>(wordList);
        Queue<String> q = new LinkedList<>();
        q.offer(beginWord);

        int res = 0;
        int jLenth = beginWord.length();
        while (!q.isEmpty()) {
            res++;
            int size = q.size();
            for (int i = 0; i < size; i++) {
                String node = q.poll();
                if (node.equals(endWord))
                    return res;
                for (int j = 0; j < jLenth; j++) {
                    for (char c = 'a'; c <= 'z'; c++) {
                        if (node.charAt(j) == c)
                            continue;
                        String word = node.substring(0, j) + c + node.substring(j + 1);
                        if (set.contains(word)) {
                            q.offer(word);
                            set.remove(word);
                        }
                    }
                }
            }
        }
        return 0;
    }
}
