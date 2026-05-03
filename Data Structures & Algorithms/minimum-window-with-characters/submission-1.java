class Solution {
    public String minWindow(String s, String t) {
        // Edge case: if either string is empty or t is larger than s
        if (s == null || t == null || s.length() < t.length()) {
            return "";
        }

        // Step 1: Frequency count for characters in t
        Map<Character, Integer> tCount = new HashMap<>();
        for (char c : t.toCharArray()) {
            tCount.put(c, tCount.getOrDefault(c, 0) + 1);
        }

        // Step 2: Sliding window with two pointers (l and r)
        Map<Character, Integer> sMap = new HashMap<>();
        int l = 0, r = 0; // Left and right pointers for the sliding window
        int required = tCount.size(); // Number of distinct characters in t
        int formed = 0; // To track how many distinct characters are fully matched
        int[] ans = {-1, 0, 0}; // Result: [window length, left, right]

        // Step 3: Expanding the window with the right pointer
        while (r < s.length()) {
            char c = s.charAt(r);
            sMap.put(c, sMap.getOrDefault(c, 0) + 1);

            // If the current character's count matches the target in t
            if (tCount.containsKey(c) && sMap.get(c).intValue() == tCount.get(c).intValue()) {
                formed++;
            }

            // Step 4: Try to shrink the window from the left when all characters are matched
            while (l <= r && formed == required) {
                char leftChar = s.charAt(l);

                // Update the result if this window is smaller
                if (r - l + 1 < ans[0] || ans[0] == -1) {
                    ans[0] = r - l + 1;
                    ans[1] = l;
                    ans[2] = r;
                }

                // Shrink the window by moving left pointer
                sMap.put(leftChar, sMap.get(leftChar) - 1);
                if (tCount.containsKey(leftChar) && sMap.get(leftChar).intValue() < tCount.get(leftChar).intValue()) {
                    formed--;
                }
                l++;
            }

            // Expand the window by moving right pointer
            r++;
        }

        // Return the result, or an empty string if no valid window is found
        return ans[0] == -1 ? "" : s.substring(ans[1], ans[2] + 1);
    }
}