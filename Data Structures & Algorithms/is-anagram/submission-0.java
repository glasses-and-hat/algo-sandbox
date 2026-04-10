class Solution {
    public boolean isAnagram(String s, String t) {

        if(s == null || t == null) {
            return false;
        }

        if(s.length() != t.length()) {
            return false;
        }

        HashMap<Character, Integer> charCounter = new HashMap<>();

        for(int i =0; i< s.length(); i++) {
            char sChar = s.charAt(i);
            char tChar = t.charAt(i);
            charCounter.put(sChar, charCounter.getOrDefault(sChar, 0) + 1);
            charCounter.put(tChar, charCounter.getOrDefault(tChar, 0) - 1);
        }

        for(int count: charCounter.values()) {
            if(count != 0) {
                return false;
            }
        }

        return true;

    }
}
