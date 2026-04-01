class MinStack {
    Stack<Integer> st;
    Stack<Integer> min;
    public MinStack() {
        st = new Stack<Integer>();
        min = new Stack<Integer>();
    }
    
    public void push(int val) {
        st.push(val);
        if(min.isEmpty() || min.peek()>=val){
            min.push(val);
        }
    }
    
    public void pop() {
        int popped = st.pop();
        if(min.isEmpty() || min.peek()==popped){
           min.pop();
        }
    }
    
    public int top() {
        return st.peek();
    }
    
    public int getMin() {
        return min.peek();
    }
}
