class Solution {
    Stack<String> stack = new Stack<>();

    public int evalRPN(String[] tokens) {
        for (String token : tokens) {
            if (token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/")) {
                int second = Integer.parseInt(stack.pop());
                int first = Integer.parseInt(stack.pop());
                if (token.equals("+")) {
                    stack.push("" + (first + second));
                } else if (token.equals("-")) {
                    stack.push("" + (first - second));
                } else if (token.equals("*")) {
                    stack.push("" + (first * second));
                } else if (token.equals("/")) {
                    stack.push("" + (first / second));
                }
            } else {
                stack.push(token);
            }
        }
        return Integer.parseInt(stack.peek());
    }
}
