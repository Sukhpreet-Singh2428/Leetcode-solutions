class Solution {
    public String reverseByType(String s) {
        StringBuilder ans = new StringBuilder(s);
        Stack<Character> st1 = new Stack<>();
        Stack<Character> st2 = new Stack<>();
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            if(c>='a' && c<='z'){
                st1.push(c);
            }
            else{
                st2.push(c);
            }
        }

        for(int i=0; i<ans.length(); i++){
            char c = s.charAt(i);
            if(c>='a' && c<='z'){
                ans.setCharAt(i, st1.pop());
            }
            else{
                ans.setCharAt(i, st2.pop());
            }
        }

        return ans.toString();
    }
}