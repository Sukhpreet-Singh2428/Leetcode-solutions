class Solution {
    public boolean backspaceCompare(String s, String t) {
        Stack<Character> st = new Stack<>();

        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            if(c=='#'){
                if(!st.isEmpty()) st.pop();
            }
            else{
                st.push(c);
            }
        }
        StringBuilder ans1 = new StringBuilder("");
        while(!st.isEmpty()){
            ans1.append(st.pop());
        }

        for(int i=0; i<t.length(); i++){
            char c = t.charAt(i);
            if(c=='#'){
                if(!st.isEmpty()) st.pop();
            }
            else{
                st.push(c);
            }
        }
        StringBuilder ans2 = new StringBuilder("");
        while(!st.isEmpty()){
            ans2.append(st.pop());
        }

        return ans1.toString().equals(ans2.toString());
    }
}