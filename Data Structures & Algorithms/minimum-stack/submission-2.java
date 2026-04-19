class MinStack {
    long min;
    Stack<Long> stack;
    public MinStack() {
        stack = new Stack<>();
    }
    
    public void push(int val) {
        if(stack.isEmpty()) {
            stack.push(0L);
            min = val;
        } else {
            stack.push(val - min);
            if(val < min) min = val;
        }
    }
    
    public void pop() {
        if(stack.isEmpty()) return;
        long pop = stack.pop();
        if(pop < 0) {
            min = min - pop;
        }
    }
    
    public int top() {
        long peek = stack.peek();
        if(peek < 0) {
            return (int) min;
        } else {
            return (int) (min + peek);
        }
    }
    
    public int getMin() {
        return (int) min;
    }
}
