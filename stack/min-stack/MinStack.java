class MinStack {
    private final int[] stack = new int[30000];
    private int index = 0;
    private final int[] min = new int[30000];
    public MinStack() {
        min[0] = Integer.MAX_VALUE;
    }
    
    public void push(int val) {
        int cur = getMin();
        min[index+1] = val < cur ? val : cur;
        stack[index] = val;
        index++;
    }

    public void pop() {
        index--;
    }
    
    public int top() {
        return stack[index-1];
    }
    
    public int getMin() {
        return min[index];
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

