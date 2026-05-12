class Solution {
    public String longestPalindrome(String s) {
        int length = s.length();
        String result = "";
        for (int i = 0; i < length; i++) {
            int l = i;
            int r = i;
            while (l >= 0 && r < length && s.charAt(l) == s.charAt(r)) {
                if (r - l + 1 > result.length()) {
                    result = s.substring(l, r + 1);
                }
                l--;
                r++;
            }

            l = i;
            r = i + 1;

            while (l >= 0 && r < length && s.charAt(l) == s.charAt(r)) {
                if (r - l + 1 > result.length()) {
                    result = s.substring(l, r + 1);
                }
                l--;
                r++;
            }
        }
        return result;
    }
}
