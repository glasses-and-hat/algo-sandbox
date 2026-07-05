class Solution {
    Map<Character, List<Character>> adj = new HashMap<>();
    Map<Character, Integer> state = new HashMap<>();
    List<Character> order = new ArrayList<>();

    public String foreignDictionary(String[] words) {

        // Build graph nodes
        for (String w : words) {
            for (char c : w.toCharArray()) {
                adj.putIfAbsent(c, new ArrayList<>());
            }
        }

        // Build edges
        for (int i = 0; i < words.length - 1; i++) {
            String w1 = words[i];
            String w2 = words[i + 1];

            // Invalid prefix case
            if (w1.startsWith(w2) && w1.length() > w2.length()) {
                return "";
            }

            int minLen = Math.min(w1.length(), w2.length());
            for (int j = 0; j < minLen; j++) {
                char c1 = w1.charAt(j);
                char c2 = w2.charAt(j);
                if (c1 != c2) {
                    adj.get(c1).add(c2);
                    break;
                }
            }
        }

        // DFS topo sort
        for (char c : adj.keySet()) {
            if (state.getOrDefault(c, 0) == 0) {
                if (dfs(c)) return "";
            }
        }

        Collections.reverse(order);
        StringBuilder sb = new StringBuilder();
        for (char c : order) sb.append(c);
        return sb.toString();
    }

    private boolean dfs(char c) {
        int st = state.getOrDefault(c, 0);
        if (st == 1) return true;   // cycle
        if (st == 2) return false;  // already processed

        state.put(c, 1); // visiting

        for (char nei : adj.get(c)) {
            if (dfs(nei)) return true;
        }

        state.put(c, 2); // visited
        order.add(c);
        return false;
    }
}
