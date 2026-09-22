class MinStack {
    
    Stack<Integer> stack = new Stack<>(); 
    // hold current min
    Stack<Integer> minStack = new Stack<>(); 

    public MinStack() {
        
    }
    
    public void push(int val) {
        stack.push(val);
        
        // push to min stack if its empty or if new value added to stack is less than current top min stack 
        if (minStack.isEmpty() || stack.peek() < minStack.peek()) {
            minStack.push(stack.peek());
        } else {
            // if not re-add the top of min stack 
            minStack.push(minStack.peek());
        }
        
    }
    
    public void pop() {
        // from both 
        stack.pop(); 
        minStack.pop(); 
    }
    
    public int top() {
        return stack.peek(); 
    }
    
    public int getMin() {
        return minStack.peek(); 
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */