class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s2 == null && s1 != null)
            return false;
        if (s2.isEmpty() && !s1.isEmpty())
            return false;
        int s1Length = s1.length();
        if (s2.length() < s1Length)
            return false;

        int[] s1Array = new int[26];
        int[] s2Array = new int[26];

        for (int i = 0; i < s1Length; i++) {
            s1Array[s1.charAt(i) - 'a']++;
            s2Array[s2.charAt(i) - 'a']++;
        }
        if (Arrays.equals(s1Array, s2Array))
            return true;

        for (int i = s1Length; i < s2.length(); i++) {
            s2Array[s2.charAt(i) - 'a']++;
            s2Array[s2.charAt(i - s1Length) - 'a']--;
            if (Arrays.equals(s1Array, s2Array))
                return true;
        }
        return false;
    }
}
