class Solution {
    String[] numPad = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList();
        if (digits.isEmpty())
            return res;
        helper(digits, 0, "", res);
        return res;
    }

    private void helper(String digits, int i, String curr, List<String> res) {
        if (curr.length() == digits.length()) {
            res.add(curr);
            return;
        }

        String pad = numPad[digits.charAt(i) - '0'];

        for (char c : pad.toCharArray()) {
            helper(digits, i + 1, curr + c, res);
        }
    }
}
