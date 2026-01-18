class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> st = new Stack<>();

        for(int i=0; i<tokens.length; i++){
            String s = tokens[i];
            if(s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/")){
                int b = st.pop();
                int a = st.pop();
                int res = 0;
                switch(s){
                    case "+" : res = a+b; break;
                    case "-" : res = a-b; break;
                    case "*" : res = a*b; break;
                    case "/" : res = a/b; break;
                }
                st.push(res);
            }
            else{
                int val = Integer.parseInt(s);
                st.push(val);
            }
        }

        return st.pop();
    }
}