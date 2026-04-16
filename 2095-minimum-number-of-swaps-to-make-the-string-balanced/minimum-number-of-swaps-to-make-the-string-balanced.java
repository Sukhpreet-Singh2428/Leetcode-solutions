class Solution {
    public int minSwaps(String s) {
        Stack<Character> st = new Stack<>();

        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            if(c=='['){
                st.push(c);
            }
            else{
                if(st.isEmpty()){
                    st.push(c);
                }
                else{
                    char top = st.peek();
                    if(top=='[' && c==']'){
                        st.pop();
                    }
                    else{
                        st.push(c);
                    }
                }
            }
        }

        if(st.isEmpty()) return 0;

        int open = 0;
        int close = 0;
        while(!st.isEmpty()){
            if(st.pop() == '['){
                open++;
            }
            else{
                close++;
            }
        }

        int ans = (int)(Math.ceil(open/2.0) + Math.ceil(close/2.0));
        return ans/2;
    }
}