class Solution {
    public int[] canSeePersonsCount(int[] heights) {
        int n = heights.length;
        int[] ans = new int[n];

        Stack<Integer> st = new Stack<>();
        for(int i=n-1; i>=0; i--){
            int cnt = 0;
            while(!st.isEmpty() && st.peek() < heights[i]){
                st.pop();
                cnt++;
            }
            if(!st.isEmpty()) cnt++;
            ans[i] = cnt;
            st.push(heights[i]);
        }

        return ans;
    }
}