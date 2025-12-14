class Solution {
    public boolean isValid(String s) {
        char[] arr = s.toCharArray();
        Stack<Character> st = new Stack<>();
        for(int i=0; i<arr.length; i++){
            char ch = arr[i];
            if(ch == '(' || ch == '[' || ch == '{'){
                st.push(ch);
            }
            else{
                if(st.isEmpty()){
                    return false;
                }
                char top = st.pop();
                if((ch==')' && top != '(') || (ch==']' && top != '[') || (ch=='}' && top != '{')){
                    return false;
                }
            }
        }

        return st.isEmpty();
    }
}