class Solution {
    public int characterReplacement(String s, int k) {
        HashMap<Character, Integer> count = new HashMap<>();
        int l = 0, maxFreq = 0, res = 0;

        for (int r = 0; r < s.length(); r++) {
            char c = s.charAt(r);
            int charCount = count.getOrDefault(c, 0) + 1;
            count.put(c, charCount);
            maxFreq = Math.max(maxFreq, charCount);
            while ((r - l + 1) - maxFreq > k) {
                char lChar = s.charAt(l);
                count.put(lChar, count.get(lChar) - 1);
                l++;
            }
            res = Math.max(res, r - l + 1);
        }
        return res;
    }
}
