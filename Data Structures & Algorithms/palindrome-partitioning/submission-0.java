class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList();
        dfs(s, 0, new ArrayList(), res);
        return res;
    }

    void dfs(String s, int start, List<String> curr, List<List<String>> res) {
        if (start == s.length()) {
            res.add(new ArrayList(curr));
            return;
        }

        for (int end = start; end < s.length(); end++) {
            if (isPal(s, start, end)) {
                curr.add(s.substring(start, end + 1));
                dfs(s, end + 1, curr, res);
                curr.remove(curr.size() - 1);
            }
        }
    }

    boolean isPal(String s, int l, int r) {
        while (l < r) {
            if (s.charAt(l) != s.charAt(r)) {
                return false;
            }
            l++;
            r--;
        }
        return true;
    }
}
