class Solution {
    public String resultingString(String s) {
        Stack<Character> st = new Stack<>();

        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            if(st.isEmpty()){
                st.push(c);
            }
            else{
                char top = st.peek();
                if(Math.abs(top-c)==1 || Math.abs(top-c)==25){
                    st.pop();
                }
                else{
                    st.push(c);
                }
            }
        }

        StringBuilder ans = new StringBuilder("");
        while(!st.isEmpty()){
            ans.append(st.pop());
        }
        ans.reverse();

        return ans.toString();
    }
}