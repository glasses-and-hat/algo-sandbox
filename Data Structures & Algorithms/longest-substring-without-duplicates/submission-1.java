class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.isEmpty())
            return 0;
        int l = 0, result = Integer.MIN_VALUE;
        Map<Character, Integer> map = new HashMap();

        for (int r = 0; r < s.length(); r++) {
            char c = s.charAt(r);
            if (map.containsKey(c)) {
                l = Math.max(map.get(c) + 1, l);
            }
            map.put(c, r);
            result = Math.max(r - l + 1, result);
        }
        return result;
    }
}
