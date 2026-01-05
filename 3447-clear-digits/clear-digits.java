class Solution {
    public String clearDigits(String s) {
        Stack<Character> st = new Stack<>();

        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            if(c>='0' && c<='9'){
                if(!st.isEmpty()) st.pop();
            }
            else{
                st.push(c);
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