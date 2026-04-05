class Solution {
    public int maxDepth(String s) {
        int maxi = 0;
        int cnt = 0;
        Stack<Character> st = new Stack<>();
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            if(c=='('){
                cnt++;
                maxi = Math.max(maxi, cnt);
                st.push(c);
            }
            else if(c==')'){
                if(!st.isEmpty() && st.peek() == '('){
                    cnt--;
                    st.pop();
                }
            }
        }

        return maxi;
    }
}