class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList();
        backtrack(0, 0, n, new StringBuilder(), res);
        return res;
    }

    private void backtrack(int openN, int closeN, int n, StringBuilder stack, List<String> res) {
        if (openN == closeN && openN == n) {
            res.add(stack.toString());
            return;
        }

        if (openN < n) {
            stack.append("(");
            backtrack(openN + 1, closeN, n, stack, res);
            stack.deleteCharAt(stack.length() - 1);
        }

        if (closeN < openN) {
            stack.append(")");
            backtrack(openN, closeN + 1, n, stack, res);
            stack.deleteCharAt(stack.length() - 1);
        }
    }
}
