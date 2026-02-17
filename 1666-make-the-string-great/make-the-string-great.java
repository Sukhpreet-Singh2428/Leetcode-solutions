class Solution {
    public String makeGood(String s) {
        Stack<Character> st = new Stack<>();

        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            if(!st.isEmpty() && c!=st.peek() && (c==Character.toLowerCase(st.peek()) || Character.toLowerCase(c)==st.peek()) ){
                st.pop();
            }
            else{
                st.push(c);
            }
        }

        StringBuilder ans = new StringBuilder();
        while(!st.isEmpty()){
            ans.append(st.pop());
        }
        ans.reverse();

        return ans.toString();
    }
}