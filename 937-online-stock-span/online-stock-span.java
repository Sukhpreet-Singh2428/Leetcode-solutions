class pair{
    int val;
    int idx;

    public pair(int val, int idx){
        this.val = val;
        this.idx = idx;
    }
}
class StockSpanner {

    Stack<pair> st;
    int idx;

    public StockSpanner() {
        st = new Stack<>();
        idx = -1;
    }
    
    public int next(int price) {
        idx++;
        while(!st.isEmpty() && st.peek().val <= price){
            st.pop();
        }
        int ans = idx - (st.isEmpty() ? -1 : st.peek().idx);
        st.push(new pair(price, idx));
        return ans;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */