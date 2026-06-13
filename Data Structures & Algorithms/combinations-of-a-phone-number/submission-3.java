class Solution {
    String[] numPad = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.isEmpty())
            return new ArrayList();
        List<String> res = new ArrayList();
        helper(digits, 0, "", res);
        return res;
    }

    private void helper(String digits, int i, String curr, List<String> res) {
        if (curr.length() == digits.length()) {
            res.add(curr);
            return;
        }

        String chars = numPad[digits.charAt(i) - '0'];

        for (char c : chars.toCharArray()) {
            helper(digits, i + 1, curr + c, res);
        }
    }
}
