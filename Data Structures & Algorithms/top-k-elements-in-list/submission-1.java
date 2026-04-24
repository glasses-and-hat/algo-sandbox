class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> count = new HashMap<>();
        for (int num : nums) {
            count.put(num, count.getOrDefault(num, 0) + 1);
        }
        List<Integer>[] freq = new List[count.size() + 2];
        for (int i = 0; i < freq.length; i++) {
            freq[i] = new ArrayList<>();
        }

        for (Map.Entry<Integer, Integer> entry : count.entrySet()) {
            freq[entry.getValue()].add(entry.getKey());
        }

        int[] res = new int[k];
        int check = 0;
        for (int i = freq.length - 1; i > 0; i--) {
            for (int x : freq[i]) {
                res[check++] = x;
                if (check == k) {
                    return res;
                }
            }
        }
        return res;
    }
}
