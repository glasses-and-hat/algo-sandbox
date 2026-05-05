class Solution {
    public String minWindow(String s, String t) {
        if (s == null || t == null || t.isEmpty() || s.length() < t.length()) {
            return "";
        }

        Map<Character, Integer> tCount = new HashMap<>();
        for (char c : t.toCharArray()) {
            tCount.put(c, tCount.getOrDefault(c, 0) + 1);
        }
        int need = tCount.size(), have = 0, l = 0;
        int[] ans = {Integer.MAX_VALUE, 0, s.length() - 1};

        Map<Character, Integer> sCount = new HashMap<>();

        for (int r = 0; r < s.length(); r++) {
            char rChar = s.charAt(r);
            sCount.put(rChar, sCount.getOrDefault(rChar, 0) + 1);
            if (tCount.containsKey(rChar) && sCount.get(rChar) == tCount.get(rChar)) {
                have++;
            }
            while (need == have) {
                if ((r - l + 1) < ans[0]) {
                    ans[0] = r - l + 1;
                    ans[1] = l;
                    ans[2] = r;
                }

                char leftChar = s.charAt(l);
                sCount.put(leftChar, sCount.get(leftChar) - 1);
                if (tCount.containsKey(leftChar) && sCount.get(leftChar) < tCount.get(leftChar)) {
                    have--;
                }
                l++;
            }
        }
        return ans[0] == Integer.MAX_VALUE ? "" : s.substring(ans[1], ans[2] + 1);
    }
}
