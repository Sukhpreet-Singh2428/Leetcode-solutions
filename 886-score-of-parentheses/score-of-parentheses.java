class Solution {
    public int scoreOfParentheses(String s) {
        int n = s.length();

        Stack<String> st = new Stack<>();

        for(int i=0; i<n; i++){
            char c = s.charAt(i);

            if(c == '('){
                st.push("(");
            }
            else{
                int x = 0;
                while(!st.isEmpty() && !st.peek().equals("(")){
                    String ch = st.pop();
                    if(ch.charAt(0)>='1' && ch.charAt(0)<='9'){
                        x += Integer.parseInt(ch);
                    }
                }
                x *= 2;
                st.pop();
                if(x != 0) st.push(String.valueOf(x));
                else st.push("1");
            }
        }

        int ans = 0;
        while(!st.isEmpty()){
            ans += Integer.parseInt(st.pop());
        }

        return ans;
    }
}