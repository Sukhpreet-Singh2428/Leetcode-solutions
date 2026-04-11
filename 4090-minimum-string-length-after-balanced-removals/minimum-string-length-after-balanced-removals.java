class Solution {
    public int minLengthAfterRemovals(String s) {
        Stack<Character> st = new Stack<>();

        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            if(c=='a'){
                if(!st.isEmpty() && st.peek()=='b'){
                    st.pop();
                }
                else{
                    st.push(c);
                }
            }
            else{
                if(!st.isEmpty() && st.peek()=='a'){
                    st.pop();
                }
                else{
                    st.push(c);
                }
            }
        }

        return st.size();
    }
}