import java.util.*;

class Solution {
    public boolean hasDuplicate(int[] nums) {

        HashMap<Integer, Boolean> numCheck = new HashMap<>();

        for(int num: nums) {
            boolean check = numCheck.getOrDefault(num, false);
            if(check) {
                return true;
            }
            numCheck.put(num, true);
        }
        return false;
    }
}