class MyStack {
    Queue<Integer> qu;

    public MyStack() {
        qu = new ArrayDeque<>();
    }
    
    public void push(int x) {
        qu.offer(x);
    }
    
    public int pop() {
        if(empty()) return -1;
        int size = qu.size();
        int x = -1;
        for(int i=0; i<size; i++){
            if(i==size-1){
                x = qu.poll();
            }
            else{
                int y = qu.poll();
                qu.offer(y);
            }
        }
        size = qu.size();
        for(int i=0; i<size; i++){
            int y = qu.poll();
            qu.offer(y);
        }
        return x;
    }
    
    public int top() {
        if(empty()) return -1;
        int size = qu.size();
        int x = -1;
        for(int i=0; i<size; i++){
            x = qu.poll();
            qu.offer(x);
        }
        for(int i=0; i<size; i++){
            int y = qu.poll();
            qu.offer(y);
        }
        return x;
    }
    
    public boolean empty() {
        return qu.size()==0;
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */