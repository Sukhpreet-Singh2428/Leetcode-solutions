class Solution {
    public String decodeString(String s) {
        Stack<Character> st = new Stack<>();

        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            if(c != ']'){
                st.push(c);
            }
            else{
                StringBuilder str = new StringBuilder();
                while(!st.isEmpty() && st.peek() != '['){
                    str.append(st.pop());
                }
                st.pop();
                str.reverse();

                StringBuilder num = new StringBuilder();
                while(!st.isEmpty() && (st.peek()>='0' && st.peek()<='9')){
                    num.append(st.pop());
                }
                int cnt = Integer.parseInt(num.reverse().toString());

                StringBuilder whole = new StringBuilder();
                for(int j=0; j<=cnt-1; j++){
                    whole.append(str);
                }

                for(int j=0; j<whole.length(); j++){
                    st.push(whole.charAt(j));
                }
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