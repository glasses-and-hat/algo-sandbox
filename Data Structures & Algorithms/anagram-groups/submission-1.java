class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {

        HashMap<String, List<String>> mapOfAnagrams = new HashMap<>();

        for(String str: strs) {
            int[] counter = new int[26];
            for(char c: str.toCharArray()) {
                counter[c - 'a']++;
            }
            String key = Arrays.toString(counter);
            mapOfAnagrams.putIfAbsent(key, new ArrayList());
            mapOfAnagrams.get(key).add(str);
        }

        return new ArrayList(mapOfAnagrams.values());
        
    }
}
