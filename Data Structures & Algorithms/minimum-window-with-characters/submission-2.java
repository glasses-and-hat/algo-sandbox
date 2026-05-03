class Solution {
    public String minWindow(String s, String t) {
        if (s.length() < t.length()) return "";

        int[] need = new int[128]; // ASCII
        for (char c : t.toCharArray()) {
            need[c]++;
        }

        int left = 0, right = 0;
        int count = t.length(); // total chars we still need

        int minLen = Integer.MAX_VALUE;
        int start = 0;

        while (right < s.length()) {
            char rc = s.charAt(right);

            // if this char is needed, reduce missing count
            if (need[rc] > 0) count--;

            need[rc]--; // include it in window
            right++;

            // when window is valid
            while (count == 0) {
                // update answer
                if (right - left < minLen) {
                    minLen = right - left;
                    start = left;
                }

                char lc = s.charAt(left);

                need[lc]++; // remove from window

                // if we now need this char again, window breaks
                if (need[lc] > 0) count++;

                left++;
            }
        }

        return minLen == Integer.MAX_VALUE ? "" : s.substring(start, start + minLen);
    }
}