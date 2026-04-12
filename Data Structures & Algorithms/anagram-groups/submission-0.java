import java.util.*;

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {

        HashMap<String, List<String>> mapOfAnagrams = new HashMap<>();

        for(String str: strs) {
            char[] strChars = str.toCharArray();
            Arrays.sort(strChars);
            String sortedChars = new String(strChars);

            List<String> anagrams = mapOfAnagrams.getOrDefault(sortedChars, new ArrayList<String>());
            anagrams.add(str);
            mapOfAnagrams.put(sortedChars, anagrams);
        }

        List<List<String>> result = new ArrayList<>();

        for(List<String> list: mapOfAnagrams.values()) {
            result.add(list);
        }
        return result;
        
    }
}
