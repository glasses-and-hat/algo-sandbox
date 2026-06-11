class Solution {
    private String[] digiChars = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList();
        if (digits.isEmpty())
            return res;

        dfs(digits, 0, "", res);
        return res;
    }

    private void dfs(String digits, int i, String curr, List<String> res) {
        if (curr.length() == digits.length()) {
            res.add(curr);
            return;
        }

        String chars = digiChars[digits.charAt(i) - '0'];
        for (char c : chars.toCharArray()) {
            dfs(digits, i + 1, curr + c, res);
        }
    }
}
