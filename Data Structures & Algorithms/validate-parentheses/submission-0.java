class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        
        for (char c : s.toCharArray()) {
            // Push opening brackets
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else {
                // If stack is empty, no matching opening bracket
                if (stack.isEmpty()) return false;
                
                char top = stack.pop();
                
                // Check for matching pairs
                if (c == ')' && top != '(') return false;
                if (c == '}' && top != '{') return false;
                if (c == ']' && top != '[') return false;
            }
        }
        
        // If stack is empty, all brackets matched
        return stack.isEmpty();
    }
}